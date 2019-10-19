/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.logic;

import com.may.dao.GenericDAO;
import com.may.util.ConstantStrings;
import com.may.util.ValidationExcepation;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @param <E> - entity type
 * @param <T> - DAO type
 *
 * @author mayab
 */
public abstract class GenericLogic< E, T extends GenericDAO<E>> {

    private final T DAO;

    GenericLogic(T dao) {
        this.DAO = dao;
    }

    protected final T dao() {
        return DAO;
    }

    protected <R> R get(Supplier<R> supplier) {
        R r;
        DAO.beginTransaction();
        r = supplier.get();
        DAO.closeTransaction();
        return r;
    }

    public void add(E entity) {
        DAO.beginTransaction();
        DAO.save(entity);
        DAO.commitAndCloseTransaction();
    }

    public void delete(E entity) {
        DAO.beginTransaction();
        DAO.delete(entity);
        DAO.commitAndCloseTransaction();
    }

    public void detach(E entity) {
        DAO.beginTransaction();
        DAO.detach(entity);
        DAO.commitAndCloseTransaction();
    }

    public E update(E entity) {
        DAO.beginTransaction();
        E e = DAO.update(entity);
        DAO.commitAndCloseTransaction();
        return e;
    }

    abstract public List<E> getAll();

    abstract public E getWithId(int id);

    abstract public E createEntity(Map<String, String[]> requestData);

    abstract public List<E> search(String search);

    public void validateString(Map<String, String[]> map, String key) {
        boolean x = map.containsKey(key);
        String y = map.get(key)[0];
        boolean z = map.get(key)[0].isEmpty();
        int w = map.get(key)[0].length();
        if (!map.containsKey(key) || map.get(key)[0] == null) {
            throw new ValidationExcepation(key + ConstantStrings.EMPTY_OBJECT_ERROR);
        } else if (map.get(key)[0].isEmpty() || map.get(key)[0].length() > ConstantStrings.MAX_COULUMN_CHAR) {
            throw new ValidationExcepation(ConstantStrings.NUM_CHAR_ERROR);
        }
    }
}

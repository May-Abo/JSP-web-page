/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.logic;

import com.may.entity.Country;
import com.may.dao.CountryDAO;
import com.may.util.ConstantStrings;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**
 *
 * @author mayab
 */
public class CountryLogic  extends GenericLogic<Country, CountryDAO>{
    
    /**
     * public constructor with no arguments
     * @see GenericLogic#GenericLogic(dao.GenericDAO)
     */
    public CountryLogic() {
        super(new CountryDAO());
    }

    /**
     * get all row (a list of Country objects) from Country table
     * @see GenericLogic#get(java.util.function.Supplier) see {@link CountryDAO#findAll()}
     * @return a list of Country objects
     */
    @Override
    public List<Country> getAll() {
        return get(() -> dao().findAll());
    }

    /**
     * get one row {@link Country} based on a given id from Country table
     * @see  GenericLogic#get(java.util.function.Supplier) 
     * see {@link CountryDAO#findById(int)  }
     * @param id - int id
     * @return one {@link Country} with the selected id
     */
    @Override
    public Country getWithId(int id) {
        return get(() -> dao().findById(id));
    }

    // There is no need for it at the moment
    @Override
    public Country createEntity(Map<String, String[]> parameterMap) {
        Objects.requireNonNull(parameterMap, AccountLogic.class +" parameterMap" + ConstantStrings.NULL_OBJECT_ERROR);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // There is no need for it at the moment
    @Override
    public List<Country> search(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

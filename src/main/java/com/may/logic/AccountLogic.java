/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.logic;

import com.may.entity.Account;
import com.may.dao.AccountDAO;
import com.may.util.ConstantStrings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author mayab
 */
public class AccountLogic extends GenericLogic<Account, AccountDAO> {

    /**
     * public constructor with no arguments
     *
     * @see GenericLogic#GenericLogic(dao.GenericDAO)
     */
    public AccountLogic() {
        super(new AccountDAO());
    }

    /**
     * get all row (a list of Account objects) from Account table
     *
     * @see GenericLogic#get(java.util.function.Supplier) see
     * {@link AccountDAO#findAll()}
     * @return a list of Account objects
     */
    @Override
    public List<Account> getAll() {
        return get(() -> dao().findAll());
    }

    /**
     * get one row {@link Account} based on a given id from Account table
     *
     * @see GenericLogic#get(java.util.function.Supplier) see {@link AccountDAO#findById(int)
     * }
     * @param id - int id
     * @return one {@link Account} with the selected id
     */
    @Override
    public Account getWithId(int id) {
        return get(() -> dao().findById(id));
    }

    /**
     * get one row {@link Account} based on a given userName from Account table
     *
     * @see GenericLogic#get(java.util.function.Supplier) 
     * see {@link AccountDAO#findByUserName(java.lang.String)}
     * @param userName - string userName
     * @return one {@link Account} with the selected userName
     */

    public Account getWithUserName(String userName) {
        return get(() -> dao().findByUserName(userName));
    }
    
    /**
     * create a new Account object and set the values using Class setters
     * 
     * @see GenericLogic#createEntity(java.util.Map)
     * @param parameterMap - {@link Map}
     * @return {@link Account}
     */
    @Override
    public Account createEntity(Map<String, String[]> parameterMap) {

        Objects.requireNonNull(parameterMap, AccountLogic.class.getName() + " parameterMap" + ConstantStrings.NULL_OBJECT_ERROR);

        Account account = new Account();
        if (parameterMap.containsKey(ConstantStrings.ID)) {
            account.setId(Integer.parseInt(parameterMap.get(ConstantStrings.ID)[0]));
        }
        
        validateString(parameterMap, ConstantStrings.USER_NAME);
        validateString(parameterMap, ConstantStrings.EMAIL);
        validateString(parameterMap, ConstantStrings.FIRST_NAME);
        validateString(parameterMap, ConstantStrings.LAST_NAME);
        validateString(parameterMap, ConstantStrings.PASSWORD);
        
        
        account.setUserName(parameterMap.get(ConstantStrings.USER_NAME)[0]);
        account.setEmail(parameterMap.get(ConstantStrings.EMAIL)[0]);
        account.setFirstName(parameterMap.get(ConstantStrings.FIRST_NAME)[0]);
        account.setLastName(parameterMap.get(ConstantStrings.LAST_NAME)[0]);
        account.setPassword(parameterMap.get(ConstantStrings.PASSWORD)[0]);
       
        if (parameterMap.containsKey(ConstantStrings.PHONE_NUMBER)) {
            account.setPhoneNumber(parameterMap.get(ConstantStrings.PHONE_NUMBER)[0]);
        }
        // status 1 is active
        account.setStatus(1);

        return account;
    }

    /**
     * this method is not implemented
     *
     * @param search
     * @return
     */
    @Override
    public List<Account> search(String search) {
        return null;
    }

    /**
     * @see GenericLogic#get(java.util.function.Supplier) see {@link AccountDAO#findByUserName(java.lang.String)
     * }
     * @param userName - search for this userName in the table
     * @param password - match given password with password retrieved from db
     * @return {@link Account} - if this account exists in db
     */
    public Account getAcountWith(String userName, String password) {
        Objects.requireNonNull(userName, AccountLogic.class.getName() + " userName " + ConstantStrings.NULL_OBJECT_ERROR);
        Objects.requireNonNull(password, AccountLogic.class.getName() + " password " + ConstantStrings.NULL_OBJECT_ERROR);
        
        Optional<Account> userNameAccount = Optional.ofNullable(get(() -> dao().findByUserName(userName)));
        if (userNameAccount.isPresent()) {
            return BCrypt.checkpw(password, userNameAccount.get().getPassword()) ? userNameAccount.get() : null;
        }

        return null;
    }
    
    public boolean comparePasswords(String newPassword, String oldPassword) {
      
        return BCrypt.checkpw(newPassword, oldPassword);
    }

    /**
     * check if there is an exciting account for this email or userName
     *
     * @see GenericLogic#get(java.util.function.Supplier) 
     * see {@link AccountDAO#findByUserName(java.lang.String)}
     * see {@link AccountDAO#findByEmail(java.lang.String) }
     * @param userName - search for this userName in the table
     * @param email - search for this email in the table
     * @return - {@link Map}
     */
    public Map<String, Boolean> getUniqueAcount(String userName, String email) {
        
        Objects.requireNonNull(userName, AccountLogic.class.getName() + " userName " + ConstantStrings.NULL_OBJECT_ERROR);
        Objects.requireNonNull(email, AccountLogic.class.getName() + " email " + ConstantStrings.NULL_OBJECT_ERROR);

        // FIXME: {@link AccountDAO#findByEmail(java.lang.String) } is not working as it should
        Optional<Account> emailAccount = Optional.ofNullable(get(() -> dao().findByEmail(email)));
        Optional<Account> userNameAccount = Optional.ofNullable(get(() -> dao().findByUserName(userName)));
        Map<String, Boolean> map = new HashMap<>();

        map.put(ConstantStrings.USER_NAME, userNameAccount.isPresent());
        map.put(ConstantStrings.EMAIL, emailAccount.isPresent());

        return map;
    }
}

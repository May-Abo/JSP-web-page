/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.dao;

import com.may.entity.Account;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayab
 */
public class AccountDAO extends GenericDAO<Account>{
    
    /**
     * public constructor with no arguments 
     * @see GenericDAO#GenericDAO(java.lang.Class)
     */
    public AccountDAO() {
        super(Account.class);
    }
    
    /**
     * get all rows from Account table
     * @return all rows as a list of Account objects
     */
    public List<Account> findAll() {
        return findResults("Account.findAll", null);
    }
    
    /**
     * get the row (Account Object) with the given id from Account table
     * @param id - search for this id in Account table
     * @return one row {@link Account} with the selected id
     */
    public Account findById(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResult("Account.findById", map);
    }
    
    /**
     * get the row (entity) with the given userName from Account table
     * @param userName - search for this userName in Account table
     * @return one row {@link Account} with the selected userName
     */
    public Account findByUserName(String userName) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        return findResult("Account.findByUserName", map);
    }
    
    /**
     * get the row (entity) with the given userName from Account table
     * @param email - search for this email in Account table
     * @return one row {@link Account} with the selected email
     */
    public Account findByEmail(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        return findResult("Account.findByEmail", map);
    }
    
    /**
     * validate user log in by checking if a userName with this password exists
     * or not
     * @param userName - search for this username in Account table
     * @param password - search for this password in Account table
     * @return one row {@link Account} with the selected username and password
     */
    public Account validateUser(String userName, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("password", password);
        return findResult("Account.validateUser", map);
    }
    
}

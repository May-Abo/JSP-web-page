/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.dao;

import com.may.entity.Country;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayab
 */
public class CountryDAO extends GenericDAO<Country>{
    
    /**
     * public constructor with no arguments 
     * @see GenericDAO#GenericDAO(java.lang.Class)
     */
    public CountryDAO() {
        super(Country.class);
    }
    
    /**
     * get all rows from Country table
     * @return all rows as a list of Country objects
     */
    public List<Country> findAll() {
        return findResults("Country.findAll", null);
    }
    
    /**
     * get the row (Country Object) with the given id from Country table
     * @param id - search for this id in Country table
     * @return one row {@link Country} with the selected id
     */
    public Country findById(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return findResult("Country.findById", map);
    }
    
    /**
     * get the row (entity) with the given userName from Country table
     * @param country - search for this userName in Country table
     * @return one row {@link Country} with the selected userName
     */
    public Country findByCountry(String country) {
        Map<String, Object> map = new HashMap<>();
        map.put("country", country);
        return findResult("Country.findByCountry", map);
    }
    
    
}

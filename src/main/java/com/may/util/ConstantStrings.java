/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.util;

/**
 *
 * @author mayab
 */
public class ConstantStrings {
    
    // Column names:
    /**
     * This the column id
     */
    public static final String ID = "id";
    /**
     * This the column User_Name
     */
    public static final String USER_NAME = "User_Name";
    /**
     * This the column First_Name
     */
    public static final String FIRST_NAME = "First_Name";
    /**
     * This the column Last_Name
     */
    public static final String LAST_NAME = "Last_Name";
    /**
     * This the column Email
     */
    public static final String EMAIL = "Email";
    /**
     * This the column Password
     */
    public static final String PASSWORD = "Password";
    /**
     * This the column Status
     */
    public static final String STATUS = "Status";
    /**
     * This the column Country
     */
    public static final String COUNTRY = "Country";
    /**
     * This the column PhoneNumber
     */
    public static final String PHONE_NUMBER = "PhoneNumber";
    
    
    // Number constrians
    
    /**
    * Max number of characters  
    */
    public static final int MAX_COULUMN_CHAR = 45;
    /**
    * Min number of characters  
    */
    public static final int MIN_COULUMN_CHAR = 1;
    
    
    
    
    
   // Error messages
   /**
    * Error message for empty input fields
    */
    public static final String EMPTY_OBJECT_ERROR = "Can not be empty!";
    
    /**
    * Error message for failed log in
    */
    public static final String INVALID_LOGIN_ERROR = "Invalid User Name or Password!";
    
    /**
    * Error attribute message for failed log in
    */
    public static final String INVALID_LOGIN = "Invalid Login!";
    
    /**
    * Error password and repassword are not the same
    */
    public static final String PASSWORD_MATCH_ERROR = "The passwords do not match!";
    /**
    * Null pointer exception Message
    */
    public static final String NULL_OBJECT_ERROR = "Can not be null!";
    /**
     * String length in not between  {@link ConstantStrings#MAX_COULUMN_CHAR} and {@link ConstantStrings#MIN_COULUMN_CHAR}
     */
    public static final String NUM_CHAR_ERROR = "Number of characters can't be more than " + MAX_COULUMN_CHAR;
    /**
     * Error userName or email taken
     */
    public static final String USERNAME_TAKEN_ERROR = "This User Name is already taken!";
    public static final String EMAIL_TAKEN_ERROR = "This Email is already taken!";
    public static final String USERNAME_ERROR = "userNameNotUnique";
    public static final String EMAIL_ERROR = "emailNotUnique";
    
    // Front-end strings
    public static final String LOGIN = "Login";
    public static final String SIGNUP = "SignUp";
    
    /**
     * password Restriction
     */
    public static final String ONE_NUM = "at least 1 number";
    public static final String ONE_LOWER = "at least 1 lowercase";
    public static final String ONE_UPPER = "at least 1 uppercase";
    public static final String ONE_SPECIAL = "at least one special character";
    public static final String MIN_CHAR = "at least 8 characters";

}

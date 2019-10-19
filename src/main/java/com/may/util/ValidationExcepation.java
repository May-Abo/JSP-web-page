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
public class ValidationExcepation extends RuntimeException{
    
    public ValidationExcepation(){
        super();
    }
    public ValidationExcepation(String message){
        super(message);
    }
}

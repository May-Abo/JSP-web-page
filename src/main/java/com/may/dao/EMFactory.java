/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @see https://www.deadcoderising.com/execute-code-on-webapp-startup-and-shutdown-using-servletcontextlistener/
 * @see https://docs.oracle.com/javaee/7/api/javax/servlet/ServletContextListener.html
 * @see https://docs.oracle.com/javaee/7/api/javax/persistence/Persistence.html
 * @author mayab
 */

//This annotation was introduced in Servlet 3.0 and will make sure that the web application 
//will find your ServletContextListener implementation.
@WebListener
public class EMFactory implements ServletContextListener{

    private static EntityManagerFactory emFactory;
    
    
    /**
     * this method is triggered when the web application is starting the
     * initialization. This will be invoked before any of the filters
     * and servlets are initialized.
     * @param sce 
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if(emFactory==null){
            emFactory = Persistence.createEntityManagerFactory("JPA-Tomcat-ScoreDB");
        }
    }

    /**
     * this method is triggered when the ServletContext is about to be 
     * destroyed. This will be invoked after all the servlets and filters 
     * have been destroyed.
     * @param sce 
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if(emFactory!=null){
            emFactory.close();
        }
    }
    
    public static EntityManagerFactory getEMFactory(){
        return emFactory;
    }
}

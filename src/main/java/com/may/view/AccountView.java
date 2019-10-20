/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.view;

import com.may.entity.Account;
import com.may.logic.AccountLogic;
import java.io.IOException;
import com.may.util.ConstantStrings;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mayab
 */
@WebServlet(name = "AccountView", urlPatterns = {"/AccountView"})
public class AccountView extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        viewUserAccount(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter(ConstantStrings.LOGOUT) != null) {
            logOut(request, response);
        } else if (request.getParameter(ConstantStrings.DELETE) != null) {
            deleteAccount(request, response);
        }
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void logOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession(false).setAttribute("userlogedID", null);
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");

    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer currentUserID = (Integer) request.getSession(false).getAttribute("userlogedID");
        String[] userNameRequesting = request.getParameterValues(ConstantStrings.DELETE);      
        
        AccountLogic al = new AccountLogic();
        Optional<Account> userRequesting = Optional.ofNullable(al.getWithUserName(userNameRequesting[0]));
         
        if(userRequesting.isPresent()) {
            if(Objects.equals(currentUserID, userRequesting.get().getId())) {
                al.delete(userRequesting.get());
            }
        }
        logOut(request, response);
    }
    
    private void viewUserAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer currentUserID = (Integer) request.getSession(false).getAttribute("userloged");
        if(Optional.ofNullable(currentUserID).orElse(0) != 0) {
            AccountLogic al = new AccountLogic();
            Optional<Account> userAccount = Optional.ofNullable(al.getWithId(currentUserID));
        } else {
            logOut(request, response);
        }
    }
}

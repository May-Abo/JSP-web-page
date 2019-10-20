/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.view;

import com.may.entity.Account;
import com.may.logic.AccountLogic;
import com.may.util.ConstantStrings;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mayab
 */
@WebServlet(name = "LogInView", urlPatterns = {"/LogInView"})
public class LogInView extends HttpServlet {

    private void loginFormValidation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String> errorMessages = new HashMap<>();
        
        String userName = request.getParameter(ConstantStrings.USER_NAME);
        String password = request.getParameter(ConstantStrings.PASSWORD);
        
        if (userName == null || userName.isEmpty()) {
            errorMessages.put(ConstantStrings.USER_NAME, ConstantStrings.EMPTY_OBJECT_ERROR);
        }

        if (password == null || password.isEmpty()) {
            errorMessages.put(ConstantStrings.PASSWORD, ConstantStrings.EMPTY_OBJECT_ERROR);
        }

        if (errorMessages.isEmpty()) {
            AccountLogic al = new AccountLogic();
            Account validAccount  = al.getAcountWith(userName, password);
            boolean validLogin = (Optional.ofNullable(validAccount).isPresent());
            if (!validLogin) {
                errorMessages.put(ConstantStrings.LOGIN, ConstantStrings.INVALID_LOGIN_ERROR);
            } else {
                request.getSession().setAttribute("userlogedID", validAccount.getId());
            }
        }

        if (errorMessages.isEmpty()) {
            
            response.sendRedirect("account.jsp");
        } else {
            request.setAttribute("errorMessages", errorMessages);
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }

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
        response.sendRedirect("index.jsp");
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
        processRequest(request, response);
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
        if (request.getParameter("signUpButton") != null) {
            response.sendRedirect("SignUpView");
        } else {
            loginFormValidation(request, response);
        }
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

}

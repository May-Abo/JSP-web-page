/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.may.view;

import com.may.entity.Account;
import com.may.entity.Country;
import com.may.util.ConstantStrings;
import com.may.logic.AccountLogic;
import com.may.logic.CountryLogic;
import com.may.util.ValidationExcepation;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mayab
 */
@WebServlet(name = "SignUpView", urlPatterns = {"/SignUpView"})
public class SignUpView extends HttpServlet {

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

        Map<String, String> errorMessages = registrationFormValidation(request);

        AccountLogic al = new AccountLogic();

        if (errorMessages.isEmpty()) {
            errorMessages = uniqueAcountValidation(errorMessages, request, ConstantStrings.USER_NAME, ConstantStrings.EMAIL);

            if (errorMessages.isEmpty()) {
                errorMessages = createAcountValidation(errorMessages, request, response);
            }
        }

        if (errorMessages.isEmpty()) {
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessages", errorMessages);
            List<Country> countries = fillCountyDropDown();
            request.setAttribute("countries", countries);
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }

    }

    private Map<String, String> registrationFormValidation(HttpServletRequest request)
            throws ServletException, IOException {

        Map<String, String> errorMessages = new HashMap<>();

        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> {
            if (!(k.equals(ConstantStrings.PHONE_NUMBER) || k.equals(ConstantStrings.SIGNUP))) {
                if (v == null || v[0].isEmpty()) {
                    errorMessages.put(k, ConstantStrings.EMPTY_OBJECT_ERROR);
                }
            }
        });

        return errorMessages;
    }

    private Map<String, String> uniqueAcountValidation(Map<String, String> errorMessages, HttpServletRequest request, String userName, String emailAddress)
            throws ServletException, IOException {

        AccountLogic al = new AccountLogic();
        String user = request.getParameter(userName);
        String email = request.getParameter(emailAddress);

        Map<String, Boolean> excitingAccount = al.getUniqueAcount(user, email);

        if (excitingAccount.get(userName)) {
            errorMessages.put(ConstantStrings.USERNAME_ERROR, ConstantStrings.USERNAME_TAKEN_ERROR);
        }
        if (excitingAccount.get(emailAddress)) {
            errorMessages.put(ConstantStrings.EMAIL_ERROR, ConstantStrings.EMAIL_TAKEN_ERROR);
        }

        return errorMessages;
    }

    private Map<String, String> createAcountValidation(Map<String, String> errorMessages, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountLogic al = new AccountLogic();

        try {

            Account userAccount = al.createEntity(request.getParameterMap());
            Objects.requireNonNull(userAccount);

            String countryID = request.getParameter(ConstantStrings.COUNTRY);
            Objects.requireNonNull(Integer.parseInt(countryID));

            Country country = new CountryLogic().getWithId(Integer.parseInt(countryID));
            Objects.requireNonNull(country);

            userAccount.setCountry(country);

            al.add(userAccount);

        } catch (ValidationExcepation e) {
            errorMessages.put("Error", e.getMessage());
        } catch (RuntimeException ex) {
            errorMessages.put("Error", "This is not supposed to happen!");
        }

        return errorMessages;
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
        List<Country> countries = fillCountyDropDown();
        request.setAttribute("countries", countries);
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }

    private List<Country> fillCountyDropDown() {
        
        CountryLogic cl = new CountryLogic();
        List<Country> countries = cl.getAll();
        return countries;
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
        processRequest(request, response);

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

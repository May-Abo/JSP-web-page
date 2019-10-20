<%-- 
    Document   : strings
    Created on : 19-Oct-2019, 4:29:57 PM
    Author     : mayab
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.may.util.ConstantStrings" %>

    <c:set var="password" value="${ConstantStrings.PASSWORD}"/>
    <c:set var="userName" value="${ConstantStrings.USER_NAME}"/>
    <c:set var="login" value="${ConstantStrings.LOGIN}"/>
    <c:set var="emptyFiledError" value="${ConstantStrings.EMPTY_OBJECT_ERROR}"/> 
    <c:set var="fname" value="${ConstantStrings.FIRST_NAME}"/>
    <c:set var="lname" value="${ConstantStrings.LAST_NAME}"/>
    <c:set var="email" value="${ConstantStrings.EMAIL}"/>
    <c:set var="phone" value="${ConstantStrings.PHONE_NUMBER}"/>
    <c:set var="country" value="${ConstantStrings.COUNTRY}"/>
    <c:set var="signUp" value="${ConstantStrings.SIGNUP}"/>
    <c:set var="passMatchError" value="${ConstantStrings.PASSWORD_MATCH_ERROR}"/>
        
    <c:set var="userErrorMes" value="${ConstantStrings.USERNAME_TAKEN_ERROR}"/>
    <c:set var="userError" value="${ConstantStrings.USERNAME_ERROR}"/>
    <c:set var="emailErroMes" value="${ConstantStrings.EMAIL_TAKEN_ERROR}"/>
    <c:set var="emailError" value="${ConstantStrings.EMAIL_ERROR}"/>
    
    <c:set var="oneNum" value="${ConstantStrings.ONE_NUM}"/>
    <c:set var="oneLow" value="${ConstantStrings.ONE_LOWER}"/>
    <c:set var="oneUp" value="${ConstantStrings.ONE_UPPER}"/>
    <c:set var="oneSpecial" value="${ConstantStrings.ONE_SPECIAL}"/>
    <c:set var="minChar" value="${ConstantStrings.MIN_CHAR}"/>

    <c:set var="logout" value="${ConstantStrings.LOGOUT}"/>
    <c:set var="delete" value="${ConstantStrings.DELETE}"/>
    <c:set var="update" value="${ConstantStrings.UPDATE}"/>
    <c:set var="confirm" value="${ConstantStrings.CONFIRM}"/>
    <c:set var="Discard" value="${ConstantStrings.DISCARD}"/>
    
    <c:set var="deleteAcount" value="${ConstantStrings.DELETE_ACCOUNT}"/>
    <c:set var="updateAcount" value="${ConstantStrings.UPDATE_ACCOUNT}"/>
    <c:set var="resetPassword" value="${ConstantStrings.RESET_PASSWORD}"/>
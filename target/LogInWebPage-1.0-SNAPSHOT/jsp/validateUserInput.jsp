<%-- 
    Document   : newjsp
    Created on : 18-Oct-2019, 9:59:37 PM
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
<script>
   
function validateUserRegistration() {
    
    $("#${emailError}").addClass("d-none");
    $("#${userError}").addClass("d-none");
    $(".form-group .form-control").removeClass("is-invalid");
    $(".form-group .form-control").removeClass("is-valid");
    
    var invalid = false;
    if ($("#${fname}").val()==''){
        $("#${fname}").addClass("is-invalid");
        invalid = true;
    }
    if($("#${lname}").val()==''){
        $("#${lname}").addClass("is-invalid");
        invalid = true;
    }
    if ($("#${userName}").val()==''){
        $("#${userName}").addClass("is-invalid");
        invalid = true;
    }
    if($("#${email}").val()==''){
        $("#${email}").addClass("is-invalid");
        invalid = true;
    }
    
    if(passwordRestriction($("#${password}").val())){
        $("#${password}").addClass("is-invalid");
        invalid = true;
    }
    if($("#repass").val() !== $("#${password}").val() || $("#repass").val()==''){
       $("#repass").addClass("is-invalid");
       invalid = true; 
    } else {
       $("#repass").addClass("is-valid"); 
    }
    
    if(invalid){
        event.preventDefault();
    }
}


function validateUserLoginForm() {
    $("#invalidLoginError").addClass("d-none");
    $(".form-group input").removeClass("is-invalid");
    var invalid = false;
    if ($("#${userName}").val()==''){
        $("#${userName}").addClass("is-invalid");
        invalid = true;
    }
    if($("#${password}").val()==''){
        $("#${password}").addClass("is-invalid");
        invalid = true;
    }
    if(invalid){
        event.preventDefault();
    }  
}

function passwordRestriction(password) {
    var invalid = false;
    var pass = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    if(!pass.test(password)){

        $(document).ready(function() {
        $('[data-toggle="popover"]').popover({
            html: true,
            content: function() {
              return $('#popover-content').html();
            }
          });
        });

    }
   return invalid;
   }
</script>

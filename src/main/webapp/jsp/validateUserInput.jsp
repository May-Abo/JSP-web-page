<%-- 
    Document   : newjsp
    Created on : 18-Oct-2019, 9:59:37 PM
    Author     : mayab
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./strings.jsp" %>
<script>

    function validateUserRegistration() {

        $("#${emailError}").addClass("d-none");
        $("#${userError}").addClass("d-none");
        $(".form-group .form-control").removeClass("is-invalid");
        $(".form-group .form-control").removeClass("is-valid");

        var invalid = false;
        if ($("#${fname}").val() == '') {
            $("#${fname}").addClass("is-invalid");
            invalid = true;
        }
        if ($("#${lname}").val() == '') {
            $("#${lname}").addClass("is-invalid");
            invalid = true;
        }
        if ($("#${userName}").val() == '') {
            $("#${userName}").addClass("is-invalid");
            invalid = true;
        }
        if ($("#${email}").val() == '') {
            $("#${email}").addClass("is-invalid");
            invalid = true;
        }

        if (passwordRestriction($("#${password}").val())) {
            $("#${password}").addClass("is-invalid");
            invalid = true;
        }
        if ($("#repass").val() !== $("#${password}").val() || $("#repass").val() == '') {
            $("#repass").addClass("is-invalid");
            invalid = true;
        } else {
            $("#repass").addClass("is-valid");
        }

        if (invalid) {
            event.preventDefault();
        }
    }


    function validateUserLoginForm() {
        $("#invalidLoginError").addClass("d-none");
        $(".form-group input").removeClass("is-invalid");
        var invalid = false;
        if ($("#${userName}").val() == '') {
            $("#${userName}").addClass("is-invalid");
            invalid = true;
        }
        if ($("#${password}").val() == '') {
            $("#${password}").addClass("is-invalid");
            invalid = true;
        }
        if (invalid) {
            event.preventDefault();
        }
    }

    function passwordRestriction(password) {
        var invalid = false;
        var pass = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
        if (!pass.test(password)) {

            $(document).ready(function () {
                $('[data-toggle="popover"]').popover({
                    html: true,
                    content: function () {
                        return $('#popover-content').html();
                    }
                });
            });
               invalid = true;
        }
        return invalid;
    }
    
    function validateResetPassword(){
        
        $(".form-group .form-control").removeClass("is-invalid");
        $(".form-group .form-control").removeClass("is-valid");

        var invalid = false;
        
        
        if (passwordRestriction($("#${currPass}").val())) {
            $("#${currPass}").addClass("is-invalid");
            invalid = true;
        }
        if (passwordRestriction($("#${newPass}").val())) {
            $("#${newPass}").addClass("is-invalid");
            invalid = true;
        }
        if ($("#repass").val() !== $("#${newPass}").val() || $("#repass").val() == '') {
            $("#repass").addClass("is-invalid");
            invalid = true;
        } else {
            $("#repass").addClass("is-valid");
        }
        
        if (invalid) {
            event.preventDefault();
        }
        
    }
</script>

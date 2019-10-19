<%-- 
    Document   : index
    Created on : 14-Oct-2019, 11:54:05 PM
    Author     : mayab
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="jsp/validateUserInput.jsp" %>
<html>
    <head>
        <%@ include file="jsp/header.jsp" %>
        <title>Login Page</title>
    </head>
    <body>

        <script>
            window.onload = checkErrorMessages;
            validateUserLoginForm();
            function checkErrorMessages() {
            <c:forEach var="errorMessage" items="${errorMessages}">
            $("#${errorMessage.key}").addClass("is-invalid");
            </c:forEach>
                if ($("#${login}").hasClass("is-invalid")) {
                    $("#invalidLoginError").removeClass("d-none");
                }
            }
        </script>

        <div class="container d-flex justify-content-center align-items-center">
            <div class="border border-warning p-3 shadow-lg mb-5 bg-white rounded w-50">
                <div class="row">
                    <div class="col">
                        <h3 class="col-form-label">Login to your account</h3>
                        <div class="dropdown-divider"></div>
                        <form action="LogInView" name="logInForm" method="post" id="logInForm" onsubmit="return validateUserLoginForm()">
                            <div class="form-group">
                                <label for="${userName}">User Name</label>
                                <input type="text" class="form-control" id="${userName}" 
                                       name="${userName}" placeholder="User Name" >
                                <span class="invalid-feedback">${emptyFiledError}</span>
                            </div>
                            <div class="form-group">
                                <label for="${password}">Password</label>
                                <input type="password" class="form-control" id="${password}" 
                                       name="${password}" placeholder="Password" >
                                <span class="invalid-feedback">${emptyFiledError}</span>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <button type="submit" class="btn btn-outline-dark  btn-block" name="${login}"
                                            id="${login}" title="Login" value="${login}">Login</button>
                                </div>
                                <div class="col">
                                    <a href="SignUpView" class="btn btn-outline-dark  btn-block" role="button" aria-pressed="true"
                                       title="Sign Up" name="signUpButton">Sign Up</a>
                                </div>
                            </div>
                            <div class="row d-none" id="invalidLoginError">
                                <div class="col p-3" >
                                    <div class="alert alert-danger text-center">
                                        ${errorMessages.get(login)}
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>    
                </div>
            </div>
        </div>
    </body>
</html>

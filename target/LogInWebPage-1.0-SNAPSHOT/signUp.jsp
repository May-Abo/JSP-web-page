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
        <title>LogIn Page</title>
    </head>
    <body>

        <script>
            window.onload = checkErrorMessages;
            validateUserRegistration();

            function checkErrorMessages() {
                 
                <c:forEach var="errorMessage" items="${errorMessages}">
                        
                    <c:set var="duplicateEmailorUser" value="${errorMessage.key}"/> 
                    if ("${duplicateEmailorUser}" == "${userError}") {
                        $("#${userError}").removeClass("d-none");
                    }
                    if ("${duplicateEmailorUser}" == "${emailError}") {
                       $("#${emailError}").removeClass("d-none");
                    }
                    $("#${errorMessage.key}").addClass("is-invalid");
                </c:forEach>
            }
        </script>

        <div class="container d-flex justify-content-center align-items-center">
            <div class="border border-warning p-3 shadow-lg mb-5 bg-white rounded w-50">
                <div class="row ">
                    <div class="col">
                        <h3 class="col-form-label">Create an account</h3>
                        <div class="dropdown-divider"></div>
                        <form action="SignUpView" name="signUpForm" method="post" id="signUpForm" onsubmit="return validateUserRegistration()">
                            <div class="form-group">
                                <input type="text" class="form-control" id="${fname}" name="${fname}" placeholder="First Name">
                                <span class="invalid-feedback">${emptyFiledError}</span>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="${lname}" name="${lname}" placeholder="Last Name">
                                <span class="invalid-feedback">${emptyFiledError}</span>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" id="${userName}" name="${userName}" placeholder="User Name">
                                <span class="invalid-feedback">${emptyFiledError}</span>
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" id="${email}" name="${email}" placeholder="Email">
                                <span class="invalid-feedback">${emptyFiledError}</span>
                            </div>
                            <div class="form-group">
                                <input type="tel" class="form-control" id="${phone}" name="${phone}" placeholder="Phone Number">
                            </div>
                            <div class="form-group">
                                <select class="selectpicker form-control" data-live-search="true" data-size="7"
                                        id="${country}" name="${country}" placeholder="Country">
                                    <c:forEach var="c" items="${countries}">
                                        <option value="${c.id}" data-tokens="${c.country}">${c.country}</option>
                                    </c:forEach>
                                </select>
                                <span class="invalid-feedback">${emptyFiledError}</span>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="${password}" 
                                       name="${password}" placeholder="Password" data-toggle="popover">
                                <span class="invalid-feedback">${emptyFiledError}</span>
                                <div id="popover-content" style="display: none">
                                    <ul class="list-group custom-popover ">
                                        <li class="list-group-item text-danger">${oneNum}</li>
                                        <li class="list-group-item text-danger">${oneLow}</li>
                                        <li class="list-group-item text-danger">${oneUp}</li>
                                        <li class="list-group-item text-danger">${oneSpecial}</li>
                                        <li class="list-group-item text-danger">${minChar}</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="repass" name="repass" placeholder="Re-Password">
                                <span class="invalid-feedback">${passMatchError}</span>
                                <span class="valid-feedback">test</span>
                            </div>
                            <div class="row ">
                                <div class="col">
                                    <a href="LogInView" class="btn btn-outline-dark  btn-block" role="button" aria-pressed="true"
                                       title="Login" name="loginButton">Login</a>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-outline-dark  btn-block" name="${signUp}"
                                            id="${signUp}" title="Sign Up" >Sign Up</button>
                                </div>
                            </div>
                            <div class="row d-none" id="${userError}">
                                <div class="col p-3" >
                                    <div class="alert alert-danger text-center">
                                        ${errorMessages.get(userError)}
                                    </div>
                                </div>
                            </div>
                            <div class="row d-none" id="${emailError}">
                                <div class="col p-3" >
                                    <div class="alert alert-danger text-center">
                                        ${errorMessages.get(emailError)}
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

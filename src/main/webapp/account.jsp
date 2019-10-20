<%-- 
    Document   : account.jsp
    Created on : 19-Oct-2019, 11:04:45 AM
    Author     : mayab
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="jsp/strings.jsp" %>

<html>
    <head>
        <%@ include file="jsp/header.jsp" %>
        <title>Account Page</title>
    </head>
    <body>
        <div class="container d-flex justify-content-center align-items-center">
            <div class="border border-warning p-3 shadow-lg mb-5 bg-white rounded w-50">
                <div class="row ">
                    <div class="col">
                        <h3 class="col-form-label">Account Information</h3>
                        <div class="dropdown-divider"></div>
                        <form action="AccountView" name="AccountForm" method="post" id="AccountForm" class="form-horizontal">
                            <div class="form-group d-flex">
                                <div class="col-md-3">
                                    <label class="control-label text-center"  for="${fname}">First Name</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control border-warning" name="${fname}" placeholder="First Name" readonly>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-md-3">
                                    <label class="control-label text-center"  for="${lname}">Last Name</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control border-warning" name="${lname}" placeholder="Last Name" readonly>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-md-3">
                                    <label class="control-label text-center"  for="${userName}">User Name</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control border-warning" name="${userName}" placeholder="User Name" readonly>
                                </div>
                            </div>   

                            <div class="form-group d-flex">
                                <div class="col-md-3">
                                    <label class="control-label text-center"  for="${email}">Email</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="email" class="form-control border-warning" name="${email}" placeholder="Email" readonly>
                                </div>
                            </div>           
                            <div class="form-group d-flex">
                                <div class="col-md-3">
                                    <label class="control-label text-center"  for="${phone}">Phone</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="tel" class="form-control border-warning" name="${phone}" placeholder="Phone Number" readonly>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-md-3">
                                    <label class="control-label text-center"  for="${country}">Country</label>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control border-warning" name="${country}" placeholder="Country" readonly>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <button type="submit" class="btn btn-outline-dark  btn-block" name="${update}"
                                            id="${update}" title="${updateAcount}" value="${update}">${updateAcount}</button>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-outline-dark  btn-block" name="${confirm}"
                                            id="${confirm}" title="${resetPassword}" value="${confirm}">${resetPassword}</button>
                                </div>
                            </div>
                            <div class="dropdown-divider"></div>
                            <div class="row">
                                <div class="col">
                                    <button type="submit" class="btn btn-outline-dark  btn-block" name="${logout}"
                                            id="${logout}" title="Log Out" value="${logout}">Log Out</button>
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-outline-dark  btn-block" name="${delete}"
                                            id="${delete}" title="${deleteAcount}" value="${delete}">${deleteAcount}</button>
                                </div>
                            </div>
                        </form>
                    </div>    
                </div>
            </div>
        </div>
    </body>
</html>

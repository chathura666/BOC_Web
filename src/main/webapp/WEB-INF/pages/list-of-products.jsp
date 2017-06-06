<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>List of Products</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  


                </head>
                <body>
                    <div class="container">
                        <h3>List of Products</h3>
                        <div class="row"><br></br></div>
                        <div class="row" style="padding-bottom: 10px">
                            <div class="col-sm-10">
                                <c:if test = "${not empty message}">
                                    <div style="padding-top: 5px;padding-bottom: 5px;" class="alert alert-success" role="alert"><c:out value = "${message}"/></div>
                                </c:if>
                            </div>
                            <div class="col-sm-2">
                                <a href="${pageContext.request.contextPath}/pbase/addProduct.html" class="btn btn-success" role="button" style="width:110px">+ Add New</a>
                            </div>
                        </div>
                        <!-- Table -->
                        <div class="row">
                            <table class="table table-striped table-bordered">

                                <thead>
                                    <tr>
                                        <div class="row">
                                            <td class="col-md-1">PID</td>
                                            <td class="col-md-1">P_Code</td>
                                            <td class="col-md-1">WF_P_Code</td>
                                            <td class="col-md-3">P_Name</td>
                                            <td class="col-md-3">P_Desc</td>
                                            <td class="col-md-1">P_Cat_ID</td>
                                            <td class="col-md-2"></td>
                                    </tr>
                                </thead>

                                <tbody>
                                    <c:forEach var="pbase" items="${pbases}">
                                        <div class="row">
                                            <tr>
                                                <td class="col-md-1">${pbase.PID}</td>
                                                <td class="col-md-1">${pbase.PRODUCT_CODE}</td>
                                                <td class="col-md-1">${pbase.WF_PRODUCT_CODE}</td>
                                                <td class="col-md-3">${pbase.PRODUCT_NAME}</td>
                                                <td class="col-md-3">${pbase.PRODUCT_DESCRIPTION}</td>
                                                <td class="col-md-1">${pbase.PRODUCT_CATEGORY_ID}</td>
                                                <td class="col-md-2">
                                                    <a href="${pageContext.request.contextPath}/pbase/editProduct/${pbase.PID}.html" class="btn btn-primary" role="button" style="width:60px">Edit</a>
                                                    <a href="${pageContext.request.contextPath}/pbase/deleteProduct/${pbase.PID}.html" class="btn btn-warning" role="button" style="width:60px">Delete</a>
                                                </td>
                                            </tr>
                                        </div>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!--<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>-->
                    </div>



                </body>
                </html>
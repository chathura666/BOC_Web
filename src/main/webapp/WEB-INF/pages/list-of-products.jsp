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
                    <h2 style="padding-left: 10px;">List of Products</h2>
                    <div><br></br></div>
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading" style="padding-left: 10px; padding-bottom: 10px">Here you can see the list of the products, edit them, remove or update.</div>
     
                        <!-- Table -->
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr align="center">
                                    <th align="center" width="5%">PID</th><th align="center" width="5%">P_Code</th><th align="center" width="5%">WF_P_Code</th><th align="center" width="20%">P_Name</th><th align="center" width="35%">P_Desc</th><th align="center" width="5%">P_Cat_ID</th><th align="center" width="20%"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="pbase" items="${pbases}">
                                    <tr>
                                        <td align="left">${pbase.PID}</td>
                                        <td align="left">${pbase.PRODUCT_CODE}</td>
                                        <td align="left">${pbase.WF_PRODUCT_CODE}</td>
                                        <td align="left">${pbase.PRODUCT_NAME}</td>
                                        <td align="left">${pbase.PRODUCT_DESCRIPTION}</td>
                                        <td align="left">${pbase.PRODUCT_CATEGORY_ID}</td>
                                        <td align="center">
                                            <a href="${pageContext.request.contextPath}/pbase/editProduct/${pbase.PID}.html" class="btn btn-primary" role="button" style="width:70px">Edit</a>
                                            <a href="${pageContext.request.contextPath}/pbase/deleteProduct/${pbase.PID}.html" class="btn btn-primary" role="button" style="width:70px">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

                </body>
                </html>
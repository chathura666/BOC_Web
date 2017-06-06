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
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  

            <script src=" //code.jquery.com/jquery-1.12.4.js"></script> 
            <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 
            <script src="https://cdn.datatables.net/1.10.15/js/dataTables.jqueryui.min.js"></script> 

            <script>

                $(document).ready(function () {
                    $('#datatable').DataTable();
                });
            </script>
    </head>
    <body>
        <div class="container">
            <h3>List of Products</h3>
            <div><br></br></div>
            <div style="padding-bottom: 10px">
                <div>
                    <c:if test = "${not empty message}">
                        <div style="padding-top: 5px;padding-bottom: 5px;" class="alert alert-success" role="alert"><c:out value = "${message}"/></div>
                    </c:if>
                </div>
                <div>
                    <a href="${pageContext.request.contextPath}/pbase/addProduct.html" class="btn btn-success" role="button" style="width:110px">+ Add New</a>
                </div>
            </div>
            <!-- Table -->
            <div>
                <table id="datatable" class="display" cellspacing="0" width="100%">

                    <thead>
                        <tr>
                            <div>
                                <td>PID</td>
                                <td>P_Code</td>
                                <td>WF_P_Code</td>
                                <td>P_Name</td>
                                <td>P_Desc</td>
                                <td>P_Cat_ID</td>
                                <td></td>
                                <td></td>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="pbase" items="${pbases}">
                            <tr>
                                <td>${pbase.PID}</td>
                                <td>${pbase.PRODUCT_CODE}</td>
                                <td>${pbase.WF_PRODUCT_CODE}</td>
                                <td>${pbase.PRODUCT_NAME}</td>
                                <td>${pbase.PRODUCT_DESCRIPTION}</td>
                                <td>${pbase.PRODUCT_CATEGORY_ID}</td>

                                <td>   <a href="${pageContext.request.contextPath}/pbase/editProduct/${pbase.PID}.html" class="btn btn-primary" role="button" style="width:60px">Edit</a>  </td>
                                <td>   <a href="${pageContext.request.contextPath}/pbase/deleteProduct/${pbase.PID}.html" class="btn btn-warning" role="button" style="width:60px">Delete</a>  </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!--<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>-->
        </div>



    </body>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  
            <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.jqueryui.min.css">  
                </html>



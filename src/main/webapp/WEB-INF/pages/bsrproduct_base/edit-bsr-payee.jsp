<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Edit Payee page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

                <script>
                    function disable()
                    {
                        document.getElementById('pid').disabled = true;
                    }
                </script>

                </head>
                <body>
                    <div class ="container" >
                        <div class="col-sm-9 col-sm-offset-3"><h3>Edit BSR Payee</h3></div>
                        <div class="col-sm-9 col-sm-offset-3"><p>Here you can edit payee details....</p></div>
                        <form:form method="POST" class="form-horizontal" commandName="product" action="${pageContext.request.contextPath}/bsrproduct/editProduct/${payee.payeeId}.html">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">PRODUCT ID:</label>
                                <div class="col-sm-4">
                                    <form:input id="pid" type="text" class="form-control" readonly="true" path="productId"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">PRODUCT CODE:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="productCode"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">PRODUCT NAME:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="productName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">CURRENCY:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="currency"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">SO DEBITS ALLOWED:</label>
                                <div class="col-sm-4">
                                    <form:input id="pid" type="text" class="form-control"  path="soDebitsAllowed"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">SO CREDITS ALLOWED:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="soCreditsAllowed"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">TFR TO LKR AC ALLOWED:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="tfrToLkrAcAllowed"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">TFR TO FCY AC ALLOWED:</label>
                                <div class="col-sm-4">
                                    <form:input id="pid" type="text" class="form-control"  path="tfrToFcyAcAllowed"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">IF FCY ALLOWED ELIGIBLE PRODUCT TYPES:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="ifFcyAllowedEligibleProductTypes"/>
                                </div>
                            </div>                        
                            <div class="form-group row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary btn-block">Edit Record</button>
                                </div>
                                <div class="col-sm-2">
                                    <a href="${pageContext.request.contextPath}/bsrproduct/listProducts.html" type="button" class="btn btn-default btn-block" >Close</a>
                                </div>
                                <div class="col-sm-5"></div>
                            </div>     
                        </form:form>
                    </div>


                </body>
                </html>
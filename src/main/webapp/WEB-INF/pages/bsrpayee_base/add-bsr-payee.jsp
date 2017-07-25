<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Add BSR Payee</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

                </head>
                <body>
                    <div class ="container" >
                        <div class="col-sm-9 col-sm-offset-3"><h3>Add Payee</h3></div>
                        <div class="col-sm-9 col-sm-offset-3"><p>Here you can add payee details....</p></div>
                        <form:form method="POST" class="form-horizontal" commandName="payee" action="${pageContext.request.contextPath}/bsrpayee/addPayee.html">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">PAYEE ID:</label>
                                <div class="col-sm-4">
                                    <form:input id="pid" type="text" class="form-control"  path="payeeId"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">PAYEE:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="payee"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">PAYEE TYPE:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="payeeType"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">TARGET TYPE:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="targetType"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">ACCOUNT NO:</label>
                                <div class="col-sm-4">
                                    <form:input id="pid" type="text" class="form-control"  path="accountNo"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">TARGET DESCRIPTION:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="targetDescription"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">FEE PLAN:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="feePlan"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">CURRENCY:</label>
                                <div class="col-sm-4">
                                    <form:input id="pid" type="text" class="form-control"  path="currency"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">COMPROF DR AC SV:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="comprofDrAcSv"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">COMPROF DR AC DD:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="comprofDrAcDd"/>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary btn-block">Add Record</button>
                                </div>
                                <div class="col-sm-2">
                                    <a href="${pageContext.request.contextPath}/bsrpayee/listPayees.html" type="button" class="btn btn-default btn-block" >Close</a>
                                </div>
                                <div class="col-sm-5"></div>
                            </div>    
                        </form:form>
                    </div>


                </body>
                </html>
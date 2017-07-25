<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Add Product page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  

                </head>
                <body>
                    <div class="container" >
                        <div class="col-sm-9 col-sm-offset-3"><h3>Add Credit Limit</h3></div>
                        <div class="col-sm-9 col-sm-offset-3"><p>Here you can add a new credit limit details....</p></div>
                        <form:form method="POST" class="form-horizontal" role="form" commandName="eligibility" action="${pageContext.request.contextPath}/cceligibility/addEligibility.html">        

                            <div class="form-group">
                                <label  class="col-sm-3 control-label">CCE ID:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="cceId" maxlength="4"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">MAIN CATEGORY:</label>
                                <div class="col-sm-4">
                                    <form:select class="form-control" path="mainCategory" style="margin-top: 6px;width:150px">
                                        <form:options  items="${creditBrand}"></form:options>                                                                                                       
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">SUB CATEGORY:</label>
                                <div class="col-sm-4">
                                    <form:select class="form-control" path="subCategory" style="margin-top: 6px;width:150px">
                                        <form:options  items="${subCategory}"></form:options>                                                                                                       
                                    </form:select>                           
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">SUB SELECTION:</label>
                                <div class="col-sm-4">
                                    <form:select class="form-control" path="subSelection" style="margin-top: 6px;width:150px">
                                        <form:options  items="${creditType}"></form:options>                                                                                                       
                                    </form:select> 
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary btn-block">Add Credit Limit</button>
                                </div>
                                <div class="col-sm-2">
                                    <a href="${pageContext.request.contextPath}/cceligibility/listEligibilities.html" type="button" class="btn btn-default btn-block" >Close</a>
                                </div>
                                <div class="col-sm-5"></div>
                            </div>
                        </form:form>
                    </div>


                </body>
                </html>
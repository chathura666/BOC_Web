<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Edit Product Category page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

                </head>
                <body>
                    <div class ="container" >
                        <div class="col-sm-9 col-sm-offset-3"><h3>Edit Loan Product Index Id Map</h3></div>
                        <div class="col-sm-9 col-sm-offset-3"><p>Here you can edit Loan Product Index Id Map details....</p></div>
                        <form:form method="POST" class="form-horizontal" commandName="idmap" action="${pageContext.request.contextPath}/LoanProductIndexIdMapping/editMapping/${idmap.prodIndexId}.html">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label" >PROD_INDEX_ID:</label>
                                <div class="col-sm-4">
                                    <form:input id="pid" type="text" readonly="true" class="form-control"  path="prodIndexId"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">PRODUCT NAME:</label>
                                <div class="col-sm-4">
                                    <form:select data-live-search="true" class="form-control" type="text" name="pname" path="">
                                        <form:option item="${ProdName}" value="${ProdName}" selected="true" >${ProdName}</form:option>
                                        <form:options items="${ProdNames}"></form:options>                                                                                                        
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">DESCRIPTION:</label>
                                <div class="col-sm-4">                       
                                    <form:select data-live-search="true" class="form-control" type="text" name="desc" path="">
                                        <form:option item="${index}" value="${index}" selected="true" >${index}</form:option>
                                        <form:options items="${Indexes}"></form:options>                                                                                                        
                                    </form:select>                                
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary btn-block">Edit Record</button>
                                </div>
                                <div class="col-sm-2">
                                    <a href="${pageContext.request.contextPath}/LoanProductIndexIdMapping/listMappings.html" type="button" class="btn btn-default btn-block" >Close</a>
                                </div>
                                <div class="col-sm-5"></div>
                            </div>    



                        </form:form>
                    </div>


                </body>
                </html>
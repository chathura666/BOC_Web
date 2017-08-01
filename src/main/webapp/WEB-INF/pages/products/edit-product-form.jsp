<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Edit Product page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

                </head>
                <body>
                    <div class="container" >
                        <div class="col-sm-9 col-sm-offset-3"><h3>Edit Product</h3></div>
                        <div class="col-sm-9 col-sm-offset-3"><p>Here you can edit products....</p></div>
                        <form:form method="POST" class="form-horizontal" commandName="pbase" action="${pageContext.request.contextPath}/ProductBase/editBase/${pbase.pid}.html">        
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product ID:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" readonly="true" path="pid" maxlength="4"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product Code:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" required="true" path="productCode" maxlength="5"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">WF Product Code:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" required="true" path="wfProductCode" maxlength="5"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Product Name:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" required="true" path="productName" maxlength="100"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product Description:</label>
                                <div class="col-sm-4">
                                    <form:input type="text" class="form-control" path="productDescription" maxlength="200" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product Category:</label>
                                <div class="col-sm-4">
                                    <form:select data-live-search="true" class="form-control" type="text" name="pcat" path="">
                                        <form:option value="${ProdCat}" selected="true" >${ProdCat}</form:option>
                                        <form:options  items="${ProdCats}"></form:options>                                                                                                        
                                    </form:select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary btn-block">Edit Record</button>
                                </div>
                                <div class="col-sm-2">
                                    <a href="${pageContext.request.contextPath}/ProductBase/listBases.html" type="button" class="btn btn-default btn-block" >Close</a>
                                </div>
                                <div class="col-sm-5"></div>
                            </div>
                        </form:form>
                    </div>


                </body>
                </html>
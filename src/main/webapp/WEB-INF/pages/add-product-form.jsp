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
                        <div class="col-sm-9 col-sm-offset-3"><h3>Add Product</h3></div>
                        <div class="col-sm-9 col-sm-offset-3"><p>Here you can add a new product....</p></div>
                        <form:form method="POST" class="form-horizontal" role="form" commandName="pbase" action="${pageContext.request.contextPath}/pbase/addProduct.html">        
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product ID:</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" path="pid"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product Code:</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" path="productCode"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">WF Product Code:</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" path="wfProductCode"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Product Name:</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" path="productName"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product Description:</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" path="productDescription"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">Product Category ID:</label>
                                <div class="col-sm-9">
                                    <form:input type="text" class="form-control" path="productCategoryId.productCategoryId"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-2 col-sm-offset-6">
                                    <button type="submit" class="btn btn-primary btn-block">Add Product</button>
                                </div>
                            </div>

<!--                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-3">
                                    <p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
                                </div>
                            </div>                                -->
                        </form:form>
                    </div>


                </body>
                </html>
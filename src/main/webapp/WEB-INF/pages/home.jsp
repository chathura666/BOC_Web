<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Home page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  

                <script>
                    function redirect_url(url)
                    {
                        window.location = url;
                    }


                </script>

                </head>
                <body>
                    <div class="container" style="padding-left: 140px;
                         padding-right: 140px;
                         padding-top: 140px;
                         padding-bottom: 140px;">
                        <form name="dropdown">
                            <div>
                                <select size="1" name="tablelist" id="tablelist" >
                                    <option value="${pageContext.request.contextPath}/pbase/listProducts.html">Product Base</option>
                                    <option value="${pageContext.request.contextPath}/pcbase/listProductCategories.html">Product Base Category</option>
                                     <option value="${pageContext.request.contextPath}/dtbase/listDocumentTypes.html">Document Type Base</option>
                                </select>
                            </div>
                            <br></br>
                            <div>
                                <a class="btn btn-success" role="button" style="width:110px" onclick="redirect_url(document.getElementById('tablelist').value)">Next</a>
                            </div>
                        </form>
                    </div>
                </body>
                </html>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Add Document Chacklist Mapping page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">  
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 

                </head>
                <body>
                    <div class ="container" >
                        <div class="col-sm-9 col-sm-offset-3"><h3>Add Area Branch Mapping</h3></div>
                        <div class="col-sm-9 col-sm-offset-3"><p>Here you can add Checklist Mapping details....</p></div>
                        <div>&nbsp&nbsp</div>    
                        <form:form method="POST" class="form-horizontal" commandName="abmap" action="${pageContext.request.contextPath}/AreaBranchMap/addMap.html">
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">AREA_BR_ID</label>
                                <div class="col-sm-4">
                                    <form:input id="did" type="text" class="form-control"  path="areaBrId"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-3 control-label">BRANCH NAME:</label>
                                <div class="col-sm-4">
                                    <form:select data-live-search="true" class="form-control" type="text" name="bname" path="">
                                        <form:options items="${branchName}"></form:options>                                                                                                        
                                    </form:select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label  class="col-sm-3 control-label">AREA NAME:</label>
                                <div class="col-sm-4">
                                    <form:select data-live-search="true" class="form-control" type="text" name="aname" path="">
                                        <form:options  items="${areaName}"></form:options>                                                                                                        
                                    </form:select>
                                </div>
                            </div>
                            <div>&nbsp&nbsp</div>    
                            <div class="form-group row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary btn-block">Add Mapping</button>
                                </div>
                                <div class="col-sm-2">
                                    <a href="${pageContext.request.contextPath}/AreaBranchMap/listMap.html" type="button" class="btn btn-default btn-block" >Close</a>
                                </div>
                                <div class="col-sm-5"></div>
                            </div>

                        </form:form>
                    </div>


                </body>
                </html>
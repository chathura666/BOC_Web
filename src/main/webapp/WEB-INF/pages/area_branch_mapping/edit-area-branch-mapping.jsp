<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Edit Document Checklist Mapping</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>


            <script>
                function redirect_url(url)
                {
                    window.location = url;
                }


            </script>
            <script>
                function disable()
                {
                    document.getElementById('pid').disabled = true;
                }
            </script>

    </head>
    <body>
        <div class ="container" >
            <div class="col-sm-9 col-sm-offset-3"><h3>Edit Document Area Branch Mapping page</h3></div>
            <div class="col-sm-9 col-sm-offset-3"><p>Here you can edit Area Branch Mapping details....</p></div>
            <div>&nbsp&nbsp</div>
            <form:form method="POST" class="form-horizontal" commandName="abmap" action="${pageContext.request.contextPath}/AreaBranchMapping/editMapping/${abmap.areaBrId}.html">
                <div class="form-group">
                    <label  class="col-sm-3 control-label">AREA_BR_ID:</label>
                    <div class="col-sm-4">
                        <form:input id="did" type="text" class="form-control" readonly="true" path="areaBrId"/>
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-3 control-label">BRANCH NAME:</label>
                    <div class="col-sm-4">
                        <form:select data-live-search="true" class="form-control" type="text" name="bname" path="">
                            <form:option item="${BName}" value="${BName}" selected="true" >${BName}</form:option>
                            <form:options items="${BNames}"></form:options>                                                                                                        
                        </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-sm-3 control-label">AREA NAME</label>
                    <div class="col-sm-4">
                        <form:select data-live-search="true" class="form-control" type="text" name="aname" path="">
                            <form:option value="${AName}" selected="true" >${AName}</form:option>
                            <form:options  items="${ANames}"></form:options>                                                                                                        
                        </form:select>
                    </div>
                </div> 
                <div class="form-group row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-primary btn-block">Edit Mapping</button>
                    </div>
                    <div class="col-sm-2">
                        <a href="${pageContext.request.contextPath}/AreaBranchMapping/listMappings.html" type="button" class="btn btn-default btn-block" >Close</a>
                    </div>
                    <div class="col-sm-5"></div>
                </div>

            </form:form>
        </div>


    </body>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"/>  
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.jqueryui.min.css"/>  
</html>
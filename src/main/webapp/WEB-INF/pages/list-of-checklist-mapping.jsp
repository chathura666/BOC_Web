<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>List of Document Checklist Mapping</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
            <script src=" //code.jquery.com/jquery-1.12.4.js"></script> 
            <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 
            <script src="https://cdn.datatables.net/1.10.15/js/dataTables.jqueryui.min.js"></script> 


            <script type="text/javascript">

                function redirect_url()
                {
                    var x = document.getElementById("tablelist").value;
                    window.location = x;
                }

                $(document).ready(function () {
                    $('#datatable').DataTable();
                });


                window.setTimeout(function () {
                    $(".alert-success").fadeTo(500, 0).slideUp(500, function () {
                        $(this).remove();
                    });
                }, 5000);

                window.setTimeout(function () {
                    $(".alert-danger").fadeTo(500, 0).slideUp(500, function () {
                        $(this).remove();
                    });
                }, 5000);

                function getConfirmation() {
                    var retVal = confirm("Do you want to continue ?");
                    if (retVal == true) {
                        //document.write("User wants to continue!");
                        return true;
                    } else {
                        //document.write("User does not want to continue!");
                        return false;
                    }
                }




            </script>
    </head>

    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid row">
                <div class="navbar-header col-md-2"">
                    <a class="navbar-brand" href="#">BOC</a>
                </div>
                <div style="margin-top: 7px;" class="col-md-3">
                    <select  id="tablelist"  onchange="redirect_url()" class="selectpicker" data-live-search="true">
                        <option data-tokens="product" value="${pageContext.request.contextPath}/pbase/listProducts.html" onclick="redirect_url(this.value)">PRODUCT BASE</option>
                        <option  data-tokens="product category" value="${pageContext.request.contextPath}/pcbase/listProductCategories.html" onclick ="redirect_url(this.value)">PRODUCT CATEGORY BASE</option>
                        <option  data-tokens="document type" value="${pageContext.request.contextPath}/dtbase/listDocumentTypes.html" onclick="redirect_url(this.value)">DOCUMENT TYPE BASE</option>
                        <option selected data-tokens="document chacklist map " value="${pageContext.request.contextPath}/dcmap/listChecklistMaps.html" onclick="redirect_url(this.value)">PRODUCT DOCUMENT CHECKLIST MAPPING</option>
                    </select>
                </div>
                <div class="col-md-7"></div>

            </div>
        </nav>
        <div class="container">
            <h3>List of Checklist Mapping</h3>
            <div><br></br></div>
            <div style="padding-bottom: 10px">
                <div>
                    <c:if test = "${not empty message}">
                        <div style="padding-top: 5px;padding-bottom: 5px;" id="success-alert" class="alert alert-success" role="alert"><c:out value = "${message}"/></div>
                    </c:if>
                    <c:if test = "${not empty message1}">
                        <div style="padding-top: 5px;padding-bottom: 5px;" class="alert alert-danger" role="alert"><c:out value = "${message1}"/></div>
                    </c:if>
                </div>
                <div>
                    <a href="${pageContext.request.contextPath}/dcmap/addChecklistMap.html" class="btn btn-success" role="button" style="width:110px">+ Add New</a>
                </div>
            </div>
            <!-- Table -->
            <div class="table-responsive">
                <table id="datatable" class="display" cellspacing="0" width="100%">

                    <thead>
                        <tr>

                            <div>
                                <td>PDCID</td>
                                <td>PRODUCT_ID</td>
                                <td>DOCUMENT_ID</td>
                                <td>SCAN_REQIURED</td>
                                <td>MANDATORY</td>
                                <td></td>
                                <td></td>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="dcmap" items="${dcmaps}">
                            <tr>
                                <td>${dcmap.pdcid}</td>
                                <td>${dcmap.productId.pid}</td>
                                <td>${dcmap.documentId.did}</td>
                                <td>${dcmap.scanRequired}</td>
                                <td>${dcmap.mandatory}</td>

                                <td><a href="${pageContext.request.contextPath}/dcmap/editChecklistMapping/${dcmap.pdcid}.html" class="btn btn-primary" role="button" id="editbtn" style="width:60px"  onclick="return confirm('Are you sure you want to edit this item?');">Edit</a>  </td>

                                <td><a href="${pageContext.request.contextPath}/dcmap/deleteChecklistMapping/${dcmap.pdcid}.html" class="btn btn-warning" role="button" id="deletebtn"  onclick="return confirm('Are you sure you want to delete this item?');" style="width:60px">Delete</a>  </td>

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



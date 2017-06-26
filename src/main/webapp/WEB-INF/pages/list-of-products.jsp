<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>List of Products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">   

            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>
                <script src=" //code.jquery.com/jquery-1.12.4.js"></script> 
                <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script> 
                <script src="https://cdn.datatables.net/1.10.15/js/dataTables.jqueryui.min.js"></script> 

                <script type="text/javascript">

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


                    function redirect_url()
                    {
                        var x = document.getElementById("tablelist").value;
                        window.location = x;
                    }

                    $('body').on('hidden.bs.modal', '.modal', function () {
                        $(this).removeData('bs.modal');
                    });


                    function clearModal()
                    {
                        $('#myModal .modal-content').empty();
                    }




                    jQuery(document).keypress(function (e) {
                        if (e.keyCode == 27) {
                            jQuery("#myModal").modal('toggle');
                            OR
                            jQuery("#myModal").modal('hide');
                        }
                    });



                </script>



                <style>
                    html, body{
                        padding-right: 0px !important; 
                        position: relative!important

                            .modal-backdrop.in {
                            opacity: 0.5;
                        }


                    </style>

                    </head>
                    <body>
                        <nav class="navbar navbar-default" style="margin-bottom: 0px;">
                            <div class="container-fluid row">
                                <div class="navbar-header col-md-2"">
                                    <a class="navbar-brand" href="#">BOC</a>
                                </div>
                                <div style="margin-top: 7px;" class="col-md-3">
                                    <select  id="tablelist"  onchange="redirect_url()" class="selectpicker" data-live-search="true">
                                        <option selected data-tokens="product" value="${pageContext.request.contextPath}/pbase/listProducts.html" onclick="redirect_url(this.value)">PRODUCT BASE</option>
                                        <option  data-tokens="product category" value="${pageContext.request.contextPath}/pcbase/listProductCategories.html" onclick ="redirect_url(this.value)">PRODUCT CATEGORY BASE</option>
                                        <option data-tokens="document type" value="${pageContext.request.contextPath}/dtbase/listDocumentTypes.html" onclick="redirect_url(this.value)">DOCUMENT TYPE BASE</option>
                                        <option data-tokens="document chacklist map " value="${pageContext.request.contextPath}/dcmap/listChecklistMaps.html" onclick="redirect_url(this.value)">PRODUCT DOCUMENT CHECKLIST MAPPING</option>
                                    </select>
                                </div>
                                <div class="col-md-7"></div>

                            </div>
                        </nav>

                        <div class="container">
                            <div class="row">
                                <div>
                                    <h3 style="margin-top: 10px;">List of Products</h3>
                                    <div style="padding-bottom: 10px">
                                            <div>
                                                <c:if test = "${not empty message}">
                                                    <div style="padding-top: 5px;padding-bottom: 5px;" id="success-alert" class="alert alert-success" role="alert"><c:out value = "${message}"/></div>
                                            </c:if>
                                            <c:if test = "${not empty message1}">
                                                <div style="padding-top: 5px;padding-bottom: 5px;" class="alert alert-danger" role="alert"><c:out value = "${message1}"/></div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div style="float:right">
                                        <a href="${pageContext.request.contextPath}/pbase/addProduct.html" class="btn btn-success" role="button" data-toggle="modal" data-target="#myModal" style="width:110px">+ Add New</a>
                                    </div>
                                </div>


                                <!-- Table -->
                                <div class="table-responsive row" style="margin-top: 5px;">
                                <table id="datatable" class="display" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <div>
                                                <td>PID</td>
                                                <td>P_Code</td>
                                                <td>WF_P_Code</td>
                                                <td>P_Name</td>
                                                <td>P_Desc</td>
                                                <td>P_Cat_ID</td>
                                                <td>Edit</td>
                                                <td>Delete</td>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="pbase" items="${pbases}">
                                            <tr>
                                                <td>${pbase.pid}</td>
                                                <td>${pbase.productCode}</td>
                                                <td>${pbase.wfProductCode}</td>
                                                <td>${pbase.productName}</td>
                                                <td>${pbase.productDescription}</td>
                                                <td>${pbase.productCategoryId.productCategoryId}</td>

                                                <td><p data-placement="top" title="Edit"><button class="btn btn-primary btn-s" data-title="Edit" data-toggle="modal" style="width:60px"  data-target="#edtModalcnfm_${pbase.pid}" >Edit</button></p></td>
                                                <td><p data-placement="top" id="deletebtn"  title="Delete"><button class="btn btn-warning btn-s" data-title="Delete"  style="width:60px" data-toggle="modal" data-target="#dltModalcnfm_${pbase.pid}" >Delete</button></p></td>

                                            </tr>
                                            <div id="dltModalcnfm_${pbase.pid}" class="modal">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                            <h4 class="modal-title">Confirm Delete</h4>
                                                        </div>

                                                        <div class="modal-body">
                                                            <p>Are you sure you want to delete this user? </p>
                                                        </div>
                                                        <div class="modal-footer">

                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/pbase/deleteProduct/${pbase.pid}.html" title="Delete"><i class="fa fa-trash-o"></i>Delete</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>  

                                            <div id="edtModalcnfm_${pbase.pid}" class="modal">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                            <h4 class="modal-title">Confirm Delete</h4>
                                                        </div>

                                                        <div class="modal-body">
                                                            <p>Are you sure you want to edit this user? </p>
                                                        </div>
                                                        <div class="modal-footer">

                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                            <a  href="${pageContext.request.contextPath}/pbase/editProduct/${pbase.pid}.html" data-toggle="modal" data-dismiss="modal" class="btn btn-warning" data-target="#myModal" ><i class="fa fa-trash-o"></i>Edit</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!--<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>-->
                        </div>


                        <!--  ************************************************************    -->


                        <!-- Modal -->
                        <div id="myModal" data-keyboard="true"  class="modal" role="dialog" style="background-color: black !important;  ">
                            <div class="modal-dialog modal-lg">
                                <!-- Modal content-->
                                <div class="modal-content"> </div>
                            </div>

                        </div>

                    </body>

                    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
                        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">  
                            <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.jqueryui.min.css">  
                                </html>



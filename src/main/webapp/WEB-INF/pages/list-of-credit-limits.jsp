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

            <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-select.css"/>
            <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
            <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/resources/js/bootstrap-select.js"></script>
            <script src="<%=request.getContextPath()%>/resources/js/jquery-1.12.4.js"></script> 
            <script src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script> 
            <script src="<%=request.getContextPath()%>/resources/js/dataTables.jqueryui.min.js"></script> 
            <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>  
            <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css"/>  
            <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/dataTables.jqueryui.min.css"/>  

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

                $(window).load(function () {
                    // When the page has loaded
                    $("body").fadeIn(100);
                });



            </script>



            <style>

                body {
                    display: none;
                    overflow-x: hidden;
                    overflow-y: scroll;
                }
                html, body{
                    padding-right: 0px !important; 
                    position: relative!important
                }

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
                <div style="margin-top: 7px;" class="col-md-3" >
                    <select  id="tablelist"  onchange="redirect_url()" class="selectpicker" data-live-search="true">
                        <option data-tokens="area" value="${pageContext.request.contextPath}/abase/listAreaBases.html" onclick="redirect_url(this.value)">AREA BASE</option>
                        <option selected data-tokens="credit card wise credit limit" value="${pageContext.request.contextPath}/creditlimit/listCreditLimits.html" onclick="redirect_url(this.value)">CC CARD CATEGORY WISE CREDIT LIMITS</option>
                        <option data-tokens="document type" value="${pageContext.request.contextPath}/dtbase/listDocumentTypes.html" onclick="redirect_url(this.value)">DOCUMENT TYPE BASE</option>
                        <option data-tokens="loan product mapping" value="${pageContext.request.contextPath}/lpidmap/listIndexIdMap.html" onclick="redirect_url(this.value)">LOAN PRODUCT INDEX ID MAPPING</option>
                        <option data-tokens="pick list values" value="${pageContext.request.contextPath}/picklist/listPickList.html" onclick="redirect_url(this.value)">PICKLIST VALUES</option>
                        <option data-tokens="product" value="${pageContext.request.contextPath}/pbase/listProducts.html" onclick="redirect_url(this.value)">PRODUCT BASE</option>
                        <option data-tokens="product category" value="${pageContext.request.contextPath}/pcbase/listProductCategories.html" onclick ="redirect_url(this.value)">PRODUCT CATEGORY BASE</option>
                        <option data-tokens="document chacklist map " value="${pageContext.request.contextPath}/dcmap/listChecklistMaps.html" onclick="redirect_url(this.value)">PRODUCT DOCUMENT CHECKLIST MAPPING</option>
                    </select>
                </div>
                <div class="col-md-7"></div>

            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div>
                    <h3 style="margin-top: 10px;">List of Credit Card Wise Credit Limits</h3>
                    <div>
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

            <!-- Table -->
            <div class="table-responsive row" style="margin-top: 5px;">
                <table id="datatable" class="display" cellspacing="0" width="100%">
                    <thead>
                        <div style="float:right">
                            <a href="${pageContext.request.contextPath}/creditlimit/addCreditLimit.html" class="btn btn-success" role="button" data-toggle="modal" data-target="#myModal" style="width:110px;margin-bottom: 5px">+ Add New</a>
                        </div>
                        <tr>
                            <div>
                                <td>CCL_ID</td>
                                <td>MAIN_CATEGORY</td>
                                <td>SUB_CATEGORY</td>
                                <td>LOWER_LIMIT</td>
                                <td>UPPER_LIMIT</td>
                                <td  style="width: 5%;">EDIT</td>
                                <td  style="width: 5%;">DELETE</td>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="creditlimits" items="${creditlimits}">
                            <tr>
                                <td>${creditlimits.cclId}</td>
                                <td>${creditlimits.mainCategory}</td>
                                <td>${creditlimits.subCategory}</td>
                                <td>${creditlimits.lowerLimit}</td>
                                <td>${creditlimits.upperLimit}</td>

                                <td style="width: 5%;"><p data-placement="top" title="Edit"><button class="btn btn-primary btn-s" data-title="Edit" data-toggle="modal"  style="width:60px"  data-target="#edtModalcnfm_${creditlimits.cclId}">Edit</button></p></td>
                                <td style="width: 5%;"><p data-placement="top" id="deletebtn"  title="Delete"><button class="btn btn-warning btn-s" data-title="Delete"  style="width:60px" data-toggle="modal" data-target="#dltModalcnfm_${creditlimits.cclId}">Delete</button></p></td>

                            </tr>
                            <div id="dltModalcnfm_${creditlimits.cclId}" class="modal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title">Confirm Delete</h4>
                                        </div>

                                        <div class="modal-body">
                                            <p>Are you sure you want to delete this </p>
                                        </div>
                                        <div class="modal-footer">

                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <a class="btn btn-warning" href="${pageContext.request.contextPath}/creditlimit/deleteCreditLimit/${creditlimits.cclId}.html" title="Delete"><i class="fa fa-trash-o"></i>Delete</a>
                                        </div>
                                    </div>
                                </div>
                            </div>  

                            <div id="edtModalcnfm_${creditlimits.cclId}" class="modal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title">Confirm Edit</h4>
                                        </div>

                                        <div class="modal-body">
                                            <p>Are you sure you want to edit this? </p>
                                        </div>
                                        <div class="modal-footer">

                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <a  href="${pageContext.request.contextPath}/creditlimit/editCreditLimit/${creditlimits.cclId}.html" data-toggle="modal" data-dismiss="modal" class="btn btn-warning" data-target="#myModal" ><i class="fa fa-trash-o"></i>Edit</a>
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

</html>



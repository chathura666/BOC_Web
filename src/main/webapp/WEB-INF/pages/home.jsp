<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Home page</title>


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

    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-2" id="leftCol">

                    <ul class="nav nav-stacked" id="sidebar">
                        <li>&nbsp</li>
                        <li>&nbsp</li>
                        <li>&nbsp</li>
                        <li></li>
                        <li>&nbsp</li>
                        <li>
                            <select id="tablelist" class="selectpicker" data-live-search="true">
                                <option data-tokens="product" value="${pageContext.request.contextPath}/pbase/listProducts.html">PRODUCT BASE</option>
                                <option data-tokens="product category" value="${pageContext.request.contextPath}/pcbase/listProductCategories.html">PRODUCT CATEGORY BASE</option>
                                <option data-tokens="document type" value="${pageContext.request.contextPath}/dtbase/listDocumentTypes.html">DOCUMENT TYPE BASE</option>
                                <option data-tokens="document chacklist map " value="${pageContext.request.contextPath}/dcmap/listChecklistMaps.html">PRODUCT DOCUMENT CHECKLIST MAPPING</option>
                                <option selected data-tokens="credit card wise credit limit" value="${pageContext.request.contextPath}/creditlimit/listCreditLimits.html" onclick="redirect_url(this.value)">CC CARD CATEGORY WISE CREDIT LIMITS</option>
                                <option selected data-tokens="pick list values" value="${pageContext.request.contextPath}/picklist/listPickList.html" onclick="redirect_url(this.value)">PICKLIST VALUES</option>
                            </select>

                        </li>
                        <li>&nbsp</li>
                        <li>
                            <div>
                                <a class="btn btn-success" role="button" style="width:110px" onclick="redirect_url(document.getElementById('tablelist').value)">Next</a>
                            </div>
                        </li>

                    </ul>

                </div>  
                <div class="col-md-10" id="mainCol">


                </div>


                <div class="container" style="padding-left: 140px;
                     padding-right: 140px;
                     padding-top: 140px;
                     padding-bottom: 140px;">
                    <form name="dropdown">

                        <br></br>

                    </form>
                </div>



                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

                <!-- Modal -->
                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Modal Header</h4>
                            </div>
                            <div class="modal-body">
                                <p>Some text in the modal.</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>


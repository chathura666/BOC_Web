<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Home page</title>


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.js"></script>


        <script>
            function redirect_url()
            {
                var x = document.getElementById("tablelist").value;
                window.location = x;
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
                            <select  id="tablelist"  onchange="redirect_url()" class="selectpicker" data-live-search="true">
                                <option data-tokens="Area" value="${pageContext.request.contextPath}/AreaBase/listBases.html" onclick="redirect_url(this.value)">AREA BASE</option>
                                <option data-tokens="Area Branch" value="${pageContext.request.contextPath}/AreaBranchMapping/listMappings.html" onclick="redirect_url(this.value)">AREA BRANCH MAPPING</option>
                                <option data-tokens="Branch" value="${pageContext.request.contextPath}/BranchBase/listBases.html" onclick="redirect_url(this.value)">BRANCH BASE</option>
                                <option data-tokens="Cb Sequence" value="${pageContext.request.contextPath}/CbSequenceNumber/listSequenceNumbers.html" onclick="redirect_url(this.value)">CB SEQUENCE NUMBER</option>
                                <option data-tokens="Collateral Base" value="${pageContext.request.contextPath}/CollateralBase/.html" onclick="redirect_url(this.value)">COLLATERAL BASE</option>
                                <option data-tokens="Document" value="${pageContext.request.contextPath}/DocumetTypeBase/listBases.html" onclick="redirect_url(this.value)">DOCUMENT TYPE BASE</option>
                                <option data-tokens="Index Id" value="${pageContext.request.contextPath}/IndexIdBase/listBases.html" onclick="redirect_url(this.value)">INDEX ID BASE</option>
                                <option data-tokens="Legal Entity " value="${pageContext.request.contextPath}/LegalEntityBase/listBases.html" onclick="redirect_url(this.value)">LEGAL ENTITY BASE</option>
                                <option data-tokens="Loan Interest Rate Variance" value="${pageContext.request.contextPath}/LoanInterestRateVariance/listVariances.html" onclick="redirect_url(this.value)">LOAN INTEREST RATE VARIENCE</option>
                                <option data-tokens="Loan Product Index Id " value="${pageContext.request.contextPath}/LoanProductIndexIdMapping/listMappings.html" onclick="redirect_url(this.value)">LOAN PRODUCT INDEX ID MAPPING</option>
                                <option data-tokens="Loan Purposes" value="${pageContext.request.contextPath}/LoanPurposes/listPurposes.html" onclick="redirect_url(this.value)">LOAN PURPOSES</option>
                                <option data-tokens="pick list values" value="${pageContext.request.contextPath}/PickListValues/listPickList.html" onclick="redirect_url(this.value)">PICKLIST VALUES</option>
                                <option data-tokens="product" value="${pageContext.request.contextPath}/ProductBase/listBases.html" onclick="redirect_url(this.value)">PRODUCT BASE</option>        
                                <option data-tokens="product category" value="${pageContext.request.contextPath}/ProductCategoryBase/listBases.html" onclick="redirect_url(this.value)">PRODUCT CATEGORY BASE</option>  
                                <option data-tokens="product document checklist" value="${pageContext.request.contextPath}/ProductDocumentChecklistMapping/listMappings.html" onclick="redirect_url(this.value)">PRODUCT BASE</option>        
                                <option data-tokens="RlcBase" value="${pageContext.request.contextPath}/RlcBase/listBases.html" onclick="redirect_url(this.value)">RLC BASE</option>
                                <option data-tokens="RlcBranchMapping" value="${pageContext.request.contextPath}/RlcBranchMapping/listMappings.html" onclick="redirect_url(this.value)">RLC BRANCH MAPPING</option>
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


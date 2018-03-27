<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Employee Passport Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="EmpPassportDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Passport Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Passport Detail</button>
						</div>
						<!-- 
						<div class="col-md-6">
						</div>
					 -->
					</div>
				</div>
				<hr />
				<!-- ADD/EDIT FORM  -->
				<div class="row" ng-hide="ctrl.hideAddEdit">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<form ng-submit="ctrl.submit()" name="EmpPassportDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Emp Passport Detail Id Hidden-->
											<input type="hidden" ng-model="ctrl.empPassportDetail.id" />
											<!--EmpDetail Dropdown-->
											<div class="form-group">
												<label for="empDetail">Employee<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empPassportDetail.empDetail.id"
													name="empDetail" class="empDetail form-control input-sm"
													required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														Employee</option>
												</select> <span style="color: red"
													ng-show="EmpPassportDetailForm.empDetail.$touched || EmpPassportDetailForm.empDetail.$dirty && EmpPassportDetailForm.empDetail.$invalid">
													<span
													ng-show="EmpPassportDetailForm.empDetail.$touched && EmpPassportDetailForm.empDetail.$error.required">Employee
														Name is required.</span>
												</span>
											</div>
											<!--Passport Number Input-->
											<div class="form-group">
												<label for="passportNumber">Passport Number<span
													style="color: red"> * </span>
												</label> <input type="text" name="passportNumber"
													ng-model="ctrl.empPassportDetail.passportNumber"
													id="passportNumber"
													class="passportNumber form-control input-sm"
													placeholder="Enter Passport Number" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpPassportDetailForm.passportNumber.$touched || EmpPassportDetailForm.passportNumber.$dirty && EmpPassportDetailForm.passportNumber.$invalid ">
													<span
													ng-show="EmpPassportDetailForm.passportNumber.$touched && EmpPassportDetailForm.passportNumber.$error.required">Passport
														Number is required.</span>
												</span>
											</div>
											<!--Passport Status Dropdown-->
											<div class="form-group">
												<label for="passportStatusCode">Passport Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empPassportDetail.passportStatus"
													name="passportStatusCode"
													class="passportStatusCode form-control input-sm" required
													ng-options="u.code as u.type for u in ctrl.passportStatuses">
													<option value="" selected disabled
														class="passportStatusCode form-control input-sm">Select
														Passport Status</option>
												</select> <span style="color: red"
													ng-show="EmpPassportDetailForm.passportStatusCode.$touched || EmpPassportDetailForm.passportStatusCode.$dirty && EmpPassportDetailForm.passportStatusCode.$invalid">
													<span
													ng-show="EmpPassportDetailForm.passportStatusCode.$touched && EmpPassportDetailForm.passportStatusCode.$error.required">Passport
														Status is required.</span>
												</span>
											</div>
											<!--Place of Birth Input-->
											<div class="form-group">
												<label for="placeOfBirth">Place of Birth<span
													style="color: red"> * </span>
												</label> <input type="text" name="placeOfBirth"
													ng-model="ctrl.empPassportDetail.placeOfBirth"
													id="placeOfBirth"
													class="placeOfBirth form-control input-sm"
													placeholder="Enter Place of Birth" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpPassportDetailForm.placeOfBirth.$touched || EmpPassportDetailForm.placeOfBirth.$dirty && EmpPassportDetailForm.placeOfBirth.$invalid ">
													<span
													ng-show="EmpPassportDetailForm.placeOfBirth.$touched && EmpPassportDetailForm.placeOfBirth.$error.required">Place
														of Birth is required.</span>
												</span>
											</div>
											<!--Place Issues Input-->
											<div class="form-group">
												<label for="placeIssued">Place Issued<span
													style="color: red"> * </span>
												</label> <input type="text" name="placeIssued"
													ng-model="ctrl.empPassportDetail.placeIssued"
													id="placeIssued" class="placeIssued form-control input-sm"
													placeholder="Enter Place Issued" required ng-minlength="3" />
												<span style="color: red"
													ng-show="EmpPassportDetailForm.placeIssued.$touched || EmpPassportDetailForm.placeIssued.$dirty && EmpPassportDetailForm.placeIssued.$invalid ">
													<span
													ng-show="EmpPassportDetailForm.placeIssued.$touched && EmpPassportDetailForm.placeIssued.$error.required">Place
														Issued is required.</span>
												</span>
											</div>
											<!--Passport Issue Date-->
											<div class="form-group">
												<label for="passportIssuedDate">Passport Issue Date<span
													style="color: red"> * </span>
												</label> <input type="date" name="passportIssuedDate"
													ng-model="ctrl.empPassportDetail.passportIssuedDate"
													id="passportIssuedDate"
													class="passportIssuedDate form-control input-sm"
													placeholder="Enter Passport Issue Date" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpPassportDetailForm.passportIssuedDate.$touched || EmpPassportDetailForm.passportIssuedDate.$dirty && EmpPassportDetailForm.passportIssuedDate.$invalid ">
													<span
													ng-show="EmpPassportDetailForm.passportIssuedDate.$touched && EmpPassportDetailForm.passportIssuedDate.$error.required">Passport
														Issue Date is required.</span>
												</span>
											</div>
											<!--Passport Valid Till Date-->
											<div class="form-group">
												<label for="passportValidTillDate">Passport Valid
													Till Date<span style="color: red"> * </span>
												</label> <input type="date" name="passportValidTillDate"
													ng-model="ctrl.empPassportDetail.passportValidTillDate"
													id="passportValidTillDate"
													class="passportValidTillDate form-control input-sm"
													placeholder="Enter Passport Valid Till Date" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpPassportDetailForm.passportValidTillDate.$touched || EmpPassportDetailForm.passportValidTillDate.$dirty && EmpPassportDetailForm.passportValidTillDate.$invalid ">
													<span
													ng-show="EmpPassportDetailForm.passportValidTillDate.$touched && EmpPassportDetailForm.passportValidTillDate.$error.required">Passport
														Valid Till Date is required.</span>
												</span>
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Citizenship Dropdown-->
											<div class="form-group">
												<label for="citezenship">Citizenship<span
													style="color: red"> * </span>
												</label> <select ng-model="ctrl.empPassportDetail.citezenship"
													name="citezenship"
													class="citezenship form-control input-sm" required
													ng-options="u.code as u.type for u in ctrl.countries">
													<option value="" selected disabled
														class="citezenship form-control input-sm">Select
														Citizenship Country</option>
												</select> <span style="color: red"
													ng-show="EmpPassportDetailForm.citezenship.$touched || EmpPassportDetailForm.citezenship.$dirty && EmpPassportDetailForm.citezenship.$invalid">
													<span
													ng-show="EmpPassportDetailForm.citezenship.$touched && EmpPassportDetailForm.citezenship.$error.required">Citizenship
														is required.</span>
												</span>
											</div>
											<!--Visa Country Dropdown-->
											<div class="form-group">
												<label for="visaCountry">Visa Country<span
													style="color: red"> * </span>
												</label> <select ng-model="ctrl.empPassportDetail.visaCountry"
													name="visaCountry"
													class="visaCountry form-control input-sm"
													ng-options="u.code as u.type for u in ctrl.countries">
													<option value="" selected disabled
														class="visaCountry form-control input-sm">Select
														Visa Country</option>
												</select>
											</div>
											<!--Visa Type Dropdown-->
											<div class="form-group">
												<label for="visaType">Visa Type<span
													style="color: red"> * </span>
												</label> <select ng-model="ctrl.empPassportDetail.visaType"
													name="visaType" class="visaType form-control input-sm"
													ng-options="u.code as u.type for u in ctrl.visaTypes">
													<option value="" selected disabled
														class="visaStatus form-control input-sm">Select
														Visa Type</option>
												</select>
											</div>
											<!--Visa Status Dropdown-->
											<div class="form-group">
												<label for="visaStatus">Visa Status<span
													style="color: red"> * </span>
												</label> <select ng-model="ctrl.empPassportDetail.visaStatus"
													name="visaStatus" class="visaStatus form-control input-sm"
													ng-options="u.code as u.type for u in ctrl.visaStatuses">
													<option value="" selected disabled
														class="visaStatus form-control input-sm">Select
														Visa Status</option>
												</select>
											</div>
											<!--Visa Valid Till Date-->
											<div class="form-group">
												<label for="visaValidTill">Visa Valid Till Date<span
													style="color: red"> * </span>
												</label> <input type="date" name="visaValidTill"
													ng-model="ctrl.empPassportDetail.visaValidTill"
													id="visaValidTill"
													class="visaValidTill form-control input-sm"
													placeholder="Enter Visa Valid Till Date" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.empPassportDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="EmpPassportDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="EmpPassportDetailForm.$pristine">Reset
													Form</button>
											</div>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- DETAIL VIEW -->
				<div class="row" ng-hide="ctrl.hideView">
					<div class="col-md-12">
						<!-- Form Elements -->
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="row">
									<!-- First half form start -->
									<div class="col-md-6">

										<!--Passport ID View-->
										<div class="form-group">
											<label>ID : </label> <span class="input-sm"
												ng-bind="ctrl.empPassportDetail.id"></span>
										</div>
										<!--EmpDetail View-->
										<div class="form-group">
											<label>Employee Name : </label> <span class="input-sm"
												ng-bind="ctrl.getEmployeeName(ctrl.empPassportDetail.empDetail.id)"></span>
										</div>
										<!--Passport Number View-->
										<div class="form-group">
											<label>Passport Number :</label> <span class="input-sm"
												ng-bind="ctrl.empPassportDetail.passportNumber"></span>
										</div>
										<!--Passport Status View-->
										<div class="form-group">
											<label>Passport Status :</label> <span class="input-sm"
												ng-bind="ctrl.getPassportStatusType(ctrl.empPassportDetail.passportStatus)"></span>
										</div>
										<!--Place of Birth View-->
										<div class="form-group">
											<label>Place of Birth :</label> <span class="input-sm"
												ng-bind="ctrl.empPassportDetail.placeOfBirth"></span>
										</div>
										<!--Place Issued View-->
										<div class="form-group">
											<label>Place Issued :</label> <span class="input-sm"
												ng-bind="ctrl.empPassportDetail.placeIssued"></span>
										</div>
										<!--Passport Issue Date View-->
										<div class="form-group">
											<label>Client Allocation Date :</label> <span
												class="input-sm"
												ng-bind="ctrl.empPassportDetail.passportIssuedDate"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Passport Valid Till Date View-->
										<div class="form-group">
											<label>Passport Valid Till Date :</label> <span
												class="input-sm"
												ng-bind="ctrl.empPassportDetail.passportValidTillDate"></span>
										</div>
										<!--Citizenship View-->
										<div class="form-group">
											<label>Citizenship :</label> <span class="input-sm"
												ng-bind="ctrl.getCountryType(ctrl.empPassportDetail.citezenship)"></span>
										</div>
										<!--Visa Country View-->
										<div class="form-group">
											<label>Visa Country :</label> <span class="input-sm"
												ng-bind="ctrl.getCountryType(ctrl.empPassportDetail.visaCountry)"></span> 
										</div>
										<!--Visa Type View-->
										<div class="form-group">
											<label>Visa Type :</label> <span class="input-sm"
												ng-bind="ctrl.getVisaType(ctrl.empPassportDetail.visaType)"></span>
										</div>
										<!--Visa Status View-->
										<div class="form-group">
											<label>Visa Status :</label> <span class="input-sm"
												ng-bind="ctrl.getVisaStatusType(ctrl.empPassportDetail.visaStatus)"></span>
										</div>
										<!--Visa Valid Till Date View-->
										<div class="form-group">
											<label>Visa Valid Till Date :</label> <span class="input-sm"
												ng-bind="ctrl.empPassportDetail.visaValidTill"></span>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!-- LIST TABLE -->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<div class="form-group">

												<th><label for="empPassportDetailId">ID</label></th>
											</div>

											<div class="form-group">

												<th><label for="empDetail">Name</label></th>
											</div>
											<div class="form-group">

												<th><label for="clientName">Passport Number</label></th>
											</div>

											<div class="form-group">

												<th><label for="projectName">Status</label></th>
											</div>

											<div class="form-group">

												<th><label for="projectName">Valid
														Till</label></th>
											</div>

											<div class="form-group">

												<th><label for="billingStatus">Visa Country</label></th>
											</div>
											<div class="form-group">

												<th><label for="utilizationStatus">Visa Type</label></th>
											</div>

											<div class="form-group">

												<th><label for="clientAllocationDate">Visa
														Status</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.empPassportDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="ctrl.getEmployeeName(u.empDetail.id)"
														class="input-sm"></span></a></td>
												<td><span ng-bind="u.passportNumber" class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getPassportStatusType(u.passportStatus)"
													class="input-sm"></span></td>
												<td><span ng-bind="u.passportValidTillDate"
													class="input-sm"></span></td>
												<td><span ng-bind="ctrl.getCountryType(u.visaCountry)"
													class="input-sm"></span></td>
												<td><span ng-bind="ctrl.getVisaType(u.visaType)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getVisaStatusType(u.visaStatus)"
													class="input-sm"></span></td>

												<td><a ng-href="#"><button type="button"
															ng-click="ctrl.edit(u.id)"
															class="btn btn-success custom-width">Edit</button></a>
													<button type="button" ng-click="ctrl.remove(u.id)"
														class="btn btn-danger custom-width">Remove</button></td>
											</tr>
										</tbody>
									</table>
								</div>

							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>
			</div>

		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
	<script
		src="<c:url value="/resources/js/controller/emppassportdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/emppassportdetail_service.js" />"></script>
</body>
</html>

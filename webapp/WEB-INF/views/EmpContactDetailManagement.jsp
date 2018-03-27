<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Employee Contact Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="EmpContactDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Contact Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Contact Detail</button>
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
									<form ng-submit="ctrl.submit()" name="EmpContactDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Emp Contact Detail Id Hidden-->
											<input type="hidden" ng-model="ctrl.empContactDetail.id" />
											<!--Emp Detail Dropdown-->
											<div class="form-group">
												<label for="empDetail">Employee Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empContactDetail.empDetail.id"
													name="empDetail" class="empDetail form-control input-sm"
													required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														Employee</option>
												</select> <span style="color: red"
													ng-show="EmpContactDetailForm.empDetail.$touched || EmpContactDetailForm.empDetail.$dirty && EmpContactDetailForm.empDetail.$invalid">
													<span
													ng-show="EmpContactDetailForm.empDetail.$touched && EmpContactDetailForm.empDetail.$error.required">Employee
														Name is required.</span>
												</span>
											</div>
											<!--Personal Email Input-->
											<div class="form-group">
												<label for="personalEmail">Personal Email<span
													style="color: red"> * </span>
												</label> <input type="text" name="personalEmail"
													ng-model="ctrl.empContactDetail.personalEmail"
													id="personalEmail"
													class="personalEmail form-control input-sm"
													placeholder="Enter Personal Email" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpContactDetailForm.personalEmail.$touched || EmpContactDetailForm.personalEmail.$dirty &&	EmpContactDetailForm.personalEmail.$invalid ">
													<span
													ng-show="EmpContactDetailForm.personalEmail.$touched && EmpContactDetailForm.personalEmail.$error.required">Personal
														Email is required.</span>
												</span>
											</div>
											<!--Residence Address Input-->
											<div class="form-group">
												<label for="residenceAddress">Residence Address<span
													style="color: red"> * </span>
												</label> <input type="text" name="residenceAddress"
													ng-model="ctrl.empContactDetail.residenceAddress"
													id="residenceAddress"
													class="residenceAddress form-control input-sm"
													placeholder="Enter Residence Address" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpContactDetailForm.residenceAddress.$touched || EmpContactDetailForm.residenceAddress.$dirty &&	EmpContactDetailForm.residenceAddress.$invalid ">
													<span
													ng-show="EmpContactDetailForm.residenceAddress.$touched && EmpContactDetailForm.residenceAddress.$error.required">Residence
														Address is required.</span>
												</span>
											</div>
											<!--Permanent Address Input-->
											<div class="form-group">
												<label for="permanentAddress">Permanent Address<span
													style="color: red"> * </span>
												</label> <input type="text" name="permanentAddress"
													ng-model="ctrl.empContactDetail.permanentAddress"
													id="permanentAddress"
													class="permanentAddress form-control input-sm"
													placeholder="Enter Permanent Address" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpContactDetailForm.permanentAddress.$touched || EmpContactDetailForm.permanentAddress.$dirty &&	EmpContactDetailForm.permanentAddress.$invalid ">
													<span
													ng-show="EmpContactDetailForm.permanentAddress.$touched && EmpContactDetailForm.permanentAddress.$error.required">Permanent
														Address is required.</span>
												</span>
											</div>

										</div>
										<!-- Second half of form start  -->
										<div class="col-md-6">
											<!--Personal Contact Number Input-->
											<div class="form-group">
												<label for="personalContactNumber">Personal Contact
													Number<span style="color: red"> * </span>
												</label> <input type="text" name="personalContactNumber"
													ng-model="ctrl.empContactDetail.personalContactNumber"
													id="personalContactNumber"
													class="personalContactNumber form-control input-sm"
													placeholder="Enter Personal Contact Number" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpContactDetailForm.personalContactNumber.$touched || EmpContactDetailForm.personalContactNumber.$dirty &&	EmpContactDetailForm.personalContactNumber.$invalid ">
													<span
													ng-show="EmpContactDetailForm.personalContactNumber.$touched && EmpContactDetailForm.personalContactNumber.$error.required">Personal
														Contact Number is required.</span>
												</span>
											</div>
											<!--Emergency Contact Number Input-->
											<div class="form-group">
												<label for="emergencyContactNumber">Emergency
													Contact Number<span style="color: red"> * </span>
												</label> <input type="text" name="emergencyContactNumber"
													ng-model="ctrl.empContactDetail.emergencyContactNumber"
													id="emergencyContactNumber"
													class="emergencyContactNumber form-control input-sm"
													placeholder="Enter Emergency Contact Number" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpContactDetailForm.emergencyContactNumber.$touched || EmpContactDetailForm.emergencyContactNumber.$dirty &&	EmpContactDetailForm.emergencyContactNumber.$invalid ">
													<span
													ng-show="EmpContactDetailForm.emergencyContactNumber.$touched && EmpContactDetailForm.emergencyContactNumber.$error.required">Emergency
														Contact Number is required.</span>
												</span>
											</div>
											<!--Emergency Contact Name Input-->
											<div class="form-group">
												<label for="emergencyContactName">Emergency Contact
													Name<span style="color: red"> * </span>
												</label> <input type="text" name="emergencyContactName"
													ng-model="ctrl.empContactDetail.emergencyContactName"
													id="emergencyContactName"
													class="emergencyContactName form-control input-sm"
													placeholder="Enter Emergency Contact Name" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpContactDetailForm.emergencyContactName.$touched || EmpContactDetailForm.emergencyContactName.$dirty &&	EmpContactDetailForm.emergencyContactName.$invalid ">
													<span
													ng-show="EmpContactDetailForm.emergencyContactName.$touched && EmpContactDetailForm.emergencyContactName.$error.required">Emergency
														Contact Name is required.</span>
												</span>
											</div>

											<!--Relation With Ec Input-->
											<div class="form-group">
												<label for="relationWithEc">Relation With Ec<span
													style="color: red"> * </span>
												</label> <input type="text" name="relationWithEc"
													ng-model="ctrl.empContactDetail.relationWithEc"
													id="relationWithEc"
													class="relationWithEc form-control input-sm"
													placeholder="Enter Relation With Ec" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpContactDetailForm.relationWithEc.$touched || EmpContactDetailForm.relationWithEc.$dirty &&	EmpContactDetailForm.relationWithEc.$invalid ">
													<span
													ng-show="EmpContactDetailForm.relationWithEc.$touched && EmpContactDetailForm.relationWithEc.$error.required">Relation
														With Ec is required.</span>
												</span>
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.empContactDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="EmpContactDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="EmpContactDetailForm.$pristine">Reset
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

										<!--Emp Education ID View-->
										<div class="form-group">
											<label for="empContactDetailId">ID : </label> <span
												class="input-sm" ng-bind="ctrl.empContactDetail.id"></span>
										</div>
										<!--EmpDetail View-->
										<div class="form-group">
											<label for="firstName">Employee Name : </label> <span
												class="input-sm"
												ng-bind="ctrl.getEmployeeName(ctrl.empContactDetail.empDetail.id)"></span>
										</div>
										<!--Personal Email View-->
										<div class="form-group">
											<label for="personalEmail">Personal Email :</label> <span
												class="input-sm"
												ng-bind="ctrl.empContactDetail.personalEmail"></span>
										</div>

										<!--Residence Address View-->
										<div class="form-group">
											<label for="residenceAddress">Residence Address :</label> <span
												class="input-sm"
												ng-bind="ctrl.empContactDetail.residenceAddress"></span>
										</div>
										<!--Permanent Address View-->
										<div class="form-group">
											<label for="permanentAddress">Permanent Address :</label> <span
												class="input-sm"
												ng-bind="ctrl.empContactDetail.permanentAddress"></span>
										</div>


									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">


										<!--Personal Contact Number View-->
										<div class="form-group">
											<label for="personalContactNumber">Personal Contact
												Number :</label> <span class="input-sm"
												ng-bind="ctrl.empContactDetail.personalContactNumber"></span>
										</div>
										<!--Emergency Contact Number View-->
										<div class="form-group">
											<label for="emergencyContactNumber">Emergency Contact
												Number :</label> <span class="input-sm"
												ng-bind="ctrl.empContactDetail.emergencyContactNumber"></span>
										</div>
										<!--Emergency Contact Name View-->
										<div class="form-group">
											<label for="emergencyContactName">Emergency Contact
												Name :</label> <span class="input-sm"
												ng-bind="ctrl.empContactDetail.emergencyContactName"></span>
										</div>
										<!--Relation With Ec View-->
										<div class="form-group">
											<label for="relationWithEc">Relation With Ec :</label> <span
												class="input-sm"
												ng-bind="ctrl.empContactDetail.relationWithEc"></span>
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

												<th><label for="empContactDetailId">ID</label></th>
											</div>

											<div class="form-group">

												<th><label for="empDetail">Employee Name</label></th>
											</div>

											<div class="form-group">

												<th><label for="personalEmail">Personal Email</label></th>
											</div>

											<div class="form-group">

												<th><label for="personalContactNumber">Personal
														Contact Number</label></th>
											</div>

											<div class="form-group">

												<th><label for="emergencyContactName">Emergency
														Contact Name</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.empContactDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="ctrl.getEmployeeName(u.empDetail.id)"
														class="input-sm"></span></a></td>
												<td><span ng-bind="u.personalEmail" class="input-sm"></span></td>
												<td><span ng-bind="u.personalContactNumber"
													class="input-sm"></span></td>

												<td><span ng-bind="u.emergencyContactName"
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
		src="<c:url value="/resources/js/controller/empcontactdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/empcontactdetail_service.js" />"></script>
</body>
</html>

<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Employee Personal Detail Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="EmpPersonalDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Personal Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Personal Detail</button>
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
									<form ng-submit="ctrl.submit()" name="EmpPersonalDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Emp Personal Detail Id Hidden-->
											<input type="hidden" ng-model="ctrl.empPersonalDetail.id" />
											<!--EmpDetail Dropdown-->
											<div class="form-group">
												<label for="empDetail">Employee<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empPersonalDetail.empDetail.id"
													name="empDetail" class="empDetail form-control input-sm"
													required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														Employee</option>
												</select> <span style="color: red"
													ng-show="EmpPersonalDetailForm.empDetail.$touched || EmpPersonalDetailForm.empDetail.$dirty && EmpPersonalDetailForm.empDetail.$invalid">
													<span
													ng-show="EmpPersonalDetailForm.empDetail.$touched && EmpPersonalDetailForm.empDetail.$error.required">Employee
														Name is required.</span>
												</span>
											</div>
											<!--Employee Gender Dropdown-->
											<div class="form-group">
												<label for="gender">Gender<span style="color: red">
														* </span></label> <select ng-model="ctrl.empPersonalDetail.gender"
													name="gender" class="gender form-control input-sm" required
													ng-options="u.code as u.type for u in ctrl.genders">
													<option value="" selected disabled
														class="gender form-control input-sm">Select
														Gender</option>
												</select> <span style="color: red"
													ng-show="ProjcetResourceForm.gender.$touched || ProjcetResourceForm.gender.$dirty && ProjcetResourceForm.gender.$invalid">
													<span
													ng-show="ProjcetResourceForm.gender.$touched && ProjcetResourceForm.gender.$error.required">Genderl
														is required.</span>
												</span>
											</div>
											<!--Birth Date Input-->
											<div class="form-group">
												<label for="dateOfBirth">Date of Birth <span
													style="color: red"> * </span>
												</label> <input type="date" name="dateOfBirth"
													ng-model="ctrl.empPersonalDetail.dateOfBirth"
													id="dateOfBirth" class="dateOfBirth form-control input-sm"
													placeholder="Enter Date of Birth" required ng-minlength="3" />
												<span style="color: red"
													ng-show="EmpPersonalDetailForm.dateOfBirth.$touched || EmpPersonalDetailForm.dateOfBirth.$dirty &&	EmpPersonalDetailForm.dateOfBirth.$invalid ">
													<span
													ng-show="EmpPersonalDetailForm.dateOfBirth.$touched && EmpPersonalDetailForm.dateOfBirth.$error.required">Date
														of Birth is required.</span>
												</span>
											</div>
											<!--Father's Name Input-->
											<div class="form-group">
												<label for="fatherName">Father's Name <span
													style="color: red"> * </span>
												</label> <input type="text" name="fatherName"
													ng-model="ctrl.empPersonalDetail.fatherName"
													id="fatherName" class="fatherName form-control input-sm"
													placeholder="Enter Father's Name" required ng-minlength="3" />
												<span style="color: red"
													ng-show="EmpPersonalDetailForm.fatherName.$touched || EmpPersonalDetailForm.fatherName.$dirty && EmpPersonalDetailForm.fatherName.$invalid ">
													<span
													ng-show="EmpPersonalDetailForm.fatherName.$touched && EmpPersonalDetailForm.fatherName.$error.required">Father's
														Name is required.</span>
												</span>
											</div>
											<!--Mother's Name Input-->
											<div class="form-group">
												<label for="motherName">Mother's Name <span
													style="color: red"> * </span>
												</label> <input type="text" name="motherName"
													ng-model="ctrl.empPersonalDetail.motherName"
													id="motherName" class="motherName form-control input-sm"
													placeholder="Enter Mother's Name" required ng-minlength="3" />
												<span style="color: red"
													ng-show="EmpPersonalDetailForm.motherName.$touched || EmpPersonalDetailForm.motherName.$dirty && EmpPersonalDetailForm.motherName.$invalid ">
													<span
													ng-show="EmpPersonalDetailForm.motherName.$touched && EmpPersonalDetailForm.motherName.$error.required">Mother's
														Name is required.</span>
												</span>
											</div>
											<!--Blood Group Dropdown-->
											<div class="form-group">
												<label for="bloodGroup">Blood Group<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empPersonalDetail.bloodGroup"
													name="bloodGroup" class="bloodGroup form-control input-sm"
													required
													ng-options="u.code as u.type for u in ctrl.bloodGroups">
													<option value="" selected disabled
														class="bloodGroup form-control input-sm">Select
														Blood Group</option>
												</select> <span style="color: red"
													ng-show="EmpPersonalDetailForm.bloodGroup.$touched || EmpPersonalDetailForm.bloodGroup.$dirty && EmpPersonalDetailForm.bloodGroup.$invalid">
													<span
													ng-show="EmpPersonalDetailForm.bloodGroup.$touched && EmpPersonalDetailForm.bloodGroup.$error.required">Blood
														Group is required.</span>
												</span>
											</div>
											<!--Driving License Number Input-->
											<div class="form-group">
												<label for="drivingLicense">Driving License Number </label>
												<input type="text" name="drivingLicense"
													ng-model="ctrl.empPersonalDetail.drivingLicense"
													id="drivingLicense"
													class="drivingLicense form-control input-sm"
													placeholder="Enter Driving License Number" />
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Driving License State Dropdown-->
											<div class="form-group">
												<label for="drivingLicenseState">Driving License
													State</label> <select
													ng-model="ctrl.empPersonalDetail.drivingLicenseState"
													name="drivingLicenseState"
													class="drivingLicenseState form-control input-sm"
													ng-options="u.code as u.type for u in ctrl.drivingLicenseStates">
													<option value="" selected disabled
														class="drivingLicenseState form-control input-sm">Select
														Driving License State</option>
												</select>
											</div>
											<!--PAN Number Input-->
											<div class="form-group">
												<label for="panNumber">PAN Number </label> <input
													type="text" name="panNumber"
													ng-model="ctrl.empPersonalDetail.panNumber" id="panNumber"
													class="panNumber form-control input-sm"
													placeholder="Enter PAN Number" />
											</div>
											<!--Aadhaar Number Input-->
											<div class="form-group">
												<label for="aadharNumber">Aadhaar Number </label> <input
													type="text" name="aadharNumber"
													ng-model="ctrl.empPersonalDetail.aadharNumber"
													id="aadharNumber"
													class="aadharNumber form-control input-sm"
													placeholder="Enter Aadhaar Number" />
											</div>
											<!--Marital Status Dropdown-->
											<div class="form-group">
												<label for="maritalStatus">Marital Status </label> <select
													ng-model="ctrl.empPersonalDetail.maritalStatus"
													name="maritalStatus"
													class="maritalStatus form-control input-sm"
													ng-options="u.code as u.type for u in ctrl.maritalStatuses">
													<option value="" selected disabled
														class="maritalStatus form-control input-sm">Select
														Marital Status</option>
												</select>
											</div>
											<!--Wedding Date-->
											<div class="form-group">
												<label for="weddingDate">Wedding Date </label> <input
													type="date" name="weddingDate"
													ng-model="ctrl.empPersonalDetail.weddingDate"
													id="weddingDate" class="weddingDate form-control input-sm"
													placeholder="Enter Wedding Date" />
											</div>
											<!--Spouse Name Input-->
											<div class="form-group">
												<label for="spouseName">Spouse Name</label> <input
													type="text" name="spouseName"
													ng-model="ctrl.empPersonalDetail.spouseName"
													id="spouseName" class="spouseName form-control input-sm"
													placeholder="Enter Spouse Name" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.empPersonalDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="EmpPersonalDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="EmpPersonalDetailForm.$pristine">Reset
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
										<!--Personal ID View-->
										<div class="form-group">
											<label>ID : </label> <span class="input-sm"
												ng-bind="ctrl.empPersonalDetail.id"></span>
										</div>
										<!--Client Name View-->
										<!--EmpDetail View-->
										<div class="form-group">
											<label>Employee Name : </label> <span class="input-sm"
												ng-bind="ctrl.getEmployeeName(ctrl.empPersonalDetail.empDetail.id)"></span>
										</div>
										<!--Gender View-->
										<div class="form-group">
											<label>Gender :</label> <span class="input-sm"
												ng-bind="ctrl.getGenderType(ctrl.empPersonalDetail.gender)"></span>
										</div>
										<!--Date of Birth View-->
										<div class="form-group">
											<label>Date of Birth :</label> <span class="input-sm"
												ng-bind="ctrl.empPersonalDetail.dateOfBirth"></span>
										</div>
										<!--Father's Name View-->
										<div class="form-group">
											<label>Father's Name :</label> <span class="input-sm"
												ng-bind="ctrl.empPersonalDetail.fatherName"></span>
										</div>
										<!--Father's Name View-->
										<div class="form-group">
											<label>Father's Name :</label> <span class="input-sm"
												ng-bind="ctrl.empPersonalDetail.fatherName"></span>
										</div>
										<!--Mother's Name View-->
										<div class="form-group">
											<label>Mother's Name :</label> <span class="input-sm"
												ng-bind="ctrl.empPersonalDetail.motherName"></span>
										</div>
										<!--Blood Group View-->
										<div class="form-group">
											<label>Blood Group :</label> <span class="input-sm"
												ng-bind="ctrl.getBloodGroupType(ctrl.empPersonalDetail.bloodGroup)"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Driving License Number View-->
										<div class="form-group">
											<label>Driving License Number :</label> <span
												class="input-sm"
												ng-bind="ctrl.empPersonalDetail.drivingLicense"></span>
										</div>
										<!--Driving License State View-->
										<div class="form-group">
											<label>Driving License State :</label> <span class="input-sm"
												ng-bind="ctrl.getDrivingLicenseStateType(ctrl.empPersonalDetail.drivingLicenseState)"></span>
										</div>
										<!--PAN Number View-->
										<div class="form-group">
											<label>PAN Number :</label> <span class="input-sm"
												ng-bind="ctrl.empPersonalDetail.panNumber"></span>
										</div>
										<!--Aadhaar Number View-->
										<div class="form-group">
											<label>Aadhaar Number :</label> <span class="input-sm"
												ng-bind="ctrl.empPersonalDetail.aadharNumber"></span>
										</div>
										<!--Marital Status View-->
										<div class="form-group">
											<label for="utilizationStatus">Marital Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getMaritalStatusType(ctrl.empPersonalDetail.maritalStatus)"></span>
										</div>
										<!--Wedding Date View-->
										<div class="form-group">
											<label for="utilizationStatus">Wedding Date :</label> <span
												class="input-sm"
												ng-bind="ctrl.empPersonalDetail.weddingDate"></span>
										</div>
										<!--Spouse Name View-->
										<div class="form-group">
											<label for="utilizationStatus">Spouse Name :</label> <span
												class="input-sm" ng-bind="ctrl.empPersonalDetail.spouseName"></span>
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
												<th><label>ID</label></th>
											</div>
											<div class="form-group">
												<th><label>Employee Name</label></th>
											</div>
											<div class="form-group">
												<th><label>Gender</label></th>
											</div>
											<div class="form-group">
												<th><label>Date of Birth</label></th>
											</div>
											<div class="form-group">
												<th><label>Father's Name</label></th>
											</div>
											<div class="form-group">
												<th><label>PAN Number</label></th>
											</div>
											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.empPersonalDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="ctrl.getEmployeeName(u.empDetail.id)"
														class="input-sm"></span></a></td>
												<td><span ng-bind="ctrl.getGenderType(u.gender)"
													class="input-sm"></span></td>
												<td><span ng-bind="u.dateOfBirth" class="input-sm"></span></td>
												<td><span ng-bind="u.fatherName" class="input-sm"></span></td>
												<td><span ng-bind="u.panNumber" class="input-sm"></span></td>
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
		src="<c:url value="/resources/js/controller/emppersonaldetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/emppersonaldetail_service.js" />"></script>
</body>
</html>

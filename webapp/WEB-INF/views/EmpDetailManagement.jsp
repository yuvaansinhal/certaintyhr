<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR -Employee Detail Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="EmpDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Employee Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Employee Detail</button>
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
									<form ng-submit="ctrl.submit()" name="EmpDetailForm">
										<!-- First half Emp_detail start -->
										<div class="col-md-6">

											<input type="hidden" ng-model="ctrl.empDetail.id" />
											<!--Employee Code Input-->
											<div class="form-group">
												<label for="employeeCode">Employee Code<span
													style="color: red"> * </span></label> <input type="text"
													name="employeeCode" ng-model="ctrl.empDetail.employeeCode"
													id="employeeCode"
													class="employeeCode form-control input-sm"
													placeholder="Enter Employee Code" required ng-minlength="3" />
												<span style="color: red"
													ng-show="EmployeeForm.employeeCode.$touched || EmployeeForm.employeeCode.$dirty && EmployeeForm.employeeCode.$invalid ">
													<span
													ng-show="EmployeeForm.employeeCode.$touched && EmployeeForm.employeeCode.$error.required">Employee
														Code is required.</span>
												</span>
											</div>
											<!--First Name Input-->
											<div class="form-group">
												<label for="firstName">First Name<span
													style="color: red"> * </span></label> <input type="text"
													name="firstName" ng-model="ctrl.empDetail.firstName"
													id="firstName" class="firstName form-control input-sm"
													placeholder="Enter First Name" required ng-minlength="3" />
												<span style="color: red"
													ng-show="EmployeeForm.firstName.$touched || EmployeeForm.firstName.$dirty && EmployeeForm.firstName.$invalid ">
													<span
													ng-show="EmployeeForm.firstName.$touched && EmployeeForm.firstName.$error.required">First
														Name is required.</span>
												</span>
											</div>
											<!--Last Name Input-->
											<div class="form-group">
												<label for="lastName">Last Name</label> <input type="text"
													name="lastName" ng-model="ctrl.empDetail.lastName"
													id="lastName" class="lastName form-control input-sm"
													placeholder="Enter First Name" />
											</div>
											<!--Email Input-->
											<div class="form-group">
												<label for="email">Email<span style="color: red">
														* </span></label> <input type="text" name="email"
													ng-model="ctrl.empDetail.empEmail" id="email"
													class="email form-control input-sm"
													placeholder="Enter Email" required ng-minlength="3" /> <span
													style="color: red"
													ng-show="EmployeeForm.email.$touched || EmployeeForm.email.$dirty && EmployeeForm.email.$invalid ">
													<span
													ng-show="EmployeeForm.email.$touched && EmployeeForm.email.$error.required">Email
														is required.</span>
												</span>
											</div>
											<!--Department Id Input-->
											<div class="form-group">
												<label for="departmentId">Department<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empDetail.department.deptId"
													name="departmentId"
													class="departmentId form-control input-sm" required
													ng-options="u.deptId as u.deptName for u in ctrl.departments">
													<option value="" selected disabled
														class="departmentId form-control input-sm">Select
														Department</option>
												</select> <span style="color: red"
													ng-show="EmployeeForm.departmentId.$touched || EmployeeForm.departmentId.$dirty && EmployeeForm.departmentId.$invalid">
													<span
													ng-show="EmployeeForm.departmentId.$touched && EmployeeForm.departmentId.$error.required">Department
														is required.</span>
												</span>
											</div>
											<!--Grade Id Input-->
											<div class="form-group">
												<label for="gradeId">Grade<span style="color: red">
														* </span></label> <select ng-model="ctrl.empDetail.grade.gradeId"
													ng-change="ctrl.fetchAllOrderedDesignationsByGradeId(ctrl.empDetail.grade.gradeId)"
													name="gradeId" class="gradeId form-control input-sm"
													required
													ng-options="u.gradeId as u.gradeName for u in ctrl.grades">
													<option value="" selected disabled
														class="gradeId form-control input-sm">Select
														Grade</option>
												</select> <span style="color: red"
													ng-show="EmployeeForm.gradeId.$touched || EmployeeForm.gradeId.$dirty && EmployeeForm.gradeId.$invalid">
													<span
													ng-show="EmployeeForm.gradeId.$touched && EmployeeForm.gradeId.$error.required">Grade
														is required.</span>
												</span>
											</div>
											<!--Designation Input-->
											<div class="form-group">
												<label for="designationId">Designation<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empDetail.designation.designationId"
													name="designationId"
													class="designationId form-control input-sm" required
													ng-options="u.designationId as u.designationName for u in ctrl.designationsByGrade">
													<option value="" selected disabled
														class="designationId form-control input-sm">Select
														Designation</option>
												</select> <span style="color: red"
													ng-show="EmployeeForm.designationId.$touched || EmployeeForm.designationId.$dirty && EmployeeForm.designationId.$invalid">
													<span
													ng-show="EmployeeForm.designationId.$touched && EmployeeForm.designationId.$error.required">Designation
														is required.</span>
												</span>
											</div>
										</div>
										<!-- second half of Emp_detail start  -->
										<div class="col-md-6">
											<!--Supervisor Id Input-->
											<div class="form-group">
												<label for="supervisorId">Supervisor</label> <select
													ng-model="ctrl.empDetail.supervisorId" name="supervisorId"
													class="supervisorId form-control input-sm"
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.supervisors">
													<option value="" selected disabled
														class="supervisorId form-control input-sm">Select
														Supervisor</option>
												</select>
											</div>
											<!--Location Id Input-->
											<div class="form-group">
												<label for="locationId">Location <span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empDetail.location.locationId"
													name="locationId" class="locationId form-control input-sm"
													required
													ng-options="u.locationId as u.office for u in ctrl.locations">
													<option value="" selected disabled
														class="locationId form-control input-sm">Select
														Location</option>
												</select><span style="color: red"
													ng-show="EmployeeForm.locationId.$touched || EmployeeForm.locationId.$dirty && EmployeeForm.locationId.$invalid">
													<span
													ng-show="EmployeeForm.locationId.$touched && EmployeeForm.locationId.$error.required">
														Location is required.</span>
												</span>
											</div>
											<!--Office Contact Number Input-->
											<div class="form-group">
												<label for="officeContactNumber">Office Contact
													Number<span style="color: red"> * </span>
												</label> <input type="text" name="officeContactNumber"
													ng-model="ctrl.empDetail.officeContactNumber"
													id="officeContactNumber"
													class="officeContactNumber form-control input-sm"
													placeholder="Enter Office Contact Number" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmployeeForm.officeContactNumber.$touched || EmployeeForm.officeContactNumber.$dirty && EmployeeForm.officeContactNumber.$invalid ">
													<span
													ng-show="EmployeeForm.officeContactNumber.$touched && EmployeeForm.officeContactNumber.$error.required">Office
														Contact Number is required.</span>
												</span>
											</div>
											<!--Joining start date Input-->
											<div class="form-group">
												<label>Joining Date <span style="color: red">*
												</span>
												</label> <input type="date" ng-model="ctrl.empDetail.joiningDate"
													name="joiningDate"
													class="joiningDate form-control input-sm" id="joiningDate"
													placeholder="Enter Joining Date" required /> <span
													style="color: red"
													ng-show="EmployeeForm.joiningDate.$touched || EmployeeForm.joiningDate.$dirty && EmployeeForm.joiningDate.$invalid">
													<span
													ng-show="EmployeeForm.Joiningdate.$touched && EmployeeForm.joiningDate.$error.required">
														Joining Date is required.</span>
												</span>
											</div>
											<!--Emp previous Experience-->
											<div class="form-group">
												<label for="previousExperience">Previous Experience
													(in Months)<span style="color: red"> * </span>
												</label> <input type="text"
													ng-model="ctrl.empDetail.previousExperience"
													name="previousExperience"
													class="previousExperience form-control input-sm"
													id="previousExperience"
													placeholder="Enter Previous Experience" required /> <span
													style="color: red"
													ng-show="EmployeeForm.previousExperience.$touched || EmployeeForm.previousExperience.$dirty && EmployeeForm.previousExperience.$invalid">
													<span
													ng-show="EmployeeForm.previousExperience.$touched && EmployeeForm.previousExperience.$error.required">Previous
														Experience is required.</span>
												</span>
											</div>
											<!--Cost to Company Input-->
											<div class="form-group">
												<label for="costToCompany">Cost To Company<span
													style="color: red"> * </span>
												</label> <input type="text" ng-model="ctrl.empDetail.costToCompany"
													name="costToCompany"
													class="costToCompany form-control input-sm"
													id="costToCompany" placeholder="Enter Cost To Company "
													required /> <span style="color: red"
													ng-show="EmployeeForm.costToCompany.$touched || EmployeeForm.costToCompany.$dirty && EmployeeForm.costToCompany.$invalid">
													<span
													ng-show="EmployeeForm.costToCompany.$touched && EmployeeForm.costToCompany.$error.required">Cost
														To Company is required.</span>
												</span>
											</div>
											<!--Current status Input-->
											<div class="form-group">
												<label for="employeeStatusId">Employee Status</label> <select
													ng-model="ctrl.empDetail.employeeStatus.employeeStatusId"
													name="employeeStatusId"
													class="employeeStatusId form-control input-sm"
													ng-options="u.employeeStatusId as u.employeeStatusName for u in ctrl.employeeStatuses">
													<option value="" selected disabled
														class="employeeStatusId form-control input-sm">Select
														Employee Status</option>
												</select>
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.empDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="EmpDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="EmpDetailForm.$pristine">Reset Form</button>
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
										<!--Employee ID View-->
										<div class="form-group">
											<label>ID : </label> <span class="input-sm"
												ng-bind="ctrl.empDetail.id"></span>
										</div>
										<!--Employee Code Input-->
										<div class="form-group">
											<label>Employee Code : </label> <span class="input-sm"
												ng-bind="ctrl.empDetail.employeeCode"></span>
										</div>
										<!--First Name View-->
										<div class="form-group">
											<label>First Name : </label> <span class="input-sm"
												ng-bind="ctrl.empDetail.firstName"></span>
										</div>
										<!--Last Name Input-->
										<div class="form-group">
											<label>Last Name : </label> <span class="input-sm"
												ng-bind="ctrl.empDetail.lastName"> </span>
										</div>
										<!--Email-->
										<div class="form-group">
											<label>Email : </label> <span class="input-sm"
												ng-bind="ctrl.empDetail.empEmail"></span>
										</div>
										<!--Department Id Input-->
										<div class="form-group">
											<label>Department : </label> <span class="input-sm"
												ng-bind="ctrl.getDepartmentName(ctrl.empDetail.department.deptId)"></span>
										</div>
										<!--Grade Id Input-->
										<div class="form-group">
											<label>Grade : </label> <span class="input-sm"
												ng-bind="ctrl.getGradeName(ctrl.empDetail.grade.gradeId)">
											</span>
										</div>
										<!--Designation Input-->
										<div class="form-group">
											<label>Designation : </label> <span class="input-sm"
												ng-bind="ctrl.getDesignationName(ctrl.empDetail.designation.designationId)">
											</span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Supervisor Id Input-->
										<div class="form-group">
											<label>Supervisor : </label> <span class="input-sm"
												ng-bind="ctrl.getSupervisorName(ctrl.empDetail.supervisorId)">
											</span>
										</div>
										<!--Location Id Input-->
										<div class="form-group">
											<label>Location : </label> <span class="input-sm"
												ng-bind="ctrl.getOfficeLocation(ctrl.empDetail.location.locationId)">
											</span>
										</div>
										<!--Office Contact Number Input-->
										<div class="form-group">
											<label>Office Contact Number : </label> <span
												class="input-sm"
												ng-bind="ctrl.empDetail.officeContactNumber"></span>
										</div>
										<!--Joining start date-->
										<div class="form-group">
											<label>Joining Date : </label> <span class="input-sm"
												ng-bind="ctrl.empDetail.joiningDate"></span>
										</div>
										<!--Employee previous Experinece-->
										<div class="form-group">
											<label>Previous Experience (in Months) : </label><span
												class="input-sm" ng-bind="ctrl.empDetail.previousExperience"></span>
										</div>
										<!--Cost to Company Input-->
										<div class="form-group">
											<label>Cost To Company : </label><span class="input-sm"
												ng-bind="ctrl.empDetail.costToCompany"></span>
										</div>
										<!--Employee status Input-->
										<div class="form-group">
											<label>Employee Status : </label> <span class="input-sm"
												ng-bind="ctrl.getEmployeeStatusName(ctrl.empDetail.employeeStatus.employeeStatusId)">
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--End DETAIL VIEW -->
				<!-- LIST TABLE -->
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<!--Id-->
											<div class="form-group">
												<th><label for="id">Id</label></th>
											</div>
											<!--Employee Code -->
											<div class="form-group">
												<th><label for="employeeCode">Employee Code</label></th>
											</div>
											<!--First Name View-->
											<div class="form-group">
												<th><label for="firstName">First Name</label></th>
											</div>
											<!--Last Name-->
											<div class="form-group">
												<th><label for="lastName">Last Name</label></th>
											</div>
											<!--Email-->
											<div class="form-group">
												<th><label for="email">Email</label></th>
											</div>
											<!--Department-->
											<div class="form-group">
												<th><label for="departmentId">Department</label></th>
											</div>
											<!--Actions of Edit / Add-->
											<div class="form-group">
												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>
										</thead>
										<tbody>
											<tr ng-repeat="u in ctrl.empDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="u.employeeCode" class="input-sm"></span></a></td>
												<td><span ng-bind="u.firstName" class="input-sm"></span></td>
												<td><span ng-bind="u.lastName" class="input-sm"></span></td>
												<td><span ng-bind="u.empEmail" class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getDepartmentName(u.department.deptId)"
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
						<!--End List Tables -->
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- /. PAGE INNER  -->

	<%@ include file="/WEB-INF/views/footer.jsp"%>
	<script
		src="<c:url value="/resources/js/controller/empdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/empdetail_service.js" />"></script>
</body>
</html>








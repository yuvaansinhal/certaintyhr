<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Employee Project Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="EmpProjectDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Project Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Project Detail</button>
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
									<form ng-submit="ctrl.submit()" name="EmpProjectDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Emp Project Detail Id Hidden-->
											<input type="hidden" ng-model="ctrl.empProjectDetail.id" />
											<!--Client Dropdown-->
											<div class="form-group">
												<label for="clientId">Client<span style="color: red">
														* </span></label> <select
													ng-model="ctrl.empProjectDetail.clientDetail.id"
													name="clientId"
													ng-change="ctrl.fetchAllOrderedProjectDetailsByClient(ctrl.empProjectDetail.clientDetail.id)"
													class="clientId form-control input-sm" required
													ng-options="u.id as u.clientName for u in ctrl.clientDetails">
													<option value="" selected disabled
														class="clientId form-control input-sm">Select
														Client</option>
												</select> <span style="color: red"
													ng-show="EmpProjectDetailForm.clientId.$touched || EmpProjectDetailForm.clientId.$dirty && EmpProjectDetailForm.clientId.$invalid">
													<span
													ng-show="EmpProjectDetailForm.clientId.$touched && EmpProjectDetailForm.clientId.$error.required">Client
														is required.</span>
												</span>
											</div>
											<!--Project Detail Dropdown-->
											<div class="form-group">
												<label for="projectId">Project Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empProjectDetail.projectDetail.id"
													name="projectId" class="projectId form-control input-sm"
													required
													ng-options="u.id as u.projectName for u in ctrl.projectDetailsByClients">
													<option value="" selected disabled
														class="projectId form-control input-sm">Select
														Project</option>
												</select> <span style="color: red"
													ng-show="EmpProjectDetailForm.projectId.$touched || EmpProjectDetailForm.projectId.$dirty && EmpProjectDetailForm.projectId.$invalid">
													<span
													ng-show="EmpProjectDetailForm.projectId.$touched && EmpProjectDetailForm.projectId.$error.required">Project
														Name is required.</span>
												</span>
											</div>
											<!--EmpDetail Dropdown-->
											<div class="form-group">
												<label for="empDetail">Employee Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empProjectDetail.empDetail.id"
													name="empDetail" class="empDetail form-control input-sm"
													required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														Employee</option>
												</select> <span style="color: red"
													ng-show="EmpProjectDetailForm.empDetail.$touched || EmpProjectDetailForm.empDetail.$dirty && EmpProjectDetailForm.empDetail.$invalid">
													<span
													ng-show="EmpProjectDetailForm.empDetail.$touched && EmpProjectDetailForm.empDetail.$error.required">Employee
														Name is required.</span>
												</span>
											</div>
											<!--Project Role Dropdown-->
											<div class="form-group">
												<label for="projectRoleId">Project Role<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empProjectDetail.projectRole.projectRoleId"
													name="projectRoleId"
													class="projectRoleId form-control input-sm" required
													ng-options="u.projectRoleId as u.projectRoleName for u in ctrl.projectRoles">
													<option value="" selected disabled
														class="projectRoleId form-control input-sm">Select
														Project Role</option>
												</select> <span style="color: red"
													ng-show="EmpProjectDetailForm.projectRoleId.$touched || EmpProjectDetailForm.projectRoleId.$dirty && EmpProjectDetailForm.projectRoleId.$invalid">
													<span
													ng-show="EmpProjectDetailForm.projectRoleId.$touched && EmpProjectDetailForm.projectRoleId.$error.required">Project
														Role is required.</span>
												</span>
											</div>
											<!--Billing Status Dropdown-->
											<div class="form-group">
												<label for="billingStatus">Billing Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empProjectDetail.billingStatus.billingStatusId"
													name="billingStatus"
													class="billingStatus form-control input-sm" required
													ng-options="u.billingStatusId as u.billingStatusName for u in ctrl.billingStatuses">
													<option value="" selected disabled
														class="billingStatus form-control input-sm">Select
														Billing Status</option>
												</select> <span style="color: red"
													ng-show="EmpProjectDetailForm.billingStatus.$touched || EmpProjectDetailForm.billingStatus.$dirty && EmpProjectDetailForm.billingStatus.$invalid">
													<span
													ng-show="EmpProjectDetailForm.billingStatus.$touched && EmpProjectDetailForm.billingStatus.$error.required">Billing
														Status is required.</span>
												</span>
											</div>
											<!--Client Allocation Date-->
											<div class="form-group">
												<label for="clientAllocationDate">Client Allocation
													Date<span style="color: red"> * </span>
												</label> <input type="date" name="clientAllocationDate"
													ng-model="ctrl.empProjectDetail.clientAllocationDate"
													id="clientAllocationDate"
													class="clientAllocationDate form-control input-sm"
													placeholder="Enter client Allocation Date" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpProjectDetailForm.clientAllocationDate.$touched || EmpProjectDetailForm.clientAllocationDate.$dirty &&	EmpProjectDetailForm.clientAllocationDate.$invalid ">
													<span
													ng-show="EmpProjectDetailForm.clientAllocationDate.$touched && EmpProjectDetailForm.clientAllocationDate.$error.required">Client
														Allocation Date is required.</span>
												</span>
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Project Allocation Date-->
											<div class="form-group">
												<label for="projectAllocationDate">Project
													Allocation Date<span style="color: red"> * </span>
												</label> <input type="date" name="projectAllocationDate"
													ng-model="ctrl.empProjectDetail.projectAllocationDate"
													id="projectAllocationDate"
													class="projectAllocationDate form-control input-sm"
													placeholder="Enter project Allocation Date" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpProjectDetailForm.projectAllocationDate.$touched || EmpProjectDetailForm.projectAllocationDate.$dirty &&	EmpProjectDetailForm.projectAllocationDate.$invalid ">
													<span
													ng-show="EmpProjectDetailForm.projectAllocationDate.$touched && EmpProjectDetailForm.projectAllocationDate.$error.required">Project 
														Allocation Date is required.</span>
												</span>
											</div>
											<!--Utilization Status Dropdown-->
											<div class="form-group">
												<label for="utilizationStatusId">Utilization Status
													Id<span style="color: red"> * </span>
												</label> <select
													ng-model="ctrl.empProjectDetail.utilizationStatus.utilizationStatusId"
													name="utilizationStatusId"
													class="utilizationStatusId form-control input-sm" required
													ng-options="u.utilizationStatusId as u.utilizationStatusName for u in ctrl.utilizationStatuses">
													<option value="" selected disabled
														class="utilizationStatusId form-control input-sm">Select
														Utilization Status</option>
												</select> <span style="color: red"
													ng-show="EmpProjectDetailForm.utilizationStatusId.$touched || EmpProjectDetailForm.utilizationStatusId.$dirty && EmpProjectDetailForm.utilizationStatusId.$invalid">
													<span
													ng-show="EmpProjectDetailForm.utilizationStatusId.$touched && EmpProjectDetailForm.utilizationStatusId.$error.required">Utilization
														Status is required.</span>
												</span>
											</div>
											<!--Expected Release Date -->
											<div class="form-group">
												<label for="expectedReleaseDate">Expected Release
													Date <span style="color: red"> * </span>
												</label> <input type="date" name="expectedReleaseDate"
													ng-model="ctrl.empProjectDetail.expectedReleaseDate"
													id="expectedReleaseDate"
													class="expectedReleaseDate form-control input-sm"
													placeholder="Enter expected Release Date" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpProjectDetailForm.expectedReleaseDate.$touched || EmpProjectDetailForm.expectedReleaseDate.$dirty &&	EmpProjectDetailForm.expectedReleaseDate.$invalid ">
													<span
													ng-show="EmpProjectDetailForm.expectedReleaseDate.$touched && EmpProjectDetailForm.expectedReleaseDate.$error.required">Expected 
														Release Date is required.</span>
												</span>
											</div>
											<!--Allocation Proportion Input-->
											<div class="form-group">
												<label for="allocationProportion">Allocation
													Proportion<span style="color: red"> * </span>
												</label> <input type="text" name="allocationProportion"
													ng-model="ctrl.empProjectDetail.allocationProportion"
													id="allocationProportion"
													class="allocationProportion form-control input-sm"
													placeholder="Enter Allocation Proportion" required
													ng-minlength="1" /> <span style="color: red"
													ng-show="EmpProjectDetailForm.allocationProportion.$touched || EmpProjectDetailForm.allocationProportion.$dirty &&	EmpProjectDetailForm.allocationProportion.$invalid ">
													<span
													ng-show="EmpProjectDetailForm.allocationProportion.$touched && EmpProjectDetailForm.allocationProportion.$error.required">Allocation
														Proportion is required.</span>
												</span>
											</div>
											<!--Allocation Plan Input-->
											<div class="form-group">
												<label for="allocationPlan">Allocation Plan<span
													style="color: red"> * </span></label> <input type="text"
													name="allocationPlan"
													ng-model="ctrl.empProjectDetail.allocationPlan"
													id="allocationPlan"
													class="allocationPlan form-control input-sm"
													placeholder="Enter Allocation Plan" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpProjectDetailForm.allocationPlan.$touched || EmpProjectDetailForm.allocationPlan.$dirty &&	EmpProjectDetailForm.allocationPlan.$invalid ">
													<span
													ng-show="EmpProjectDetailForm.allocationPlan.$touched && EmpProjectDetailForm.allocationPlan.$error.required">Allocation
														Plan is required.</span>
												</span>
											</div>
											<!--Status change Date-->
											<div class="form-group">
												<label>Status Change Date</label> <input type="date"
													ng-model="ctrl.empProjectDetail.statusChangeDate"
													name="statusChangeDate"
													class="statusChangeDate form-control input-sm"
													id="statusChangeDate"
													placeholder="Enter Status Change Date" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.empProjectDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="EmpProjectDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="EmpProjectDetailForm.$pristine">Reset
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

										<!--Project ID View-->
										<div class="form-group">
											<label for="empProjectDetailId">ID : </label> <span
												class="input-sm" ng-bind="ctrl.empProjectDetail.id"></span>
										</div>
										<!--Client Name View-->
										<div class="form-group">
											<label for="clientDetail">Client Name :</label> <span
												class="input-sm"
												ng-bind="ctrl.getClientName(ctrl.empProjectDetail.clientDetail.id)"></span>
										</div>
										<!--Project Name View-->
										<div class="form-group">
											<label for="projectDetail">Project Name :</label> <span
												class="input-sm"
												ng-bind="ctrl.getProjectName(ctrl.empProjectDetail.projectDetail.id)"></span>
										</div>
										<!--EmpDetail View-->
										<div class="form-group">
											<label for="firstName">Employee Name : </label> <span
												class="input-sm"
												ng-bind="ctrl.getEmployeeName(ctrl.empProjectDetail.empDetail.id)"></span>
										</div>
										<!--Project Role View-->
										<div class="form-group">
											<label for="projectRole">Project Role :</label> <span
												class="input-sm"
												ng-bind="ctrl.getProjectRoleName(ctrl.empProjectDetail.projectRole.projectRoleId)"></span>
										</div>
										<!--Billing Status View-->
										<div class="form-group">
											<label for="billingStatus">Billing Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getBillingStatusName(ctrl.empProjectDetail.billingStatus.billingStatusId)"></span>
										</div>
										<!--Client Allocation Date View-->
										<div class="form-group">
											<label>Client Allocation Date :</label> <span
												class="input-sm"
												ng-bind="ctrl.empProjectDetail.clientAllocationDate"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Project Allocation Date View-->
										<div class="form-group">
											<label>Project Allocation Date :</label> <span
												class="input-sm"
												ng-bind="ctrl.empProjectDetail.projectAllocationDate"></span>
										</div>
										<!--Utilization Status View-->
										<div class="form-group">
											<label for="utilizationStatus">Utilization Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getUtilizationStatusName(ctrl.empProjectDetail.utilizationStatus.utilizationStatusId)"></span>
										</div>
										<!--Expected Release Date View-->
										<div class="form-group">
											<label>Expected Release Date :</label> <span class="input-sm"
												ng-bind="ctrl.empProjectDetail.expectedReleaseDate"></span>
										</div>
										<!--Allocation Proportion View-->
										<div class="form-group">
											<label>Allocation Proportion :</label> <span class="input-sm"
												ng-bind="ctrl.empProjectDetail.allocationProportion"></span>
										</div>
										<!--Allocation Plan View-->
										<div class="form-group">
											<label>Allocation Plan :</label> <span class="input-sm"
												ng-bind="ctrl.empProjectDetail.allocationPlan"></span>
										</div>
										<!--Status change View-->
										<div class="form-group">
											<label>Status Change Date</label> <span class="input-sm"
												ng-bind="ctrl.empProjectDetail.statusChangeDate"></span>
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

												<th><label for="empProjectDetailId">ID</label></th>
											</div>

											<div class="form-group">

												<th><label for="empDetail">Employee Name</label></th>
											</div>
											<div class="form-group">

												<th><label for="clientName">Client</label></th>
											</div>

											<div class="form-group">

												<th><label for="projectName">Project Name</label></th>
											</div>

											<div class="form-group">

												<th><label for="billingStatus">Billing Status</label></th>
											</div>
											<div class="form-group">

												<th><label for="utilizationStatus">Utilization
														Status</label></th>
											</div>

											<div class="form-group">

												<th><label for="clientAllocationDate">Client
														Allocation Date</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.empProjectDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="ctrl.getEmployeeName(u.empDetail.id)"
														class="input-sm"></span></a></td>
												<td><span
													ng-bind="ctrl.getClientName(u.clientDetail.id)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getProjectName(u.projectDetail.id)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getBillingStatusName(u.billingStatus.billingStatusId)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getUtilizationStatusName(u.utilizationStatus.utilizationStatusId)"
													class="input-sm"></span></td>
												<td><span ng-bind="u.clientAllocationDate"
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
		src="<c:url value="/resources/js/controller/empprojectdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/empprojectdetail_service.js" />"></script>
</body>
</html>

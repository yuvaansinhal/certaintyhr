<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Project Resource Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="ProjectResourceController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Project Resource Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Project Resource</button>
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
									<form ng-submit="ctrl.submit()" name="ProjectResourceForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Project Resource Id Hidden-->
											<input type="hidden" ng-model="ctrl.projectResource.id" />
											<!--Client Dropdown-->
											<div class="form-group">
												<label for="clientId">Client<span style="color: red">
														* </span></label> <select ng-model="ctrl.projectResource.clientDetail.id"
													name="clientId"
													ng-change="ctrl.fetchAllOrderedProjectDetailsByClient(ctrl.projectResource.clientDetail.id)"
													class="clientId form-control input-sm" required
													ng-options="u.id as u.clientName for u in ctrl.clientDetails">
													<option value="" selected disabled
														class="clientId form-control input-sm">Select
														Client</option>
												</select> <span style="color: red"
													ng-show="ProjectResourceForm.clientId.$touched || ProjectResourceForm.clientId.$dirty && ProjectResourceForm.clientId.$invalid">
													<span
													ng-show="ProjectResourceForm.clientId.$touched && ProjectResourceForm.clientId.$error.required">Client
														is required.</span>
												</span>
											</div>
											<!--Project Detail Dropdown-->
											<div class="form-group">
												<label for="projectId">Project Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectResource.projectDetail.id"
													name="projectId" class="projectId form-control input-sm"
													required
													ng-options="u.id as u.projectName for u in ctrl.projectDetailsByClients">
													<option value="" selected disabled
														class="projectId form-control input-sm">Select
														Project</option>
												</select> <span style="color: red"
													ng-show="ProjectResourceForm.projectId.$touched || ProjectResourceForm.projectId.$dirty && ProjectResourceForm.projectId.$invalid">
													<span
													ng-show="ProjectResourceForm.projectId.$touched && ProjectResourceForm.projectId.$error.required">User
														Name is required.</span>
												</span>
											</div>
											<!--EmpDetail Dropdown-->
											<div class="form-group">
												<label for="empDetail">Employee Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectResource.empDetail.id"
													name="empDetail" class="empDetail form-control input-sm"
													required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														Employee</option>
												</select> <span style="color: red"
													ng-show="ProjectResourceForm.empDetail.$touched || ProjectResourceForm.empDetail.$dirty && ProjectResourceForm.empDetail.$invalid">
													<span
													ng-show="ProjectResourceForm.empDetail.$touched && ProjectResourceForm.empDetail.$error.required">User
														Name is required.</span>
												</span>
											</div>
											<!--Project Role Dropdown-->
											<div class="form-group">
												<label for="projectRoleId">Project Role<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectResource.projectRole.projectRoleId"
													name="projectRoleId"
													class="projectRoleId form-control input-sm" required
													ng-options="u.projectRoleId as u.projectRoleName for u in ctrl.projectRoles">
													<option value="" selected disabled
														class="projectRoleId form-control input-sm">Select
														Project Role</option>
												</select> <span style="color: red"
													ng-show="ProjcetResourceForm.projectRoleId.$touched || ProjcetResourceForm.projectRoleId.$dirty && ProjcetResourceForm.projectRoleId.$invalid">
													<span
													ng-show="ProjcetResourceForm.projectRoleId.$touched && ProjcetResourceForm.projectRoleId.$error.required">Project
														Role is required.</span>
												</span>
											</div>
											<!--Billing Status Dropdown-->
											<div class="form-group">
												<label for="billingStatus">Billing Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectResource.billingStatus.billingStatusId"
													name="billingStatus"
													class="billingStatus form-control input-sm" required
													ng-options="u.billingStatusId as u.billingStatusName for u in ctrl.billingStatuses">
													<option value="" selected disabled
														class="billingStatus form-control input-sm">Select
														Billing Status</option>
												</select> <span style="color: red"
													ng-show="ProjectResourceForm.billingStatus.$touched || ProjectResourceForm.billingStatus.$dirty && ProjectResourceForm.billingStatus.$invalid">
													<span
													ng-show="ProjectResourceForm.billingStatus.$touched && ProjectResourceForm.billingStatus.$error.required">Billing
														Status is required.</span>
												</span>
											</div>
											<!--Rate Per Hour Input-->
											<div class="form-group">
												<label for="ratePerHour">Rate Per Hour<span
													style="color: red"> * </span></label> <input type="text"
													name="ratePerHour"
													ng-model="ctrl.projectResource.ratePerHour"
													id="ratePerHour" class="ratePerHour form-control input-sm"
													placeholder="Enter Rate Per Hour" required ng-minlength="1" />
												<span style="color: red"
													ng-show="ProjectResourceForm.ratePerHour.$touched || ProjectResourceForm.ratePerHour.$dirty && ProjectResourceForm.ratePerHour.$invalid ">
													<span
													ng-show="ProjectResourceForm.ratePerHour.$touched && ProjectResourceForm.ratePerHour.$error.required">Rate
														Per Hour is required.</span>
												</span>
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Billing start date Input-->
											<div class="form-group">
												<label>Billing Start Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectResource.billingStartDate"
													name="billingStartDate"
													class="billingStartDate form-control input-sm"
													id="billingStartDate"
													placeholder="Enter Billinng Start Date" required /> <span
													style="color: red"
													ng-show="ProjectResourceForm.billingStartDate.$touched || ProjectResourceForm.billingStartDate.$dirty && ProjectResourceForm.billingStartDate.$invalid">
													<span
													ng-show="ProjectResourceForm.billingStartDate.$touched && ProjectResourceForm.billingStartDate.$error.required">Billing
														Start Date is required.</span>
												</span>
											</div>
											<!--Billing End date Input-->
											<div class="form-group">
												<label>Billing End Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectResource.billingEndDate"
													name="billingEndDate"
													class="billingEndDate form-control input-sm"
													id="billingEndDate" placeholder="Enter Billing End Date"
													required /> <span style="color: red"
													ng-show="ProjectResourceForm.billingEndDate.$touched || ProjectResourceForm.billingEndDate.$dirty && ProjectResourceForm.billingEndDate.$invalid">
													<span
													ng-show="ProjectResourceForm.billingEndDate.$touched && ProjectResourceForm.billingEndDate.$error.required">Billing
														End Date is required.</span>
												</span>
											</div>
											<!-- Allocation Percentage Input-->
											<div class="form-group">
												<label for="allocationPercentage">Allocation
													Percentage<span style="color: red"> * </span>
												</label> <input type="text" name="allocationPercentage"
													ng-model="ctrl.projectResource.allocationPercentage"
													id="allocationPercentage"
													class="poAmount form-control input-sm"
													placeholder="Enter Allocation Percentage" required
													ng-minlength="2" /> <span style="color: red"
													ng-show="ProjectResourceForm.allocationPercentage.$touched || ProjectResourceForm.allocationPercentage.$dirty &&	ProjectResourceForm.allocationPercentage.$invalid ">
													<span
													ng-show="ProjectResourceForm.allocationPercentage.$touched && ProjectResourceForm.allocationPercentage.$error.required">Allocation
														Percentage is required.</span>
												</span>
											</div>
											<!--Current status Drodown-->
											<div class="form-group">
												<label for="currentStatus">Current Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectResource.currentStatus"
													name="currentStatus"
													class="form-control form-control input-sm" required>
													<option value="" selected disabled>Select Status
														Type</option>
													<option ng-repeat="u in ctrl.currentStatuses"
														value="{{u.code}}"
														ng-selected="{{ u.code == ctrl.projectResource.currentStatus}}">
														{{u.type}}</option>
												</select><span style="color: red"
													ng-show="ProjectResourceForm.currentStatus.$touched || ProjectResourceForm.currentStatus.$dirty && ProjectResourceForm.currentStatus.$invalid">
													<span
													ng-show="ProjectResourceForm.currentStatus.$touched && ProjectResourceForm.currentStatus.$error.required">Project
														Resource Current Status is required.</span>
												</span>
											</div>
											<!--Status change Date-->
											<div class="form-group">
												<label>Status Change Date</label> <input type="date"
													ng-model="ctrl.projectResource.statusChangeDate"
													name="statusChangeDate"
													class="statusChangeDate form-control input-sm"
													id="statusChangeDate"
													placeholder="Enter Status Change Date" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.projectResource.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="ProjectResourceForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="ProjectResourceForm.$pristine">Reset
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
											<label for="projectResourceId">ID : </label> <span
												class="input-sm" ng-bind="ctrl.projectResource.id"></span>
										</div>
										<!--Client Name View-->
										<div class="form-group">
											<label for="clientDetail">Client Name :</label> <span
												class="input-sm"
												ng-bind="ctrl.getClientName(ctrl.projectResource.clientDetail.id)"></span>
										</div>
										<!--Project Name View-->
										<div class="form-group">
											<label for="projectDetail">Project Name :</label> <span
												class="input-sm"
												ng-bind="ctrl.getProjectName(ctrl.projectResource.projectDetail.id)"></span>
										</div>
										<!--EmpDetail View-->
										<div class="form-group">
											<label for="firstName">Employee Name : </label> <span
												class="input-sm"
												ng-bind="ctrl.getEmployeeName(ctrl.projectResource.empDetail.id)"></span>
										</div>
										<!--Project Role View-->
										<div class="form-group">
											<label for="projectRole">Project Role :</label> <span
												class="input-sm"
												ng-bind="ctrl.getProjectRoleName(ctrl.projectResource.projectRole.projectRoleId)"></span>
										</div>
										<!--Billing Status View-->
										<div class="form-group">
											<label for="billingStatus">Billing Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getBillingStatusName(ctrl.projectResource.billingStatus.billingStatusId)"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Rate Per Hour View-->
										<div class="form-group">
											<label for="ratePerHour">Rate Per Hour :</label> <span
												class="input-sm" ng-bind="ctrl.projectResource.ratePerHour"></span>
										</div>
										<!--Billing Start Date View-->
										<div class="form-group">
											<label>Billing Start Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectResource.billingStartDate"></span>
										</div>
										<!--Billing End Date View-->
										<div class="form-group">
											<label>Billing End Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectResource.billingEndDate"></span>
										</div>
										<!--Allocation Percentage View-->
										<div class="form-group">
											<label for="allocationPercentage">Allocation
												Percentage :</label> <span class="input-sm"
												ng-bind="ctrl.projectResource.allocationPercentage"></span>
										</div>
										<!--Current status View-->
										<div class="form-group">
											<label for="currentStatus">Current Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getStatusType(ctrl.projectResource.currentStatus)"></span>
										</div>
										<!--Status change View-->
										<div class="form-group">
											<label>Status Change Date</label> <span class="input-sm"
												ng-bind="ctrl.projectResource.statusChangeDate"></span>
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

												<th><label for="projectResourceId">ID</label></th>
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

												<th><label for="BillingStartDate">Start Date</label></th>
											</div>

											<div class="form-group">

												<th><label for="BillingEndDate">End Date</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.projectResources">
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
												<td><span ng-bind="u.billingStartDate" class="input-sm"></span></td>
												<td><span ng-bind="u.billingEndDate" class="input-sm"></span></td>
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
		src="<c:url value="/resources/js/controller/projectresource_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/projectresource_service.js" />"></script>
</body>
</html>

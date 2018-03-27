<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Project Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="ProjectDetailController as ctrl">
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
								Project</button>
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
									<form ng-submit="ctrl.submit()" name="ProjectDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Project Id Hidden-->
											<input type="hidden" ng-model="ctrl.projectDetail.id" />
											<!--Project Name Input-->
											<div class="form-group">
												<label for="projectName">Project Name<span
													style="color: red"> * </span></label> <input type="text"
													name="projectName"
													ng-model="ctrl.projectDetail.projectName" id="projectName"
													class="projectName form-control input-sm"
													placeholder="Enter Project Name" required ng-minlength="3" />
												<span style="color: red"
													ng-show="ProjectDetailForm.projectName.$touched || ProjectDetailForm.projectName.$dirty &&	ProjectDetailForm.projectName.$invalid ">
													<span
													ng-show="ProjectDetailForm.projectName.$touched && ProjectDetailForm.projectName.$error.required">Project
														name is required.</span>
												</span>
											</div>
											<div class="form-group">
												<label for="projectDescription">Project Description<span
													style="color: red"> * </span></label> <input type="text"
													name="projectDescription"
													ng-model="ctrl.projectDetail.projectDescription"
													id="projectDescription"
													class="projectDescription form-control input-sm"
													placeholder="Enter Project Description" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="ProjectDetailForm.projectDescription.$touched || ProjectDetailForm.projectDescription.$dirty &&	ProjectDetailForm.projectDescription.$invalid ">
													<span
													ng-show="ProjectDetailForm.projectDescription.$touched && ProjectDetailForm.projectDescription.$error.required">Project
														Description is required.</span>
												</span>
											</div>
											<!--Client Dropdown-->
											<div class="form-group">
												<label for="clientId">Client<span style="color: red">
														* </span></label> <select ng-model="ctrl.projectDetail.clientDetail.id"
													name="clientId" class="clientId form-control input-sm"
													required
													ng-options="u.id as u.clientName for u in ctrl.clientDetails">
													<option value="" selected disabled
														class="clientId form-control input-sm">Select
														Client</option>
												</select> <span style="color: red"
													ng-show="ProjectDetailForm.clientId.$touched || ProjectDetailForm.clientId.$dirty && ProjectDetailForm.clientId.$invalid">
													<span
													ng-show="ProjectDetailForm.clientId.$touched && ProjectDetailForm.clientId.$error.required">Client
														is required.</span>
												</span>
											</div>
											<!--Client POC Name Hidden-->
											<input type="hidden"
												ng-model="ctrl.projectDetail.clientPocName" />

											<!--Project Type Dropdown-->
											<div class="form-group">
												<label for="projectTypeId">Project Type<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectDetail.projectType.projectTypeId"
													name="projectTypeId"
													class="projectTypeId form-control input-sm" required
													ng-options="u.projectTypeId as u.projectTypeName for u in ctrl.projectTypes">
													<option value="" selected disabled
														class="projectTypeId form-control input-sm">Select
														Project Type</option>
												</select> <span style="color: red"
													ng-show="ProjectDetailForm.projectTypeId.$touched || ProjectDetailForm.projectTypeId.$dirty && ProjectDetailForm.projectTypeId.$invalid">
													<span
													ng-show="ProjectDetailForm.projectTypeId.$touched && ProjectDetailForm.projectTypeId.$error.required">Project
														type is required.</span>
												</span>
											</div>
											<!--Project Estimation Input-->
											<div class="form-group">
												<label for="projectEstimation">Project Estimation<span
													style="color: red"> * </span></label> <input type="text"
													name="projectEstimation"
													ng-model="ctrl.projectDetail.projectEstimation"
													id="projectEstimation"
													class="projectEstimation form-control input-sm"
													placeholder="Enter Project Estimation" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="ProjectDetailForm.projectEstimation.$touched || ProjectDetailForm.projectEstimation.$dirty &&	ProjectDetailForm.projectEstimation.$invalid ">
													<span
													ng-show="ProjectDetailForm.projectEstimation.$touched && ProjectDetailForm.projectEstimation.$error.required">Project
														Estimation is required.</span>
												</span>
											</div>
											<!--Technology Dropdown-->
											<div class="form-group">
												<label for="technologyId">Technology<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectDetail.technology.technologyId"
													name="technologyId"
													class="technologyId form-control input-sm" required
													ng-options="u.technologyId as u.technologyName for u in ctrl.technologies">
													<option value="" selected disabled
														class="technologyId form-control input-sm">Select
														Technology</option>
												</select> <span style="color: red"
													ng-show="ProjectDetailForm.technologyId.$touched || ProjectDetailForm.technologyId.$dirty && ProjectDetailForm.technologyId.$invalid">
													<span
													ng-show="ProjectDetailForm.technologyId.$touched && ProjectDetailForm.technologyId.$error.required">Technology
														is required.</span>
												</span>
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Project start date Input-->
											<div class="form-group">
												<label>Project Start Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectDetail.projectStartDate"
													name="projectStartDate"
													class="projectStartDate form-control input-sm"
													id="projectStartDate"
													placeholder="Enter Project Start Date" required /> <span
													style="color: red"
													ng-show="ProjectDetailForm.projectStartDate.$touched || ProjectDetailForm.projectStartDate.$dirty && ProjectDetailForm.projectStartDate.$invalid">
													<span
													ng-show="ProjectDetailForm.projectStartDate.$touched && ProjectDetailForm.projectStartDate.$error.required">Project
														Start Date is required.</span>
												</span>
											</div>
											<!--Project End date Input-->
											<div class="form-group">
												<label>Project End Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectDetail.projectEndDate"
													name="projectEndDate"
													class="projectEndDate form-control input-sm"
													id="projectEndDate" placeholder="Enter Project End Date"
													required /> <span style="color: red"
													ng-show="ProjectDetailForm.projectEndDate.$touched || ProjectDetailForm.projectEndDate.$dirty && ProjectDetailForm.projectEndDate.$invalid">
													<span
													ng-show="ProjectDetailForm.projectEndDate.$touched && ProjectDetailForm.projectEndDate.$error.required">Project
														End Date is required.</span>
												</span>
											</div>
											<!--PO Number Input-->
											<div class="form-group">
												<label for="poNumber">PO Number<span
													style="color: red"> * </span></label> <input type="text"
													name="poNumber" ng-model="ctrl.projectDetail.poNumber"
													id="poNumber" class="poNumber form-control input-sm"
													placeholder="Enter PO Number" required ng-minlength="3" />
												<span style="color: red"
													ng-show="ProjectDetailForm.poNumber.$touched || ProjectDetailForm.poNumber.$dirty &&	ProjectDetailForm.poNumber.$invalid ">
													<span
													ng-show="ProjectDetailForm.poNumber.$touched && ProjectDetailForm.poNumber.$error.required">PO
														Number is required.</span>
												</span>
											</div>
											<!-- PO Amount Input-->
											<div class="form-group">
												<label for="poAmount">PO Amount<span
													style="color: red"> * </span></label> <input type="text"
													name="poAmount" ng-model="ctrl.projectDetail.poAmount"
													id="poNumber" class="poAmount form-control input-sm"
													placeholder="Enter PO Amount" required ng-minlength="3" />
												<span style="color: red"
													ng-show="ProjectDetailForm.poAmount.$touched || ProjectDetailForm.poAmount.$dirty &&	ProjectDetailForm.poAmount.$invalid ">
													<span
													ng-show="ProjectDetailForm.poAmount.$touched && ProjectDetailForm.poAmount.$error.required">PO
														Amount is required.</span>
												</span>
											</div>
											<!--Current status Drodown-->
											<div class="form-group">
												<label for="currentStatus">Current Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectDetail.currentStatus"
													name="currentStatus"
													class="form-control form-control input-sm" required>
													<option value="" selected disabled>Select Status
														Type</option>
													<option ng-repeat="u in ctrl.currentStatuses"
														value="{{u.code}}"
														ng-selected="{{ u.code == ctrl.projectDetail.currentStatus}}">
														{{u.type}}</option>
												</select><span style="color: red"
													ng-show="ProjectDetailForm.currentStatus.$touched || ProjectDetailForm.currentStatus.$dirty && ProjectDetailForm.currentStatus.$invalid">
													<span
													ng-show="ProjectDetailForm.currentStatus.$touched && ProjectDetailForm.currentStatus.$error.required">Project
														Current Status is required.</span>
												</span>
											</div>
											<!--Status change Date-->
											<div class="form-group">
												<label>Status Change Date</label> <input type="date"
													ng-model="ctrl.projectDetail.statusChangeDate"
													name="statusChangeDate"
													class="statusChangeDate form-control input-sm"
													id="statusChangeDate"
													placeholder="Enter Status Change Date" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.projectDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="ProjectDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="ProjectDetailForm.$pristine">Reset
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
											<label for="projectId">Project ID : </label> <span
												class="input-sm" ng-bind="ctrl.projectDetail.id"></span>
										</div>
										<!--Project Name View-->
										<div class="form-group">
											<label for="projectName">Project Name : </label> <span
												class="input-sm" ng-bind="ctrl.projectDetail.projectName"></span>
										</div>
										<!--Project Description View-->
										<div class="form-group">
											<label for="projectDescription">Project Description :</label>
											<span class="input-sm"
												ng-bind="ctrl.projectDetail.projectDescription"></span>
										</div>
										<!--Client Name View-->
										<div class="form-group">
											<label for="clientDetail">Client :</label> <span
												class="input-sm"
												ng-bind="ctrl.getClientName(ctrl.projectDetail.clientDetail.id)"></span>
										</div>
										<!--Client POC Name View-->
										<div class="form-group">
											<label for="clientPocName">Client POC Name :</label> <span
												class="input-sm" ng-bind="ctrl.projectDetail.clientPocName"></span>
										</div>
										<!--Project Type View-->
										<div class="form-group">
											<label for="proejctType">Proejct Type :</label> <span
												class="input-sm"
												ng-bind="ctrl.getProjectTypeName(ctrl.projectDetail.projectType.projectTypeId)"></span>
										</div>
										<!--Technology View-->
										<div class="form-group">
											<label for="technology">Technology :</label> <span
												class="input-sm"
												ng-bind="ctrl.getTechnologyName(ctrl.projectDetail.technology.technologyId)"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Project Estimation View-->
										<div class="form-group">
											<label for="projectEstimation">Project Estimation :</label> <span
												class="input-sm"
												ng-bind="ctrl.projectDetail.projectEstimation"></span>
										</div>
										<!--Project Start Date View-->
										<div class="form-group">
											<label>Project Start Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectDetail.projectStartDate"></span>
										</div>
										<!--Project End Date View-->
										<div class="form-group">
											<label>Project End Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectDetail.projectEndDate"></span>
										</div>
										<!--PO Number View-->
										<div class="form-group">
											<label for="poNumber">PO Number :</label> <span
												class="input-sm" ng-bind="ctrl.projectDetail.poNumber"></span>
										</div>
										<!--PO Amount View-->
										<div class="form-group">
											<label for="poAmount">PO Amount :</label> <span
												class="input-sm" ng-bind="ctrl.projectDetail.poAmount"></span>
										</div>
										<!--Current status View-->
										<div class="form-group">
											<label for="currentStatus">Current Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getStatusType(ctrl.projectDetail.currentStatus)"></span>
										</div>
										<!--Status change View-->
										<div class="form-group">
											<label>Status Change Date</label> <span class="input-sm"
												ng-bind="ctrl.projectDetail.statusChangeDate"></span>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>

				<!-- LIST TABLE -->
				<div class="row">
					<div class="col-md-14">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<div class="form-group">

												<th><label for="projectId">ID</label></th>
											</div>

											<div class="form-group">

												<th><label for="projectName">Project Name</label></th>
											</div>

											<div class="form-group">

												<th><label for="clientName">Client</label></th>
											</div>

											<div class="form-group">
												<th><label for="projectStartDate">Start Date</label></th>
											</div>

											<div class="form-group">

												<th><label for="projectEndDate">End Date</label></th>
											</div>

											<div class="form-group">

												<th><label for="projectType">Type</label></th>
											</div>

											<div class="form-group">

												<th><label for="currentStatus">Current Status</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.projectDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="u.projectName" class="input-sm"></a></span></td>
												<td><span
													ng-bind="ctrl.getClientName(u.clientDetail.id)"
													class="input-sm"></span></td>
												<td><span ng-bind="u.projectStartDate" class="input-sm"></span></td>
												<td><span ng-bind="u.projectEndDate" class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getProjectTypeName(u.projectType.projectTypeId)"
													class="input-sm"></span></td>
												<td><span ng-bind="ctrl.getStatusType(u.currentStatus)"
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
		src="<c:url value="/resources/js/controller/projectdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/projectdetail_service.js" />"></script>
</body>
</html>

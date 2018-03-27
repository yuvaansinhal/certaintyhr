<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Client Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="ClientDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Client Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Client</button>
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
									<form ng-submit="ctrl.submit()" name="ClientDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">

											<input type="hidden" ng-model="ctrl.clientDetail.id" />
											<!--Client Name Input-->
											<div class="form-group">
												<label for="clientName">Client Name<span
													style="color: red"> * </span></label> <input type="text"
													name="clientName" ng-model="ctrl.clientDetail.clientName"
													id="clientName" class="clientName form-control input-sm"
													placeholder="Enter Client Name" required ng-minlength="3" />
												<span style="color: red"
													ng-show="ClientDetailForm.clientName.$touched || ClientDetailForm.clientName.$dirty &&	ClientDetailForm.clientName.$invalid ">
													<span
													ng-show="ClientDetailForm.clientName.$touched && ClientDetailForm.clientName.$error.required">Client
														name is required.</span>
												</span>
											</div>
											<!--Client Description Input-->
											<div class="form-group">
												<label for="clientDesc">Client Description</label> <input
													type="text" name="clientDesc"
													ng-model="ctrl.clientDetail.clientDesc"
													class="clientDesc form-control input-sm" id="clientDesc"
													placeholder="Enter Client Description" />
											</div>
											<!--Client Address Input-->
											<div class="form-group">
												<label>Client Address <span style="color: red">
														* </span></label> <input type="text"
													ng-model="ctrl.clientDetail.clientAddress"
													name="clientAddress"
													class="clientAddress form-control input-sm"
													id="clientAddress" placeholder="Enter Client Address"
													required ng-minlength="3" /> <span style="color: red"
													ng-show="ClientDetailForm.clientAddress.$touched ||  ClientDetailForm.clientAddress.$dirty && ClientDetailForm.clientAddress.$invalid">
													<span
													ng-show="ClientDetailForm.clientAddress.$touched && ClientDetailForm.clientAddress.$error.required">Client
														Address is required.</span>
												</span>

											</div>
											<!--Client Billing Address-->
											<div class="form-group">
												<label for="clientBillingAddress">Client Billing
													Address<span style="color: red"> * </span>
												</label> <input type="text"
													ng-model="ctrl.clientDetail.clientBillingAddress"
													name="clientBillingAddress"
													class="clientBillingAddress form-control input-sm"
													id="clientBillingAddress"
													placeholder="Enter Client Billing Address" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="ClientDetailForm.clientBillingAddress.$touched || ClientDetailForm.clientBillingAddress.$dirty && ClientDetailForm.clientBillingAddress.$invalid">
													<span
													ng-show="ClientDetailForm.clientBillingAddress.$touched && ClientDetailForm.clientBillingAddress.$error.required">Client
														Address is required.</span>
												</span>

											</div>
											<!--Industry Type Input-->
											<div class="form-group">
												<label for="industryId">Industry<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.clientDetail.industryType.industryId"
													name="industryId" class="industryId form-control input-sm"
													required
													ng-options="u.industryId as u.industryName for u in ctrl.industryTypes">
													<option value="" selected disabled
														class="industryÌd form-control input-sm">Select
														Industry Type</option>
												</select> <span style="color: red"
													ng-show="ClientDetailForm.industryId.$touched || ClientDetailForm.industryId.$dirty && ClientDetailForm.industryId.$invalid">
													<span
													ng-show="ClientDetailForm.industryId.$touched && ClientDetailForm.industryId.$error.required">Industry
														type is required.</span>
												</span>
											</div>
											<!--Client Revenue Input-->
											<div class="form-group">
												<label>Client Revenue</label> <input type="text"
													ng-model="ctrl.clientDetail.clientRevenue"
													name="clientRevenue"
													class="clientRevenue form-control input-sm"
													id="clientRevenue" placeholder="Enter Client Revenue" />
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Client POC Input-->
											<div class="form-group">
												<label for="clientPocName">POC Name<span
													style="color: red"> * </span></label> <input type="text"
													ng-model="ctrl.clientDetail.clientPocName"
													name="clientPocName"
													class="clientPocName form-control input-sm"
													id="clientPocName" placeholder="Enter Client Poc Name"
													required ng-minlength="3" /> <span style="color: red"
													ng-show="ClientDetailForm.clientPocName.$touched || ClientDetailForm.clientPocName.$dirty && ClientDetailForm.clientPocName.$invalid">
													<span
													ng-show="ClientDetailForm.clientPocName.$touched && ClientDetailForm.clientPocName.$error.required">Client
														POC Name is required.</span>
												</span>
											</div>
											<!--Engagment start date Input-->
											<div class="form-group">
												<label>Engagement Start Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.clientDetail.engagementStartDate"
													name="engagementStartDate"
													class="engagementStartDate form-control input-sm"
													id="engagementStartDate"
													placeholder="Enter Engagement Start Date" required /> <span
													style="color: red"
													ng-show="ClientDetailForm.engagementStartDate.$touched || ClientDetailForm.engagementStartDate.$dirty && ClientDetailForm.engagementStartDate.$invalid">
													<span
													ng-show="ClientDetailForm.engagementStartDate.$touched && ClientDetailForm.engagementStartDate.$error.required">Client
														Engagement Start Date is required.</span>
												</span>
											</div>
											<!--Engagment Type Input-->
											<div class="form-group">
												<label for="engagementType">Engagement Type<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.clientDetail.engagementType"
													name="engagementType"
													class="engagementType form-control input-sm" required>
													<option value="" selected disabled
														class="engagementType form-control input-sm">Select
														Engagement Type</option>
													<option ng-repeat="u in ctrl.engagementTypes"
														value="{{u.code}}"
														ng-selected="{{ u.code == ctrl.clientDetail.engagementType}}">
														{{u.type}}</option>
												</select><span style="color: red"
													ng-show="ClientDetailForm.engagementType.$touched || ClientDetailForm.engagementType.$dirty && ClientDetailForm.engagementType.$invalid">
													<span
													ng-show="ClientDetailForm.engagementType.$touched && ClientDetailForm.engagementType.$error.required">Client
														Engagement Type is required.</span>
												</span>
											</div>
											<!--Current status Input-->
											<div class="form-group">
												<label for="currentStatus">Current Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.clientDetail.currentStatus"
													name="currentStatus"
													class="form-control form-control input-sm" required>
													<option value="" selected disabled>Select Status
														Type</option>
													<option ng-repeat="u in ctrl.currentStatuses"
														value="{{u.code}}"
														ng-selected="{{ u.code == ctrl.clientDetail.currentStatus}}">
														{{u.type}}</option>
												</select><span style="color: red"
													ng-show="ClientDetailForm.currentStatus.$touched || ClientDetailForm.currentStatus.$dirty && ClientDetailForm.currentStatus.$invalid">
													<span
													ng-show="ClientDetailForm.currentStatus.$touched && ClientDetailForm.currentStatus.$error.required">Client
														Current Status is required.</span>
												</span>
											</div>
											<!--Status change Input-->
											<div class="form-group">
												<label>Status Change Date</label> <input type="date"
													ng-model="ctrl.clientDetail.statusChangeDate"
													name="statusChangeDate"
													class="statusChangeDate form-control input-sm"
													id="statusChangeDate"
													placeholder="Enter Status Change Date" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.clientDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="ClientDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="ClientDetailForm.$pristine">Reset
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

										<!--Client ID View-->
										<div class="form-group">
											<label for="clientId">Client ID : </label> <span
												class="input-sm" ng-bind="ctrl.clientDetail.id"></span>
										</div>
										<!--Client Name View-->
										<div class="form-group">
											<label for="clientName">Client Name : </label> <span
												class="input-sm" ng-bind="ctrl.clientDetail.clientName"></span>
										</div>
										<!--Client Description View-->
										<div class="form-group">
											<label for="clientDesc">Client Description :</label> <span
												class="input-sm" ng-bind="ctrl.clientDetail.clientDesc"></span>
										</div>
										<!--Client Address View-->
										<div class="form-group">
											<label for="clientAddress">Client Address :</label> <span
												class="input-sm" ng-bind="ctrl.clientDetail.clientAddress"></span>
										</div>
										<!--Client Billing Address-->
										<div class="form-group">
											<label for="clientBillingAddress">Client Billing
												Address :</label> <span class="input-sm"
												ng-bind="ctrl.clientDetail.clientBillingAddress"></span>
										</div>
										<!--Industry Type View-->
										<div class="form-group">
											<label for="Industry">Industry :</label> <span
												class="input-sm"
												ng-bind="ctrl.getIndustryName(ctrl.clientDetail.industryType.industryId)"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Client Revenue View-->
										<div class="form-group">
											<label>Client Revenue :</label> <span class="input-sm"
												ng-bind="ctrl.clientDetail.clientRevenue"></span>
										</div>
										<!--Client POC View-->
										<div class="form-group">
											<label for="clientPocName">POC Name :</label> <span
												class="input-sm" ng-bind="ctrl.clientDetail.clientPocName"></span>
										</div>
										<!--Engagment start date View-->
										<div class="form-group">
											<label>Engagement Start Date :</label> <span class="input-sm"
												ng-bind="ctrl.clientDetail.engagementStartDate"></span>
										</div>
										<!--Engagment Type View-->
										<div class="form-group">
											<label for="engagementType">Engagement Type :</label> <span
												class="input-sm"
												ng-bind="ctrl.getEngagementTypeName(ctrl.clientDetail.engagementType)"></span>
										</div>
										<!--Current status View-->
										<div class="form-group">
											<label for="currentStatus">Current Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getStatusType(ctrl.clientDetail.currentStatus)"></span>
										</div>
										<!--Status change View-->
										<div class="form-group">
											<label>Status Change Date</label> <span class="input-sm"
												ng-bind="ctrl.clientDetail.statusChangeDate"></span>
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

												<th><label for="clientId">ID</label></th>
											</div>
											<div class="form-group">

												<th><label for="clientName">Client Name</label></th>
											</div>
											<div class="form-group">

												<th><label for="clientAddress">Address</label></th>
											</div>
											<div class="form-group">

												<th><label for="clientPocName">POC Name</label></th>
											</div>

											<div class="form-group">

												<th><label for="engagementStartDate">Start Date</label></th>
											</div>

											<div class="form-group">
												<th><label for="engagementType">Type</label></th>
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
											<tr ng-repeat="u in ctrl.clientDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)">
														<span ng-bind="u.clientName" class="input-sm"></span>
												</a></td>
												<td><span ng-bind="u.clientAddress" class="input-sm"></span></td>
												<td><span ng-bind="u.clientPocName" class="input-sm"></span></td>
												<td><span ng-bind="u.engagementStartDate"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getEngagementTypeName(u.engagementType)"
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
		src="<c:url value="/resources/js/controller/clientdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/clientdetail_service.js" />"></script>
</body>
</html>

<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Project Invoicing Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="ProjectInvoicingController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Project Invoicing Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Invoice</button>
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
									<form ng-submit="ctrl.submit()" name="ProjectInvoicingForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Project Id Hidden-->
											<input type="hidden" ng-model="ctrl.projectInvoicing.id" />
											<!--Project Name Input-->
											<div class="form-group">
												<label for="invoiceNumber">Invoice Number<span
													style="color: red"> * </span></label> <input type="text"
													name="invoiceNumber"
													ng-model="ctrl.projectInvoicing.invoiceNumber"
													id="invoiceNumber"
													class="invoiceNumber form-control input-sm"
													placeholder="Enter Invoice Number" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="ProjectInvoicingForm.invoiceNumber.$touched || ProjectInvoicingForm.invoiceNumber.$dirty && ProjectInvoicingForm.invoiceNumber.$invalid ">
													<span
													ng-show="ProjectInvoicingForm.invoiceNumber.$touched && ProjectInvoicingForm.invoiceNumber.$error.required">Invoice
														number is required.</span>
												</span>
											</div>
											<!--Client Dropdown-->
											<div class="form-group">
												<label for="clientId">Client<span style="color: red">
														* </span></label> <select
													ng-model="ctrl.projectInvoicing.clientDetail.id"
													name="clientId" class="clientId form-control input-sm"
													ng-change="ctrl.fetchAllOrderedProjectDetailsByClient(ctrl.projectInvoicing.clientDetail.id)"
													required
													ng-options="u.id as u.clientName for u in ctrl.clientDetails">
													<option value="" selected disabled
														class="clientId form-control input-sm">Select
														Client</option>
												</select> <span style="color: red"
													ng-show="ProjectInvoicingForm.clientId.$touched || ProjectInvoicingForm.clientId.$dirty && ProjectInvoicingForm.clientId.$invalid">
													<span
													ng-show="ProjectInvoicingForm.clientId.$touched && ProjectInvoicingForm.clientId.$error.required">Client
														is required.</span>
												</span>
											</div>
											<!--Project Dropdown-->
											<div class="form-group">
												<label for="projectId">Project<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectInvoicing.projectDetail.id"
													name="projectId" class="projectId form-control input-sm"
													required
													ng-options="u.id as u.projectName for u in ctrl.projectDetailsByClients">
													<option value="" selected disabled
														class="projectId form-control input-sm">Select
														Project</option>
												</select> <span style="color: red"
													ng-show="ProjectInvoicingForm.projectId.$touched || ProjectInvoicingForm.projectId.$dirty && ProjectInvoicingForm.projectId.$invalid">
													<span
													ng-show="ProjectInvoicingForm.projectId.$touched && ProjectInvoicingForm.projectId.$error.required">Project
														is required.</span>
												</span>
											</div>
											<!--Project Billing From date Input-->
											<div class="form-group">
												<label>Billing From Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectInvoicing.billingFromDate"
													name="billingFromDate"
													class="billingFromDate form-control input-sm"
													id="billingFromDate" placeholder="Enter Billing From Date"
													required /> <span style="color: red"
													ng-show="ProjectInvoicingForm.billingFromDate.$touched || ProjectInvoicingForm.billingFromDate.$dirty && ProjectInvoicingForm.billingFromDate.$invalid">
													<span
													ng-show="ProjectInvoicingForm.billingFromDate.$touched && ProjectInvoicingForm.billingFromDate.$error.required">Billing
														From Date is required.</span>
												</span>
											</div>
											<!--Project Billing To date Input-->
											<div class="form-group">
												<label>Billing To Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectInvoicing.billingToDate"
													name="billingToDate"
													class="billingToDate form-control input-sm"
													id="billingToDate" placeholder="Enter Billing To Date"
													required /> <span style="color: red"
													ng-show="ProjectInvoicingForm.billingToDate.$touched || ProjectInvoicingForm.billingToDate.$dirty && ProjectInvoicingForm.billingToDate.$invalid">
													<span
													ng-show="ProjectInvoicingForm.billingToDate.$touched && ProjectInvoicingForm.billingToDate.$error.required">Billing
														To Date is required.</span>
												</span>
											</div>
											<!--Invoice Amount Input-->
											<div class="form-group">
												<label for="amount">Invoice Amount<span
													style="color: red"> * </span></label> <input type="text"
													name="amount" ng-model="ctrl.projectInvoicing.amount"
													id="amount" class="amount form-control input-sm"
													placeholder="Enter Invoice Amount" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="ProjectInvoicingForm.amount.$touched || ProjectInvoicingForm.amount.$dirty &&	ProjectInvoicingForm.amount.$invalid ">
													<span
													ng-show="ProjectInvoicingForm.amount.$touched && ProjectInvoicingForm.amount.$error.required">Invoice
														Amount is required.</span>
												</span>
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Invoice Raised date Input-->
											<div class="form-group">
												<label>Invoice Raised Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectInvoicing.raisedDate"
													name="raisedDate" class="raisedDate form-control input-sm"
													id="raisedDate" placeholder="Enter Invoice Raised Date"
													required /> <span style="color: red"
													ng-show="ProjectInvoicingForm.raisedDate.$touched || ProjectInvoicingForm.raisedDate.$dirty && ProjectInvoicingForm.raisedDate.$invalid">
													<span
													ng-show="ProjectInvoicingForm.raisedDate.$touched && ProjectInvoicingForm.raisedDate.$error.required">Invoice
														Raised Date is required.</span>
												</span>
											</div>
											<!--Invoice Due date Input-->
											<div class="form-group">
												<label>Invoice Due Date<span style="color: red">
														* </span></label> <input type="date"
													ng-model="ctrl.projectInvoicing.dueDate" name="dueDate"
													class="dueDate form-control input-sm" id="dueDate"
													placeholder="Enter Invoice Due Date" required /> <span
													style="color: red"
													ng-show="ProjectInvoicingForm.dueDate.$touched || ProjectInvoicingForm.dueDate.$dirty && ProjectInvoicingForm.dueDate.$invalid">
													<span
													ng-show="ProjectInvoicingForm.dueDate.$touched && ProjectInvoicingForm.dueDate.$error.required">Invoice
														Due Date is required.</span>
												</span>
											</div>
											<!--PO Balance Input-->
											<div class="form-group">
												<label for="poNumber">PO Balance<span
													style="color: red"> * </span></label> <input type="text"
													name="poBalance" ng-model="ctrl.projectInvoicing.poBalance"
													id="poBalance" class="poBalance form-control input-sm"
													placeholder="Enter PO Balance" required ng-minlength="3" />
												<span style="color: red"
													ng-show="ProjectInvoicingForm.poBalance.$touched || ProjectInvoicingForm.poBalance.$dirty &&	ProjectInvoicingForm.poBalance.$invalid ">
													<span
													ng-show="ProjectInvoicingForm.poBalance.$touched && ProjectInvoicingForm.poBalance.$error.required">PO
														Balance is required.</span>
												</span>
											</div>
											<!--Current status Drodown-->
											<div class="form-group">
												<label for="currentStatus">Current Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.projectInvoicing.currentStatus"
													name="currentStatus"
													class="form-control form-control input-sm" required>
													<option value="" selected disabled>Select Status
														Type</option>
													<option ng-repeat="u in ctrl.currentStatuses"
														value="{{u.code}}"
														ng-selected="{{ u.code == ctrl.projectInvoicing.currentStatus}}">
														{{u.type}}</option>
												</select><span style="color: red"
													ng-show="ProjectInvoicingForm.currentStatus.$touched || ProjectInvoicingForm.currentStatus.$dirty && ProjectInvoicingForm.currentStatus.$invalid">
													<span
													ng-show="ProjectInvoicingForm.currentStatus.$touched && ProjectInvoicingForm.currentStatus.$error.required">Project
														Current Status is required.</span>
												</span>
											</div>
											<!--Status change Date-->
											<div class="form-group">
												<label>Status Change Date</label> <input type="date"
													ng-model="ctrl.projectInvoicing.statusChangeDate"
													name="statusChangeDate"
													class="statusChangeDate form-control input-sm"
													id="statusChangeDate"
													placeholder="Enter Status Change Date" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.projectInvoicing.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="ProjectInvoicingForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="ProjectInvoicingForm.$pristine">Reset
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

										<!--Invoice ID View-->
										<div class="form-group">
											<label>Invoice ID : </label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.id"></span>
										</div>
										<!--Invoice Number View-->
										<div class="form-group">
											<label>Invoice Number : </label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.invoiceNumber"></span>
										</div>
										<!--Client Name View-->
										<div class="form-group">
											<label>Client :</label> <span class="input-sm"
												ng-bind="ctrl.getClientName(ctrl.projectInvoicing.clientDetail.id)"></span>
										</div>
										<!--Project Name View-->
										<div class="form-group">
											<label>Project :</label> <span class="input-sm"
												ng-bind="ctrl.getProjectName(ctrl.projectInvoicing.projectDetail.id)"></span>
										</div>
										<!--Billing From Date View-->
										<div class="form-group">
											<label>Billing From Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.billingFromDate"></span>
										</div>
										<!--Billing To Date View-->
										<div class="form-group">
											<label>Billing To Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.billingToDate"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Invoice Amount View-->
										<div class="form-group">
											<label>Invoice Amount :</label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.amount"></span>
										</div>
										<!--Invoice Raised Date View-->
										<div class="form-group">
											<label>Invoice Raised Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.raisedDate"></span>
										</div>
										<!--Invoice Due Date View-->
										<div class="form-group">
											<label>Invoice Due Date :</label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.dueDate"></span>
										</div>
										<!--PO Balance View-->
										<div class="form-group">
											<label>PO Balance :</label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.poBalance"></span>
										</div>
										<!--Current status View-->
										<div class="form-group">
											<label>Current Status :</label> <span class="input-sm"
												ng-bind="ctrl.getStatusType(ctrl.projectInvoicing.currentStatus)"></span>
										</div>
										<!--Status change View-->
										<div class="form-group">
											<label>Status Change Date</label> <span class="input-sm"
												ng-bind="ctrl.projectInvoicing.statusChangeDate"></span>
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

												<th><label>ID</label></th>
											</div>

											<div class="form-group">

												<th><label>Number</label></th>
											</div>

											<div class="form-group">

												<th><label>Client</label></th>
											</div>

											<div class="form-group">
												<th><label>Project</label></th>
											</div>

											<div class="form-group">

												<th><label">From Date</label></th>
											</div>

											<div class="form-group">

												<th><label>To Date</label></th>
											</div>

											<div class="form-group">

												<th><label>Amount</label></th>
											</div>

											<div class="form-group">

												<th><label>Due Date</label></th>
											</div>

											<div class="form-group">

												<th><label>Current Status</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.projectInvoicings">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="u.invoiceNumber" class="input-sm"></a></span></td>
												<td><span
													ng-bind="ctrl.getClientName(u.clientDetail.id)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getProjectName(u.projectDetail.id)"
													class="input-sm"></span></td>
												<td><span ng-bind="u.billingFromDate" class="input-sm"></span></td>
												<td><span ng-bind="u.billingToDate" class="input-sm"></span></td>
												<td><span ng-bind="u.amount" class="input-sm"></span></td>
												<td><span ng-bind="u.dueDate" class="input-sm"></span></td>
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
		src="<c:url value="/resources/js/controller/projectinvoicing_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/projectinvoicing_service.js" />"></script>
</body>
</html>

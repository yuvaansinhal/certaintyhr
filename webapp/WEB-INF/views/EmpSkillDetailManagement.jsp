<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Employee Skill Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="EmpSkillDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Employee Skill Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Skill</button>
						</div>
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
									<form ng-submit="ctrl.submit()" name="EmpSkillDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--User Id Hidden-->
											<input type="hidden" ng-model="ctrl.empSkillDetail.id" />
											<!--EmpDetail Dropdown-->
											<div class="form-group">
												<label for="empDetail">Employee Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empSkillDetail.empDetail.id"
													name="empDetail" class="empDetail form-control input-sm"
													required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														Employee</option>
												</select> <span style="color: red"
													ng-show="EmpSkillDetailForm.empDetail.$touched || EmpSkillDetailForm.empDetail.$dirty && EmpSkillDetailForm.empDetail.$invalid">
													<span
													ng-show="EmpSkillDetailForm.empDetail.$touched && EmpSkillDetailFormForm.empDetail.$error.required">Employee
														Name is required.</span>
												</span>
											</div>
											<!--Skill Type Dropdown-->
											<div class="form-group">
												<label for="skillType">Skill Type<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empSkillDetail.skillType.skillTypeId"
													name="skillType" class="skillType form-control input-sm"
													required
													ng-options="u.skillTypeId as u.skillTypeName for u in ctrl.skillTypes">
													<option value="" selected disabled
														class="skillType form-control input-sm">Select
														Skill Type</option>
												</select> <span style="color: red"
													ng-show="EmpSkillDetailForm.skillType.$touched || EmpSkillDetailForm.skillType.$dirty && EmpSkillDetailForm.skillType.$invalid">
													<span
													ng-show="EmpSkillDetailForm.skillType.$touched && EmpSkillDetailFormForm.skillType.$error.required">Skill
														Type is required.</span>
												</span>
											</div>
											<!--Emp Skill Description Input-->
											<div class="form-group">
												<label for="empSkillDetailDesc">Description</label> <input
													type="text" name="empSkillDetailDesc"
													ng-model="ctrl.empSkillDetail.empSkillDetailDesc"
													id="empSkillDetailDesc"
													class="empSkillDetailDesc form-control input-sm"
													placeholder="Enter Description" />
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Experience Input-->
											<div class="form-group">
												<label for="experience">Experience (in Months)<span
													style="color: red"> * </span></label> <input type="text"
													name="experience" ng-model="ctrl.empSkillDetail.experience"
													id="experience" class="experience form-control input-sm"
													placeholder="Enter Experience" required ng-minlength="1" />
												<span style="color: red"
													ng-show="EmpSkillDetailForm.experience.$touched || EmpSkillDetailForm.experience.$dirty && EmpSkillDetailForm.experience.$invalid">
													<span
													ng-show="EmpSkillDetailForm.experience.$touched && EmpSkillDetailFormForm.experience.$error.required">Experience
														is required.</span>
												</span>
											</div>
											<!--Primary Sill Flag Dropdown-->
											<div class="form-group">
												<label for="primaryFlag">Primary Skill<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empSkillDetail.primaryFlag"
													name="primaryFlag"
													class="primaryFlag form-control input-sm" required
													ng-options="u.code as u.type for u in ctrl.primaryFlags">
													<option value="" selected disabled
														class="primaryFlag form-control input-sm">Select
														Flag</option>
												</select> <span style="color: red"
													ng-show="EmpSkillDetailForm.primaryFlag.$touched || EmpSkillDetailForm.primaryFlag.$dirty && EmpSkillDetailForm.primaryFlag.$invalid">
													<span
													ng-show="EmpSkillDetailForm.primaryFlag.$touched && EmpSkillDetailForm.primaryFlag.$error.required">Primary
														Flag is required.</span>
												</span>
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.empSkillDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="EmpSkillDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="EmpSkillDetailForm.$pristine">Reset
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

										<!--Emp Skill ID View-->
										<div class="form-group">
											<label>ID : </label> <span class="input-sm"
												ng-bind="ctrl.empSkillDetail.id"></span>
										</div>
										<!--EmpDetail View-->
										<div class="form-group">
											<label>Employee Name : </label> <span class="input-sm"
												ng-bind="ctrl.getEmployeeName(ctrl.empSkillDetail.empDetail.id)"></span>
										</div>
										<!--Skill Type View-->
										<div class="form-group">
											<label>Skill Type : </label> <span class="input-sm"
												ng-bind="ctrl.getSkillTypeName(ctrl.empSkillDetail.skillType.skillTypeId)"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Emp Skill Descripttion View-->
										<div class="form-group">
											<label>Description : </label> <span class="input-sm"
												ng-bind="ctrl.empSkillDetail.empSkillDetailDesc"></span>
										</div>
										<!--Experience View-->
										<div class="form-group">
											<label>Experience (in Months) :</label> <span
												class="input-sm" ng-bind="ctrl.empSkillDetail.experience"></span>
										</div>
										<!--Primary Skill Flag View-->
										<div class="form-group">
											<label>Primary Skill :</label> <span class="input-sm"
												ng-bind="ctrl.getPrimaryFlagType(ctrl.empSkillDetail.primaryFlag)"></span>
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

												<th><label>Employee</label></th>
											</div>

											<div class="form-group">

												<th><label>Skill Type</label></th>
											</div>

											<div class="form-group">

												<th><label>Experience</label></th>
											</div>


											<div class="form-group">

												<th><label>Primary Skill</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.empSkillDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="ctrl.getEmployeeName(u.empDetail.id)"
														class="input-sm"></a></span></td>
												<td><span
													ng-bind="ctrl.getSkillTypeName(u.skillType.skillTypeId)"
													class="input-sm"></span></td>
												<td><span ng-bind="u.experience" class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getPrimaryFlagType(u.primaryFlag)"
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
		src="<c:url value="/resources/js/controller/empskilldetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/empskilldetail_service.js" />"></script>
</body>
</html>

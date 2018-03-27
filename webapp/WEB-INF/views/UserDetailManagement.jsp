<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - User Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="UserDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>User Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								User</button>
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
									<form ng-submit="ctrl.submit()" name="UserDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--User Id Hidden-->
											<input type="hidden" ng-model="ctrl.userDetail.id" />
											<!--UserId Input-->
											<div class="form-group">
												<label for="userId">User ID<span style="color: red">
														* </span></label> <input type="text" name="userId"
													ng-model="ctrl.userDetail.userId" id="userId"
													class="userId form-control input-sm"
													placeholder="Enter User ID" required ng-minlength="3" /> <span
													style="color: red"
													ng-show="UserDetailForm.userId.$touched || UserDetailForm.userId.$dirty &&	UserDetailForm.userId.$invalid ">
													<span
													ng-show="UserDetailForm.userId.$touched && UserDetailForm.userId.$error.required">User
														ID is required.</span>
												</span>
											</div>
											<!--Password Input-->
											<div class="form-group">
												<label for="pwd">Password<span style="color: red">
														* </span></label> <input type="password" name="pwd"
													ng-model="ctrl.userDetail.pwd" id="pwd"
													class="pwd form-control input-sm"
													placeholder="Enter Password" required ng-minlength="3" />
												<span style="color: red"
													ng-show="UserDetailForm.pwd.$touched || UserDetailForm.pwd.$dirty &&	UserDetailForm.pwd.$invalid ">
													<span
													ng-show="UserDetailForm.pwd.$touched && UserDetailForm.pwd.$error.required">Password
														is required.</span>
												</span>
											</div>
											<!--EmpDetail Dropdown-->
											<div class="form-group">
												<label for="empDetail">User Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.userDetail.empDetail.id" name="empDetail"
													class="empDetail form-control input-sm" required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														User</option>
												</select> <span style="color: red"
													ng-show="UserDetailForm.empDetail.$touched || UserDetailForm.empDetail.$dirty && UserDetailForm.empDetail.$invalid">
													<span
													ng-show="UserDetailForm.empDetail.$touched && UserDetailForm.empDetail.$error.required">User
														Name is required.</span>
												</span>
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--User Role Dropdown-->
											<div class="form-group">
												<label for="userRoleId">User Role<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.userDetail.userRole.userRoleId"
													name="userRoleId" class="userRoleId form-control input-sm"
													required
													ng-options="u.userRoleId as u.userRoleName for u in ctrl.userRoles">
													<option value="" selected disabled
														class="userRoleId form-control input-sm">Select
														User Role</option>
												</select> <span style="color: red"
													ng-show="UserDetailForm.userRoleId.$touched || UserDetailForm.userRoleId.$dirty && UserDetailForm.userRoleId.$invalid">
													<span
													ng-show="UserDetailForm.userRoleId.$touched && UserDetailForm.userRoleId.$error.required">User Role
													 is required.</span>
												</span>
											</div>
											<!--User Status Name Drodown-->
											<div class="form-group">
												<label for="userDetailStatusName">User Status<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.userDetail.userDetailStatusName"
													name="userDetailStatusName"
													class="form-control form-control input-sm" required>
													<option value="" selected disabled>Select User
														Status Type</option>
													<option ng-repeat="u in ctrl.userDetailStatusNames"
														value="{{u.code}}"
														ng-selected="{{ u.code == ctrl.userDetail.userDetailStatusName}}">
														{{u.type}}</option>
												</select><span style="color: red"
													ng-show="UserDetailForm.userDetailStatusName.$touched || UserDetailForm.userDetailStatusName.$dirty && UserDetailForm.userDetailStatusName.$invalid">
													<span
													ng-show="UserDetailForm.userDetailStatusName.$touched && UserDetailForm.userDetailStatusName.$error.required">User
														Status is required.</span>
												</span>
											</div>
											<!--Status Change Date-->
											<div class="form-group">
												<label>Status Change Date</label> <input type="date"
													ng-model="ctrl.userDetail.statusChangeDate"
													name="statusChangeDate"
													class="statusChangeDate form-control input-sm"
													id="statusChangeDate"
													placeholder="Enter Status Change Date" />
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.userDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="UserDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="UserDetailForm.$pristine">Reset Form</button>
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

										<!--User ID View-->
										<div class="form-group">
											<label>ID : </label> <span class="input-sm"
												ng-bind="ctrl.userDetail.id"></span>
										</div>
										<!--UserId View-->
										<div class="form-group">
											<label for="userId">User ID : </label> <span class="input-sm"
												ng-bind="ctrl.userDetail.userId"></span>
										</div>
										<!--EmpDetail View-->
										<div class="form-group">
											<label for="firstName">User Name : </label> <span
												class="input-sm"
												ng-bind="ctrl.getUserName(ctrl.userDetail.empDetail.id)"></span>
										</div>
									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--User Role View-->
										<div class="form-group">
											<label for="userRole">User Role :</label> <span
												class="input-sm"
												ng-bind="ctrl.getUserRoleName(ctrl.userDetail.userRole.userRoleId)"></span>
										</div>
										<!--User Detail Status View-->
										<div class="form-group">
											<label for="userDetailStatusName">User Status :</label> <span
												class="input-sm"
												ng-bind="ctrl.getUserDetailStatusName(ctrl.userDetail.userDetailStatusName)"></span>
										</div>
										<!--Status change View-->
										<div class="form-group">
											<label>Status Change Date</label> <span class="input-sm"
												ng-bind="ctrl.userDetail.statusChangeDate"></span>
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

												<th><label for="userId">ID</label></th>
											</div>
											<div class="form-group">

												<th><label for="userId">User ID</label></th>
											</div>

											<div class="form-group">

												<th><label for="empDetail">User Name</label></th>
											</div>

											<div class="form-group">

												<th><label for="userRole">User Role</label></th>
											</div>


											<div class="form-group">

												<th><label for="userDetailStatusName">User
														Status</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.userDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="u.userId" class="input-sm"></a></span></td>
												<td><span ng-bind="ctrl.getUserName(u.empDetail.id)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getUserRoleName(u.userRole.userRoleId)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getUserDetailStatusName(u.userDetailStatusName)"
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
		src="<c:url value="/resources/js/controller/userdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/userdetail_service.js" />"></script>
</body>
</html>

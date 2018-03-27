<%@ include file="/WEB-INF/views/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- For providng view setting according to device coordinate -->
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Certainty HR - Employee Education Management</title>
<%@ include file="/WEB-INF/views/header.jsp"%>
</head>

<!-- Body of code start-->

<body ng-app="hr" class="ng-cloak">
	<div id="wrapper" class="generic-container"
		ng-controller="EmpEducationDetailController as ctrl">
		<!-- NAV TOP  -->
		<%@ include file="/WEB-INF/views/topnav.jsp"%>
		<!-- NAV SIDE  -->
		<%@ include file="/WEB-INF/views/leftnav.jsp"%>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-6">
							<h2>Education Detail Management</h2>
							<button align="right" type="button"
								ng-click="ctrl.hideAddEditDiv()" class="btn btn-warning btn-sm">Add
								Education Detail</button>
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
									<form ng-submit="ctrl.submit()" name="EmpEducationDetailForm">
										<!-- First half form start -->
										<div class="col-md-6">
											<!--Emp Education Detail Id Hidden-->
											<input type="hidden" ng-model="ctrl.empEducationDetail.id" />
											<!--EmpDetail Dropdown-->
											<div class="form-group">
												<label for="empDetail">Employee Name<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empEducationDetail.empDetail.id"
													name="empDetail" class="empDetail form-control input-sm"
													required
													ng-options="u.id as u.firstName+' '+u.lastName for u in ctrl.empDetails">
													<option value="" selected disabled
														class="empDetail form-control input-sm">Select
														Employee</option>
												</select> <span style="color: red"
													ng-show="EmpEducationDetailForm.empDetail.$touched || EmpEducationDetailForm.empDetail.$dirty && EmpEducationDetailForm.empDetail.$invalid">
													<span
													ng-show="EmpEducationDetailForm.empDetail.$touched && EmpEducationDetailForm.empDetail.$error.required">Employee
														Name is required.</span>
												</span>
											</div>
											<!--Education Course Dropdown-->
											<div class="form-group">
												<label for="courseId">Education Course<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empEducationDetail.educationCourse.courseId"
													name="courseId" class="courseId form-control input-sm"
													required
													ng-options="u.courseId as u.courseName for u in ctrl.educationCourses">
													<option value="" selected disabled
														class="courseId form-control input-sm">Select
														Education Course</option>
												</select> <span style="color: red"
													ng-show="EmpEducationDetailForm.courseId.$touched || EmpEducationDetailForm.courseId.$dirty && EmpEducationDetailForm.courseId.$invalid">
													<span
													ng-show="EmpEducationDetailForm.courseId.$touched && EmpEducationDetailForm.courseId.$error.required">Education
														Course is required.</span>
												</span>
											</div>
											<!--Specialization Stream Dropdown-->
											<div class="form-group">
												<label for="streamId">Specialization Stream<span
													style="color: red"> * </span>
												</label> <select
													ng-model="ctrl.empEducationDetail.specializationStream.streamId"
													name="streamId" class="streamId form-control input-sm"
													required
													ng-options="u.streamId as u.streamName for u in ctrl.specializationStreams">
													<option value="" selected disabled
														class="streamId form-control input-sm">Select
														Specialization Stream</option>
												</select> <span style="color: red"
													ng-show="EmpEducationDetailForm.streamId.$touched || EmpEducationDetailForm.streamId.$dirty && EmpEducationDetailForm.streamId.$invalid">
													<span
													ng-show="EmpEducationDetailForm.streamId.$touched && EmpEducationDetailForm.streamId.$error.required">Specialization
														Stream is required.</span>
												</span>
											</div>
											<!--Course From  Date -->
											<div class="form-group">
												<label for="courseFromDate">Course From Date <span
													style="color: red"> * </span>
												</label> <input type="date" name="courseFromDate"
													ng-model="ctrl.empEducationDetail.courseFromDate"
													id="courseFromDate"
													class="courseFromDate form-control input-sm"
													placeholder="Enter Course From Date" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpEducationDetailForm.courseFromDate.$touched || EmpEducationDetailForm.courseFromDate.$dirty &&	EmpEducationDetailForm.courseFromDate.$invalid ">
													<span
													ng-show="EmpEducationDetailForm.courseFromDate.$touched && EmpEducationDetailForm.courseFromDate.$error.required">Course
														From Date is required.</span>
												</span>
											</div>
											<!--Course To Date-->
											<div class="form-group">
												<label>Course To Date</label> <input type="date"
													ng-model="ctrl.empEducationDetail.courseToDate"
													name="courseToDate"
													class="courseToDate form-control input-sm"
													id="courseToDate" placeholder="Enter Course To Date" />
											</div>
										</div>
										<!-- second half of form start  -->
										<div class="col-md-6">
											<!--Level Of Courses Drodown-->
											<div class="form-group">
												<label for="levelOfCourse">Level Of Course<span
													style="color: red"> * </span></label> <select
													ng-model="ctrl.empEducationDetail.levelOfCourse"
													name="levelOfCourse"
													class="form-control form-control input-sm" required>
													<option value="" selected disabled>Select Level of
														Course</option>
													<option ng-repeat="u in ctrl.levelOfCourses"
														value="{{u.code}}"
														ng-selected="{{ u.code == ctrl.empEducationDetail.levelOfCourse}}">
														{{u.type}}</option>
												</select><span style="color: red"
													ng-show="EmpEducationDetailForm.levelOfCourse.$touched || EmpEducationDetailForm.levelOfCourse.$dirty && EmpEducationDetailForm.levelOfCourse.$invalid">
													<span
													ng-show="EmpEducationDetailForm.levelOfCourse.$touched && EmpEducationDetailForm.levelOfCourse.$error.required">Level
														of Course is required.</span>
												</span>
											</div>
											<!--University Name Input-->
											<div class="form-group">
												<label for="universityName">University Name<span
													style="color: red"> * </span>
												</label> <input type="text" name="universityName"
													ng-model="ctrl.empEducationDetail.universityName"
													id="universityName"
													class="universityName form-control input-sm"
													placeholder="Enter University Name" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpEducationDetailForm.universityName.$touched || EmpEducationDetailForm.universityName.$dirty &&	EmpEducationDetailForm.universityName.$invalid ">
													<span
													ng-show="EmpEducationDetailForm.universityName.$touched && EmpEducationDetailForm.universityName.$error.required">University
														Name is required.</span>
												</span>
											</div>
											<!--Institute Name Input-->
											<div class="form-group">
												<label for="instituteName">Institute Name<span
													style="color: red"> * </span></label> <input type="text"
													name="instituteName"
													ng-model="ctrl.empEducationDetail.instituteName"
													id="instituteName"
													class="instituteName form-control input-sm"
													placeholder="Enter Institute Name" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpEducationDetailForm.instituteName.$touched || EmpEducationDetailForm.instituteName.$dirty &&	EmpEducationDetailForm.instituteName.$invalid ">
													<span
													ng-show="EmpEducationDetailForm.instituteName.$touched && EmpEducationDetailForm.instituteName.$error.required">Institute
														Name is required.</span>
												</span>
											</div>
											<!-- Year Of Passing Input-->
											<div class="form-group">
												<label for="yearOfPassing">Year Of Passing<span
													style="color: red"> * </span></label> <input type="text"
													name="yearOfPassing"
													ng-model="ctrl.empEducationDetail.yearOfPassing"
													id="yearOfPassing"
													class="yearOfPassing form-control input-sm"
													placeholder="Enter Year Of Passing" required
													ng-minlength="3" /> <span style="color: red"
													ng-show="EmpEducationDetailForm.yearOfPassing.$touched || EmpEducationDetailForm.yearOfPassing.$dirty &&	EmpEducationDetailForm.yearOfPassing.$invalid ">
													<span
													ng-show="EmpEducationDetailForm.yearOfPassing.$touched && EmpEducationDetailForm.yearOfPassing.$error.required">Year
														Of Passing is required.</span>
												</span>
											</div>
											<!--Percentage Input-->
											<div class="form-group">
												<label for="percentage">Percentage<span
													style="color: red"> * </span></label> <input type="text"
													name="percentage"
													ng-model="ctrl.empEducationDetail.percentage"
													id="percentage" class="percentage form-control input-sm"
													placeholder="Enter Percentage" required ng-minlength="2" />
												<span style="color: red"
													ng-show="EmpEducationDetailForm.percentage.$touched || EmpEducationDetailForm.percentage.$dirty &&	EmpEducationDetailForm.percentage.$invalid ">
													<span
													ng-show="EmpEducationDetailForm.percentage.$touched && EmpEducationDetailForm.percentage.$error.required">Percentage
														is required.</span>
												</span>
											</div>
											<!--Submit and reset button Input-->
											<div class="form-group">
												<input type="submit"
													value="{{!ctrl.empEducationDetail.id ? 'Add' : 'Update'}}"
													class="btn btn-primary btn-sm"
													ng-disabled="EmpEducationDetailForm.$invalid">
												<button type="button" ng-click="ctrl.reset()"
													class="btn btn-warning btn-sm"
													ng-disabled="EmpEducationDetailForm.$pristine">Reset
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
											<label for="empEducationDetailId">ID : </label> <span
												class="input-sm" ng-bind="ctrl.empEducationDetail.id"></span>
										</div>
										<!--EmpDetail View-->
										<div class="form-group">
											<label for="firstName">Employee Name : </label> <span
												class="input-sm"
												ng-bind="ctrl.getEmployeeName(ctrl.empEducationDetail.empDetail.id)"></span>
										</div>
										<!--Education Course View-->
										<div class="form-group">
											<label for="educationCourse">Education Course :</label> <span
												class="input-sm"
												ng-bind="ctrl.getCourseName(ctrl.empEducationDetail.educationCourse.courseId)"></span>
										</div>
										<!--Specialization Stream View-->
										<div class="form-group">
											<label for="specializationStream">Specialization
												Stream :</label> <span class="input-sm"
												ng-bind="ctrl.getStreamName(ctrl.empEducationDetail.specializationStream.streamId)"></span>
										</div>
										<!--Course From Date View-->
										<div class="form-group">
											<label>Course From Date :</label> <span class="input-sm"
												ng-bind="ctrl.empEducationDetail.courseFromDate"></span>
										</div>
										<!--Course To Date View-->
										<div class="form-group">
											<label>Course To Date :</label> <span class="input-sm"
												ng-bind="ctrl.empEducationDetail.courseToDate"></span>
										</div>

									</div>
									<!-- second half of form start  -->
									<div class="col-md-6">
										<!--Level Of Course View-->
										<div class="form-group">
											<label>Level Of Course :</label> <span class="input-sm"
												ng-bind="ctrl.getLevelOfCourse(ctrl.empEducationDetail.levelOfCourse)"></span>
										</div>
										<!-- University Name View-->
										<div class="form-group">
											<label>University Name:</label> <span class="input-sm"
												ng-bind="ctrl.empEducationDetail.universityName"></span>
										</div>
										<!-- Institute Name View-->
										<div class="form-group">
											<label>Institute Name:</label> <span class="input-sm"
												ng-bind="ctrl.empEducationDetail.instituteName"></span>
										</div>
										<!--Year Of Passing View-->
										<div class="form-group">
											<label>Year Of Passing :</label> <span class="input-sm"
												ng-bind="ctrl.empEducationDetail.yearOfPassing"></span>
										</div>
										<!--Percentage View-->
										<div class="form-group">
											<label>Percentage :</label> <span class="input-sm"
												ng-bind="ctrl.empEducationDetail.percentage"></span>
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

												<th><label for="empEducationDetailId">ID</label></th>
											</div>

											<div class="form-group">

												<th><label for="empDetail">Employee Name</label></th>
											</div>
											<div class="form-group">

												<th><label for="educationCourse">Education
														Course</label></th>
											</div>

											<div class="form-group">

												<th><label for="specializationStream">Stream</label></th>
											</div>

											<div class="form-group">

												<th><label for="universityName">University Name</label></th>
											</div>
											<div class="form-group">

												<th><label for="instituteName">Institute Name</label></th>
											</div>

											<div class="form-group">

												<th><label for="courseFromDate">Course From
														Date</label></th>
											</div>

											<div class="form-group">

												<th><label for="Actions">Actions</label></th>
											</div>
											</tr>

										</thead>

										<tbody>
											<tr ng-repeat="u in ctrl.empEducationDetails">
												<td><span ng-bind="u.id" class="input-sm"></span></td>
												<td><a ng-href="#" ng-click="ctrl.copyView(u.id)"><span
														ng-bind="ctrl.getEmployeeName(u.empDetail.id)"
														class="input-sm"></span></a></td>
												<td><span
													ng-bind="ctrl.getCourseName(u.educationCourse.courseId)"
													class="input-sm"></span></td>
												<td><span
													ng-bind="ctrl.getStreamName(u.specializationStream.streamId)"
													class="input-sm"></span></td>
												<td><span ng-bind="u.universityName" class="input-sm"></span></td>
												<td><span ng-bind="u.instituteName" class="input-sm"></span></td>
												<td><span ng-bind="u.courseFromDate" class="input-sm"></span></td>
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
		src="<c:url value="/resources/js/controller/empeducationdetail_controller.js" />"></script>
	<script
		src="<c:url value="/resources/js/service/empeducationdetail_service.js" />"></script>
</body>
</html>

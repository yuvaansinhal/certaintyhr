'use strict';

angular
		.module('hr')
		.factory(
				'EmpDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllDepartments : fetchAllDepartments,
								fetchAllDesignations : fetchAllDesignations,
								fetchAllEmpDetails : fetchAllEmpDetails,
								fetchAllEmployeeStatuses : fetchAllEmployeeStatuses,
								fetchAllGrades : fetchAllGrades,
								fetchAllLocations : fetchAllLocations,
								fetchAllSupervisors : fetchAllSupervisors,
								fetchAllOrderedDesignationsByGradeId : fetchAllOrderedDesignationsByGradeId,
								createEmpDetail : createEmpDetail,
								updateEmpDetail : updateEmpDetail,
								deleteEmpDetail : deleteEmpDetail

							};

							return factory;

							function fetchAllDepartments() {
								var deferred = $q.defer();
								console
										.log("####EmployeeService:fetchAllDepartments()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listDepartments')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmployeeService:fetchAllDepartments() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Departments');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllDesignations() {
								var deferred = $q.defer();
								console
										.log("####EmployeeService:fetchAllDesignations()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listDesignations')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmployeeService:fetchAllDesignations() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching all Designations');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedDesignationsByGradeId(
									gradeId) {
								var deferred = $q.defer();
								console
										.log("####EmployeeService:fetchAllOrderedDesignationsByGradeId()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedDesignationsByGrade/'
														+ gradeId)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmployeeService:fetchAllOrderedDesignationsByGradeId() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Orderd Designations Details by Grade');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEmployeeStatuses() {
								var deferred = $q.defer();
								console
										.log("####EmployeeService:fetchAllEmployeeStatuses()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmployeeStatus')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmployeeService:fetchAllEmployeeStatuses() response recived#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Employee Statuses');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllGrades() {
								var deferred = $q.defer();
								console
										.log("####EmployeeService:fetchAllGrades()#########");
								$http
										.get(REST_SERVICE_URI + 'listGrades')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmployeeService:fetchAllGrades() response recived#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching all Grades');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllLocations() {
								var deferred = $q.defer();
								console
										.log("####EmployeeService:fetchAllLocations()#########");
								$http
										.get(REST_SERVICE_URI + 'listLocations')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmployeeService:fetchAllLocations() response recived#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching all Locations');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllSupervisors() {
								var deferred = $q.defer();
								console
										.log("####EmployeeService:fetchAllSupervisors()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmployeeService:fetchAllSupervisors() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Supervisors');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpDetailService:fetchAllEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpDetailService:fetchAllEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createEmpDetail(empDetail) {
								console
										.log(
												"####EmpDetailService:createEmpDetail()#########",
												empDetail);
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addEmpDetail',
												empDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating Emp Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateEmpDetail(empDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateEmpDetail',
												empDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating Emp Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteEmpDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteEmpDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting Emp Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
						} ]);
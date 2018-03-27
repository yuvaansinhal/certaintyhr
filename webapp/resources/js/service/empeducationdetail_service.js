'use strict';

angular
		.module('hr')
		.factory(
				'EmpEducationDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllempEducationDetails : fetchAllempEducationDetails,
								fetchAllEmpDetails : fetchAllEmpDetails,
								fetchAllEducationCourses : fetchAllEducationCourses,
								fetchAllSpecializationStreams : fetchAllSpecializationStreams,
								createEmpEducationDetail : createEmpEducationDetail,
								updateEmpEducationDetail : updateEmpEducationDetail,
								deleteEmpEducationDetail : deleteEmpEducationDetail
							};

							return factory;

							function fetchAllempEducationDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpEducationDetailService:fetchAllEmpEducationDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpEducationDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpEducationDetailService:fetchAllEmpEducationDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpEducationDetails');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpEducationDetailService:fetchAllEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpEducationDetailService:fetchAllEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEducationCourses() {
								var deferred = $q.defer();
								console
										.log("####EmpEducationDetailService:fetchAllEducationCourses()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEducationCourses')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpEducationDetailService:fetchAllEducationCourses() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Education Courses');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllSpecializationStreams() {
								var deferred = $q.defer();
								console
										.log("####EmpEducationDetailService:fetchAllSpecializationStreams()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listSpecializationStreams')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpEducationDetailService:fetchAllSpecializationStreams() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Specialization Streamss');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createEmpEducationDetail(
									empEducationDetail) {
								console
										.log("####EmpEducationDetailService:createEmpEducationDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addEmpEducationDetail',
												empEducationDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating EmpEducation Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateEmpEducationDetail(
									empEducationDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateEmpEducationDetail',
												empEducationDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating EmpEducation Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteEmpEducationDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteEmpEducationDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting EmpEducation Detail ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
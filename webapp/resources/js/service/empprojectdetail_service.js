'use strict';

angular
		.module('hr')
		.factory(
				'EmpProjectDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllEmpProjectDetails : fetchAllEmpProjectDetails,
								fetchAllOrderedProjectDetails : fetchAllOrderedProjectDetails,
								fetchAllOrderedProjectDetailsByClient : fetchAllOrderedProjectDetailsByClient,
								fetchAllOrderedClientDetails : fetchAllOrderedClientDetails,
								fetchAllOrderedEmpDetails : fetchAllOrderedEmpDetails,
								fetchAllProjectRoles : fetchAllProjectRoles,
								fetchAllBillingStatuses : fetchAllBillingStatuses,
								fetchAllUtilizationStatuses : fetchAllUtilizationStatuses,
								createEmpProjectDetail : createEmpProjectDetail,
								updateEmpProjectDetail : updateEmpProjectDetail,
								deleteEmpProjectDetail : deleteEmpProjectDetail
							};
							
							return factory;

							function fetchAllEmpProjectDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllEmpProjectDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpProjectDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllEmpProjectDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpProjectDetails');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchAllOrderedProjectDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllOrderedProjectDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedProjectDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllOrderedProjectDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Project Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchAllOrderedProjectDetailsByClient(clientId) {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllOrderedProjectDetailsByClient()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedProjectDetailsByClient/'+clientId)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllOrderedProjectDetailsByClient() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Project Details by Client');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchAllOrderedEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllOrderedEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllOrderedEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedClientDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllOrderedClientDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedClientDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllOrderedClientDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Orderd Client Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllProjectRoles() {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllProjectRoles()#########");
								$http
										.get(REST_SERVICE_URI + 'listProjectRoles')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllProjectRoles() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Roles');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchAllBillingStatuses() {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllBillingStatuses()#########");
								$http
										.get(REST_SERVICE_URI + 'listBillingStatuses')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllBillingStatuses() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching User Roles');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchAllUtilizationStatuses() {
								var deferred = $q.defer();
								console
										.log("####EmpProjectDetailService:fetchAllUtilizationStatuses()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listUtilizationStatuses')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpProjectDetailService:fetchAllUtilizationStatuses() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching all UtilizationStatus statuses');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function createEmpProjectDetail(empProjectDetail) {
								console
										.log("####EmpProjectDetailService:createEmpProjectDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addEmpProjectDetail',
												empProjectDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating EmpProject Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateEmpProjectDetail(empProjectDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateEmpProjectDetail',
												empProjectDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating EmpProject Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteEmpProjectDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteEmpProjectDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting EmpProject Detail ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
'use strict';

angular
		.module('hr')
		.factory(
				'ProjectResourceService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllProjectResources : fetchAllProjectResources,
								fetchAllOrderedProjectDetails : fetchAllOrderedProjectDetails,
								fetchAllOrderedProjectDetailsByClient : fetchAllOrderedProjectDetailsByClient,
								fetchAllOrderedClientDetails : fetchAllOrderedClientDetails,
								fetchAllEmpDetails : fetchAllEmpDetails,
								fetchAllProjectRoles : fetchAllProjectRoles,
								fetchAllBillingStatuses : fetchAllBillingStatuses,
								createProjectResource : createProjectResource,
								updateProjectResource : updateProjectResource,
								deleteProjectResource : deleteProjectResource
							};

							return factory;

							function fetchAllProjectResources() {
								var deferred = $q.defer();
								console
										.log("####ProjectResourceService:fetchAllProjectResources()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listProjectResources')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllProjectResources() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ProjectResources');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedProjectDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectResourceService:fetchAllOrderedProjectDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedProjectDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllOrderedProjectDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Project Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedProjectDetailsByClient(
									clientId) {
								var deferred = $q.defer();
								console
										.log("####ProjectResourceService:fetchAllOrderedProjectDetailsByClient()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedProjectDetailsByClient/'
														+ clientId)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllOrderedProjectDetailsByClient() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Project Details by Client');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectResourceService:fetchAllEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedClientDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectResourceService:fetchAllOrderedClientDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedClientDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllOrderedClientDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Orderd Client Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectResourceService:fetchAllEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllProjectRoles() {
								var deferred = $q.defer();
								console
										.log("####ProjectResourceService:fetchAllProjectRoles()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listProjectRoles')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllProjectRoles() response received#########");
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
										.log("####ProjectResourceService:fetchAllBillingStatuses()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listBillingStatuses')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectResourceService:fetchAllBillingStatuses() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching User Roles');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createProjectResource(projectResource) {
								console
										.log("####ProjectResourceService:createProjectResource()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addProjectResource',
												projectResource)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating Project Resource ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateProjectResource(projectResource) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateProjectResource',
												projectResource)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating Project Resource ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteProjectResource(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteProjectResource/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting Project Resource ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
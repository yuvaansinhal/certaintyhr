'use strict';

angular
		.module('hr')
		.factory(
				'ProjectInvoicingService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllProjectInvoicings : fetchAllProjectInvoicings,
								fetchAllOrderedClientDetails : fetchAllOrderedClientDetails,
								fetchAllOrderedProjectDetails : fetchAllOrderedProjectDetails,
								createProjectInvoicing : createProjectInvoicing,
								updateProjectInvoicing : updateProjectInvoicing,
								deleteProjectInvoicing : deleteProjectInvoicing,
								fetchAllOrderedProjectDetailsByClient : fetchAllOrderedProjectDetailsByClient
							};

							return factory;

							function fetchAllProjectInvoicings() {
								var deferred = $q.defer();
								console
										.log("####ProjectInvoicingService:fetchAllProjectInvoicings()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listProjectInvoicings')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectInvoicingService:fetchAllProjectInvoicings() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Invoicings');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedClientDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectInvoicingService:fetchAllOrderedClientDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedClientDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectInvoicingService:fetchAllOrderedClientDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Orderd Client Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedProjectDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectInvoicingService:fetchAllOrderedProjectDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedProjectDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectInvoicingService:fetchAllOrderedProjectDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedProjectDetailsByClient(
									clientId) {
								var deferred = $q.defer();
								console
										.log("####ProjectInvoicingService:fetchAllOrderedProjectDetailsByClient()#########");
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
															.log("####ProjectInvoicingService:fetchAllOrderedProjectDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createProjectInvoicing(projectInvoicing) {
								console
										.log("####ProjectInvoicingService:createProjectInvoicing()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addProjectInvoicing',
												projectInvoicing)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating Project Invoicing');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateProjectInvoicing(projectInvoicing) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateProjectInvoicing',
												projectInvoicing)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating project Invoicing');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteProjectInvoicing(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteProjectInvoicing/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting Project Invoicing');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
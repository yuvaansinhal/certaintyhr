'use strict';

angular
		.module('hr')
		.factory(
				'ProjectDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllProjectDetails : fetchAllProjectDetails,
								fetchAllOrderedClientDetails : fetchAllOrderedClientDetails,
								fetchAllTechnologies : fetchAllTechnologies,
								fetchAllProjectTypes : fetchAllProjectTypes,
								createProjectDetail : createProjectDetail,
								updateProjectDetail : updateProjectDetail,
								deleteProjectDetail : deleteProjectDetail
							};

							return factory;

							function fetchAllProjectDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectDetailService:fetchAllProjectDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listProjectDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectDetailService:fetchAllProjectDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedClientDetails() {
								var deferred = $q.defer();
								console
										.log("####ProjectDetailService:fetchAllOrderedClientDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedClientDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectDetailService:fetchAllOrderedClientDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Orderd Client Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllTechnologies() {
								var deferred = $q.defer();
								console
										.log("####ProjectDetailService:fetchAllTechnologies()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listTechnologies')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectDetailService:fetchAllTechnologies() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Technologies');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllProjectTypes() {
								var deferred = $q.defer();
								console
										.log("####ProjectDetailService:fetchAllProjectTypes()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listProjectTypes')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ProjectDetailService:fetchAllProjectTypes() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Types');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createProjectDetail(projectDetail) {
								console
										.log("####ProjectDetailService:createProjectDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addProjectDetail',
												projectDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating Project Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateProjectDetail(projectDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateProjectDetail',
												projectDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating project Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteProjectDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteProjectDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting Project Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
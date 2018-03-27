'use strict';

angular
		.module('hr')
		.factory(
				'ClientDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllClientDetails : fetchAllClientDetails,
								fetchAllIndustryTypes : fetchAllIndustryTypes,
								createClientDetail : createClientDetail,
								updateClientDetail : updateClientDetail,
								deleteClientDetail : deleteClientDetail
							};

							return factory;

							function fetchAllClientDetails() {
								var deferred = $q.defer();
								console
										.log("####ClientDetailService:fetchAllClientDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listClientDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ClientDetailService:fetchAllClientDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Client Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllIndustryTypes() {
								var deferred = $q.defer();
								console
										.log("####ClientDetailService:fetchAllIndustryTypes()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listIndustryTypes')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####ClientDetailService:fetchAllIndustryTypes() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Industry Types');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createClientDetail(clientDetail) {
								console
										.log("####ClientDetailService:createClientDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addClientDetail',
												clientDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating Client Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateClientDetail(clientDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateClientDetail',
												clientDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating Client Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteClientDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteClientDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting Client Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
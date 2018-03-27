'use strict';

angular
		.module('hr')
		.factory(
				'EmpContactDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllEmpContactDetails : fetchAllEmpContactDetails,
								fetchAllOrderedEmpDetails : fetchAllOrderedEmpDetails,
								createEmpContactDetail : createEmpContactDetail,
								updateEmpContactDetail : updateEmpContactDetail,
								deleteEmpContactDetail : deleteEmpContactDetail
							};

							return factory;

							function fetchAllEmpContactDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpContactDetailService:fetchAllEmpContactDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpContactDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpContactDetailService:fetchAllEmpContactDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpContactDetails');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpContactDetailService:fetchAllOrderedEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpContactDetailService:fetchAllOrderedEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createEmpContactDetail(empContactDetail) {
								console
										.log("####EmpContactDetailService:createEmpContactDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addEmpContactDetail',
												empContactDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating EmpContact Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateEmpContactDetail(empContactDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateEmpContactDetail',
												empContactDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating EmpContact Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteEmpContactDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteEmpContactDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting EmpContact Detail ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
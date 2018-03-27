'use strict';

angular
		.module('hr')
		.factory(
				'EmpPersonalDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllEmpPersonalDetails : fetchAllEmpPersonalDetails,
								fetchAllOrderedEmpDetails : fetchAllOrderedEmpDetails,
								createEmpPersonalDetail : createEmpPersonalDetail,
								updateEmpPersonalDetail : updateEmpPersonalDetail,
								deleteEmpPersonalDetail : deleteEmpPersonalDetail
							};

							return factory;

							function fetchAllEmpPersonalDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpPersonalDetailService:fetchAllEmpPersonalDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpPersonalDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpPersonalDetailService:fetchAllEmpPersonalDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpPersonalDetails');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpPersonalDetailService:fetchAllOrderedEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpPersonalDetailService:fetchAllOrderedEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createEmpPersonalDetail(empPersonalDetail) {
								console
										.log("####EmpPersonalDetailService:createEmpPersonalDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addEmpPersonalDetail',
												empPersonalDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating EmpPersonal Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateEmpPersonalDetail(empPersonalDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateEmpPersonalDetail',
												empPersonalDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating EmpPersonal Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteEmpPersonalDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteEmpPersonalDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting EmpPersonal Detail ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
'use strict';

angular
		.module('hr')
		.factory(
				'EmpPassportDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllEmpPassportDetails : fetchAllEmpPassportDetails,
								fetchAllOrderedEmpDetails : fetchAllOrderedEmpDetails,
								createEmpPassportDetail : createEmpPassportDetail,
								updateEmpPassportDetail : updateEmpPassportDetail,
								deleteEmpPassportDetail : deleteEmpPassportDetail
							};
							
							return factory;

							function fetchAllEmpPassportDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpPassportDetailService:fetchAllEmpPassportDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpPassportDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpPassportDetailService:fetchAllEmpPassportDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpPassportDetails');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchAllOrderedEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpPassportDetailService:fetchAllOrderedEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpPassportDetailService:fetchAllOrderedEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createEmpPassportDetail(empPassportDetail) {
								console
										.log("####EmpPassportDetailService:createEmpPassportDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addEmpPassportDetail',
												empPassportDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating Emp Passport Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateEmpPassportDetail(empPassportDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateEmpPassportDetail',
												empPassportDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating Emp Passport Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteEmpPassportDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteEmpPassportDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting Emp Passport Detail ');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
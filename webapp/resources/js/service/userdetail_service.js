'use strict';

angular
		.module('hr')
		.factory(
				'UserDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllUserDetails : fetchAllUserDetails,
								fetchAllEmpDetails : fetchAllEmpDetails,
								fetchAllUserRoles : fetchAllUserRoles,
								createUserDetail : createUserDetail,
								updateUserDetail : updateUserDetail,
								deleteUserDetail : deleteUserDetail
							};
							return factory;

							function fetchAllUserDetails() {
								var deferred = $q.defer();
								console
										.log("####UserDetailService:fetchAllUserDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listUserDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####UserDetailService:fetchAllUserDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching User Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####UserDetailService:fetchAllEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####UserDetailService:fetchAllEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllUserRoles() {
								var deferred = $q.defer();
								console
										.log("####UserDetailService:fetchAllUserRoles()#########");
								$http
										.get(REST_SERVICE_URI + 'listUserRoles')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####UserDetailService:fetchAllUserRoles() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching User Roles');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createUserDetail(userDetail) {
								console
										.log("####UserDetailService:createUserDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addUserDetail',
												userDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating User Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateUserDetail(userDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateUserDetail',
												userDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating user Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteUserDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteUserDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting User Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
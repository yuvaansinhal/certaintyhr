'use strict';

angular
		.module('hr')
		.factory(
				'EmpSkillDetailService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = contextPath;

							var factory = {
								fetchAllEmpSkillDetails : fetchAllEmpSkillDetails,
								fetchAllOrderedEmpDetails : fetchAllOrderedEmpDetails,
								fetchAllSkillTypes : fetchAllSkillTypes,
								createEmpSkillDetail : createEmpSkillDetail,
								updateEmpSkillDetail : updateEmpSkillDetail,
								deleteEmpSkillDetail : deleteEmpSkillDetail
							};

							return factory;

							function fetchAllEmpSkillDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpSkillDetailService:fetchAllEmpSkillDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listEmpSkillDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpSkillDetailService:fetchAllEmpSkillDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Skill Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllOrderedEmpDetails() {
								var deferred = $q.defer();
								console
										.log("####EmpSkillDetailService:fetchAllOrderedEmpDetails()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listOrderedEmpDetails')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpSkillDetailService:fetchAllOrderedEmpDetails() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Orderd Emp Details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function fetchAllSkillTypes() {
								var deferred = $q.defer();
								console
										.log("####EmpSkillDetailService:fetchAllSkillTypes()#########");
								$http
										.get(
												REST_SERVICE_URI
														+ 'listSkillTypes')
										.then(
												function(response) {
													deferred
															.resolve(response.data);
													console
															.log("####EmpSkillDetailService:fetchAllSkillTypes() response received#########");
												},
												function(errResponse) {
													console
															.error('Error while fetching Skill Types');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function createEmpSkillDetail(empSkillDetail) {
								console
										.log("####EmpSkillDetailService:createEmpSkillDetail()#########");
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'addEmpSkillDetail',
												empSkillDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while creating Emp Skill Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function updateEmpSkillDetail(empSkillDetail) {
								var deferred = $q.defer();
								$http
										.post(
												REST_SERVICE_URI
														+ 'updateEmpSkillDetail',
												empSkillDetail)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating Emp Skill Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function deleteEmpSkillDetail(id) {
								var deferred = $q.defer();
								$http
										.get(
												REST_SERVICE_URI
														+ 'deleteEmpSkillDetail/'
														+ id)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting Emp Skill Detail');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);
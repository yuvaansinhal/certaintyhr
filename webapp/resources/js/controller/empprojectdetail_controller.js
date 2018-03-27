'use strict';

angular
		.module('hr')
		.controller(
				'EmpProjectDetailController',
				[
						'$scope',
						'EmpProjectDetailService',
						function($scope, EmpProjectDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;
							
							self.clientDetail = {
								id : null
							};
							self.projectRole = {
								projectRoleId : null
							};
							self.empDetail = {
								id : null
							};
							self.billingStatus = {
								billingStatusId : null
							};
							self.projectDetail = {
								id : null,
							};
							self.utilizationStatus = {
								utilizationStatusId : null
							};

							self.empProjectDetail = {
								id : null,
								billingStatus : self.billingStatus,
								clientDetail : self.clientDetail,
								empDetail : self.empDetail,
								projectDetail : self.projectDetail,
								projectRole : self.projectRole,
								utilizationStatus : self.utilizationStatus,
								clientAllocationDate : null,
								projectAllocationDate : null,
								statusChangeDate : null,
								expectedReleaseDate : null,
								allocationProportion : null,
								allocationPlan : ''
							};

							self.empProjectDetails = [];
							self.projectDetails = [];
							self.projectDetailsByClients = [];
							self.empDetails = [];
							self.clientDetails = [];
							self.projectRoles = [];
							self.billingStatuses = [];
							self.utilizationStatuses = [];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.getProjectName = getProjectName;
							self.getClientName = getClientName;
							self.getEmployeeName = getEmployeeName;
							self.getProjectRoleName = getProjectRoleName;
							self.getBillingStatusName = getBillingStatusName;
							self.getUtilizationStatusName = getUtilizationStatusName;
							self.fetchAllOrderedProjectDetailsByClient = fetchAllOrderedProjectDetailsByClient;

							fetchAllEmpProjectDetails();
							fetchAllOrderedProjectDetails();
							fetchAllOrderedClientDetails();
							fetchAllOrderedEmpDetails();
							fetchAllProjectRoles();
							fetchAllBillingStatuses();
							fetchAllUtilizationStatuses();

							function fetchAllEmpProjectDetails() {
								console
										.log("####EmpProjectDetailController:fetchAllEmpProjectDetails()#########");
								EmpProjectDetailService
										.fetchAllEmpProjectDetails()
										.then(
												function(d) {
													self.empProjectDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpProject Details');
												});
							}

							function fetchAllOrderedProjectDetails() {
								console
										.log("####EmpProjectDetailController:fetchAllOrderedProjectDetails()#########");
								EmpProjectDetailService
										.fetchAllOrderedProjectDetails()
										.then(
												function(d) {
													self.projectDetails = d;
													self.projectDetailsByClients = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Ordered Project Details');
												});
							}

							function fetchAllOrderedProjectDetailsByClient(
									clientId) {
								console
										.log("####EmpProjectDetailController:fetchAllOrderedProjectDetailsByClient()#########");
								EmpProjectDetailService
										.fetchAllOrderedProjectDetailsByClient(
												clientId)
										.then(
												function(d) {
													self.projectDetailsByClients = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Ordered Project Details by Client');
												});
							}

							function fetchAllOrderedClientDetails() {
								console
										.log("####EmpProjectDetailController:fetchAllOrderedClientDetails()#########");
								EmpProjectDetailService
										.fetchAllOrderedClientDetails()
										.then(
												function(d) {
													self.clientDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Ordered Client Details');
												});
							}

							function fetchAllOrderedEmpDetails() {
								console
										.log("####EmpProjectDetailController:fetchAllOrderedEmpDetails()#########");
								EmpProjectDetailService
										.fetchAllOrderedEmpDetails()
										.then(
												function(d) {
													self.empDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching ordered Emp Details');
												});
							}

							function fetchAllProjectRoles() {
								console
										.log("####EmpProjectDetailController:fetchAllProjectRoles()#########");
								EmpProjectDetailService
										.fetchAllProjectRoles()
										.then(
												function(d) {
													self.projectRoles = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Roles');
												});
							}

							function fetchAllBillingStatuses() {
								console
										.log("####EmpProjectDetailController:fetchAllBillingStatuses()#########");
								EmpProjectDetailService
										.fetchAllBillingStatuses()
										.then(
												function(d) {
													self.billingStatuses = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Billing Statueses');
												});
							}
							
							function fetchAllUtilizationStatuses() {
								console
										.log("####EmpProjectDetailController:fetchAllUtilizationStatuses#########");
								EmpProjectDetailService
										.fetchAllUtilizationStatuses()
										.then(
												function(d) {
													self.utilizationStatuses = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Utilization Statuses');
												});
							}

							function createEmpProjectDetail(empProjectDetail) {
								EmpProjectDetailService
										.createEmpProjectDetail(empProjectDetail)
										.then(
												fetchAllEmpProjectDetails,
												function(errResponse) {
													console
															.error('Error while creating EmpProject Detail');
												});
							}

							function updateEmpProjectDetail(empProjectDetail) {
								EmpProjectDetailService
										.updateEmpProjectDetail(empProjectDetail)
										.then(
												fetchAllEmpProjectDetails,
												function(errResponse) {
													console
															.error('Error while updating EmpProject Detail');
												});
							}

							function deleteEmpProjectDetail(id) {
								console
										.log(
												'calling controller deleteEmpProjectDetail(id);',
												id);
								EmpProjectDetailService
										.deleteEmpProjectDetail(id)
										.then(
												fetchAllEmpProjectDetails,
												function(errResponse) {
													console
															.error('Error while deleting EmpProject Detail ');
												});
							}

							function submit() {   
								if (self.empProjectDetail.id === null) {
									console.log('Saving New Project Resource ',
											self.empProjectDetail);
									self.empProjectDetail.clientAllocationDate = new Date(
											self.empProjectDetail.clientAllocationDate);
									self.empProjectDetail.projectAllocationDate = new Date(
											self.empProjectDetail.projectAllocationDate);
									self.empProjectDetail.expectedReleaseDate = new Date(
											self.empProjectDetail.expectedReleaseDate);
									if (self.empProjectDetail.statusChangeDate) {
										self.empProjectDetail.statusChangeDate = new Date(
												self.empProjectDetail.statusChangeDate);
									}
									createEmpProjectDetail(self.empProjectDetail);
								} else {
									updateEmpProjectDetail(self.empProjectDetail);
									console
											.log(
													'EmpProject Detail  updated with id ',
													self.empProjectDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.empProjectDetails.length; i++) {
									if (self.empProjectDetails[i].id === id) {
										self.empProjectDetail = angular
												.copy(self.empProjectDetails[i]);
										console
												.log(
														'Copied empProject detail  in Edit',
														self.empProjectDetail);
										self.empProjectDetail.clientAllocationDate = new Date(
												self.empProjectDetail.clientAllocationDate);
										self.empProjectDetail.projectAllocationDate = new Date(
												self.empProjectDetail.projectAllocationDate);
										self.empProjectDetail.expectedReleaseDate = new Date(
												self.empProjectDetail.expectedReleaseDate);
										if (self.empProjectDetails[i].statusChangeDate) {
											self.empProjectDetail.statusChangeDate = new Date(
													self.empProjectDetails[i].statusChangeDate);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.empProjectDetails.length; i++) {
									if (self.empProjectDetails[i].id === id) {
										self.empProjectDetail = angular
												.copy(self.empProjectDetails[i]);
										console
												.log(
														'Copied project resource  in Copy',
														self.empProjectDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.empProjectDetail.id === id) {
									reset();
								}
								console.log(
										'calling deleteEmpProjectDetail(id);',
										id);
								deleteEmpProjectDetail(id);
							}

							function getProjectName(id) {
								for (var i = 0; i < self.projectDetails.length; i++) {
									if (self.projectDetails[i].id == id) {
										return self.projectDetails[i].projectName;
									}
								}
							}

							function getClientName(id) {
								for (var i = 0; i < self.clientDetails.length; i++) {
									if (self.clientDetails[i].id == id) {
										return self.clientDetails[i].clientName;
									}
								}
							}

							function getEmployeeName(id) {
								for (var i = 0; i < self.empDetails.length; i++) {
									if (self.empDetails[i].id == id) {
										return self.empDetails[i].firstName
												+ ' '
												+ self.empDetails[i].lastName;
									}
								}
							}

							function getProjectRoleName(projectRoleId) {
								for (var i = 0; i < self.projectRoles.length; i++) {
									if (self.projectRoles[i].projectRoleId === projectRoleId) {
										return self.projectRoles[i].projectRoleName;
									}
								}
							}
							function getBillingStatusName(billingStatusId) {
								for (var i = 0; i < self.billingStatuses.length; i++) {
									if (self.billingStatuses[i].billingStatusId === billingStatusId) {
										return self.billingStatuses[i].billingStatusName;
									}
								}
							}

							function getUtilizationStatusName(utilizationStatusId) {
								for (var i = 0; i < self.utilizationStatuses.length; i++) {
									if (self.utilizationStatuses[i].utilizationStatusId === utilizationStatusId) {
										return self.utilizationStatuses[i].utilizationStatusName;
									}
								}
							}

							function hideAddEditDiv() {
								self.hideView = true;
								if (self.hideAddEdit === true) {
									reset();
								}
								self.hideAddEdit = self.hideAddEdit ? false
										: true;
							}

							function showViewDiv() {
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function reset() {
								self.empProjectDetail = {
										id : null,
										billingStatus : null,
										clientDetail : null,
										empDetail : null,
										projectDetail : null,
										projectRole : null,
										utilizationStatus : null,
										clientAllocationDate : null,
										projectAllocationDate : null,
										statusChangeDate : null,
										expectedReleaseDate : null,
										allocationProportion : null,
										allocationPlan : ''
									};
								$scope.EmpProjectDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
'use strict';

angular
		.module('hr')
		.controller(
				'ProjectResourceController',
				[
						'$scope',
						'ProjectResourceService',
						function($scope, ProjectResourceService) {
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

							self.projectResource = {
								id : null,
								billingStatus : self.billingStatus,
								clientDetail : self.clientDetail,
								empDetail : self.empDetail,
								projectDetail : self.projectDetail,
								projectRole : self.projectRole,
								ratePerHour : null,
								billingStartDate : null,
								billingEndDate : null,
								allocationPercentage : null,
								currentStatus : '',
								statusChangeDate : null,
							};

							self.projectResources = [];
							self.projectDetails = [];
							self.projectDetailsByClients = [];
							self.empDetails = [];
							self.clientDetails = [];
							self.projectRoles = [];
							self.billingStatuses = [];

							self.currentStatuses = [ {
								type : "Billable",
								code : "BILLABLE"
							}, {
								type : "Shadow",
								code : "SHADOW"
							}, {
								type : "Proposed",
								code : "PROPOSED"
							}, {
								type : "Available",
								code : "AVAILABLE"
							} ];

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
							self.getStatusType = getStatusType;
							self.fetchAllOrderedProjectDetailsByClient = fetchAllOrderedProjectDetailsByClient;

							fetchAllProjectResources();
							fetchAllOrderedProjectDetails();
							fetchAllOrderedClientDetails();
							fetchAllEmpDetails();
							fetchAllProjectRoles();
							fetchAllBillingStatuses();

							function fetchAllProjectResources() {
								console
										.log("####ProjectResourceController:fetchAllProjectResources()#########");
								ProjectResourceService
										.fetchAllProjectResources()
										.then(
												function(d) {
													self.projectResources = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Resources');
												});
							}

							function fetchAllOrderedProjectDetails() {
								console
										.log("####ProjectResourceController:fetchAllOrderedProjectDetails()#########");
								ProjectResourceService
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
										.log("####ProjectResourceController:fetchAllOrderedProjectDetailsByClient()#########");
								ProjectResourceService
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
										.log("####ProjectResourceController:fetchAllOrderedClientDetails()#########");
								ProjectResourceService
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

							function fetchAllEmpDetails() {
								console
										.log("####ProjectResourceController:fetchAllEmpDetails()#########");
								ProjectResourceService
										.fetchAllEmpDetails()
										.then(
												function(d) {
													self.empDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Details');
												});
							}

							function fetchAllProjectRoles() {
								console
										.log("####ProjectResourceController:fetchAllProjectRoles()#########");
								ProjectResourceService
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
										.log("####ProjectResourceController:fetchAllBillingStatuses()#########");
								ProjectResourceService
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

							function createProjectResource(projectResource) {
								ProjectResourceService
										.createProjectResource(projectResource)
										.then(
												fetchAllProjectResources,
												function(errResponse) {
													console
															.error('Error while creating Project Resource');
												});
							}

							function updateProjectResource(projectResource) {
								ProjectResourceService
										.updateProjectResource(projectResource)
										.then(
												fetchAllProjectResources,
												function(errResponse) {
													console
															.error('Error while updating Project Resource');
												});
							}

							function deleteProjectResource(id) {
								console
										.log(
												'calling controller deleteProjectResource(id);',
												id);
								ProjectResourceService
										.deleteProjectResource(id)
										.then(
												fetchAllProjectResources,
												function(errResponse) {
													console
															.error('Error while deleting Project Resource ');
												});
							}

							function submit() {
								if (self.projectResource.id === null) {
									console.log('Saving New Project Resource ',
											self.projectResource);
									self.projectResource.billingStartDate = new Date(
											self.projectResource.billingStartDate);
									self.projectResource.billingEndDate = new Date(
											self.projectResource.billingEndDate);
									if (self.projectResource.statusChangeDate) {
										self.projectResource.statusChangeDate = new Date(
												self.projectResource.statusChangeDate);
									}
									createProjectResource(self.projectResource);
								} else {
									updateProjectResource(self.projectResource);
									console
											.log(
													'Project Resource  updated with id ',
													self.projectResource.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.projectResources.length; i++) {
									if (self.projectResources[i].id === id) {
										self.projectResource = angular
												.copy(self.projectResources[i]);
										console
												.log(
														'Copied project resource  in Edit',
														self.projectResource);
										self.projectResource.billingStartDate = new Date(
												self.projectResources[i].billingStartDate);
										self.projectResource.billingEndDate = new Date(
												self.projectResources[i].billingEndDate);
										if (self.projectResources[i].statusChangeDate) {
											self.projectResource.statusChangeDate = new Date(
													self.projectResources[i].statusChangeDate);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.projectResources.length; i++) {
									if (self.projectResources[i].id === id) {
										self.projectResource = angular
												.copy(self.projectResources[i]);
										console
												.log(
														'Copied project resource  in Copy',
														self.projectResource);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.projectResource.id === id) {
									reset();
								}
								console.log(
										'calling deleteProjectResource(id);',
										id);
								deleteProjectResource(id);
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

							function getStatusType(code) {
								for (var i = 0; i < self.currentStatuses.length; i++) {
									if (self.currentStatuses[i].code === code) {
										return self.currentStatuses[i].type;
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
								self.projectResource = {
									id : null,
									billingStatus : null,
									clientDetail : null,
									empDetail : null,
									projectDetail : null,
									projectRole : null,
									ratePerHour : null,
									billingStartDate : null,
									billingEndDate : null,
									allocationPercentage : null,
									currentStatus : '',
									statusChangeDate : null,
								};
								$scope.ProjectResourceForm.$setPristine(); // reset
								// Form
							}

						} ]);
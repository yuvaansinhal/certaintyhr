'use strict';

angular
		.module('hr')
		.controller(
				'ProjectDetailController',
				[
						'$scope',
						'ProjectDetailService',
						function($scope, ProjectDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;
							self.clientDetail = {
								id : null
							};

							self.projectType = {
								projectTypeId : null
							};

							self.technology = {
								technologyId : null
							};
							self.projectDetail = {
								id : null,
								clientDetail : self.clientDetail,
								projectType : self.projectType,
								technology : self.technology,
								projectName : '',
								projectDescription : '',
								clientPocName : '',
								projectStartDate : null,
								projectEndDate : null,
								projectEstimation : null,
								poNumber : '',
								poAmount : null,
								currentStatus : '',
								statusChangeDate : null,
							};

							self.projectDetails = [];
							self.clientDetails = [];
							self.projectTypes = [];
							self.technologies = [];

							self.currentStatuses = [ {
								type : "Not Started",
								code : "NOT_STARTED"
							}, {
								type : "In Progress",
								code : "IN_PROGRESS"
							}, {
								type : "On Hold",
								code : "ON_HOLD"
							}, {
								type : "Completed",
								code : "COMPLETED"
							} ];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.getProjectTypeName = getProjectTypeName;
							self.getClientName = getClientName;
							self.getTechnologyName = getTechnologyName;
							self.getStatusType = getStatusType;
							self.setClientPOCName = setClientPOCName;

							fetchAllProjectDetails();
							fetchAllProjectTypes();
							fetchAllOrderedClientDetails();
							fetchAllTechnologies();

							function fetchAllProjectDetails() {
								console
										.log("####ProjectDetailController:fetchAllProjectDetails()#########");
								ProjectDetailService
										.fetchAllProjectDetails()
										.then(
												function(d) {
													self.projectDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Details');
												});
							}

							function fetchAllProjectTypes() {
								console
										.log("####ProjectDetailController:fetchAllProjectTypes()#########");
								ProjectDetailService
										.fetchAllProjectTypes()
										.then(
												function(d) {
													self.projectTypes = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Types');
												});
							}

							function fetchAllOrderedClientDetails() {
								console
										.log("####ProjectDetailController:fetchAllOrderedClientDetails()#########");
								ProjectDetailService
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

							function fetchAllTechnologies() {
								console
										.log("####ProjectDetailController:fetchAllTechnologies()#########");
								ProjectDetailService
										.fetchAllTechnologies()
										.then(
												function(d) {
													self.technologies = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Technologies');
												});
							}

							function createProjectDetail(projectDetail) {
								ProjectDetailService
										.createProjectDetail(projectDetail)
										.then(
												fetchAllProjectDetails,
												function(errResponse) {
													console
															.error('Error while creating Project Detail');
												});
							}

							function updateProjectDetail(projectDetail) {
								ProjectDetailService
										.updateProjectDetail(projectDetail)
										.then(
												fetchAllProjectDetails,
												function(errResponse) {
													console
															.error('Error while updating Project Detail');
												});
							}

							function deleteProjectDetail(id) {
								console
										.log(
												'calling controller deleteProjectDetail(id);',
												id);
								ProjectDetailService
										.deleteProjectDetail(id)
										.then(
												fetchAllProjectDetails,
												function(errResponse) {
													console
															.error('Error while deleting Project Detail');
												});
							}

							function setClientPOCName() {
								for (var i = 0; i < self.clientDetails.length; i++) {
									if (self.clientDetails[i].id == self.projectDetail.clientDetail.id) {
										self.projectDetail.clientPocName = self.clientDetails[i].clientPocName;
									}
								}
							}

							function submit() {
								setClientPOCName();
								if (self.projectDetail.id === null) {
									console.log('Saving New Project Detail',
											self.projectDetail);
									self.projectDetail.projectStartDate = new Date(
											self.projectDetail.projectStartDate);
									self.projectDetail.projectEndDate = new Date(
											self.projectDetail.projectEndDate);
									if (self.projectDetail.statusChangeDate) {
										self.projectDetail.statusChangeDate = new Date(
												self.projectDetail.statusChangeDate);
									}
									createProjectDetail(self.projectDetail);
								} else {
									updateProjectDetail(self.projectDetail);
									console.log(
											'Project Detail updated with id ',
											self.projectDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.projectDetails.length; i++) {
									if (self.projectDetails[i].id === id) {
										self.projectDetail = angular
												.copy(self.projectDetails[i]);
										console
												.log(
														'Copied project detail in Edit',
														self.projectDetail);
										self.projectDetail.projectStartDate = new Date(
												self.projectDetails[i].projectStartDate);
										self.projectDetail.projectEndDate = new Date(
												self.projectDetails[i].projectEndDate);
										if (self.projectDetails[i].statusChangeDate) {
											self.projectDetail.statusChangeDate = new Date(
													self.projectDetails[i].statusChangeDate);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.projectDetails.length; i++) {
									if (self.projectDetails[i].id === id) {
										self.projectDetail = angular
												.copy(self.projectDetails[i]);
										console
												.log(
														'Copied project detail in Copy',
														self.projectDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.projectDetail.id === id) {
									reset();
								}
								console.log('calling deleteProjectDetail(id);',
										id);
								deleteProjectDetail(id);
							}

							function getProjectTypeName(id) {
								for (var i = 0; i < self.projectTypes.length; i++) {
									if (self.projectTypes[i].projectTypeId == id) {
										return self.projectTypes[i].projectTypeName;
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

							function getTechnologyName(id) {
								for (var i = 0; i < self.technologies.length; i++) {
									if (self.technologies[i].technologyId == id) {
										return self.technologies[i].technologyName;
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
								self.projectDetail = {
									id : null,
									clientDetail : null,
									projectType : null,
									technology : null,
									projectName : '',
									projectDescription : '',
									clientPocName : '',
									projectStartDate : null,
									projectEndDate : null,
									projectEstimation : null,
									poNumber : '',
									poAmount : null,
									currentStatus : '',
									statusChangeDate : null
								};
								$scope.ProjectDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
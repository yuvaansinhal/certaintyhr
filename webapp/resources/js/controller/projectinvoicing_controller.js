'use strict';

angular
		.module('hr')
		.controller(
				'ProjectInvoicingController',
				[
						'$scope',
						'ProjectInvoicingService',
						function($scope, ProjectInvoicingService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;

							self.clientDetail = {
								id : null
							};

							self.projectDetail = {
								id : null
							};

							self.projectInvocing = {
								id : null,
								clientDetail : self.clientDetail,
								projectDetail : self.projectDetail,
								invoiceNumber : '',
								billingFromDate : null,
								billingToDate : null,
								amount : null,
								raisedDate : null,
								dueDate : null,
								poBalance : null,
								currentStatus : '',
								statusChangeDate : null,
							};

							self.projectInvocings = [];
							self.clientDetails = [];
							self.projectDetails = [];
							self.projectDetailsByClients = [];

							self.currentStatuses = [ {
								type : "Raised",
								code : "RAISED"
							}, {
								type : "Paid",
								code : "PAID"
							}, {
								type : "Overdue",
								code : "OVERDUE"
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
							self.getStatusType = getStatusType;
							self.fetchAllOrderedProjectDetailsByClient = fetchAllOrderedProjectDetailsByClient;

							fetchAllProjectInvoicings();
							fetchAllOrderedClientDetails();
							fetchAllOrderedProjectDetails();

							function fetchAllProjectInvoicings() {
								console
										.log("####ProjectInvoicingController:fetchAllProjectInvoicings()#########");
								ProjectInvoicingService
										.fetchAllProjectInvoicings()
										.then(
												function(d) {
													self.projectInvoicings = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Invoicings');
												});
							}

							function fetchAllOrderedClientDetails() {
								console
										.log("####ProjectInvoicingController:fetchAllOrderedClientDetails()#########");
								ProjectInvoicingService
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

							function fetchAllOrderedProjectDetails() {
								console
										.log("####ProjectInvoicingController:fetchAllOrderedProjectDetails()#########");
								ProjectInvoicingService
										.fetchAllOrderedProjectDetails()
										.then(
												function(d) {
													self.projectDetails = d;
													self.projectDetailsByClients = self.projectDetails;
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Details');
												});
							}

							function fetchAllOrderedProjectDetailsByClient(
									clientId) {
								console
										.log("####ProjectInvoicingController:fetchAllOrderedProjectDetailsByClient()#########");
								ProjectInvoicingService
										.fetchAllOrderedProjectDetailsByClient(
												clientId)
										.then(
												function(d) {
													self.projectDetailsByClients = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Project Details');
												});
							}

							function createProjectInvoicing(projectInvoicing) {
								ProjectInvoicingService
										.createProjectInvoicing(
												projectInvoicing)
										.then(
												fetchAllProjectInvoicings,
												function(errResponse) {
													console
															.error('Error while creating Project Invoicing');
												});
							}

							function updateProjectInvoicing(projectInvoicing) {
								ProjectInvoicingService
										.updateProjectInvoicing(
												projectInvoicing)
										.then(
												fetchAllProjectInvoicings,
												function(errResponse) {
													console
															.error('Error while updating Project Invoicing');
												});
							}

							function deleteProjectInvoicing(id) {
								console
										.log(
												'calling controller deleteProjectInvoicing(id);',
												id);
								ProjectInvoicingService
										.deleteProjectInvoicing(id)
										.then(
												fetchAllProjectInvoicings,
												function(errResponse) {
													console
															.error('Error while deleting Project Invoicing');
												});
							}

							function submit() {
								if (self.projectInvoicing.id === null) {
									console.log('Saving New Project Invoicing',
											self.projectInvoicing);
									self.projectInvoicing.billingFromDate = new Date(
											self.projectInvoicing.billingFromDate);
									self.projectInvoicing.billingToDate = new Date(
											self.projectInvoicing.billingToDate);
									self.projectInvoicing.raisedDate = new Date(
											self.projectInvoicing.raisedDate);
									self.projectInvoicing.dueDate = new Date(
											self.projectInvoicing.dueDate);
									if (self.projectInvoicing.statusChangeDate) {
										self.projectInvoicing.statusChangeDate = new Date(
												self.projectInvoicing.statusChangeDate);
									}
									createProjectInvoicing(self.projectInvoicing);
								} else {
									updateProjectInvoicing(self.projectInvoicing);
									console.log(
											'Project Invoice updated with id ',
											self.projectInvoicing.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.projectInvoicings.length; i++) {
									if (self.projectInvoicings[i].id === id) {
										self.projectInvoicing = angular
												.copy(self.projectInvoicings[i]);
										console
												.log(
														'Copied project invoicing in Edit',
														self.projectInvoicing);
										self.projectInvoicing.billingFromDate = new Date(
												self.projectInvoicing.billingFromDate);
										self.projectInvoicing.billingToDate = new Date(
												self.projectInvoicing.billingToDate);
										self.projectInvoicing.raisedDate = new Date(
												self.projectInvoicing.raisedDate);
										self.projectInvoicing.dueDate = new Date(
												self.projectInvoicing.dueDate);
										if (self.projectInvoicing.statusChangeDate) {
											self.projectInvoicing.statusChangeDate = new Date(
													self.projectInvoicing.statusChangeDate);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.projectInvoicings.length; i++) {
									if (self.projectInvoicings[i].id === id) {
										self.projectInvoicing = angular
												.copy(self.projectInvoicings[i]);
										console
												.log(
														'Copied project invoice in Copy',
														self.projectInvoicing);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.projectInvoicing.id === id) {
									reset();
								}
								console.log(
										'calling deleteProjectInvoicing(id);',
										id);
								deleteProjectInvoicing(id);
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
								self.projectInvoicing = {
									id : null,
									clientDetail : null,
									projectDetail : null,
									invoiceNumber : '',
									billingFromDate : null,
									billingToDate : null,
									amount : null,
									raisedDate : null,
									dueDate : null,
									poBalance : null,
									currentStatus : '',
									statusChangeDate : null,
								};
								$scope.ProjectInvoicingForm.$setPristine(); // reset
								// Form
							}

						} ]);
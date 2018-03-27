'use strict';

angular
		.module('hr')
		.controller(
				'ClientDetailController',
				[
						'$scope',
						'ClientDetailService',
						function($scope, ClientDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;
							self.industryType = {
								industryId : null
							};
							self.clientDetail = {
								id : null,
								clientName : '',
								industryType : self.industryType,
								clientRevenue : null,
								clientAddress : '',
								clientBillingAddress : '',
								clientPocName : '',
								engagementStartDate : null,
								engagementType : '',
								currentStatus : '',
								statusChangeDate : null,
								clientDesc : ''
							};

							self.clientDetails = [];
							self.industryTypes = [];
							self.engagementTypes = [ {
								type : "Long Term",
								code : "LONGTERM"
							}, {
								type : "Short Term",
								code : "SHORTTERM"
							} ];

							self.currentStatuses = [ {
								type : "Active",
								code : "ACTIVE"
							}, {
								type : "Inactive",
								code : "INACTIVE"
							} ];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.getIndustryName = getIndustryName;
							self.getEngagementTypeName = getEngagementTypeName;
							self.getStatusType = getStatusType;

							fetchAllIndustryTypes();
							fetchAllClientDetails();

							function fetchAllClientDetails() {
								console
										.log("####ClientDetailController:fetchAllClientDetails()#########");
								ClientDetailService
										.fetchAllClientDetails()
										.then(
												function(d) {
													self.clientDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Client Details');
												});
							}

							function fetchAllIndustryTypes() {
								console
										.log("####ClientDetailController:fetchAllIndustryTypes()#########");
								ClientDetailService
										.fetchAllIndustryTypes()
										.then(
												function(d) {
													self.industryTypes = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Industry Types');
												});
							}

							function createClientDetail(clientDetail) {
								ClientDetailService
										.createClientDetail(clientDetail)
										.then(
												fetchAllClientDetails,
												function(errResponse) {
													console
															.error('Error while creating Client Detail');
												});
							}

							function updateClientDetail(clientDetail) {
								ClientDetailService
										.updateClientDetail(clientDetail)
										.then(
												fetchAllClientDetails,
												function(errResponse) {
													console
															.error('Error while updating Client Detail');
												});
							}

							function deleteClientDetail(id) {
								console
										.log(
												'calling controller deleteClientDetail(id);',
												id);
								ClientDetailService
										.deleteClientDetail(id)
										.then(
												fetchAllClientDetails,
												function(errResponse) {
													console
															.error('Error while deleting Client Detail');
												});
							}

							function submit() {
								if (self.clientDetail.id === null) {
									console.log('Saving New Client Detail',
											self.clientDetail);
									self.clientDetail.engagementStartDate = new Date(
											self.clientDetail.engagementStartDate);
									if (self.clientDetail.statusChangeDate) {
										self.clientDetail.statusChangeDate = new Date(
												self.clientDetail.statusChangeDate);
									}
									createClientDetail(self.clientDetail);
								} else {
									updateClientDetail(self.clientDetail);
									console.log(
											'Client Detail updated with id ',
											self.clientDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.clientDetails.length; i++) {
									if (self.clientDetails[i].id === id) {
										self.clientDetail = angular
												.copy(self.clientDetails[i]);
										console.log(
												'Copied client detail in Edit',
												self.clientDetail);
										self.clientDetail.engagementStartDate = new Date(
												self.clientDetails[i].engagementStartDate);
										if (self.clientDetail.statusChangeDate) {
											self.clientDetail.statusChangeDate = new Date(
													self.clientDetails[i].statusChangeDate);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;

							}

							function copyView(id) {
								for (var i = 0; i < self.clientDetails.length; i++) {
									if (self.clientDetails[i].id === id) {
										self.clientDetail = angular
												.copy(self.clientDetails[i]);
										console.log(
												'Copied client detail in Copy',
												self.clientDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.clientDetail.id === id) {
									reset();
								}
								console.log('calling deleteClientDetail(id);',
										id);
								deleteClientDetail(id);
							}

							function getIndustryName(id) {
								for (var i = 0; i < self.industryTypes.length; i++) {
									if (self.industryTypes[i].industryId == id) {
										return self.industryTypes[i].industryName;
									}
								}
							}

							function getEngagementTypeName(code) {
								for (var i = 0; i < self.engagementTypes.length; i++) {
									if (self.engagementTypes[i].code === code) {
										return self.engagementTypes[i].type;
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
								self.clientDetail = {
									id : null,
									industryType : null,
									clientRevenue : null,
									clientAddress : '',
									clientBillingAddress : '',
									clientPocName : '',
									engagementStartDate : null,
									engagementType : '',
									currentStatus : '',
									statusChangeDate : null,
									clientDesc : ''
								};
								$scope.ClientDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
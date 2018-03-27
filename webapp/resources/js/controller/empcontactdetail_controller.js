'use strict';

angular
		.module('hr')
		.controller(
				'EmpContactDetailController',
				[
						'$scope',
						'EmpContactDetailService',
						function($scope, EmpContactDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;

							self.empDetail = {};

							self.empContactDetail = {
								id : null,
								empDetail : self.empDetail,
								personalEmail : '',
								personalContactNumber : '',
								residenceAddress : '',
								permanentAddress : '',
								emergencyContactNumber : '',
								emergencyContactName : '',
								relationWithEc : '',
							};

							self.empContactDetails = [];
							self.empDetails = [];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.getEmployeeName = getEmployeeName;

							fetchAllEmpContactDetails();
							fetchAllOrderedEmpDetails();

							function fetchAllEmpContactDetails() {
								console
										.log("####EmpContactDetailController:fetchAllEmpContactDetails()#########");
								EmpContactDetailService
										.fetchAllEmpContactDetails()
										.then(
												function(d) {
													self.empContactDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpContact Details');
												});
							}

							function fetchAllOrderedEmpDetails() {
								console
										.log("####EmpContactDetailController:fetchAllOrderedEmpDetails()#########");
								EmpContactDetailService
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

							function createEmpContactDetail(empContactDetail) {
								EmpContactDetailService
										.createEmpContactDetail(
												empContactDetail)
										.then(
												fetchAllEmpContactDetails,
												function(errResponse) {
													console
															.error('Error while creating Emp Contact Detail');
												});
							}

							function updateEmpContactDetail(empContactDetail) {
								EmpContactDetailService
										.updateEmpContactDetail(
												empContactDetail)
										.then(
												fetchAllEmpContactDetails,
												function(errResponse) {
													console
															.error('Error while updating Emp Contact Detail');
												});
							}

							function deleteEmpContactDetail(id) {
								console
										.log(
												'calling controller deleteEmpContactDetail(id);',
												id);
								EmpContactDetailService
										.deleteEmpContactDetail(id)
										.then(
												fetchAllEmpContactDetails,
												function(errResponse) {
													console
															.error('Error while deleting Emp Contact Detail ');
												});
							}

							function submit() {
								if (self.empContactDetail.id === null) {
									console.log(
											'Saving New Emp Contact Detail ',
											self.empContactDetail);
									createEmpContactDetail(self.empContactDetail);
								} else {
									updateEmpContactDetail(self.empContactDetail);
									console
											.log(
													'Emp Contact Detail  updated with id ',
													self.empContactDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.empContactDetails.length; i++) {
									if (self.empContactDetails[i].id === id) {
										self.empContactDetail = angular
												.copy(self.empContactDetails[i]);
										console
												.log(
														'Copied Emp Contact detail  in Edit',
														self.empContactDetail);
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.empContactDetails.length; i++) {
									if (self.empContactDetails[i].id === id) {
										self.empContactDetail = angular
												.copy(self.empContactDetails[i]);
										console
												.log(
														'Copied Emp Contact detail  in Copy',
														self.empContactDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.empContactDetail.id === id) {
									reset();
								}
								console.log(
										'calling deleteEmpContactDetail(id);',
										id);
								deleteEmpContactDetail(id);
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
								self.empContactDetail = {
									id : null,
									empDetail : null,
									personalEmail : '',
									personalContactNumber : '',
									residenceAddress : '',
									permanentAddress : '',
									emergencyContactNumber : '',
									emergencyContactName : '',
									relationWithEc : '',
								};
								$scope.EmpContactDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
'use strict';

angular
		.module('hr')
		.controller(
				'EmpPersonalDetailController',
				[
						'$scope',
						'EmpPersonalDetailService',
						function($scope, EmpPersonalDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;

							self.empDetail = {
								id : null
							};

							self.empPersonalDetail = {
								id : null,
								empDetail : self.empDetail,
								gender : '',
								dateOfBirth : null,
								fatherName : '',
								motherName : '',
								bloodGroup : '',
								drivingLicense : '',
								drivingLicenseState : '',
								panNumber : '',
								aadharNumber : null,
								maritalStatus : '',
								weddingDate : null,
								spouseName : '',
								picture : null
							};

							self.empPersonalDetails = [];
							self.empDetails = [];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.selectPicture = selectPicture;

							self.getEmployeeName = getEmployeeName;
							self.getBloodGroupType = getBloodGroupType;
							self.getGenderType = getGenderType;
							self.getMaritalStatusType = getMaritalStatusType;
							self.getDrivingLicenseStateType = getDrivingLicenseStateType;

							fetchAllEmpPersonalDetails();
							fetchAllOrderedEmpDetails();

							function fetchAllEmpPersonalDetails() {
								console
										.log("####EmpPersonalDetailController:fetchAllEmpPersonalDetails()#########");
								EmpPersonalDetailService
										.fetchAllEmpPersonalDetails()
										.then(
												function(d) {
													self.empPersonalDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpPersonal Details');
												});
							}

							function fetchAllOrderedEmpDetails() {
								console
										.log("####EmpPersonalDetailController:fetchAllOrderedEmpDetails()#########");
								EmpPersonalDetailService
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

							function createEmpPersonalDetail(empPersonalDetail) {
								EmpPersonalDetailService
										.createEmpPersonalDetail(
												empPersonalDetail)
										.then(
												fetchAllEmpPersonalDetails,
												function(errResponse) {
													console
															.error('Error while creating EmpPersonal Detail');
												});
							}

							function updateEmpPersonalDetail(empPersonalDetail) {
								EmpPersonalDetailService
										.updateEmpPersonalDetail(
												empPersonalDetail)
										.then(
												fetchAllEmpPersonalDetails,
												function(errResponse) {
													console
															.error('Error while updating EmpPersonal Detail');
												});
							}

							function deleteEmpPersonalDetail(id) {
								console
										.log(
												'calling controller deleteEmpPersonalDetail(id);',
												id);
								EmpPersonalDetailService
										.deleteEmpPersonalDetail(id)
										.then(
												fetchAllEmpPersonalDetails,
												function(errResponse) {
													console
															.error('Error while deleting EmpPersonal Detail ');
												});
							}

							function submit() {
								if (self.empPersonalDetail.id === null) {
									console.log('Saving New Personal Detail ',
											self.empPersonalDetail);
									self.empPersonalDetail.dateOfBirth = new Date(
											self.empPersonalDetail.dateOfBirth);
									if (self.empPersonalDetail.weddingDate) {
										self.empPersonalDetail.weddingDate = new Date(
												self.empPersonalDetail.weddingDate);
									}
									createEmpPersonalDetail(self.empPersonalDetail);
								} else {
									updateEmpPersonalDetail(self.empPersonalDetail);
									console
											.log(
													'EmpPersonal Detail updated with id ',
													self.empPersonalDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.empPersonalDetails.length; i++) {
									if (self.empPersonalDetails[i].id === id) {
										self.empPersonalDetail = angular
												.copy(self.empPersonalDetails[i]);
										console
												.log(
														'Copied empPersonal detail  in Edit',
														self.empPersonalDetail);
										self.empPersonalDetail.dateOfBirth = new Date(
												self.empPersonalDetail.dateOfBirth);
										if (self.empPersonalDetail.weddingDate) {
											self.empPersonalDetail.weddingDate = new Date(
													self.empPersonalDetail.weddingDate);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.empPersonalDetails.length; i++) {
									if (self.empPersonalDetails[i].id === id) {
										self.empPersonalDetail = angular
												.copy(self.empPersonalDetails[i]);
										console
												.log(
														'Copied Personal Detail in Copy',
														self.empPersonalDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
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

							function selectPicture() {
								var file = self.empPersonalDetail.picture;
								console.log('file is ', file);
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.empPersonalDetail.id === id) {
									reset();
								}
								console.log(
										'calling deleteEmpPersonalDetail(id);',
										id);
								deleteEmpPersonalDetail(id);
							}

							function reset() {
								self.empPersonalDetail = {
									id : null,
									empDetail : null,
									gender : '',
									dateOfBirth : null,
									fatherName : '',
									motherName : '',
									bloodGroup : '',
									drivingLicense : '',
									drivingLicenseState : '',
									panNumber : '',
									aadharNumber : '',
									maritalStatus : '',
									weddingDate : null,
									spouseName : '',
									picture : null
								};
								$scope.EmpPersonalDetailForm.$setPristine(); // reset
								// Form
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

							self.bloodGroups = [ {
								type : "A +ve",
								code : "A+"
							}, {
								type : "A -ve",
								code : "A-"
							}, {
								type : "B +ve",
								code : "B+"
							}, {
								type : "B -ve",
								code : "B-"
							}, {
								type : "AB +ve",
								code : "AB+"
							}, {
								type : "AB -ve",
								code : "AB-"
							}, {
								type : "O +ve",
								code : "O+"
							}, {
								type : "O -ve",
								code : "O-"
							} ];

							function getBloodGroupType(code) {
								for (var i = 0; i < self.bloodGroups.length; i++) {
									if (self.bloodGroups[i].code === code) {
										return self.bloodGroups[i].type;
									}
								}
							}

							self.genders = [ {
								type : "Male",
								code : "1"
							}, {
								type : "Female",
								code : "2"
							}, {
								type : "Other",
								code : "3"
							} ];

							function getGenderType(code) {
								for (var i = 0; i < self.genders.length; i++) {
									if (self.genders[i].code === code) {
										return self.genders[i].type;
									}
								}
							}

							self.maritalStatuses = [ {
								type : "Single",
								code : "1"
							}, {
								type : "Married",
								code : "2"
							}, {
								type : "Divorced",
								code : "3"
							} ];

							function getMaritalStatusType(code) {
								for (var i = 0; i < self.maritalStatuses.length; i++) {
									if (self.maritalStatuses[i].code === code) {
										return self.maritalStatuses[i].type;
									}
								}
							}

							self.drivingLicenseStates = [ {
								type : "Andhra Pradesh",
								code : "1"
							}, {
								type : "Arunachal Pradesh",
								code : "2"
							}, {
								type : "Assam",
								code : "3"
							}, {
								type : "Bihar",
								code : "4"
							}, {
								type : "Chhattisgarh",
								code : "5"
							}, {
								type : "Goa",
								code : "6"
							}, {
								type : "Gujarat",
								code : "7"
							}, {
								type : "Haryana",
								code : "8"
							}, {
								type : "Himachal Pradesh",
								code : "9"
							}, {
								type : "Jammu & Kashmir",
								code : "10"
							}, {
								type : "Jharkhand",
								code : "11"
							}, {
								type : "Karnataka",
								code : "12"
							}, {
								type : "Kerala",
								code : "13"
							}, {
								type : "Madhya Pradesh",
								code : "14"
							}, {
								type : "Maharashtra",
								code : "15"
							}, {
								type : "Manipur",
								code : "16"
							}, {
								type : "Meghalaya",
								code : "17"
							}, {
								type : "Mizoram",
								code : "18"
							}, {
								type : "Nagaland",
								code : "19"
							}, {
								type : "Orissa",
								code : "20"
							}, {
								type : "Punjab",
								code : "21"
							}, {
								type : "Rajasthan",
								code : "22"
							}, {
								type : "Sikkim",
								code : "23"
							}, {
								type : "Tamil Nadu",
								code : "24"
							}, {
								type : "Telangana",
								code : "25"
							}, {
								type : "Tripura",
								code : "26"
							}, {
								type : "Uttar Pradesh",
								code : "27"
							}, {
								type : "Uttarakhand",
								code : "28"
							}, {
								type : "West Bengal",
								code : "29"
							} ];

							function getDrivingLicenseStateType(code) {
								for (var i = 0; i < self.drivingLicenseStates.length; i++) {
									if (self.drivingLicenseStates[i].code === code) {
										return self.drivingLicenseStates[i].type;
									}
								}
							}

						} ]);
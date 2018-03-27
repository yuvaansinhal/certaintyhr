'use strict';

angular
		.module('hr')
		.controller(
				'EmpSkillDetailController',
				[
						'$scope',
						'EmpSkillDetailService',
						function($scope, EmpSkillDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;

							self.empDetail = {
								id : null
							};

							self.skillType = {
								skillTypeId : null
							};

							self.primaryFlags = [ {
								type : "Yes",
								code : "Y"
							}, {
								type : "No",
								code : "N"
							} ];

							self.empSkillDetail = {
								id : null,
								empDetail : self.empDetail,
								skillType : self.skillType,
								experience : null,
								empSkillDetailDesc : '',
								primaryFlag : ''
							};

							self.empDetails = [];
							self.skillTypes = [];
							self.empSkillDetails = [];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.getSkillTypeName = getSkillTypeName;
							self.getEmployeeName = getEmployeeName;
							self.getPrimaryFlagType = getPrimaryFlagType; 

							fetchAllEmpSkillDetails();
							fetchAllSkillTypes();
							fetchAllOrderedEmpDetails();

							function fetchAllEmpSkillDetails() {
								console
										.log("####EmpSkillDetailController:fetchAllEmpSkillDetails()#########");
								EmpSkillDetailService
										.fetchAllEmpSkillDetails()
										.then(
												function(d) {
													self.empSkillDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Skill Details');
												});
							}

							function fetchAllSkillTypes() {
								console
										.log("####EmpSkillDetailController:fetchAllSkillTypes()#########");
								EmpSkillDetailService
										.fetchAllSkillTypes()
										.then(
												function(d) {
													self.skillTypes = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Skill Types');
												});
							}

							function fetchAllOrderedEmpDetails() {
								console
										.log("####EmpSkillDetailController:fetchAllOrderedEmpDetails()#########");
								EmpSkillDetailService
										.fetchAllOrderedEmpDetails()
										.then(
												function(d) {
													self.empDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Ordered Emp Details');
												});
							}

							function createEmpSkillDetail(empSkillDetail) {
								EmpSkillDetailService
										.createEmpSkillDetail(empSkillDetail)
										.then(
												fetchAllEmpSkillDetails,
												function(errResponse) {
													console
															.error('Error while creating Emp Skill Detail');
												});
							}

							function updateEmpSkillDetail(empSkillDetail) {
								EmpSkillDetailService
										.updateEmpSkillDetail(empSkillDetail)
										.then(
												fetchAllEmpSkillDetails,
												function(errResponse) {
													console
															.error('Error while updating Emp Skill Detail');
												});
							}

							function deleteEmpSkillDetail(id) {
								console
										.log(
												'calling controller deleteEmpSkillDetail(id);',
												id);
								EmpSkillDetailService
										.deleteEmpSkillDetail(id)
										.then(
												fetchAllEmpSkillDetails,
												function(errResponse) {
													console
															.error('Error while deleting Emp Skill Detail');
												});
							}

							function submit() {
								if (self.empSkillDetail.id === null) {
									console.log('Saving New Emp Skill Detail',
											self.empSkillDetail);
									createEmpSkillDetail(self.empSkillDetail);
								} else {
									updateEmpSkillDetail(self.empSkillDetail);
									console
											.log(
													'Emp Skill Detail updated with id ',
													self.empSkillDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.empSkillDetails.length; i++) {
									if (self.empSkillDetails[i].id === id) {
										self.empSkillDetail = angular
												.copy(self.empSkillDetails[i]);
										console
												.log(
														'Copied Emp Skill detail in Edit',
														self.empSkillDetail);
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.empSkillDetails.length; i++) {
									if (self.empSkillDetails[i].id === id) {
										self.empSkillDetail = angular
												.copy(self.empSkillDetails[i]);
										console
												.log(
														'Copied Emp Skill detail in Copy',
														self.empSkillDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.empSkillDetail.id === id) {
									reset();
								}
								console
										.log(
												'calling deleteEmpSkillDetail(id);',
												id);
								deleteEmpSkillDetail(id);
							}

							function getSkillTypeName(id) {
								for (var i = 0; i < self.skillTypes.length; i++) {
									if (self.skillTypes[i].skillTypeId == id) {
										return self.skillTypes[i].skillTypeName;
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

							function getPrimaryFlagType(code) {
								for (var i = 0; i < self.primaryFlags.length; i++) {
									if (self.primaryFlags[i].code === code) {
										return self.primaryFlags[i].type;
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
								self.empSkillDetail = {
									id : null,
									empDetail : null,
									skillType : null,
									experience : null,
									empSkillDetailDesc : '',
									primaryFlag : ''
								};
								$scope.EmpSkillDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
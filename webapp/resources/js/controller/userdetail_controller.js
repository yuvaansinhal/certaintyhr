'use strict';

angular
		.module('hr')
		.controller(
				'UserDetailController',
				[
						'$scope',
						'UserDetailService',
						function($scope, UserDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;
							self.empDetail = {
								id : null
							};

							self.userRole = {
								userRoleId : null
							};

							self.userDetail = {
								id : null,
								empDetail : self.empDetail,
								userRole : self.userRole,
								userId : '',
								pwd : '',
								userDetailStatusName : '',
								statusChangeDate : null
							};

							self.userDetails = [];
							self.empDetails = [];
							self.userRoles = [];
							self.userDetailStatusNames = [ {
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
							self.getUserRoleName = getUserRoleName;
							self.getUserName = getUserName;
							self.getUserDetailStatusName = getUserDetailStatusName;

							fetchAllUserDetails();
							fetchAllEmpDetails();
							fetchAllUserRoles();

							function fetchAllUserDetails() {
								console
										.log("####UserDetailController:fetchAllUserDetails()#########");
								UserDetailService
										.fetchAllUserDetails()
										.then(
												function(d) {
													self.userDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching User Details');
												});
							}

							function fetchAllEmpDetails() {
								console
										.log("####UserDetailController:fetchAllEmpDetails()#########");
								UserDetailService
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

							function fetchAllUserRoles() {
								console
										.log("####UserDetailController:fetchAllUserRoles()#########");
								UserDetailService
										.fetchAllUserRoles()
										.then(
												function(d) {
													self.userRoles = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching User Roles');
												});
							}

							function createUserDetail(userDetail) {
								UserDetailService
										.createUserDetail(userDetail)
										.then(
												fetchAllUserDetails,
												function(errResponse) {
													console
															.error('Error while creating User Detail');
												});
							}

							function updateUserDetail(userDetail) {
								UserDetailService
										.updateUserDetail(userDetail)
										.then(
												fetchAllUserDetails,
												function(errResponse) {
													console
															.error('Error while updating User Detail');
												});
							}

							function deleteUserDetail(id) {
								console
										.log(
												'calling controller deleteUserDetail(id);',
												id);
								UserDetailService
										.deleteUserDetail(id)
										.then(
												fetchAllUserDetails,
												function(errResponse) {
													console
															.error('Error while deleting User Detail');
												});
							}

							function submit() {
								if (self.userDetail.id === null) {
									console.log('Saving New User Detail',
											self.userDetail);
									if (self.userDetail.statusChangeDate) {
										self.userDetail.statusChangeDate = new Date(
												self.userDetail.statusChangeDate);
									}
									createUserDetail(self.userDetail);
								} else {
									updateUserDetail(self.userDetail);
									console.log('User Detail updated with id ',
											self.userDetail.id);
								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.userDetails.length; i++) {
									if (self.userDetails[i].id === id) {
										self.userDetail = angular
												.copy(self.userDetails[i]);
										console.log(
												'Copied user detail in Edit',
												self.userDetail);
										if (self.userDetails[i].statusChangeDate) {
											self.userDetail.statusChangeDate = new Date(
													self.userDetails[i].statusChangeDate);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.userDetails.length; i++) {
									if (self.userDetails[i].id === id) {
										self.userDetail = angular
												.copy(self.userDetails[i]);
										console.log(
												'Copied user detail in Copy',
												self.userDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.userDetail.id === id) {
									reset();
								}
								console
										.log('calling deleteUserDetail(id);',
												id);
								deleteUserDetail(id);
							}

							function getUserRoleName(id) {
								for (var i = 0; i < self.userRoles.length; i++) {
									if (self.userRoles[i].userRoleId == id) {
										return self.userRoles[i].userRoleName;
									}
								}
							}

							function getUserDetailStatusName(code) {
								for (var i = 0; i < self.userDetailStatusNames.length; i++) {
									if (self.userDetailStatusNames[i].code === code) {
										return self.userDetailStatusNames[i].type;
									}
								}
							}

							function getUserName(id) {
								for (var i = 0; i < self.empDetails.length; i++) {
									if (self.empDetails[i].id == id) {
										return self.empDetails[i].firstName + ' ' + self.empDetails[i].lastName;
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
								self.userDetail = {
									id : null,
									empDetail : null,
									userRole : null,
									userId : '',
									pwd : '',
									userDetailStatusName : '',
									statusChangeDate : null
								};
								$scope.UserDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
'use strict';

angular
		.module('hr')
		.controller(
				'EmpDetailController',
				[
						'$scope',
						'EmpDetailService',
						function($scope, EmpDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;

							self.department = {
								deptId : null
							};

							self.designation = {
								designationId : null
							};

							self.employeeStatuse = {
								employeeStatusId : null
							};

							self.grade = {
								gradeId : null
							};

							self.location = {
								locationId : null
							};

							self.empDetail = {
								id : null,
								department : self.department,
								designation : self.designation,
								supervisorId : null,
								employeeStatus : self.employeeStatus,
								grade : self.grade,
								location : self.location,
								employeeCode : '',
								firstName : '',
								lastName : '',
								empEmail : '',
								joiningDate : null,
								previousExperience : null,
								costToCompany : null,
								officeContactNumber : ''
							};

							self.departments = [];
							self.designations = [];
							self.designationsByGrade = [];
							self.employeeStatuses = [];
							self.grades = [];
							self.locations = [];
							self.supervisors = [];
							self.empDetails = [];

							self.getDepartmentName = getDepartmentName;
							self.getDesignationName = getDesignationName;
							self.getEmployeeStatusName = getEmployeeStatusName;
							self.getGradeName = getGradeName;
							self.getOfficeLocation = getOfficeLocation;
							self.fetchAllOrderedDesignationsByGradeId = fetchAllOrderedDesignationsByGradeId;
							self.getSupervisorName = getSupervisorName;

							self.reset = reset;
							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;

							fetchAllDepartments();
							fetchAllDesignations();
							fetchAllEmployeeStatuses();
							fetchAllGrades();
							fetchAllLocations();
							fetchAllSupervisors();
							fetchAllEmpDetails();

							function fetchAllEmpDetails() {
								console
										.log("####EmpDetailController:fetchAllEmpDetails()#########");
								EmpDetailService
										.fetchAllEmpDetails()
										.then(
												function(d) {
													self.empDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching emp Details');
												});
							}

							function fetchAllDepartments() {
								console
										.log("####EmployeeController:fetchAllDepartments#########");
								EmpDetailService
										.fetchAllDepartments()
										.then(
												function(d) {
													self.departments = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Departments');
												});
							}

							function fetchAllDesignations() {
								console
										.log("####EmployeeController:fetchAllDesignations#########");
								EmpDetailService
										.fetchAllDesignations()
										.then(
												function(d) {
													self.designations = d;
													self.designationsByGrade = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Designations');
												});
							}

							function fetchAllOrderedDesignationsByGradeId(
									gradeId) {
								console
										.log(
												"####EmployeeController:fetchAllOrderedDesignationsByGradeId()#########",
												gradeId);
								EmpDetailService
										.fetchAllOrderedDesignationsByGradeId(
												gradeId)
										.then(
												function(d) {
													self.designationsByGrade = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching  Ordered Designations by Grade');
												});
							}

							function fetchAllEmployeeStatuses() {
								console
										.log("####EmployeeController:fetchAllEmployeeStatuses#########");
								EmpDetailService
										.fetchAllEmployeeStatuses()
										.then(
												function(d) {
													self.employeeStatuses = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Employee Statuses');
												});
							}

							function fetchAllGrades() {
								console
										.log("####EmployeeController:fetchAllGrades#########");
								EmpDetailService
										.fetchAllGrades()
										.then(
												function(d) {
													self.grades = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Grades');
												});
							}

							function fetchAllLocations() {
								console
										.log("####EmployeeController:fetchAllLocations#########");
								EmpDetailService
										.fetchAllLocations()
										.then(
												function(d) {
													self.locations = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Locations');
												});
							}

							function fetchAllSupervisors() {
								console
										.log("####EmployeeController:fetchAllSupervisors#########");
								EmpDetailService
										.fetchAllSupervisors()
										.then(
												function(d) {
													self.supervisors = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Supervisors');
												});
							}

							function getSupervisorName(supervisorId) {
								for (var i = 0; i < self.supervisors.length; i++) {
									if (self.supervisors[i].supervisorId === supervisorId) {
										var send = self.supervisors[i].firstName
												+ ' '
												+ self.supervisors[i].lastName;
										return send;
									}
								}
							}

							function getDepartmentName(deptId) {
								for (var i = 0; i < self.departments.length; i++) {
									if (self.departments[i].deptId === deptId) {
										return self.departments[i].deptName;
									}
								}
							}

							function getDesignationName(designationId) {
								for (var i = 0; i < self.designations.length; i++) {
									if (self.designations[i].designationId === designationId) {
										return self.designations[i].designationName;
									}
								}
							}
							function getEmployeeStatusName(employeeStatusId) {
								for (var i = 0; i < self.employeeStatuses.length; i++) {
									if (self.employeeStatuses[i].employeeStatusId === employeeStatusId) {
										return self.employeeStatuses[i].employeeStatusName;
									}
								}
							}

							function getGradeName(gradeId) {
								for (var i = 0; i < self.grades.length; i++) {
									if (self.grades[i].gradeId === gradeId) {
										return self.grades[i].gradeName;
									}
								}
							}
							function getOfficeLocation(locationId) {
								for (var i = 0; i < self.locations.length; i++) {
									if (self.locations[i].locationId === locationId) {
										return self.locations[i].office;
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

							function createEmpDetail(empDetail) {
								console.log('creating Emp Detail',
										self.empDetail);
								EmpDetailService
										.createEmpDetail(self.empDetail)
										.then(
												fetchAllEmpDetails,
												function(errResponse) {
													console
															.error('Error while creating Emp Detail');
												});
							}

							function updateEmpDetail(empDetail) {
								EmpDetailService
										.updateEmpDetail(empDetail)
										.then(
												fetchAllEmpDetails,
												function(errResponse) {
													console
															.error('Error while updating Emp Detail');
												});
							}

							function submit() {

								if (self.empDetail.id === null) {
									console.log('Saving New Emp Detail',
											self.empDetail);
									self.empDetail.joiningDate = new Date(
											self.empDetail.joiningDate);

									createEmpDetail(self.empDetail);
								} else {
									updateEmpDetail(self.empDetail);
									console.log('Emp Detail updated with id ',
											self.empDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function copyView(id) {
								for (var i = 0; i < self.empDetails.length; i++) {
									if (self.empDetails[i].id === id) {
										self.empDetail = angular
												.copy(self.empDetails[i]);
										console.log(
												'Copied Emp detail in Copy',
												self.empDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function deleteEmpDetail(id) {
								console
										.log(
												'calling controller deleteEmpDetail(id);',
												id);
								EmpDetailService
										.deleteEmpDetail(id)
										.then(
												fetchAllEmpDetails,
												function(errResponse) {
													console
															.error('Error while deleting Emp Detail');
												});
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.empDetail.id === id) {
									reset();
								}
								console.log('calling deleteEmpDetail(id);', id);
								deleteEmpDetail(id);
							}

							function edit(id) {
								for (var i = 0; i < self.empDetails.length; i++) {
									if (self.empDetails[i].id === id) {
										self.empDetail = angular
												.copy(self.empDetails[i]);
										console.log('Copied Employee in Edit',
												self.empDetail);

										self.empDetail.joiningDate = new Date(
												self.empDetail.joiningDate);
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function reset() {
								self.empDetail = {
									id : null,
									department : null,
									designation : null,
									supervisorId : null,
									employeeStatus : null,
									grade : null,
									location : null,
									employeeCode : '',
									firstName : '',
									lastName : '',
									empEmail : '',
									joiningDate : null,
									previousExperience : null,
									costToCompany : null,
									officeContactNumber : ''
								};
								$scope.EmpDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
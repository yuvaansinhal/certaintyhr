'use strict';

angular
		.module('hr')
		.controller(
				'EmpEducationDetailController',
				[
						'$scope',
						'EmpEducationDetailService',
						function($scope, EmpEducationDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;

							self.empDetail = {
								id : null
							};
							self.educationCourse = {
								courseId : null
							};
							self.specializationStream = {
								streamId : null
							};

							self.empEducationDetail = {
								id : null,
								educationCourse : self.educationCourse,
								empDetail : self.empDetail,
								specializationStream : self.specializationStream,
								courseFromDate : null,
								courseToDate : null,
								levelOfCourse : '',
								universityName : '',
								instituteName : '',
								yearOfPassing : null,
								percentage : ''
							};

							self.empEducationDetails = [];
							self.empDetails = [];
							self.educationCourses = [];
							self.specializationStreams = [];

							self.levelOfCourses = [ {
								type : "Graduate",
								code : "GRADUATE"
							}, {
								type : "Post-Graduate",
								code : "POST_GRADUATE"
							}, {
								type : "Doctorate",
								code : "DOCTORATE"
							} ];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.getEmployeeName = getEmployeeName;
							self.getStreamName = getStreamName;
							self.getCourseName = getCourseName;
							self.getLevelOfCourse = getLevelOfCourse;

							fetchAllempEducationDetails();
							fetchAllEmpDetails();
							fetchAllEducationCourses();
							fetchAllSpecializationStreams();

							function fetchAllempEducationDetails() {
								console
										.log("####EmpEducationDetailController:fetchAllempEducationDetails()#########");
								EmpEducationDetailService
										.fetchAllempEducationDetails()
										.then(
												function(d) {
													self.empEducationDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpEducation Details');
												});
							}

							function fetchAllEmpDetails() {
								console
										.log("####EmpEducationDetailController:fetchAllEmpDetails()#########");
								EmpEducationDetailService
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

							function fetchAllEducationCourses() {
								console
										.log("####EmpEducationDetailController:fetchAllEducationCourses#########");
								EmpEducationDetailService
										.fetchAllEducationCourses()
										.then(
												function(d) {
													self.educationCourses = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Education Courses');
												});
							}

							function fetchAllSpecializationStreams() {
								console
										.log("####EmpEducationDetailController:fetchAllSpecializationStreams#########");
								EmpEducationDetailService
										.fetchAllSpecializationStreams()
										.then(
												function(d) {
													self.specializationStreams = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching all Specialization Streams');
												});
							}

							function createEmpEducationDetail(
									empEducationDetail) {
								EmpEducationDetailService
										.createEmpEducationDetail(
												empEducationDetail)
										.then(
												fetchAllempEducationDetails,
												function(errResponse) {
													console
															.error('Error while creating Emp Educations Detail');
												});
							}

							function updateEmpEducationDetail(
									empEducationDetail) {
								EmpEducationDetailService
										.updateEmpEducationDetail(
												empEducationDetail)
										.then(
												fetchAllempEducationDetails,
												function(errResponse) {
													console
															.error('Error while updating Emp Education Detail');
												});
							}

							function deleteEmpEducationDetail(id) {
								console
										.log(
												'calling controller deleteEmpEducationDetail(id);',
												id);
								EmpEducationDetailService
										.deleteEmpEducationDetail(id)
										.then(
												fetchAllempEducationDetails,
												function(errResponse) {
													console
															.error('Error while deleting Emp Education Detail ');
												});
							}

							function submit() {
								if (self.empEducationDetail.id === null) {
									console.log(
											'Saving New Emp Education Detail ',
											self.empEducationDetail);
									self.empEducationDetail.courseFromDate = new Date(
											self.empEducationDetail.courseFromDate);
									if (self.empEducationDetail.courseToDate) {
										self.empEducationDetail.courseToDate = new Date(
												self.empEducationDetail.courseToDate);
									}
									createEmpEducationDetail(self.empEducationDetail);
								} else {
									updateEmpEducationDetail(self.empEducationDetail);
									console
											.log(
													'Emp Education Detail  updated with id ',
													self.empEducationDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.empEducationDetails.length; i++) {
									if (self.empEducationDetails[i].id === id) {
										self.empEducationDetail = angular
												.copy(self.empEducationDetails[i]);
										console
												.log(
														'Copied Emp Education detail  in Edit',
														self.empEducationDetail);
										self.empEducationDetail.courseFromDate = new Date(
												self.empEducationDetail.courseFromDate);
										if (self.empEducationDetails[i].statusChangeDate) {
											self.empEducationDetails.statusChangeDate = new Date(
													self.empEducationDetails[i].statusChangeDate);
										}

										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.empEducationDetails.length; i++) {
									if (self.empEducationDetails[i].id === id) {
										self.empEducationDetail = angular
												.copy(self.empEducationDetails[i]);
										console
												.log(
														'Copied Emp Education detail  in Copy',
														self.empEducationDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.empEducationDetail.id === id) {
									reset();
								}
								console
										.log(
												'calling deleteEmpEducationDetail(id);',
												id);
								deleteEmpEducationDetail(id);
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

							function getStreamName(streamId) {
								for (var i = 0; i < self.specializationStreams.length; i++) {
									if (self.specializationStreams[i].streamId === streamId) {
										return self.specializationStreams[i].streamName;
									}
								}
							}

							function getCourseName(courseId) {
								for (var i = 0; i < self.educationCourses.length; i++) {
									if (self.educationCourses[i].courseId === courseId) {
										return self.educationCourses[i].courseName;
									}
								}
							}

							function getLevelOfCourse(code) {
								for (var i = 0; i < self.levelOfCourses.length; i++) {
									if (self.levelOfCourses[i].code === code) {
										return self.levelOfCourses[i].type;
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
								self.empEducationDetail = {
									id : null,
									educationCourse : null,
									empDetail : null,
									specializationStream : null,
									courseFromDate : null,
									courseToDate : null,
									levelOfCourse : '',
									universityName : '',
									instituteName : '',
									yearOfPassing : null,
									percentage : ''
								};
								$scope.EmpEducationDetailForm.$setPristine(); // reset
								// Form
							}

						} ]);
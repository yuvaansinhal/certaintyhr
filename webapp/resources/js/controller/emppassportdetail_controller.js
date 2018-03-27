'use strict';

angular
		.module('hr')
		.controller(
				'EmpPassportDetailController',
				[
						'$scope',
						'EmpPassportDetailService',
						function($scope, EmpPassportDetailService) {
							var self = this;
							self.hideAddEdit = true;
							self.hideView = true;

							self.empDetail = {
								id : null
							};

							self.empPassportDetail = {
								id : null,
								empDetail : self.empDetail,
								passportStatus : '',
								passportNumber : '',
								placeOfBirth : '',
								placeIssued : '',
								passportIssuedDate : null,
								passportValidTillDate : null,
								citezenship : '',
								visaStatus : '',
								visaType : '',
								visaCountry : '',
								visaValidTill : null
							};

							self.empPassportDetails = [];
							self.empDetails = [];

							self.submit = submit;
							self.edit = edit;
							self.remove = remove;
							self.reset = reset;
							self.hideAddEditDiv = hideAddEditDiv;
							self.showViewDiv = showViewDiv;
							self.copyView = copyView;
							self.getEmployeeName = getEmployeeName;

							self.getPassportStatusType = getPassportStatusType;
							self.getVisaStatusType = getVisaStatusType;
							self.getVisaType = getVisaType;
							self.getCountryType = getCountryType;

							fetchAllEmpPassportDetails();
							fetchAllOrderedEmpDetails();

							function fetchAllEmpPassportDetails() {
								console
										.log("####EmpPassportDetailController:fetchAllEmpPassportDetails()#########");
								EmpPassportDetailService
										.fetchAllEmpPassportDetails()
										.then(
												function(d) {
													self.empPassportDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching EmpPassport Details');
												});
							}

							function fetchAllOrderedEmpDetails() {
								console
										.log("####EmpPassportDetailController:fetchAllOrderedEmpDetails()#########");
								EmpPassportDetailService
										.fetchAllOrderedEmpDetails()
										.then(
												function(d) {
													self.empDetails = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Emp Details');
												});
							}

							function createEmpPassportDetail(empPassportDetail) {
								EmpPassportDetailService
										.createEmpPassportDetail(
												empPassportDetail)
										.then(
												fetchAllEmpPassportDetails,
												function(errResponse) {
													console
															.error('Error while creating EmpPassport Detail');
												});
							}

							function updateEmpPassportDetail(empPassportDetail) {
								EmpPassportDetailService
										.updateEmpPassportDetail(
												empPassportDetail)
										.then(
												fetchAllEmpPassportDetails,
												function(errResponse) {
													console
															.error('Error while updating EmpPassport Detail');
												});
							}

							function deleteEmpPassportDetail(id) {
								console
										.log(
												'calling controller deleteEmpPassportDetail(id);',
												id);
								EmpPassportDetailService
										.deleteEmpPassportDetail(id)
										.then(
												fetchAllEmpPassportDetails,
												function(errResponse) {
													console
															.error('Error while deleting EmpPassport Detail ');
												});
							}

							function submit() {
								if (self.empPassportDetail.id === null) {
									console.log(
											'Saving New Passport Resource ',
											self.empPassportDetail);

									self.empPassportDetail.passportIssuedDate = new Date(
											self.empPassportDetail.passportIssuedDate);
									self.empPassportDetail.passportValidTillDate = new Date(
											self.empPassportDetail.passportValidTillDate);
									if (self.empPassportDetail.visaValidTill) {
										self.empPassportDetail.visaValidTill = new Date(
												self.empPassportDetail.visaValidTill);
									}
									createEmpPassportDetail(self.empPassportDetail);
								} else {
									updateEmpPassportDetail(self.empPassportDetail);
									console
											.log(
													'EmpPassport Detail  updated with id ',
													self.empPassportDetail.id);

								}
								reset();
								self.hideAddEdit = true;
							}

							function edit(id) {
								for (var i = 0; i < self.empPassportDetails.length; i++) {
									if (self.empPassportDetails[i].id === id) {
										self.empPassportDetail = angular
												.copy(self.empPassportDetails[i]);
										console
												.log(
														'Copied empPassport detail  in Edit',
														self.empPassportDetail);
										self.empPassportDetail.passportIssuedDate = new Date(
												self.empPassportDetail.passportIssuedDate);
										self.empPassportDetail.passportValidTillDate = new Date(
												self.empPassportDetail.passportValidTillDate);
										if (self.empPassportDetail.visaValidTill) {
											self.empPassportDetail.visaValidTill = new Date(
													self.empPassportDetail.visaValidTill);
										}
										break;
									}
								}
								self.hideView = true;
								self.hideAddEdit = false;
							}

							function copyView(id) {
								for (var i = 0; i < self.empPassportDetails.length; i++) {
									if (self.empPassportDetails[i].id === id) {
										self.empPassportDetail = angular
												.copy(self.empPassportDetails[i]);
										console
												.log(
														'Copied project resource  in Copy',
														self.empPassportDetail);
										break;
									}
								}
								self.hideAddEdit = true;
								self.hideView = false;
							}

							function remove(id) {
								console.log('id to be deleted', id);
								if (self.empPassportDetail.id === id) {
									reset();
								}
								console.log(
										'calling deleteEmpPassportDetail(id);',
										id);
								deleteEmpPassportDetail(id);
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
								self.empPassportDetail = {
									id : null,
									empDetail : null,
									passportStatus : '',
									passportNumber : '',
									placeOfBirth : '',
									placeIssued : '',
									passportIssuedDate : null,
									passportValidTillDate : null,
									citezenship : '',
									visaStatus : '',
									visaType : '',
									visaCountry : '',
									visaValidTill : null
								};
								$scope.EmpPassportDetailForm.$setPristine(); // reset
								// Form
							}

							self.passportStatuses = [ {
								type : "Valid",
								code : "1"
							}, {
								type : "Expired",
								code : "2"
							} ];

							function getPassportStatusType(code) {
								for (var i = 0; i < self.passportStatuses.length; i++) {
									if (self.passportStatuses[i].code === code) {
										return self.passportStatuses[i].type;
									}
								}
							}

							self.visaStatuses = [ {
								type : "Valid",
								code : "1"
							}, {
								type : "Expired",
								code : "2"
							}, {
								type : "Banned",
								code : "3"
							} ];

							function getVisaStatusType(code) {
								for (var i = 0; i < self.visaStatuses.length; i++) {
									if (self.visaStatuses[i].code === code) {
										return self.visaStatuses[i].type;
									}
								}
							}

							self.visaTypes = [ {
								type : "Business",
								code : "1"
							}, {
								type : "Work",
								code : "2"
							}, {
								type : "Visit",
								code : "3"
							} ];
							function getVisaType(code) {
								for (var i = 0; i < self.visaTypes.length; i++) {
									if (self.visaTypes[i].code === code) {
										return self.visaTypes[i].type;
									}
								}
							}

							self.countries = [ {
								type : "	Afghanistan	",
								code : "	1	"
							}, {
								type : "	Albania	",
								code : "	2	"
							}, {
								type : "	Algeria	",
								code : "	3	"
							}, {
								type : "	American Samoa	",
								code : "	4	"
							}, {
								type : "	Andorra	",
								code : "	5	"
							}, {
								type : "	Angola	",
								code : "	6	"
							}, {
								type : "	Anguilla	",
								code : "	7	"
							}, {
								type : "	Antigua and Barbuda	",
								code : "	8	"
							}, {
								type : "	Argentina	",
								code : "	9	"
							}, {
								type : "	Armenia	",
								code : "	10	"
							}, {
								type : "	Aruba	",
								code : "	11	"
							}, {
								type : "	Australia	",
								code : "	12	"
							}, {
								type : "	Austria	",
								code : "	13	"
							}, {
								type : "	Azerbaijan	",
								code : "	14	"
							}, {
								type : "	Bahamas	",
								code : "	15	"
							}, {
								type : "	Bahrain	",
								code : "	16	"
							}, {
								type : "	Bangladesh	",
								code : "	17	"
							}, {
								type : "	Barbados	",
								code : "	18	"
							}, {
								type : "	Belarus	",
								code : "	19	"
							}, {
								type : "	Belgium	",
								code : "	20	"
							}, {
								type : "	Belize	",
								code : "	21	"
							}, {
								type : "	Benin	",
								code : "	22	"
							}, {
								type : "	Bermuda	",
								code : "	23	"
							}, {
								type : "	Bhutan	",
								code : "	24	"
							}, {
								type : "	Bolivia	",
								code : "	25	"
							}, {
								type : "	Bosnia and Herzegovina	",
								code : "	26	"
							}, {
								type : "	Botswana	",
								code : "	27	"
							}, {
								type : "	Brazil	",
								code : "	28	"
							}, {
								type : "	British Virgin Islands	",
								code : "	29	"
							}, {
								type : "	Brunei	",
								code : "	30	"
							}, {
								type : "	Bulgaria	",
								code : "	31	"
							}, {
								type : "	Burkina Faso	",
								code : "	32	"
							}, {
								type : "	Burundi	",
								code : "	33	"
							}, {
								type : "	Côte d'Ivoire	",
								code : "	34	"
							}, {
								type : "	Cabo Verde	",
								code : "	35	"
							}, {
								type : "	Cambodia	",
								code : "	36	"
							}, {
								type : "	Cameroon	",
								code : "	37	"
							}, {
								type : "	Canada	",
								code : "	38	"
							}, {
								type : "	Caribbean Netherlands	",
								code : "	39	"
							}, {
								type : "	Cayman Islands	",
								code : "	40	"
							}, {
								type : "	Central African Republic	",
								code : "	41	"
							}, {
								type : "	Chad	",
								code : "	42	"
							}, {
								type : "	Channel Islands	",
								code : "	43	"
							}, {
								type : "	Chile	",
								code : "	44	"
							}, {
								type : "	China	",
								code : "	45	"
							}, {
								type : "	Colombia	",
								code : "	46	"
							}, {
								type : "	Comoros	",
								code : "	47	"
							}, {
								type : "	Congo (Congo-Brazzaville)	",
								code : "	48	"
							}, {
								type : "	Cook Islands	",
								code : "	49	"
							}, {
								type : "	Costa Rica	",
								code : "	50	"
							}, {
								type : "	Croatia	",
								code : "	51	"
							}, {
								type : "	Cuba	",
								code : "	52	"
							}, {
								type : "	Curaçao	",
								code : "	53	"
							}, {
								type : "	Cyprus	",
								code : "	54	"
							}, {
								type : "	Czech Republic	",
								code : "	55	"
							}, {
								type : "	Democratic Republic of the Congo	",
								code : "	56	"
							}, {
								type : "	Denmark	",
								code : "	57	"
							}, {
								type : "	Djibouti	",
								code : "	58	"
							}, {
								type : "	Dominica	",
								code : "	59	"
							}, {
								type : "	Dominican Republic	",
								code : "	60	"
							}, {
								type : "	Ecuador	",
								code : "	61	"
							}, {
								type : "	Egypt	",
								code : "	62	"
							}, {
								type : "	El Salvador	",
								code : "	63	"
							}, {
								type : "	Equatorial Guinea	",
								code : "	64	"
							}, {
								type : "	Eritrea	",
								code : "	65	"
							}, {
								type : "	Estonia	",
								code : "	66	"
							}, {
								type : "	Ethiopia	",
								code : "	67	"
							}, {
								type : "	Faeroe Islands	",
								code : "	68	"
							}, {
								type : "	Falkland Islands (Islas Malvinas)	",
								code : "	69	"
							}, {
								type : "	Fiji	",
								code : "	70	"
							}, {
								type : "	Finland	",
								code : "	71	"
							}, {
								type : "	France	",
								code : "	72	"
							}, {
								type : "	French Guiana	",
								code : "	73	"
							}, {
								type : "	French Polynesia	",
								code : "	74	"
							}, {
								type : "	Gabon	",
								code : "	75	"
							}, {
								type : "	Gambia	",
								code : "	76	"
							}, {
								type : "	Georgia	",
								code : "	77	"
							}, {
								type : "	Germany	",
								code : "	78	"
							}, {
								type : "	Ghana	",
								code : "	79	"
							}, {
								type : "	Gibraltar	",
								code : "	80	"
							}, {
								type : "	Greece	",
								code : "	81	"
							}, {
								type : "	Greenland	",
								code : "	82	"
							}, {
								type : "	Grenada	",
								code : "	83	"
							}, {
								type : "	Guadeloupe	",
								code : "	84	"
							}, {
								type : "	Guam	",
								code : "	85	"
							}, {
								type : "	Guatemala	",
								code : "	86	"
							}, {
								type : "	Guinea	",
								code : "	87	"
							}, {
								type : "	Guinea-Bissau	",
								code : "	88	"
							}, {
								type : "	Guyana	",
								code : "	89	"
							}, {
								type : "	Haiti	",
								code : "	90	"
							}, {
								type : "	Holy See	",
								code : "	91	"
							}, {
								type : "	Honduras	",
								code : "	92	"
							}, {
								type : "	Hong Kong (S.A.R. of China)	",
								code : "	93	"
							}, {
								type : "	Hungary	",
								code : "	94	"
							}, {
								type : "	Iceland	",
								code : "	95	"
							}, {
								type : "	India	",
								code : "	96	"
							}, {
								type : "	Indonesia	",
								code : "	97	"
							}, {
								type : "	Iran	",
								code : "	98	"
							}, {
								type : "	Iraq	",
								code : "	99	"
							}, {
								type : "	Ireland	",
								code : "	100	"
							}, {
								type : "	Isle of Man	",
								code : "	101	"
							}, {
								type : "	Israel	",
								code : "	102	"
							}, {
								type : "	Italy	",
								code : "	103	"
							}, {
								type : "	Jamaica	",
								code : "	104	"
							}, {
								type : "	Japan	",
								code : "	105	"
							}, {
								type : "	Jordan	",
								code : "	106	"
							}, {
								type : "	Kazakhstan	",
								code : "	107	"
							}, {
								type : "	Kenya	",
								code : "	108	"
							}, {
								type : "	Kiribati	",
								code : "	109	"
							}, {
								type : "	Kuwait	",
								code : "	110	"
							}, {
								type : "	Kyrgyzstan	",
								code : "	111	"
							}, {
								type : "	Laos	",
								code : "	112	"
							}, {
								type : "	Latvia	",
								code : "	113	"
							}, {
								type : "	Lebanon	",
								code : "	114	"
							}, {
								type : "	Lesotho	",
								code : "	115	"
							}, {
								type : "	Liberia	",
								code : "	116	"
							}, {
								type : "	Libya	",
								code : "	117	"
							}, {
								type : "	Liechtenstein	",
								code : "	118	"
							}, {
								type : "	Lithuania	",
								code : "	119	"
							}, {
								type : "	Luxembourg	",
								code : "	120	"
							}, {
								type : "	Macao (S.A.R. of China)	",
								code : "	121	"
							}, {
								type : "	Macedonia (FYROM)	",
								code : "	122	"
							}, {
								type : "	Madagascar	",
								code : "	123	"
							}, {
								type : "	Malawi	",
								code : "	124	"
							}, {
								type : "	Malaysia	",
								code : "	125	"
							}, {
								type : "	Maldives	",
								code : "	126	"
							}, {
								type : "	Mali	",
								code : "	127	"
							}, {
								type : "	Malta	",
								code : "	128	"
							}, {
								type : "	Marshall Islands	",
								code : "	129	"
							}, {
								type : "	Martinique	",
								code : "	130	"
							}, {
								type : "	Mauritania	",
								code : "	131	"
							}, {
								type : "	Mauritius	",
								code : "	132	"
							}, {
								type : "	Mayotte	",
								code : "	133	"
							}, {
								type : "	Mexico	",
								code : "	134	"
							}, {
								type : "	Micronesia	",
								code : "	135	"
							}, {
								type : "	Moldova	",
								code : "	136	"
							}, {
								type : "	Monaco	",
								code : "	137	"
							}, {
								type : "	Mongolia	",
								code : "	138	"
							}, {
								type : "	Montenegro	",
								code : "	139	"
							}, {
								type : "	Montserrat	",
								code : "	140	"
							}, {
								type : "	Morocco	",
								code : "	141	"
							}, {
								type : "	Mozambique	",
								code : "	142	"
							}, {
								type : "	Myanmar (formerly Burma)	",
								code : "	143	"
							}, {
								type : "	Namibia	",
								code : "	144	"
							}, {
								type : "	Nauru	",
								code : "	145	"
							}, {
								type : "	Nepal	",
								code : "	146	"
							}, {
								type : "	Netherlands	",
								code : "	147	"
							}, {
								type : "	New Caledonia	",
								code : "	148	"
							}, {
								type : "	New Zealand	",
								code : "	149	"
							}, {
								type : "	Nicaragua	",
								code : "	150	"
							}, {
								type : "	Niger	",
								code : "	151	"
							}, {
								type : "	Nigeria	",
								code : "	152	"
							}, {
								type : "	Niue	",
								code : "	153	"
							}, {
								type : "	North Korea	",
								code : "	154	"
							}, {
								type : "	Northern Mariana Islands	",
								code : "	155	"
							}, {
								type : "	Norway	",
								code : "	156	"
							}, {
								type : "	Oman	",
								code : "	157	"
							}, {
								type : "	Pakistan	",
								code : "	158	"
							}, {
								type : "	Palau	",
								code : "	159	"
							}, {
								type : "	Palestine State	",
								code : "	160	"
							}, {
								type : "	Panama	",
								code : "	161	"
							}, {
								type : "	Papua New Guinea	",
								code : "	162	"
							}, {
								type : "	Paraguay	",
								code : "	163	"
							}, {
								type : "	Peru	",
								code : "	164	"
							}, {
								type : "	Philippines	",
								code : "	165	"
							}, {
								type : "	Poland	",
								code : "	166	"
							}, {
								type : "	Portugal	",
								code : "	167	"
							}, {
								type : "	Puerto Rico	",
								code : "	168	"
							}, {
								type : "	Qatar	",
								code : "	169	"
							}, {
								type : "	Réunion	",
								code : "	170	"
							}, {
								type : "	Romania	",
								code : "	171	"
							}, {
								type : "	Russia	",
								code : "	172	"
							}, {
								type : "	Rwanda	",
								code : "	173	"
							}, {
								type : "	Saint Helena	",
								code : "	174	"
							}, {
								type : "	Saint Kitts and Nevis	",
								code : "	175	"
							}, {
								type : "	Saint Lucia	",
								code : "	176	"
							}, {
								type : "	Saint Pierre and Miquelon	",
								code : "	177	"
							}, {
								type : "	Saint Vincent and the Grenadines	",
								code : "	178	"
							}, {
								type : "	Samoa	",
								code : "	179	"
							}, {
								type : "	San Marino	",
								code : "	180	"
							}, {
								type : "	Sao Tome and Principe	",
								code : "	181	"
							}, {
								type : "	Saudi Arabia	",
								code : "	182	"
							}, {
								type : "	Senegal	",
								code : "	183	"
							}, {
								type : "	Serbia	",
								code : "	184	"
							}, {
								type : "	Seychelles	",
								code : "	185	"
							}, {
								type : "	Sierra Leone	",
								code : "	186	"
							}, {
								type : "	Singapore	",
								code : "	187	"
							}, {
								type : "	Sint Maarten	",
								code : "	188	"
							}, {
								type : "	Slovakia	",
								code : "	189	"
							}, {
								type : "	Slovenia	",
								code : "	190	"
							}, {
								type : "	Solomon Islands	",
								code : "	191	"
							}, {
								type : "	Somalia	",
								code : "	192	"
							}, {
								type : "	South Africa	",
								code : "	193	"
							}, {
								type : "	South Korea	",
								code : "	194	"
							}, {
								type : "	South Sudan	",
								code : "	195	"
							}, {
								type : "	Spain	",
								code : "	196	"
							}, {
								type : "	Sri Lanka	",
								code : "	197	"
							}, {
								type : "	Sudan	",
								code : "	198	"
							}, {
								type : "	Suriname	",
								code : "	199	"
							}, {
								type : "	Swaziland	",
								code : "	200	"
							}, {
								type : "	Sweden	",
								code : "	201	"
							}, {
								type : "	Switzerland	",
								code : "	202	"
							}, {
								type : "	Syria	",
								code : "	203	"
							}, {
								type : "	Taiwan	",
								code : "	204	"
							}, {
								type : "	Tajikistan	",
								code : "	205	"
							}, {
								type : "	Tanzania	",
								code : "	206	"
							}, {
								type : "	Thailand	",
								code : "	207	"
							}, {
								type : "	Timor-Leste	",
								code : "	208	"
							}, {
								type : "	Togo	",
								code : "	209	"
							}, {
								type : "	Tokelau	",
								code : "	210	"
							}, {
								type : "	Tonga	",
								code : "	211	"
							}, {
								type : "	Trinidad and Tobago	",
								code : "	212	"
							}, {
								type : "	Tunisia	",
								code : "	213	"
							}, {
								type : "	Turkey	",
								code : "	214	"
							}, {
								type : "	Turkmenistan	",
								code : "	215	"
							}, {
								type : "	Turks and Caicos Islands	",
								code : "	216	"
							}, {
								type : "	Tuvalu	",
								code : "	217	"
							}, {
								type : "	Uganda	",
								code : "	218	"
							}, {
								type : "	Ukraine	",
								code : "	219	"
							}, {
								type : "	United Arab Emirates	",
								code : "	220	"
							}, {
								type : "	United Kingdom	",
								code : "	221	"
							}, {
								type : "	United States of America	",
								code : "	222	"
							}, {
								type : "	United States Virgin Islands	",
								code : "	223	"
							}, {
								type : "	Uruguay	",
								code : "	224	"
							}, {
								type : "	Uzbekistan	",
								code : "	225	"
							}, {
								type : "	Vanuatu	",
								code : "	226	"
							}, {
								type : "	Venezuela	",
								code : "	227	"
							}, {
								type : "	Viet Nam	",
								code : "	228	"
							}, {
								type : "	Wallis and Futuna Islands	",
								code : "	229	"
							}, {
								type : "	Western Sahara	",
								code : "	230	"
							}, {
								type : "	Yemen	",
								code : "	231	"
							}, {
								type : "	Zambia	",
								code : "	232	"
							},

							{
								type : "	Zimbabwe	",
								code : "	233	"
							}

							]

							function getCountryType(code) {
								for (var i = 0; i < self.countries.length; i++) {
									if (self.countries[i].code === code) {
										return self.countries[i].type;
									}
								}
							}

						} ]);
package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model class to represent EmpDetail
 * 
 */

@Entity
@Table(name = "emp_detail", uniqueConstraints = { @UniqueConstraint(columnNames = "emp_email"),
		@UniqueConstraint(columnNames = "employee_code") })
public class EmpDetail implements Comparable<EmpDetail>, java.io.Serializable {
	private static final long serialVersionUID = -7475239539524607705L;
	private Integer id;
	private Department department;
	private Designation designation;
	private Integer supervisorId;
	private EmployeeStatus employeeStatus;
	private Grade grade;
	private Location location;
	private String employeeCode;
	private String firstName;
	private String lastName;
	private String empEmail;
	private Date joiningDate;
	private Integer previousExperience;
	private Double costToCompany;
	private String officeContactNumber;
	private Set<EmpContactDetail> empContactDetails = new HashSet<EmpContactDetail>(0);
	private Set<EmpProjectDetail> empProjectDetails = new HashSet<EmpProjectDetail>(0);
	private Set<EmpPassportDetail> empPassportDetails = new HashSet<EmpPassportDetail>(0);
	private Set<EmpSkillDetail> empSkillDetails = new HashSet<EmpSkillDetail>(0);
	private Set<ProjectResource> projectResources = new HashSet<ProjectResource>(0);
	private Set<EmpEducationDetail> empEducationDetails = new HashSet<EmpEducationDetail>(0);
	private Set<UserDetail> userDetails = new HashSet<UserDetail>(0);
	private Set<WorkExperienceDetail> workExperienceDetails = new HashSet<WorkExperienceDetail>(0);
	private Set<EmpPersonalDetail> empPersonalDetails = new HashSet<EmpPersonalDetail>(0);

	public EmpDetail() {
	}

	public EmpDetail(Department department, Designation designation, Grade grade, Location location,
			String employeeCode, String firstName, String empEmail, Date joiningDate, Integer previousExperience,
			Double costToCompany, String officeContactNumber) {
		this.department = department;
		this.designation = designation;
		this.grade = grade;
		this.location = location;
		this.employeeCode = employeeCode;
		this.firstName = firstName;
		this.empEmail = empEmail;
		this.joiningDate = joiningDate;
		this.previousExperience = previousExperience;
		this.costToCompany = costToCompany;
		this.officeContactNumber = officeContactNumber;
	}

	public EmpDetail(Department department, Designation designation, Integer supervisorId,
			EmployeeStatus employeeStatus, Grade grade, Location location, String employeeCode, String firstName,
			String lastName, String empEmail, Date joiningDate, Integer previousExperience, Double costToCompany,
			String officeContactNumber, Set<EmpContactDetail> empContactDetails,
			Set<EmpProjectDetail> empProjectDetails, Set<EmpDetail> empDetails,
			Set<EmpPassportDetail> empPassportDetails, Set<EmpSkillDetail> empSkillDetails,
			Set<ProjectResource> projectResources, Set<EmpEducationDetail> empEducationDetails,
			Set<UserDetail> userDetails, Set<WorkExperienceDetail> workExperienceDetails,
			Set<EmpPersonalDetail> empPersonalDetails) {
		this.department = department;
		this.designation = designation;
		this.supervisorId = supervisorId;
		this.employeeStatus = employeeStatus;
		this.grade = grade;
		this.location = location;
		this.employeeCode = employeeCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empEmail = empEmail;
		this.joiningDate = joiningDate;
		this.previousExperience = previousExperience;
		this.costToCompany = costToCompany;
		this.officeContactNumber = officeContactNumber;
		this.empContactDetails = empContactDetails;
		this.empProjectDetails = empProjectDetails;
		this.empPassportDetails = empPassportDetails;
		this.empSkillDetails = empSkillDetails;
		this.projectResources = projectResources;
		this.empEducationDetails = empEducationDetails;
		this.userDetails = userDetails;
		this.workExperienceDetails = workExperienceDetails;
		this.empPersonalDetails = empPersonalDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_id", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "designation_id", nullable = false)
	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Column(name = "supervisor_id", length = 8)
	public Integer getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(Integer supervisorId) {
		this.supervisorId = supervisorId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_status_id")
	public EmployeeStatus getEmployeeStatus() {
		return this.employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grade_id", nullable = false)
	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "location_id", nullable = false)
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Column(name = "employee_code", unique = true, nullable = false, length = 16)
	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Column(name = "first_name", nullable = false, length = 64)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 64)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "emp_email", unique = true, nullable = false, length = 128)
	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "joining_date", nullable = false, length = 10)
	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Column(name = "previous_experience", nullable = false)
	public Integer getPreviousExperience() {
		return this.previousExperience;
	}

	public void setPreviousExperience(Integer previousExperience) {
		this.previousExperience = previousExperience;
	}

	@Column(name = "cost_to_company", nullable = false, precision = 12, scale = 0)
	public Double getCostToCompany() {
		return this.costToCompany;
	}

	public void setCostToCompany(Double costToCompany) {
		this.costToCompany = costToCompany;
	}

	@Column(name = "office_contact_number", nullable = false, length = 16)
	public String getOfficeContactNumber() {
		return this.officeContactNumber;
	}

	public void setOfficeContactNumber(String officeContactNumber) {
		this.officeContactNumber = officeContactNumber;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<EmpContactDetail> getEmpContactDetails() {
		return this.empContactDetails;
	}

	public void setEmpContactDetails(Set<EmpContactDetail> empContactDetails) {
		this.empContactDetails = empContactDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<EmpProjectDetail> getEmpProjectDetails() {
		return this.empProjectDetails;
	}

	public void setEmpProjectDetails(Set<EmpProjectDetail> empProjectDetails) {
		this.empProjectDetails = empProjectDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<EmpPassportDetail> getEmpPassportDetails() {
		return this.empPassportDetails;
	}

	public void setEmpPassportDetails(Set<EmpPassportDetail> empPassportDetails) {
		this.empPassportDetails = empPassportDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<EmpSkillDetail> getEmpSkillDetails() {
		return this.empSkillDetails;
	}

	public void setEmpSkillDetails(Set<EmpSkillDetail> empSkillDetails) {
		this.empSkillDetails = empSkillDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<ProjectResource> getProjectResources() {
		return this.projectResources;
	}

	public void setProjectResources(Set<ProjectResource> projectResources) {
		this.projectResources = projectResources;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<EmpEducationDetail> getEmpEducationDetails() {
		return this.empEducationDetails;
	}

	public void setEmpEducationDetails(Set<EmpEducationDetail> empEducationDetails) {
		this.empEducationDetails = empEducationDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(Set<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<WorkExperienceDetail> getWorkExperienceDetails() {
		return this.workExperienceDetails;
	}

	public void setWorkExperienceDetails(Set<WorkExperienceDetail> workExperienceDetails) {
		this.workExperienceDetails = workExperienceDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "empDetail")
	@JsonIgnore
	public Set<EmpPersonalDetail> getEmpPersonalDetails() {
		return this.empPersonalDetails;
	}

	public void setEmpPersonalDetails(Set<EmpPersonalDetail> empPersonalDetails) {
		this.empPersonalDetails = empPersonalDetails;
	}

	@Override
	public int compareTo(EmpDetail comparedObject) {
		return (this.getFirstName() + " " + this.getLastName())
				.compareToIgnoreCase(comparedObject.getFirstName() + " " + comparedObject.getLastName());
	}
}

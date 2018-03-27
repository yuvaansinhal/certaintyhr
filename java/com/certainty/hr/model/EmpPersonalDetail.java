package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Model class to represent Employee Personal details
 * 
 */

@Entity
@Table(name = "emp_personal_detail")
public class EmpPersonalDetail implements java.io.Serializable {
	private static final long serialVersionUID = -5623640660655826381L;
	private Integer id;
	private EmpDetail empDetail;
	private String gender;
	private Date dateOfBirth;
	private String fatherName;
	private String motherName;
	private String bloodGroup;
	private String drivingLicense;
	private String drivingLicenseState;
	private String panNumber;
	private String aadharNumber;
	private String maritalStatus;
	private Date weddingDate;
	private String spouseName;
	private byte[] picture;

	public EmpPersonalDetail() {
	}

	public EmpPersonalDetail(String gender, Date dateOfBirth, String fatherName, String motherName, String bloodGroup) {
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.bloodGroup = bloodGroup;
	}

	public EmpPersonalDetail(EmpDetail empDetail, String gender, Date dateOfBirth, String fatherName, String motherName,
			String bloodGroup, String drivingLicense, String drivingLicenseState, String panNumber, String aadharNumber,
			String maritalStatus, Date weddingDate, String spouseName, byte[] picture) {
		this.empDetail = empDetail;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.bloodGroup = bloodGroup;
		this.drivingLicense = drivingLicense;
		this.drivingLicenseState = drivingLicenseState;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.maritalStatus = maritalStatus;
		this.weddingDate = weddingDate;
		this.spouseName = spouseName;
		this.picture = picture;
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
	@JoinColumn(name = "employee_id")
	public EmpDetail getEmpDetail() {
		return this.empDetail;
	}

	public void setEmpDetail(EmpDetail empDetail) {
		this.empDetail = empDetail;
	}

	@Column(name = "gender", nullable = false, length = 8)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_birth", nullable = false, length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "father_name", nullable = false, length = 64)
	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@Column(name = "mother_name", nullable = false, length = 64)
	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Column(name = "blood_group", nullable = false, length = 8)
	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Column(name = "driving_license", length = 32)
	public String getDrivingLicense() {
		return this.drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	@Column(name = "driving_license_state", length = 32)
	public String getDrivingLicenseState() {
		return this.drivingLicenseState;
	}

	public void setDrivingLicenseState(String drivingLicenseState) {
		this.drivingLicenseState = drivingLicenseState;
	}

	@Column(name = "PAN_number", length = 16)
	public String getPanNumber() {
		return this.panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	@Column(name = "Aadhar_number")
	public String getAadharNumber() {
		return this.aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Column(name = "marital_status", length = 16)
	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "wedding_date", length = 10)
	public Date getWeddingDate() {
		return this.weddingDate;
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}

	@Column(name = "spouse_name", length = 64)
	public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	@Column(name = "picture")
	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}

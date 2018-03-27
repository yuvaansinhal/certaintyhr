package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model class to represent Employee Contact Detail
 * 
 */
@Entity
@Table(name = "emp_contact_detail")
public class EmpContactDetail implements java.io.Serializable {
	private static final long serialVersionUID = -3467833626051761775L;
	private Integer id;
	private EmpDetail empDetail;
	private String personalEmail;
	private String personalContactNumber;
	private String residenceAddress;
	private String permanentAddress;
	private String emergencyContactNumber;
	private String emergencyContactName;
	private String relationWithEc;

	public EmpContactDetail() {
	}

	public EmpContactDetail(String personalEmail, String personalContactNumber, String residenceAddress,
			String permanentAddress, String emergencyContactNumber, String emergencyContactName,
			String relationWithEc) {
		this.personalEmail = personalEmail;
		this.personalContactNumber = personalContactNumber;
		this.residenceAddress = residenceAddress;
		this.permanentAddress = permanentAddress;
		this.emergencyContactNumber = emergencyContactNumber;
		this.emergencyContactName = emergencyContactName;
		this.relationWithEc = relationWithEc;
	}

	public EmpContactDetail(EmpDetail empDetail, String personalEmail, String personalContactNumber,
			String residenceAddress, String permanentAddress, String emergencyContactNumber,
			String emergencyContactName, String relationWithEc) {
		this.empDetail = empDetail;
		this.personalEmail = personalEmail;
		this.personalContactNumber = personalContactNumber;
		this.residenceAddress = residenceAddress;
		this.permanentAddress = permanentAddress;
		this.emergencyContactNumber = emergencyContactNumber;
		this.emergencyContactName = emergencyContactName;
		this.relationWithEc = relationWithEc;
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

	@Column(name = "personal_email", nullable = false, length = 128)
	public String getPersonalEmail() {
		return this.personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	@Column(name = "personal_contact_number", nullable = false, length = 16)
	public String getPersonalContactNumber() {
		return this.personalContactNumber;
	}

	public void setPersonalContactNumber(String personalContactNumber) {
		this.personalContactNumber = personalContactNumber;
	}

	@Column(name = "residence_address", nullable = false, length = 256)
	public String getResidenceAddress() {
		return this.residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	@Column(name = "permanent_address", nullable = false, length = 256)
	public String getPermanentAddress() {
		return this.permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Column(name = "emergency_contact_number", nullable = false, length = 16)
	public String getEmergencyContactNumber() {
		return this.emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	@Column(name = "emergency_contact_name", nullable = false, length = 64)
	public String getEmergencyContactName() {
		return this.emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	@Column(name = "relation_with_EC", nullable = false, length = 16)
	public String getRelationWithEc() {
		return this.relationWithEc;
	}

	public void setRelationWithEc(String relationWithEc) {
		this.relationWithEc = relationWithEc;
	}
}

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
 * Model class to represent Employee passport detail
 * 
 */
@Entity
@Table(name = "emp_passport_detail")
public class EmpPassportDetail implements java.io.Serializable {
	private static final long serialVersionUID = -2075235344505469228L;
	private Integer id;
	private EmpDetail empDetail;
	private String passportStatus;
	private String passportNumber;
	private String placeOfBirth;
	private String placeIssued;
	private Date passportIssuedDate;
	private Date passportValidTillDate;
	private String citezenship;
	private String visaStatus;
	private String visaType;
	private String visaCountry;
	private Date visaValidTill;

	public EmpPassportDetail() {
	}

	public EmpPassportDetail(String passportStatus, String passportNumber, String placeOfBirth, String placeIssued,
			Date passportIssuedDate, Date passportValidTillDate, String citezenship) {
		this.passportStatus = passportStatus;
		this.passportNumber = passportNumber;
		this.placeOfBirth = placeOfBirth;
		this.placeIssued = placeIssued;
		this.passportIssuedDate = passportIssuedDate;
		this.passportValidTillDate = passportValidTillDate;
		this.citezenship = citezenship;
	}

	public EmpPassportDetail(EmpDetail empDetail, String passportStatus, String passportNumber, String placeOfBirth,
			String placeIssued, Date passportIssuedDate, Date passportValidTillDate, String citezenship,
			String visaStatus, String visaType, String visaCountry, Date visaValidTill) {
		this.empDetail = empDetail;
		this.passportStatus = passportStatus;
		this.passportNumber = passportNumber;
		this.placeOfBirth = placeOfBirth;
		this.placeIssued = placeIssued;
		this.passportIssuedDate = passportIssuedDate;
		this.passportValidTillDate = passportValidTillDate;
		this.citezenship = citezenship;
		this.visaStatus = visaStatus;
		this.visaType = visaType;
		this.visaCountry = visaCountry;
		this.visaValidTill = visaValidTill;
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

	@Column(name = "passport_status", nullable = false, length = 16)
	public String getPassportStatus() {
		return this.passportStatus;
	}

	public void setPassportStatus(String passportStatus) {
		this.passportStatus = passportStatus;
	}

	@Column(name = "passport_number", nullable = false, length = 16)
	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	@Column(name = "place_of_birth", nullable = false, length = 32)
	public String getPlaceOfBirth() {
		return this.placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	@Column(name = "place_issued", nullable = false, length = 32)
	public String getPlaceIssued() {
		return this.placeIssued;
	}

	public void setPlaceIssued(String placeIssued) {
		this.placeIssued = placeIssued;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "passport_issued_date", nullable = false, length = 10)
	public Date getPassportIssuedDate() {
		return this.passportIssuedDate;
	}

	public void setPassportIssuedDate(Date passportIssuedDate) {
		this.passportIssuedDate = passportIssuedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "passport_valid_till_date", nullable = false, length = 10)
	public Date getPassportValidTillDate() {
		return this.passportValidTillDate;
	}

	public void setPassportValidTillDate(Date passportValidTillDate) {
		this.passportValidTillDate = passportValidTillDate;
	}

	@Column(name = "citezenship", nullable = false, length = 32)
	public String getCitezenship() {
		return this.citezenship;
	}

	public void setCitezenship(String citezenship) {
		this.citezenship = citezenship;
	}

	@Column(name = "visa_status", length = 16)
	public String getVisaStatus() {
		return this.visaStatus;
	}

	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}

	@Column(name = "visa_type", length = 16)
	public String getVisaType() {
		return this.visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	@Column(name = "visa_country", length = 32)
	public String getVisaCountry() {
		return this.visaCountry;
	}

	public void setVisaCountry(String visaCountry) {
		this.visaCountry = visaCountry;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "visa_valid_till", length = 10)
	public Date getVisaValidTill() {
		return this.visaValidTill;
	}

	public void setVisaValidTill(Date visaValidTill) {
		this.visaValidTill = visaValidTill;
	}
}

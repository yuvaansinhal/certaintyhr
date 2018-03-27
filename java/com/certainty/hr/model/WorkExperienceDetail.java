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
 * Model class to represent work experience details
 * 
 */
@Entity
@Table(name = "work_experience_detail")
public class WorkExperienceDetail implements java.io.Serializable {
	private static final long serialVersionUID = -6972235669016032658L;
	private Integer id;
	private EmpDetail empDetail;
	private IndustryType industryType;
	private String nameOfOrganization;
	private String lastPositionHeld;
	private Date durationFromDate;
	private Date durationToDate;
	private String country;

	public WorkExperienceDetail() {
	}

	public WorkExperienceDetail(String nameOfOrganization, String lastPositionHeld, Date durationFromDate,
			Date durationToDate, String country) {
		this.nameOfOrganization = nameOfOrganization;
		this.lastPositionHeld = lastPositionHeld;
		this.durationFromDate = durationFromDate;
		this.durationToDate = durationToDate;
		this.country = country;
	}

	public WorkExperienceDetail(EmpDetail empDetail, IndustryType industryType, String nameOfOrganization,
			String lastPositionHeld, Date durationFromDate, Date durationToDate, String country) {
		this.empDetail = empDetail;
		this.industryType = industryType;
		this.nameOfOrganization = nameOfOrganization;
		this.lastPositionHeld = lastPositionHeld;
		this.durationFromDate = durationFromDate;
		this.durationToDate = durationToDate;
		this.country = country;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "industry_id")
	public IndustryType getIndustryType() {
		return this.industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	@Column(name = "name_of_organization", nullable = false, length = 32)
	public String getNameOfOrganization() {
		return this.nameOfOrganization;
	}

	public void setNameOfOrganization(String nameOfOrganization) {
		this.nameOfOrganization = nameOfOrganization;
	}

	@Column(name = "last_position_held", nullable = false, length = 32)
	public String getLastPositionHeld() {
		return this.lastPositionHeld;
	}

	public void setLastPositionHeld(String lastPositionHeld) {
		this.lastPositionHeld = lastPositionHeld;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "duration_from_date", nullable = false, length = 10)
	public Date getDurationFromDate() {
		return this.durationFromDate;
	}

	public void setDurationFromDate(Date durationFromDate) {
		this.durationFromDate = durationFromDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "duration_to_date", nullable = false, length = 10)
	public Date getDurationToDate() {
		return this.durationToDate;
	}

	public void setDurationToDate(Date durationToDate) {
		this.durationToDate = durationToDate;
	}

	@Column(name = "country", nullable = false, length = 32)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}

package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model class to represent Industry Type
 * 
 */

@Entity
@Table(name = "industry_type")
public class IndustryType implements Comparable<IndustryType>, java.io.Serializable {
	private static final long serialVersionUID = -7463857129296460286L;
	private Integer industryId;
	private String industryName;
	private String industryDesc;
	private Set<ClientDetail> clientDetails = new HashSet<ClientDetail>(0);
	private Set<WorkExperienceDetail> workExperienceDetails = new HashSet<WorkExperienceDetail>(0);

	public IndustryType() {
	}

	public IndustryType(String industryName) {
		this.industryName = industryName;
	}

	public IndustryType(String industryName, String industryDesc, Set<ClientDetail> clientDetails,
			Set<WorkExperienceDetail> workExperienceDetails) {
		this.industryName = industryName;
		this.industryDesc = industryDesc;
		this.clientDetails = clientDetails;
		this.workExperienceDetails = workExperienceDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "industry_id", unique = true, nullable = false)
	public Integer getIndustryId() {
		return this.industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	@Column(name = "industry_name", nullable = false, length = 32)
	public String getIndustryName() {
		return this.industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	@Column(name = "industry_desc", length = 256)
	public String getIndustryDesc() {
		return this.industryDesc;
	}

	public void setIndustryDesc(String industryDesc) {
		this.industryDesc = industryDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "industryType")
	@JsonIgnore
	public Set<ClientDetail> getClientDetails() {
		return this.clientDetails;
	}

	public void setClientDetails(Set<ClientDetail> clientDetails) {
		this.clientDetails = clientDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "industryType")
	@JsonIgnore
	public Set<WorkExperienceDetail> getWorkExperienceDetails() {
		return this.workExperienceDetails;
	}

	public void setWorkExperienceDetails(Set<WorkExperienceDetail> workExperienceDetails) {
		this.workExperienceDetails = workExperienceDetails;
	}

	@Override
	public int compareTo(IndustryType comparedObject) {
		return this.getIndustryName().compareToIgnoreCase(comparedObject.getIndustryName());
	}
}

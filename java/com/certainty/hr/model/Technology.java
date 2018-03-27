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
 * Model class to represent Technology
 * 
 */
@Entity
@Table(name = "technology")
public class Technology implements Comparable<Technology>, java.io.Serializable {
	private static final long serialVersionUID = 508392327133126032L;
	private Integer technologyId;
	private String technologyName;
	private String technologyDesc;
	private Set<ProjectDetail> projectDetails = new HashSet<ProjectDetail>(0);

	public Technology() {
	}

	public Technology(String technologyName) {
		this.technologyName = technologyName;
	}

	public Technology(String technologyName, String technologyDesc, Set<ProjectDetail> projectDetails) {
		this.technologyName = technologyName;
		this.technologyDesc = technologyDesc;
		this.projectDetails = projectDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "technology_id", unique = true, nullable = false)
	public Integer getTechnologyId() {
		return this.technologyId;
	}

	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	@Column(name = "technology_name", nullable = false, length = 64)
	public String getTechnologyName() {
		return this.technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	@Column(name = "technology_desc", length = 256)
	public String getTechnologyDesc() {
		return this.technologyDesc;
	}

	public void setTechnologyDesc(String technologyDesc) {
		this.technologyDesc = technologyDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "technology")
	@JsonIgnore
	public Set<ProjectDetail> getProjectDetails() {
		return this.projectDetails;
	}

	public void setProjectDetails(Set<ProjectDetail> projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Override
	public int compareTo(Technology comparedObject) {
		return this.getTechnologyName().compareToIgnoreCase(comparedObject.getTechnologyName());
	}
}

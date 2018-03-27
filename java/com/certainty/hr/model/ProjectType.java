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
 * Model class to represent Project Type
 * 
 */

@Entity
@Table(name = "project_type")
public class ProjectType implements Comparable<ProjectType>, java.io.Serializable {
	private static final long serialVersionUID = 1500120109763888328L;
	private Integer projectTypeId;
	private String projectTypeName;
	private String projectTypeDesc;
	private Set<ProjectDetail> projectDetails = new HashSet<ProjectDetail>(0);

	public ProjectType() {
	}

	public ProjectType(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	public ProjectType(String projectTypeName, String projectTypeDesc, Set<ProjectDetail> projectDetails) {
		this.projectTypeName = projectTypeName;
		this.projectTypeDesc = projectTypeDesc;
		this.projectDetails = projectDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "project_type_id", unique = true, nullable = false)
	public Integer getProjectTypeId() {
		return this.projectTypeId;
	}

	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	@Column(name = "project_type_name", nullable = false, length = 64)
	public String getProjectTypeName() {
		return this.projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	@Column(name = "project_type_desc", length = 256)
	public String getProjectTypeDesc() {
		return this.projectTypeDesc;
	}

	public void setProjectTypeDesc(String projectTypeDesc) {
		this.projectTypeDesc = projectTypeDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projectType")
	@JsonIgnore
	public Set<ProjectDetail> getProjectDetails() {
		return this.projectDetails;
	}

	public void setProjectDetails(Set<ProjectDetail> projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Override
	public int compareTo(ProjectType comparedObject) {
		return this.getProjectTypeName().compareToIgnoreCase(comparedObject.getProjectTypeName());
	}
}

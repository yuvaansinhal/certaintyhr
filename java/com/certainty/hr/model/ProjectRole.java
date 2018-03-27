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
 * Model class to represent Project Role
 * 
 */
@Entity
@Table(name = "project_role")
public class ProjectRole implements Comparable<ProjectRole>, java.io.Serializable {
	private static final long serialVersionUID = -4953713648398768942L;
	private Integer projectRoleId;
	private String projectRoleName;
	private String projectRoleDesc;
	private Set<EmpProjectDetail> empProjectDetails = new HashSet<EmpProjectDetail>(0);
	private Set<ProjectResource> projectResources = new HashSet<ProjectResource>(0);

	public ProjectRole() {
	}

	public ProjectRole(String projectRoleName) {
		this.projectRoleName = projectRoleName;
	}

	public ProjectRole(String projectRoleName, String projectRoleDesc, Set<EmpProjectDetail> empProjectDetails,
			Set<ProjectResource> projectResources) {
		this.projectRoleName = projectRoleName;
		this.projectRoleDesc = projectRoleDesc;
		this.empProjectDetails = empProjectDetails;
		this.projectResources = projectResources;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "project_role_id", unique = true, nullable = false)
	public Integer getProjectRoleId() {
		return this.projectRoleId;
	}

	public void setProjectRoleId(Integer projectRoleId) {
		this.projectRoleId = projectRoleId;
	}

	@Column(name = "project_role_name", nullable = false, length = 32)
	public String getProjectRoleName() {
		return this.projectRoleName;
	}

	public void setProjectRoleName(String projectRoleName) {
		this.projectRoleName = projectRoleName;
	}

	@Column(name = "project_role_desc", length = 256)
	public String getProjectRoleDesc() {
		return this.projectRoleDesc;
	}

	public void setProjectRoleDesc(String projectRoleDesc) {
		this.projectRoleDesc = projectRoleDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projectRole")
	@JsonIgnore
	public Set<EmpProjectDetail> getEmpProjectDetails() {
		return this.empProjectDetails;
	}

	public void setEmpProjectDetails(Set<EmpProjectDetail> empProjectDetails) {
		this.empProjectDetails = empProjectDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projectRole")
	@JsonIgnore
	public Set<ProjectResource> getProjectResources() {
		return this.projectResources;
	}

	public void setProjectResources(Set<ProjectResource> projectResources) {
		this.projectResources = projectResources;
	}

	@Override
	public int compareTo(ProjectRole comparedObject) {
		return this.getProjectRoleName().compareToIgnoreCase(comparedObject.getProjectRoleName());
	}
}

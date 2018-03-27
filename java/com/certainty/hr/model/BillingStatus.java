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
 * Model class to represent BillingStatus
 * 
 */

@Entity
@Table(name = "billing_status")
public class BillingStatus implements Comparable<BillingStatus>, java.io.Serializable {
	private static final long serialVersionUID = -5519182666180221733L;
	private Integer billingStatusId;
	private String billingStatusName;
	private String billingStatusDesc;
	private Set<EmpProjectDetail> empProjectDetails = new HashSet<EmpProjectDetail>(0);
	private Set<ProjectResource> projectResources = new HashSet<ProjectResource>(0);
	private Set<UtilizationStatus> utilizationStatuses = new HashSet<UtilizationStatus>(0);

	public BillingStatus() {
	}

	public BillingStatus(String billingStatusName) {
		this.billingStatusName = billingStatusName;
	}

	public BillingStatus(String billingStatusName, String billingStatusDesc, Set<EmpProjectDetail> empProjectDetails,
			Set<ProjectResource> projectResources, Set<UtilizationStatus> utilizationStatuses) {
		this.billingStatusName = billingStatusName;
		this.billingStatusDesc = billingStatusDesc;
		this.empProjectDetails = empProjectDetails;
		this.projectResources = projectResources;
		this.utilizationStatuses = utilizationStatuses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "billing_status_id", unique = true, nullable = false)
	public Integer getBillingStatusId() {
		return this.billingStatusId;
	}

	public void setBillingStatusId(Integer billingStatusId) {
		this.billingStatusId = billingStatusId;
	}

	@Column(name = "billing_status_name", nullable = false, length = 16)
	public String getBillingStatusName() {
		return this.billingStatusName;
	}

	public void setBillingStatusName(String billingStatusName) {
		this.billingStatusName = billingStatusName;
	}

	@Column(name = "billing_status_desc", length = 256)
	public String getBillingStatusDesc() {
		return this.billingStatusDesc;
	}

	public void setBillingStatusDesc(String billingStatusDesc) {
		this.billingStatusDesc = billingStatusDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "billingStatus")
	@JsonIgnore
	public Set<EmpProjectDetail> getEmpProjectDetails() {
		return this.empProjectDetails;
	}

	public void setEmpProjectDetails(Set<EmpProjectDetail> empProjectDetails) {
		this.empProjectDetails = empProjectDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "billingStatus")
	@JsonIgnore
	public Set<ProjectResource> getProjectResources() {
		return this.projectResources;
	}

	public void setProjectResources(Set<ProjectResource> projectResources) {
		this.projectResources = projectResources;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "billingStatus")
	@JsonIgnore
	public Set<UtilizationStatus> getUtilizationStatuses() {
		return this.utilizationStatuses;
	}

	public void setUtilizationStatuses(Set<UtilizationStatus> utilizationStatuses) {
		this.utilizationStatuses = utilizationStatuses;
	}

	@Override
	public int compareTo(BillingStatus comparedObject) {
		return this.getBillingStatusName().compareToIgnoreCase(comparedObject.getBillingStatusName());
	}
}

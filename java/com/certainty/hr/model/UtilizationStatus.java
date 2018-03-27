package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model class to represent utilization status
 * 
 */

@Entity
@Table(name = "utilization_status")
public class UtilizationStatus implements Comparable<UtilizationStatus>, java.io.Serializable {
	private static final long serialVersionUID = -4039913540361822330L;
	private Integer utilizationStatusId;
	private BillingStatus billingStatus;
	private String utilizationStatusName;
	private String utilizationStatusDesc;
	private Set<EmpProjectDetail> empProjectDetails = new HashSet<EmpProjectDetail>(0);

	public UtilizationStatus() {
	}

	public UtilizationStatus(String utilizationStatusName) {
		this.utilizationStatusName = utilizationStatusName;
	}

	public UtilizationStatus(BillingStatus billingStatus, String utilizationStatusName, String utilizationStatusDesc,
			Set<EmpProjectDetail> empProjectDetails) {
		this.billingStatus = billingStatus;
		this.utilizationStatusName = utilizationStatusName;
		this.utilizationStatusDesc = utilizationStatusDesc;
		this.empProjectDetails = empProjectDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "utilization_status_id", unique = true, nullable = false)
	public Integer getUtilizationStatusId() {
		return this.utilizationStatusId;
	}

	public void setUtilizationStatusId(Integer utilizationStatusId) {
		this.utilizationStatusId = utilizationStatusId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "billing_status_id")
	public BillingStatus getBillingStatus() {
		return this.billingStatus;
	}

	public void setBillingStatus(BillingStatus billingStatus) {
		this.billingStatus = billingStatus;
	}

	@Column(name = "utilization_status_name", nullable = false, length = 32)
	public String getUtilizationStatusName() {
		return this.utilizationStatusName;
	}

	public void setUtilizationStatusName(String utilizationStatusName) {
		this.utilizationStatusName = utilizationStatusName;
	}

	@Column(name = "utilization_status_desc", length = 256)
	public String getUtilizationStatusDesc() {
		return this.utilizationStatusDesc;
	}

	public void setUtilizationStatusDesc(String utilizationStatusDesc) {
		this.utilizationStatusDesc = utilizationStatusDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilizationStatus")
	@JsonIgnore
	public Set<EmpProjectDetail> getEmpProjectDetails() {
		return this.empProjectDetails;
	}

	public void setEmpProjectDetails(Set<EmpProjectDetail> empProjectDetails) {
		this.empProjectDetails = empProjectDetails;
	}

	@Override
	public int compareTo(UtilizationStatus comparedObject) {
		return this.getUtilizationStatusName().compareToIgnoreCase(comparedObject.getUtilizationStatusName());
	}
}

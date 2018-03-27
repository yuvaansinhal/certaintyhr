package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model class to represent client detail
 * 
 */

@Entity
@Table(name = "client_detail")
public class ClientDetail implements Comparable<ClientDetail>, java.io.Serializable {

	private static final long serialVersionUID = 7737439134512216971L;
	private Integer id;
	private IndustryType industryType;
	private String clientName;
	private Float clientRevenue;
	private String clientAddress;
	private String clientBillingAddress;
	private String clientPocName;
	private Date engagementStartDate;
	private String engagementType;
	private String currentStatus;
	private Date statusChangeDate;
	private String clientDesc;
	private Set<ProjectDetail> projectDetails = new HashSet<ProjectDetail>(0);
	private Set<EmpProjectDetail> empProjectDetails = new HashSet<EmpProjectDetail>(0);
	private Set<ProjectInvoicing> projectInvoicings = new HashSet<ProjectInvoicing>(0);
	private Set<ProjectResource> projectResources = new HashSet<ProjectResource>(0);

	public ClientDetail() {
	}

	public ClientDetail(String clientName, String clientAddress, String clientBillingAddress, String clientPocName,
			Date engagementStartDate, String engagementType, String currentStatus) {
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientBillingAddress = clientBillingAddress;
		this.clientPocName = clientPocName;
		this.engagementStartDate = engagementStartDate;
		this.engagementType = engagementType;
		this.currentStatus = currentStatus;
	}

	public ClientDetail(String clientName, IndustryType industryType, Float clientRevenue, String clientAddress,
			String clientBillingAddress, String clientPocName, Date engagementStartDate, String engagementType,
			String currentStatus, Date statusChangeDate, String clientDesc, Set<ProjectDetail> projectDetails,
			Set<EmpProjectDetail> empProjectDetails, Set<ProjectInvoicing> projectInvoicings,
			Set<ProjectResource> projectResources) {
		this.clientName = clientName;
		this.industryType = industryType;
		this.clientRevenue = clientRevenue;
		this.clientAddress = clientAddress;
		this.clientBillingAddress = clientBillingAddress;
		this.clientPocName = clientPocName;
		this.engagementStartDate = engagementStartDate;
		this.engagementType = engagementType;
		this.currentStatus = currentStatus;
		this.statusChangeDate = statusChangeDate;
		this.clientDesc = clientDesc;
		this.projectDetails = projectDetails;
		this.empProjectDetails = empProjectDetails;
		this.projectInvoicings = projectInvoicings;
		this.projectResources = projectResources;
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

	@Column(name = "client_name", nullable = false, length = 64)
	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "industry_id")
	public IndustryType getIndustryType() {
		return this.industryType;
	}

	public void setIndustryType(IndustryType industryType) {
		this.industryType = industryType;
	}

	@Column(name = "client_revenue", precision = 12, scale = 0)
	public Float getClientRevenue() {
		return this.clientRevenue;
	}

	public void setClientRevenue(Float clientRevenue) {
		this.clientRevenue = clientRevenue;
	}

	@Column(name = "client_address", nullable = false, length = 256)
	public String getClientAddress() {
		return this.clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	@Column(name = "client_billing_address", nullable = false, length = 256)
	public String getClientBillingAddress() {
		return this.clientBillingAddress;
	}

	public void setClientBillingAddress(String clientBillingAddress) {
		this.clientBillingAddress = clientBillingAddress;
	}

	@Column(name = "client_poc_name", nullable = false, length = 64)
	public String getClientPocName() {
		return this.clientPocName;
	}

	public void setClientPocName(String clientPocName) {
		this.clientPocName = clientPocName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "engagement_start_date", nullable = false, length = 10)
	public Date getEngagementStartDate() {
		return this.engagementStartDate;
	}

	public void setEngagementStartDate(Date engagementStartDate) {
		this.engagementStartDate = engagementStartDate;
	}

	@Column(name = "engagement_type", nullable = false, length = 16)
	public String getEngagementType() {
		return this.engagementType;
	}

	public void setEngagementType(String engagementType) {
		this.engagementType = engagementType;
	}

	@Column(name = "current_status", nullable = false, length = 16)
	public String getCurrentStatus() {
		return this.currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "status_change_date", length = 10)
	public Date getStatusChangeDate() {
		return this.statusChangeDate;
	}

	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}

	@Column(name = "client_desc", length = 256)
	public String getClientDesc() {
		return this.clientDesc;
	}

	public void setClientDesc(String clientDesc) {
		this.clientDesc = clientDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientDetail")
	@JsonIgnore
	public Set<ProjectDetail> getProjectDetails() {
		return this.projectDetails;
	}

	public void setProjectDetails(Set<ProjectDetail> projectDetails) {
		this.projectDetails = projectDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientDetail")
	@JsonIgnore
	public Set<EmpProjectDetail> getEmpProjectDetails() {
		return this.empProjectDetails;
	}

	public void setEmpProjectDetails(Set<EmpProjectDetail> empProjectDetails) {
		this.empProjectDetails = empProjectDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientDetail")
	@JsonIgnore
	public Set<ProjectInvoicing> getProjectInvoicings() {
		return this.projectInvoicings;
	}

	public void setProjectInvoicings(Set<ProjectInvoicing> projectInvoicings) {
		this.projectInvoicings = projectInvoicings;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "clientDetail")
	@JsonIgnore
	public Set<ProjectResource> getProjectResources() {
		return this.projectResources;
	}

	public void setProjectResources(Set<ProjectResource> projectResources) {
		this.projectResources = projectResources;
	}

	@Override
	public int compareTo(ClientDetail comparedObject) {
		return this.getClientName().compareToIgnoreCase(comparedObject.getClientName());
	}
}

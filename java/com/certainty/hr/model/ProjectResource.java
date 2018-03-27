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
 * Model class to represent Project Resource
 * 
 */

@Entity
@Table(name = "project_resource")
public class ProjectResource implements java.io.Serializable {
	private static final long serialVersionUID = -782804885666777537L;
	private Integer id;
	private BillingStatus billingStatus;
	private ClientDetail clientDetail;
	private EmpDetail empDetail;
	private ProjectDetail projectDetail;
	private ProjectRole projectRole;
	private float ratePerHour;
	private Date billingStartDate;
	private Date billingEndDate;
	private float allocationPercentage;
	private String currentStatus;
	private Date statusChangeDate;

	public ProjectResource() {
	}

	public ProjectResource(float ratePerHour, Date billingStartDate, Date billingEndDate, float allocationPercentage,
			String currentStatus) {
		this.ratePerHour = ratePerHour;
		this.billingStartDate = billingStartDate;
		this.billingEndDate = billingEndDate;
		this.allocationPercentage = allocationPercentage;
		this.currentStatus = currentStatus;
	}

	public ProjectResource(BillingStatus billingStatus, ClientDetail clientDetail, EmpDetail empDetail,
			ProjectDetail projectDetail, ProjectRole projectRole, float ratePerHour, Date billingStartDate,
			Date billingEndDate, float allocationPercentage, String currentStatus, Date statusChangeDate) {
		this.billingStatus = billingStatus;
		this.clientDetail = clientDetail;
		this.empDetail = empDetail;
		this.projectDetail = projectDetail;
		this.projectRole = projectRole;
		this.ratePerHour = ratePerHour;
		this.billingStartDate = billingStartDate;
		this.billingEndDate = billingEndDate;
		this.allocationPercentage = allocationPercentage;
		this.currentStatus = currentStatus;
		this.statusChangeDate = statusChangeDate;
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
	@JoinColumn(name = "billing_status_id")
	public BillingStatus getBillingStatus() {
		return this.billingStatus;
	}

	public void setBillingStatus(BillingStatus billingStatus) {
		this.billingStatus = billingStatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	public ClientDetail getClientDetail() {
		return this.clientDetail;
	}

	public void setClientDetail(ClientDetail clientDetail) {
		this.clientDetail = clientDetail;
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
	@JoinColumn(name = "project_id")
	public ProjectDetail getProjectDetail() {
		return this.projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_role_id")
	public ProjectRole getProjectRole() {
		return this.projectRole;
	}

	public void setProjectRole(ProjectRole projectRole) {
		this.projectRole = projectRole;
	}

	@Column(name = "rate_per_hour", nullable = false, precision = 12, scale = 0)
	public float getRatePerHour() {
		return this.ratePerHour;
	}

	public void setRatePerHour(float ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "billing_start_date", nullable = false, length = 10)
	public Date getBillingStartDate() {
		return this.billingStartDate;
	}

	public void setBillingStartDate(Date billingStartDate) {
		this.billingStartDate = billingStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "billing_end_date", nullable = false, length = 10)
	public Date getBillingEndDate() {
		return this.billingEndDate;
	}

	public void setBillingEndDate(Date billingEndDate) {
		this.billingEndDate = billingEndDate;
	}

	@Column(name = "allocation_percentage", nullable = false, precision = 12, scale = 0)
	public float getAllocationPercentage() {
		return this.allocationPercentage;
	}

	public void setAllocationPercentage(float allocationPercentage) {
		this.allocationPercentage = allocationPercentage;
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
}

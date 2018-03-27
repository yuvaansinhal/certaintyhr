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
 * Model class to represent Employee Project Details
 * 
 */

@Entity
@Table(name = "emp_project_detail")
public class EmpProjectDetail implements java.io.Serializable {
	private static final long serialVersionUID = 3573519029136965902L;
	private Integer id;
	private BillingStatus billingStatus;
	private ClientDetail clientDetail;
	private EmpDetail empDetail;
	private ProjectDetail projectDetail;
	private ProjectRole projectRole;
	private UtilizationStatus utilizationStatus;
	private Date clientAllocationDate;
	private Date projectAllocationDate;
	private Date statusChangeDate;
	private Date expectedReleaseDate;
	private float allocationProportion;
	private String allocationPlan;

	public EmpProjectDetail() {
	}

	public EmpProjectDetail(Date clientAllocationDate, Date projectAllocationDate, Date expectedReleaseDate,
			float allocationProportion, String allocationPlan) {
		this.clientAllocationDate = clientAllocationDate;
		this.projectAllocationDate = projectAllocationDate;
		this.expectedReleaseDate = expectedReleaseDate;
		this.allocationProportion = allocationProportion;
		this.allocationPlan = allocationPlan;
	}

	public EmpProjectDetail(BillingStatus billingStatus, ClientDetail clientDetail, EmpDetail empDetail,
			ProjectDetail projectDetail, ProjectRole projectRole, UtilizationStatus utilizationStatus,
			Date clientAllocationDate, Date projectAllocationDate, Date statusChangeDate, Date expectedReleaseDate,
			float allocationProportion, String allocationPlan) {
		this.billingStatus = billingStatus;
		this.clientDetail = clientDetail;
		this.empDetail = empDetail;
		this.projectDetail = projectDetail;
		this.projectRole = projectRole;
		this.utilizationStatus = utilizationStatus;
		this.clientAllocationDate = clientAllocationDate;
		this.projectAllocationDate = projectAllocationDate;
		this.statusChangeDate = statusChangeDate;
		this.expectedReleaseDate = expectedReleaseDate;
		this.allocationProportion = allocationProportion;
		this.allocationPlan = allocationPlan;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utilization_status_id")
	public UtilizationStatus getUtilizationStatus() {
		return this.utilizationStatus;
	}

	public void setUtilizationStatus(UtilizationStatus utilizationStatus) {
		this.utilizationStatus = utilizationStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "client_allocation_date", nullable = false, length = 10)
	public Date getClientAllocationDate() {
		return this.clientAllocationDate;
	}

	public void setClientAllocationDate(Date clientAllocationDate) {
		this.clientAllocationDate = clientAllocationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "project_allocation_date", nullable = false, length = 10)
	public Date getProjectAllocationDate() {
		return this.projectAllocationDate;
	}

	public void setProjectAllocationDate(Date projectAllocationDate) {
		this.projectAllocationDate = projectAllocationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "status_change_date", length = 10)
	public Date getStatusChangeDate() {
		return this.statusChangeDate;
	}

	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expected_release_date", nullable = false, length = 10)
	public Date getExpectedReleaseDate() {
		return this.expectedReleaseDate;
	}

	public void setExpectedReleaseDate(Date expectedReleaseDate) {
		this.expectedReleaseDate = expectedReleaseDate;
	}

	@Column(name = "allocation_proportion", nullable = false, precision = 12, scale = 0)
	public float getAllocationProportion() {
		return this.allocationProportion;
	}

	public void setAllocationProportion(float allocationProportion) {
		this.allocationProportion = allocationProportion;
	}

	@Column(name = "allocation_plan", nullable = false, length = 256)
	public String getAllocationPlan() {
		return this.allocationPlan;
	}

	public void setAllocationPlan(String allocationPlan) {
		this.allocationPlan = allocationPlan;
	}
}

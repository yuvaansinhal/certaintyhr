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
 * Model class to represent Project detail
 * 
 */
@Entity
@Table(name = "project_detail")
public class ProjectDetail implements Comparable<ProjectDetail>, java.io.Serializable {
	private static final long serialVersionUID = -2047805649292383826L;
	private Integer id;
	private ClientDetail clientDetail;
	private ProjectType projectType;
	private Technology technology;
	private String projectName;
	private String projectDescription;
	private String clientPocName;
	private Date projectStartDate;
	private Date projectEndDate;
	private float projectEstimation;
	private String poNumber;
	private float poAmount;
	private String currentStatus;
	private Date statusChangeDate;
	private Set<EmpProjectDetail> empProjectDetails = new HashSet<EmpProjectDetail>(0);
	private Set<ProjectInvoicing> projectInvoicings = new HashSet<ProjectInvoicing>(0);
	private Set<ProjectResource> projectResources = new HashSet<ProjectResource>(0);

	public ProjectDetail() {
	}

	public ProjectDetail(String projectName, String projectDescription, String clientPocName, Date projectStartDate,
			Date projectEndDate, float projectEstimation, String poNumber, float poAmount, String currentStatus) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.clientPocName = clientPocName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectEstimation = projectEstimation;
		this.poNumber = poNumber;
		this.poAmount = poAmount;
		this.currentStatus = currentStatus;
	}

	public ProjectDetail(ClientDetail clientDetail, ProjectType projectType, Technology technology, String projectName,
			String projectDescription, String clientPocName, Date projectStartDate, Date projectEndDate,
			float projectEstimation, String poNumber, float poAmount, String currentStatus, Date statusChangeDate,
			Set<EmpProjectDetail> empProjectDetails, Set<ProjectInvoicing> projectInvoicings,
			Set<ProjectResource> projectResources) {
		this.clientDetail = clientDetail;
		this.projectType = projectType;
		this.technology = technology;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.clientPocName = clientPocName;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectEstimation = projectEstimation;
		this.poNumber = poNumber;
		this.poAmount = poAmount;
		this.currentStatus = currentStatus;
		this.statusChangeDate = statusChangeDate;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	public ClientDetail getClientDetail() {
		return this.clientDetail;
	}

	public void setClientDetail(ClientDetail clientDetail) {
		this.clientDetail = clientDetail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_type_id")
	public ProjectType getProjectType() {
		return this.projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "technology_id")
	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	@Column(name = "project_name", nullable = false, length = 64)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_description", nullable = false, length = 256)
	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Column(name = "client_poc_name", nullable = false, length = 64)
	public String getClientPocName() {
		return this.clientPocName;
	}

	public void setClientPocName(String clientPocName) {
		this.clientPocName = clientPocName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "project_start_date", nullable = false, length = 10)
	public Date getProjectStartDate() {
		return this.projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "project_end_date", nullable = false, length = 10)
	public Date getProjectEndDate() {
		return this.projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	@Column(name = "project_estimation", nullable = false, precision = 12, scale = 0)
	public float getProjectEstimation() {
		return this.projectEstimation;
	}

	public void setProjectEstimation(float projectEstimation) {
		this.projectEstimation = projectEstimation;
	}

	@Column(name = "po_number", nullable = false, length = 16)
	public String getPoNumber() {
		return this.poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	@Column(name = "po_amount", nullable = false, precision = 12, scale = 0)
	public float getPoAmount() {
		return this.poAmount;
	}

	public void setPoAmount(float poAmount) {
		this.poAmount = poAmount;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projectDetail")
	@JsonIgnore
	public Set<EmpProjectDetail> getEmpProjectDetails() {
		return this.empProjectDetails;
	}

	public void setEmpProjectDetails(Set<EmpProjectDetail> empProjectDetails) {
		this.empProjectDetails = empProjectDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projectDetail")
	@JsonIgnore
	public Set<ProjectInvoicing> getProjectInvoicings() {
		return this.projectInvoicings;
	}

	public void setProjectInvoicings(Set<ProjectInvoicing> projectInvoicings) {
		this.projectInvoicings = projectInvoicings;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projectDetail")
	@JsonIgnore
	public Set<ProjectResource> getProjectResources() {
		return this.projectResources;
	}

	public void setProjectResources(Set<ProjectResource> projectResources) {
		this.projectResources = projectResources;
	}

	@Override
	public int compareTo(ProjectDetail comparedObject) {
		return this.getProjectName().compareToIgnoreCase(comparedObject.getProjectName());
	}
}

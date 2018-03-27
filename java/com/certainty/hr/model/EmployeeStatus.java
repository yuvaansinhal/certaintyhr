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
 * Model class to represent EmployeeStatus
 * 
 */

@Entity
@Table(name = "employee_status")
public class EmployeeStatus implements Comparable<EmployeeStatus>, java.io.Serializable {
	private static final long serialVersionUID = -2618374941083769315L;
	private Integer employeeStatusId;
	private String employeeStatusName;
	private String employeeStatusDesc;
	private Set<EmpDetail> empDetails = new HashSet<EmpDetail>(0);

	public EmployeeStatus() {
	}

	public EmployeeStatus(String employeeStatusName) {
		this.employeeStatusName = employeeStatusName;
	}

	public EmployeeStatus(String employeeStatusName, String employeeStatusDesc, Set<EmpDetail> empDetails) {
		this.employeeStatusName = employeeStatusName;
		this.employeeStatusDesc = employeeStatusDesc;
		this.empDetails = empDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "employee_status_id", unique = true, nullable = false)
	public Integer getEmployeeStatusId() {
		return this.employeeStatusId;
	}

	public void setEmployeeStatusId(Integer employeeStatusId) {
		this.employeeStatusId = employeeStatusId;
	}

	@Column(name = "employee_status_name", nullable = false, length = 32)
	public String getEmployeeStatusName() {
		return this.employeeStatusName;
	}

	public void setEmployeeStatusName(String employeeStatusName) {
		this.employeeStatusName = employeeStatusName;
	}

	@Column(name = "employee_status_desc", length = 256)
	public String getEmployeeStatusDesc() {
		return this.employeeStatusDesc;
	}

	public void setEmployeeStatusDesc(String employeeStatusDesc) {
		this.employeeStatusDesc = employeeStatusDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeStatus")
	@JsonIgnore
	public Set<EmpDetail> getEmpDetails() {
		return this.empDetails;
	}

	public void setEmpDetails(Set<EmpDetail> empDetails) {
		this.empDetails = empDetails;
	}

	@Override
	public int compareTo(EmployeeStatus comparedObject) {
		return this.getEmployeeStatusName().compareToIgnoreCase(comparedObject.getEmployeeStatusName());
	}
}

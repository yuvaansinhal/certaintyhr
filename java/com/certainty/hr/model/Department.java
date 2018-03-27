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
 * Model class to represent Department
 * 
 */
@Entity
@Table(name = "department")
public class Department implements Comparable<Department>, java.io.Serializable {
	private static final long serialVersionUID = -5892135588213474174L;
	private Integer deptId;
	private String deptName;
	private String deptDesc;
	private Set<EmpDetail> empDetails = new HashSet<EmpDetail>(0);

	public Department() {
	}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public Department(String deptName, String deptDesc, Set<EmpDetail> empDetails) {
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.empDetails = empDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "dept_id", unique = true, nullable = false)
	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	@Column(name = "dept_name", nullable = false, length = 32)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "dept_desc", length = 256)
	public String getDeptDesc() {
		return this.deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
	@JsonIgnore
	public Set<EmpDetail> getEmpDetails() {
		return this.empDetails;
	}

	public void setEmpDetails(Set<EmpDetail> empDetails) {
		this.empDetails = empDetails;
	}

	@Override
	public int compareTo(Department comparedObject) {
		return this.getDeptName().compareToIgnoreCase(comparedObject.getDeptName());
	}
}

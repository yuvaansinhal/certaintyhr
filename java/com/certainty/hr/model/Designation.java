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
 * Model class to represent Designation
 * 
 */
@Entity
@Table(name = "designation")
public class Designation implements Comparable<Designation>, java.io.Serializable {
	private static final long serialVersionUID = -5082519749627314542L;
	private Integer designationId;
	private Grade grade;
	private String designationName;
	private String designationDesc;
	private Set<EmpDetail> empDetails = new HashSet<EmpDetail>(0);

	public Designation() {
	}

	public Designation(Grade grade, String designationName) {
		this.grade = grade;
		this.designationName = designationName;
	}

	public Designation(Grade grade, String designationName, String designationDesc, Set<EmpDetail> empDetails) {
		this.grade = grade;
		this.designationName = designationName;
		this.designationDesc = designationDesc;
		this.empDetails = empDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "designation_id", unique = true, nullable = false)
	public Integer getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "grade_id", nullable = false)
	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Column(name = "designation_name", nullable = false, length = 64)
	public String getDesignationName() {
		return this.designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	@Column(name = "designation_desc", length = 256)
	public String getDesignationDesc() {
		return this.designationDesc;
	}

	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "designation")
	@JsonIgnore
	public Set<EmpDetail> getEmpDetails() {
		return this.empDetails;
	}

	public void setEmpDetails(Set<EmpDetail> empDetails) {
		this.empDetails = empDetails;
	}

	@Override
	public int compareTo(Designation comparedObject) {
		return this.getDesignationName().compareToIgnoreCase(comparedObject.getDesignationName());
	}
}

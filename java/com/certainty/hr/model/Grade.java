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
 * Model class to represent grade
 * 
 */
@Entity
@Table(name = "grade")
public class Grade implements Comparable<Grade>, java.io.Serializable {
	private static final long serialVersionUID = 5306996061724170947L;
	private Integer gradeId;
	private String gradeName;
	private String gradeDesc;
	private Set<EmpDetail> empDetails = new HashSet<EmpDetail>(0);
	private Set<Designation> designations = new HashSet<Designation>(0);

	public Grade() {
	}

	public Grade(String gradeName) {
		this.gradeName = gradeName;
	}

	public Grade(String gradeName, String gradeDesc, Set<EmpDetail> empDetails, Set<Designation> designations) {
		this.gradeName = gradeName;
		this.gradeDesc = gradeDesc;
		this.empDetails = empDetails;
		this.designations = designations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "grade_id", unique = true, nullable = false)
	public Integer getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	@Column(name = "grade_name", nullable = false, length = 16)
	public String getGradeName() {
		return this.gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	@Column(name = "grade_desc", length = 256)
	public String getGradeDesc() {
		return this.gradeDesc;
	}

	public void setGradeDesc(String gradeDesc) {
		this.gradeDesc = gradeDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "grade")
	@JsonIgnore
	public Set<EmpDetail> getEmpDetails() {
		return this.empDetails;
	}

	public void setEmpDetails(Set<EmpDetail> empDetails) {
		this.empDetails = empDetails;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "grade")
	@JsonIgnore
	public Set<Designation> getDesignations() {
		return this.designations;
	}

	public void setDesignations(Set<Designation> designations) {
		this.designations = designations;
	}
	@Override
	public int compareTo(Grade comparedObject) {
		return this.getGradeName().compareToIgnoreCase(comparedObject.getGradeName());
	}

	
}

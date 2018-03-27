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
 * Model class to represent Educational Course
 * 
*/

@Entity
@Table(name = "education_course")
public class EducationCourse implements Comparable<EducationCourse>, java.io.Serializable {
	private static final long serialVersionUID = -6684484959730802651L;
	private Integer courseId;
	private String courseName;
	private String courseDesc;
	private Set<EmpEducationDetail> empEducationDetails = new HashSet<EmpEducationDetail>(0);

	public EducationCourse() {
	}

	public EducationCourse(String courseName) {
		this.courseName = courseName;
	}

	public EducationCourse(String courseName, String courseDesc, Set<EmpEducationDetail> empEducationDetails) {
		this.courseName = courseName;
		this.courseDesc = courseDesc;
		this.empEducationDetails = empEducationDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Column(name = "course_name", nullable = false, length = 32)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name = "course_desc", length = 256)
	public String getCourseDesc() {
		return this.courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "educationCourse")
	@JsonIgnore
	public Set<EmpEducationDetail> getEmpEducationDetails() {
		return this.empEducationDetails;
	}

	public void setEmpEducationDetails(Set<EmpEducationDetail> empEducationDetails) {
		this.empEducationDetails = empEducationDetails;
	}

	@Override
	public int compareTo(EducationCourse comparedObject) {
		return this.getCourseName().compareToIgnoreCase(comparedObject.getCourseName());
	}
}

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
 * Model class to represent Emp Educational detail
 * 
 */
@Entity
@Table(name = "emp_education_detail")
public class EmpEducationDetail implements java.io.Serializable {
	private static final long serialVersionUID = 6510488222901061054L;
	private Integer id;
	private EducationCourse educationCourse;
	private EmpDetail empDetail;
	private SpecializationStream specializationStream;
	private Date courseFromDate;
	private Date courseToDate;
	private String levelOfCourse;
	private String universityName;
	private String instituteName;
	private Integer yearOfPassing;
	private String percentage;

	public EmpEducationDetail() {
	}

	public EmpEducationDetail(Date courseFromDate, String levelOfCourse, String universityName, String instituteName,
			Integer yearOfPassing, String percentage) {
		this.courseFromDate = courseFromDate;
		this.levelOfCourse = levelOfCourse;
		this.universityName = universityName;
		this.instituteName = instituteName;
		this.yearOfPassing = yearOfPassing;
		this.percentage = percentage;
	}

	public EmpEducationDetail(EducationCourse educationCourse, EmpDetail empDetail,
			SpecializationStream specializationStream, Date courseFromDate, Date courseToDate, String levelOfCourse,
			String universityName, String instituteName, Integer yearOfPassing, String percentage) {
		this.educationCourse = educationCourse;
		this.empDetail = empDetail;
		this.specializationStream = specializationStream;
		this.courseFromDate = courseFromDate;
		this.courseToDate = courseToDate;
		this.levelOfCourse = levelOfCourse;
		this.universityName = universityName;
		this.instituteName = instituteName;
		this.yearOfPassing = yearOfPassing;
		this.percentage = percentage;
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
	@JoinColumn(name = "course_id")
	public EducationCourse getEducationCourse() {
		return this.educationCourse;
	}

	public void setEducationCourse(EducationCourse educationCourse) {
		this.educationCourse = educationCourse;
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
	@JoinColumn(name = "stream_id")
	public SpecializationStream getSpecializationStream() {
		return this.specializationStream;
	}

	public void setSpecializationStream(SpecializationStream specializationStream) {
		this.specializationStream = specializationStream;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "course_from_date", nullable = false, length = 10)
	public Date getCourseFromDate() {
		return this.courseFromDate;
	}

	public void setCourseFromDate(Date courseFromDate) {
		this.courseFromDate = courseFromDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "course_to_date", length = 10)
	public Date getCourseToDate() {
		return this.courseToDate;
	}

	public void setCourseToDate(Date courseToDate) {
		this.courseToDate = courseToDate;
	}

	@Column(name = "level_of_course", nullable = false, length = 32)
	public String getLevelOfCourse() {
		return this.levelOfCourse;
	}

	public void setLevelOfCourse(String levelOfCourse) {
		this.levelOfCourse = levelOfCourse;
	}

	@Column(name = "university_name", nullable = false, length = 64)
	public String getUniversityName() {
		return this.universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Column(name = "institute_name", nullable = false, length = 64)
	public String getInstituteName() {
		return this.instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	@Column(name = "year_of_passing", nullable = false)
	public Integer getYearOfPassing() {
		return this.yearOfPassing;
	}

	public void setYearOfPassing(Integer yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	@Column(name = "percentage", nullable = false, length = 16)
	public String getPercentage() {
		return this.percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

}

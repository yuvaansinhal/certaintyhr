package com.certainty.hr.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Model class to represent EmployeeSkillDetails
 * 
 */

@Entity
@Table(name = "emp_skill_detail")
public class EmpSkillDetail implements java.io.Serializable {
	private static final long serialVersionUID = 2543371609147557432L;
	private Integer id;
	private EmpDetail empDetail;
	private SkillType skillType;
	private Double experience;
	private String empSkillDetailDesc;
	private String primaryFlag;

	public EmpSkillDetail() {
	}

	public EmpSkillDetail(Double experience, String primaryFlag) {
		this.experience = experience;
		this.primaryFlag = primaryFlag;
	}

	public EmpSkillDetail(EmpDetail empDetail, SkillType skillType, Double experience, String empSkillDetailDesc,
			String primaryFlag) {
		this.empDetail = empDetail;
		this.skillType = skillType;
		this.experience = experience;
		this.empSkillDetailDesc = empSkillDetailDesc;
		this.primaryFlag = primaryFlag;
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
	@JoinColumn(name = "employee_id")
	public EmpDetail getEmpDetail() {
		return this.empDetail;
	}

	public void setEmpDetail(EmpDetail empDetail) {
		this.empDetail = empDetail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_type_id")
	public SkillType getSkillType() {
		return this.skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	@Column(name = "experience", nullable = false, precision = 12, scale = 0)
	public Double getExperience() {
		return this.experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	@Column(name = "emp_skill_detail_desc", length = 256)
	public String getEmpSkillDetailDesc() {
		return this.empSkillDetailDesc;
	}

	public void setEmpSkillDetailDesc(String empSkillDetailDesc) {
		this.empSkillDetailDesc = empSkillDetailDesc;
	}

	@Column(name = "primary_flag", nullable = false, length = 1)
	public String getPrimaryFlag() {
		return this.primaryFlag;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
	}
}

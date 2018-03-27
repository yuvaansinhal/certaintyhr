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
 * Model class to represent SkillType
 * 
 */
@Entity
@Table(name = "skill_type")
public class SkillType implements Comparable<SkillType>, java.io.Serializable {
	private static final long serialVersionUID = -4898735599824307379L;
	private Integer skillTypeId;
	private String skillTypeName;
	private String skillTypeDesc;
	private Set<EmpSkillDetail> empSkillDetails = new HashSet<EmpSkillDetail>(0);

	public SkillType() {
	}

	public SkillType(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

	public SkillType(String skillTypeName, String skillTypeDesc, Set<EmpSkillDetail> empSkillDetails) {
		this.skillTypeName = skillTypeName;
		this.skillTypeDesc = skillTypeDesc;
		this.empSkillDetails = empSkillDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "skill_type_id", unique = true, nullable = false)
	public Integer getSkillTypeId() {
		return this.skillTypeId;
	}

	public void setSkillTypeId(Integer skillTypeId) {
		this.skillTypeId = skillTypeId;
	}

	@Column(name = "skill_type_name", nullable = false, length = 128)
	public String getSkillTypeName() {
		return this.skillTypeName;
	}

	public void setSkillTypeName(String skillTypeName) {
		this.skillTypeName = skillTypeName;
	}

	@Column(name = "skill_type_desc", length = 256)
	public String getSkillTypeDesc() {
		return this.skillTypeDesc;
	}

	public void setSkillTypeDesc(String skillTypeDesc) {
		this.skillTypeDesc = skillTypeDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "skillType")
	@JsonIgnore
	public Set<EmpSkillDetail> getEmpSkillDetails() {
		return this.empSkillDetails;
	}

	public void setEmpSkillDetails(Set<EmpSkillDetail> empSkillDetails) {
		this.empSkillDetails = empSkillDetails;
	}

	@Override
	public int compareTo(SkillType comparedObject) {
		return this.getSkillTypeName().compareToIgnoreCase(comparedObject.getSkillTypeName());
	}
}

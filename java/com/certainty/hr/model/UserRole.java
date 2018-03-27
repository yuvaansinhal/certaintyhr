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
 * Model class to represent User Role
 * 
 */

@Entity
@Table(name = "user_role")
public class UserRole implements Comparable<UserRole>, java.io.Serializable {
	private static final long serialVersionUID = -8130359115582620816L;
	private Integer userRoleId;
	private String userRoleName;
	private String userRoleDesc;
	private Set<UserDetail> userDetails = new HashSet<UserDetail>(0);

	public UserRole() {
	}

	public UserRole(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public UserRole(String userRoleName, String userRoleDesc, Set<UserDetail> userDetails) {
		this.userRoleName = userRoleName;
		this.userRoleDesc = userRoleDesc;
		this.userDetails = userDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_role_id", unique = true, nullable = false)
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name = "user_role_name", nullable = false, length = 64)
	public String getUserRoleName() {
		return this.userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	@Column(name = "user_role_desc", length = 256)
	public String getUserRoleDesc() {
		return this.userRoleDesc;
	}

	public void setUserRoleDesc(String userRoleDesc) {
		this.userRoleDesc = userRoleDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userRole")
	@JsonIgnore
	public Set<UserDetail> getUserDetails() {
		return this.userDetails;
	}

	public void setUserDetails(Set<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public int compareTo(UserRole comparedObject) {
		return this.getUserRoleName().compareToIgnoreCase(comparedObject.getUserRoleName());
	}
}

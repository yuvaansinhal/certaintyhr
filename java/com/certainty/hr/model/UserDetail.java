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
import javax.persistence.UniqueConstraint;

/**
 * Model class to represent UserDetail
 * 
 */

@Entity
@Table(name = "user_detail", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class UserDetail implements java.io.Serializable {
	private static final long serialVersionUID = 6434341042631178935L;
	private Integer id;
	private EmpDetail empDetail;
	private UserRole userRole;
	private String userId;
	private String pwd;
	private String userDetailStatusName;
	private Date statusChangeDate;

	public UserDetail() {
	}

	public UserDetail(String pwd, String userDetailStatusName) {
		this.pwd = pwd;
		this.userDetailStatusName = userDetailStatusName;
	}

	public UserDetail(EmpDetail empDetail, UserRole userRole, String userId, String pwd, String userDetailStatusName,
			Date statusChangeDate) {
		this.empDetail = empDetail;
		this.userRole = userRole;
		this.userId = userId;
		this.pwd = pwd;
		this.userDetailStatusName = userDetailStatusName;
		this.statusChangeDate = statusChangeDate;
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
	@JoinColumn(name = "user_role_id")
	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Column(name = "user_id", unique = true, length = 72)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "pwd", nullable = false, length = 32)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "user_detail_status_name", nullable = false, length = 16)
	public String getUserDetailStatusName() {
		return this.userDetailStatusName;
	}

	public void setUserDetailStatusName(String userDetailStatusName) {
		this.userDetailStatusName = userDetailStatusName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "status_change_date", length = 10)
	public Date getStatusChangeDate() {
		return this.statusChangeDate;
	}

	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}
}

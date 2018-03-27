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
 * Model class to represent Project invoicing
 * 
 */
@Entity
@Table(name = "project_invoicing")
public class ProjectInvoicing implements java.io.Serializable {
	private static final long serialVersionUID = -5985318692409165005L;
	private Integer id;
	private ClientDetail clientDetail;
	private ProjectDetail projectDetail;
	private String invoiceNumber;
	private Date billingFromDate;
	private Date billingToDate;
	private Double amount;
	private Date raisedDate;
	private Date dueDate;
	private Double poBalance;
	private String currentStatus;
	private Date statusChangeDate;

	public ProjectInvoicing() {
	}

	public ProjectInvoicing(String invoiceNumber, Date billingFromDate, Date billingToDate, Double amount,
			Date raisedDate, Date dueDate, Double poBalance, String currentStatus) {
		this.invoiceNumber = invoiceNumber;
		this.billingFromDate = billingFromDate;
		this.billingToDate = billingToDate;
		this.amount = amount;
		this.raisedDate = raisedDate;
		this.dueDate = dueDate;
		this.poBalance = poBalance;
		this.currentStatus = currentStatus;
	}

	public ProjectInvoicing(ClientDetail clientDetail, ProjectDetail projectDetail, String invoiceNumber,
			Date billingFromDate, Date billingToDate, Double amount, Date raisedDate, Date dueDate, Double poBalance,
			String currentStatus, Date statusChangeDate) {
		this.clientDetail = clientDetail;
		this.projectDetail = projectDetail;
		this.invoiceNumber = invoiceNumber;
		this.billingFromDate = billingFromDate;
		this.billingToDate = billingToDate;
		this.amount = amount;
		this.raisedDate = raisedDate;
		this.dueDate = dueDate;
		this.poBalance = poBalance;
		this.currentStatus = currentStatus;
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
	@JoinColumn(name = "client_id")
	public ClientDetail getClientDetail() {
		return this.clientDetail;
	}

	public void setClientDetail(ClientDetail clientDetail) {
		this.clientDetail = clientDetail;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	public ProjectDetail getProjectDetail() {
		return this.projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Column(name = "invoice_number", nullable = false, length = 32)
	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "billing_from_date", nullable = false, length = 10)
	public Date getBillingFromDate() {
		return this.billingFromDate;
	}

	public void setBillingFromDate(Date billingFromDate) {
		this.billingFromDate = billingFromDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "billing_to_date", nullable = false, length = 10)
	public Date getBillingToDate() {
		return this.billingToDate;
	}

	public void setBillingToDate(Date billingToDate) {
		this.billingToDate = billingToDate;
	}

	@Column(name = "amount", nullable = false, precision = 12, scale = 0)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "raised_date", nullable = false, length = 10)
	public Date getRaisedDate() {
		return this.raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date", nullable = false, length = 10)
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "po_balance", nullable = false, precision = 12, scale = 0)
	public Double getPoBalance() {
		return this.poBalance;
	}

	public void setPoBalance(Double poBalance) {
		this.poBalance = poBalance;
	}

	@Column(name = "current_status", nullable = false, length = 16)
	public String getCurrentStatus() {
		return this.currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
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

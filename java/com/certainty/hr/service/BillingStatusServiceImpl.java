package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.BillingStatusDAO;
import com.certainty.hr.model.BillingStatus;

/**
 * Service class implementing methods to access BillingStatus data using DAO
 * methods
 * 
 *
 */
@Service
@Transactional
public class BillingStatusServiceImpl implements BillingStatusService {
	@Autowired
	private BillingStatusDAO billingStatusDAO;

	/**
	 * Setting the autowired BillingStatus DAO passed from Application Context
	 * 
	 * @param billingStatusDAO
	 *            the BillingStatus DAO to set
	 */
	public void setBillingStatusDAO(BillingStatusDAO billingStatusDAO) {
		this.billingStatusDAO = billingStatusDAO;
	}

	/**
	 * To add a new BillingStatus
	 * 
	 * @param billingStatus
	 *            detail of a new BillingStatus
	 */
	@Override
	public void addBillingStatus(BillingStatus billingStatus) {
		this.billingStatusDAO.addBillingStatus(billingStatus);

	}

	/**
	 * To update an existing BillingStatus
	 * 
	 * @param billingStatus
	 *            detail of an existing BillingStatus
	 */
	@Override
	public void updateBillingStatus(BillingStatus billingStatus) {
		this.billingStatusDAO.updateBillingStatus(billingStatus);

	}

	/**
	 * To get the list of all BillingStatuses
	 * 
	 * @return list of all the BillingStatuses
	 */
	@Override
	public List<BillingStatus> listBillingStatuses() {
		return this.billingStatusDAO.listBillingStatuses();
	}

	/**
	 * To get a billingStatus based on billingStatus id
	 * 
	 * @param id
	 *            id of an existing billingStatus
	 * @return BillingStatus of an existing billingStatus
	 */
	@Override
	public BillingStatus getBillingStatusByID(int id) {
		return this.billingStatusDAO.getBillingStatusByID(id);
	}

	/**
	 * To delete a billingStatus based on billingStatus id
	 * 
	 * @param id
	 *            id of an existing BillingStatus
	 */
	@Override
	public void removeBillingStatus(int id) {
		this.billingStatusDAO.removeBillingStatus(id);

	}

}

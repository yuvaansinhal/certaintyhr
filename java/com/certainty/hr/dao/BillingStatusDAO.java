package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.BillingStatus;

/**
 * DAO interface declaring methods to access Billing Status data
 * 
 *
 */
public interface BillingStatusDAO {

	public BillingStatus getBillingStatusByID(int id);

	public List<BillingStatus> listBillingStatuses();

	public void addBillingStatus(BillingStatus billingStatus);

	public void removeBillingStatus(int id);

	public void updateBillingStatus(BillingStatus billingStatus);
}

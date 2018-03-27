package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.BillingStatus;

/**
 * Service interface delcaring methods to access BillingStatus data
 * 
 *
 */
public interface BillingStatusService {
	
	public void addBillingStatus(BillingStatus billingStatus);

	public void updateBillingStatus(BillingStatus billingStatus);

	public List<BillingStatus> listBillingStatuses();

	public BillingStatus getBillingStatusByID(int id);

	public void removeBillingStatus(int id);
}

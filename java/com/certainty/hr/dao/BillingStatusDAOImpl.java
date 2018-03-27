package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.BillingStatus;

/**
 * 
 * DAO class implementing methods to access Billing Status data from database
 * 
 */
@Repository
public class BillingStatusDAOImpl implements BillingStatusDAO {
	@Autowired
	private HibernateTemplate template;

	/**
	 * Setting the autowired Hibernate Template passed from Application Context
	 * 
	 * @param template
	 *            - HIbernatem Template
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * To get a BillingStatus based on billingStatus id
	 * 
	 * @param id
	 *            - billingStatus id of an existing BillingStatus
	 * @return billingStatus based on BillingStatus
	 */
	@Override
	public BillingStatus getBillingStatusByID(int id) {
		return template.get(BillingStatus.class, new Integer(id));
	}

	/**
	 * To list all the BillingStatuses
	 * 
	 * @return list of all the BillingStatuses
	 */
	@Override
	public List<BillingStatus> listBillingStatuses() {
		List<BillingStatus> orderedBillingStatuses = template.loadAll(BillingStatus.class);
		Collections.sort(orderedBillingStatuses);
		return orderedBillingStatuses;
	}

	/**
	 * To add a new BillingStatus
	 * 
	 * @param billingStatus
	 *            detail of a new BillingStatus
	 */
	@Override
	public void addBillingStatus(BillingStatus billingStatus) {
		template.save(billingStatus);

	}

	/**
	 * To delete a BillingStatus based on billingStatus id
	 * 
	 * @param id
	 *            id of an existing BillingStatus
	 */
	@Override
	public void removeBillingStatus(int id) {
		BillingStatus billingStatus = (BillingStatus) template.get(BillingStatus.class, new Integer(id));
		if (null != billingStatus)
			template.delete(billingStatus);

	}

	/**
	 * To update a BillingStatus for an existing BillingStatus
	 * 
	 * @param billingStatus
	 *            detail of an existing BillingStatus
	 */
	@Override
	public void updateBillingStatus(BillingStatus billingStatus) {
		template.update(billingStatus);

	}

}

package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.UtilizationStatus;

/**
 * 
 * DAO class implementing methods to access UtilizationStatus data from database
 * 
 */
@Repository
public class UtilizationStatusDAOImpl implements UtilizationStatusDAO {

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
	 * To get an UtilizationStatus based on UtilizationStatus id
	 * 
	 * @param id
	 *            - UtilizationStatus id of an existing UtilizationStatus
	 * @return UtilizationStatus based on UtilizationStatus
	 */
	@Override
	public UtilizationStatus getUtilizationStatusByID(int id) {
		return template.get(UtilizationStatus.class, new Integer(id));
	}

	/**
	 * To list all the UtilizationStatuses
	 * 
	 * @return list of all the UtilizationStatuses
	 */
	@Override
	public List<UtilizationStatus> listUtilizationStatuses() {
		List<UtilizationStatus> orderedUtilizationStatuss = template.loadAll(UtilizationStatus.class);
		Collections.sort(orderedUtilizationStatuss);
		return orderedUtilizationStatuss;
	}

	/**
	 * To add a new UtilizationStatus
	 * 
	 * @param UtilizationStatus
	 *            of a new UtilizationStatus
	 */
	@Override
	public void addUtilizationStatus(UtilizationStatus utilizationStatus) {
		template.save(utilizationStatus);
	}

	/**
	 * To delete a UtilizationStatus based on UtilizationStatus id
	 * 
	 * @param id
	 *            of an existing UtilizationStatus
	 */
	@Override
	public void removeUtilizationStatus(int id) {
		UtilizationStatus it = (UtilizationStatus) template.get(UtilizationStatus.class, new Integer(id));
		if (null != it) {
			template.delete(it);
		}
	}

	/**
	 * To update an UtilizationStatus for an existing UtilizationStatus
	 * 
	 * @param UtilizationStatus
	 *            of an existing UtilizationStatus
	 */
	@Override
	public void updateUtilizationStatus(UtilizationStatus utilizationStatus) {
		template.update(utilizationStatus);
	}
}

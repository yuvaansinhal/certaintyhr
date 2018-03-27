package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.IndustryType;

/**
 * 
 * DAO class implementing methods to access Industry Type data from database
 * 
 */
@Repository
public class IndustryTypeDAOImpl implements IndustryTypeDAO {

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
	 * To get an Industry Type based on Industry Type id
	 * 
	 * @param id
	 *            - IndustryType id of an existing Industry Type
	 * @return industryType based on Industry Type
	 */
	@Override
	public IndustryType getIndustryTypeByID(int id) {
		return template.get(IndustryType.class, new Integer(id));
	}

	/**
	 * To list all the Industry Types
	 * 
	 * @return list of all the Industry Types
	 */
	@Override
	public List<IndustryType> listIndustryTypes() {
		List<IndustryType> orderedIndustryTypes = template.loadAll(IndustryType.class);
		Collections.sort(orderedIndustryTypes);
		return orderedIndustryTypes;
	}

	/**
	 * To add a new Industry Type
	 * 
	 * @param industryType
	 *            of a new Industry Type
	 */
	@Override
	public void addIndustryType(IndustryType industryType) {
		template.save(industryType);
	}

	/**
	 * To delete a Industry Type based on Industry Type id
	 * 
	 * @param id
	 *            of an existing Industry Type
	 */
	@Override
	public void removeIndustryType(int id) {
		IndustryType it = (IndustryType) template.get(IndustryType.class, new Integer(id));
		if (null != it) {
			template.delete(it);
		}
	}

	/**
	 * To update an Industry Type for an existing Industry Type
	 * 
	 * @param industryType
	 *            of an existing Industry Type
	 */
	@Override
	public void updateIndustryType(IndustryType industryType) {
		template.update(industryType);
	}
}

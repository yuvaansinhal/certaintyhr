package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.Technology;

/**
 * 
 * DAO class implementing methods to access Technology data from database
 * 
 */
@Repository
public class TechnologyDAOImpl implements TechnologyDAO {
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
	 * To get a Technology based on Technology id
	 * 
	 * @param id
	 *            - Technology id of an existing Technology
	 * @return Technology based on Technology
	 */

	@Override
	public Technology getTechnologyByID(int id) {
		return template.get(Technology.class, new Integer(id));
	}

	/**
	 * To list all the Technologies
	 * 
	 * @return list of all the Technologies
	 */

	@Override
	public List<Technology> listTechnologies() {
		List<Technology> orderedTechnologies = template.loadAll(Technology.class);
		Collections.sort(orderedTechnologies);
		return orderedTechnologies;
	}

	/**
	 * To add a new Technology
	 * 
	 * @param Technology
	 *            of a new Technology
	 */
	@Override
	public void addTechnology(Technology technology) {
		template.save(technology);
	}

	/**
	 * To delete a Technology based on Technology id
	 * 
	 * @param Technology
	 *            id of an existing Technology
	 */
	@Override
	public void removeTechnology(int id) {
		Technology t = (Technology) template.get(Technology.class, new Integer(id));
		if (null != t) {
			template.delete(t);
		}
	}

	/**
	 * To update a Technology for an existing Technology
	 * 
	 * @param Technology
	 *            of an existing Technology
	 */
	@Override
	public void updateTechnology(Technology technology) {
		template.update(technology);

	}

}

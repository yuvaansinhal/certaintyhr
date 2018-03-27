package com.certainty.hr.dao;

import java.util.Collections;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.Designation;

/**
 * 
 * DAO class implementing methods to access Designation data from database
 * 
 */
@Repository
public class DesignationDAOImpl implements DesignationDAO {
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
	 * To get a designation based on designation id
	 * 
	 * @param id
	 *            - designation id of an existing Designation
	 * @return designation based on designation
	 */
	@Override
	public Designation getDesignationByID(int id) {
		return template.get(Designation.class, new Integer(id));
	}

	/**
	 * To list all the designations
	 * 
	 * @return list of all the designations
	 */
	@Override
	public List<Designation> listDesignations() {
		List<Designation> orderedDesignations = template.loadAll(Designation.class);
		Collections.sort(orderedDesignations);
		return orderedDesignations;
	}

	/**
	 * To list all the Designations in for a particular grade in ascending order
	 * 
	 * @param id
	 *            - grade id of an existing grade
	 * @return list of all the Designations for a particular grade in ascending
	 *         order
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Designation> listOrderedDesignationsByGrade(int gradeId) {
		// TODO to find out better way to query using hibernate template and
		// remove the warning
		DetachedCriteria criteria = DetachedCriteria.forClass(Designation.class);
		criteria.add(Restrictions.eq("grade.gradeId", gradeId));
		List<Designation> orderedDesignations = (List<Designation>) (List) template.findByCriteria(criteria);
		Collections.sort(orderedDesignations);
		return orderedDesignations;
	}

	/**
	 * To add a new Designation
	 * 
	 * @param designation
	 *            detail of a new Designation
	 */
	@Override
	public void addDesignation(Designation designation) {
		template.save(designation);

	}

	/**
	 * To delete a designation based on designation id
	 * 
	 * @param id
	 *            id of an existing designation
	 */
	@Override
	public void removeDesignation(int id) {
		Designation designation = (Designation) template.get(Designation.class, new Integer(id));
		if (null != designation)
			template.delete(designation);
	}

	/**
	 * To update a designation for an existing designation
	 * 
	 * @param designation
	 *            detail of an existing Designation
	 */
	@Override
	public void updateDesignation(Designation designation) {
		template.update(designation);

	}

}

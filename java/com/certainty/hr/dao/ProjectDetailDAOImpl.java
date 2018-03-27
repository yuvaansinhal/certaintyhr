package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.ProjectDetail;

/**
 * 
 * DAO class implementing methods to access project detail data from database
 * 
 */

@Repository
public class ProjectDetailDAOImpl implements ProjectDetailDAO {

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
	 * To get a project detail based on project id
	 * 
	 * @param id
	 *            - project id of an existing project detail
	 * @return project detail based on project detail
	 */
	@Override
	public ProjectDetail getProjectDetailByID(int id) {
		return template.get(ProjectDetail.class, new Integer(id));
	}

	/**
	 * To list all the project details
	 * 
	 * @return list of all the project details
	 */
	@Override
	public List<ProjectDetail> listProjectDetails() {
		return template.loadAll(ProjectDetail.class);
	}

	/**
	 * To list all the project details in ascending order
	 * 
	 * @return list of all the project details in ascending order
	 */
	@Override
	public List<ProjectDetail> listOrderedProjectDetails() {
		List<ProjectDetail> orderedProjectDetails = template.loadAll(ProjectDetail.class);
		Collections.sort(orderedProjectDetails);
		return orderedProjectDetails;
	}

	/**
	 * To list all the project details in for a particular client in ascending
	 * order
	 * 
	 * @param id
	 *            - client id of an existing client
	 * @return list of all the project details for a particular client in
	 *         ascending order
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ProjectDetail> listOrderedProjectDetailsByClientID(int id) {
		// TODO to find out better way to query using hibernate template and remove the warning
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectDetail.class);
		criteria.add(Restrictions.eq("clientDetail.id", id));
		List<ProjectDetail> orderedProjectDetails = (List<ProjectDetail>) (List) template.findByCriteria(criteria);
		Collections.sort(orderedProjectDetails);
		return orderedProjectDetails;
	}
	
	/**
	 * To add a new project detail
	 * 
	 * @param project
	 *            detail of a new project
	 */
	@Override
	public void addProjectDetail(ProjectDetail pdl) {
		template.save(pdl);
	}

	/**
	 * To delete a project detail based on project id
	 * 
	 * @param project
	 *            id of an existing project
	 */
	@Override
	public void removeProjectDetail(int id) {
		ProjectDetail pdl = template.get(ProjectDetail.class, new Integer(id));
		if (null != pdl)
			template.delete(pdl);
	}

	/**
	 * To update a project detail for an existing project
	 * 
	 * @param project
	 *            detail of an existing project
	 */
	@Override
	public void updateProjectDetail(ProjectDetail pdl) {
		template.update(pdl);
	}
}

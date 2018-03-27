package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.ProjectResource;

/**
 * 
 * DAO class implementing methods to access project Resource data from database
 * 
 */

@Repository
public class ProjectResourceDAOImpl implements ProjectResourceDAO {

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
	 * To get a project Resource based on project id
	 * 
	 * @param id
	 *            - project id of an existing project Resource
	 * @return project Resource based on project detail
	 */
	@Override
	public ProjectResource getProjectResourceByID(int id) {
		return template.get(ProjectResource.class, new Integer(id));
	}

	/**
	 * To list all the project Resources
	 * 
	 * @return list of all the project Resources
	 */
	@Override
	public List<ProjectResource> listProjectResources() {
		return template.loadAll(ProjectResource.class);
	}

	/**
	 * To add a new project Resource
	 * 
	 * @param projectResource
	 *            detail of a new project Resource
	 */
	@Override
	public void addProjectResource(ProjectResource projectResource) {
		template.save(projectResource);
	}

	/**
	 * To delete a project Resource based on project id
	 * 
	 * @param id
	 *            id of an existing project Resource
	 */
	@Override
	public void removeProjectResource(int id) {
		ProjectResource projectResource = template.get(ProjectResource.class, new Integer(id));
		if (null != projectResource)
			template.delete(projectResource);
	}

	/**
	 * To update a project Resource for an existing project
	 * 
	 * @param projectResource
	 *            detail of an existing project Resource
	 */
	@Override
	public void updateProjectResource(ProjectResource projectResource) {
		template.update(projectResource);
	}
}

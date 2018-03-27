package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.ProjectResourceDAO;
import com.certainty.hr.model.ProjectResource;

/**
 * Service class implementing methods to access project Resource data using DAO
 * methods
 * 
 *
 */

@Service
@Transactional
public class ProjectResourceServiceImpl implements ProjectResourceService {

	@Autowired
	private ProjectResourceDAO projectResourceDAO;

	/**
	 * Setting the autowired Project Resource DAO passed from Application
	 * Context
	 * 
	 * @param projectResourceDAO
	 *            the Project Resource DAO to set
	 */
	public void setProjectResourceDAO(ProjectResourceDAO projectResourceDAO) {
		this.projectResourceDAO = projectResourceDAO;
	}

	/**
	 * To add a new project Resource
	 * 
	 * @param projectResource
	 *            detail of a new project
	 */
	@Override
	public void addProjectResource(ProjectResource projectResource) {
		this.projectResourceDAO.addProjectResource(projectResource);
	}

	/**
	 * To update an existing project Resource
	 * 
	 * @param projectResource
	 *            detail of an existing Resource
	 */
	@Override
	public void updateProjectResource(ProjectResource projectResource) {
		this.projectResourceDAO.updateProjectResource(projectResource);
	}

	/**
	 * To get the list of all project Resources
	 * 
	 * @return list of all the project Resources
	 */
	@Override
	public List<ProjectResource> listProjectResources() {
		return this.projectResourceDAO.listProjectResources();
	}

	/**
	 * To get a project Resource based on Resource id
	 * 
	 * @param id
	 *            id of an existing project Resource
	 * @return project Resource detail of an existing project Resource
	 */
	@Override
	public ProjectResource getProjectResourceByID(int id) {
		return this.projectResourceDAO.getProjectResourceByID(id);
	}

	/**
	 * To delete a project Resource based on project id
	 * 
	 * @param id
	 *            id of an existing project Resource
	 */
	@Override
	public void removeProjectResource(int id) {
		this.projectResourceDAO.removeProjectResource(id);

	}
}

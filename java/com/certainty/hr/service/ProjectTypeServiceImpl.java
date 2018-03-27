package com.certainty.hr.service;

import java.util.List;
/**
 * Service class implementing methods to access project detail data using DAO
 * methods
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.ProjectTypeDAO;
import com.certainty.hr.model.ProjectType;

/**
 * Service class implementing methods to access Project Type data using
 * DAO methods
 *
 */
@Service
@Transactional
public class ProjectTypeServiceImpl implements ProjectTypeService {

	@Autowired
	private ProjectTypeDAO projectTypeDAO;

	/**
	 * Setting the autowired Project Type DAO passed from Application Context
	 * 
	 * @param ProjectTypeDAO
	 *            the Project Type DAO to set
	 */
	public void setProjectTypeDAO(ProjectTypeDAO projectTypeDAO) {
		this.projectTypeDAO = projectTypeDAO;
	}

	/**
	 * To add a new Project Type
	 * 
	 * @param projectType
	 *            detail of a new Project Type
	 */

	@Override
	public void addProjectType(ProjectType projectType) {
		this.projectTypeDAO.addProjectType(projectType);

	}

	/**
	 * To update an existing Project Type
	 * 
	 * @param projectType
	 *            detail of an existing Project Type
	 */
	@Override
	public void updateProjectType(ProjectType projectType) {
		this.projectTypeDAO.updateProjectType(projectType);

	}

	/**
	 * To get the list of all Project Types
	 * 
	 * @return list of all the Project Types
	 */
	@Override
	public List<ProjectType> listProjectTypes() {
		return this.projectTypeDAO.listProjectTypes();
	}

	/**
	 * To get a Project Type based on Project Type id
	 * 
	 * @param projectType
	 *            id of an existing Project Type
	 * @return Project Type of an existing Project Type
	 */
	@Override
	public ProjectType getProjectTypeByID(int id) {

		return this.projectTypeDAO.getProjectTypeByID(id);
	}

	/**
	 * To delete a Project Type based on Project Type id
	 * 
	 * @param projectType
	 *            id of an existing Project Type
	 */
	@Override
	public void removeProjectType(int id) {
		this.projectTypeDAO.removeProjectType(id);
	}

}

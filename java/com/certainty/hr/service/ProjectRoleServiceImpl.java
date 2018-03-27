package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.ProjectRoleDAO;
import com.certainty.hr.model.ProjectRole;

/**
 * Service class implementing methods to access UsProjecter Role data using DAO
 * methods
 */

@Service
@Transactional
public class ProjectRoleServiceImpl implements ProjectRoleService {

	@Autowired
	private ProjectRoleDAO projectRoleDAO;

	/**
	 * Setting the autowired Project Role DAO passed from Application Context
	 * 
	 * @param projectRoleDAO
	 *            the Project Role DAO to set
	 */
	public void setProjectRoleDAO(ProjectRoleDAO projectRoleDAO) {
		this.projectRoleDAO = projectRoleDAO;
	}

	/**
	 * To add a new Project Role
	 * 
	 * @param projectRole
	 *            detail of a new Project Role
	 */
	@Override
	public void addProjectRole(ProjectRole projectRole) {
		this.projectRoleDAO.addProjectRole(projectRole);
	}

	/**
	 * To update an existing Project Role
	 * 
	 * @param projectRole
	 *            detail of an existing Project Role
	 */
	@Override
	public void updateProjectRole(ProjectRole projectRole) {
		this.projectRoleDAO.updateProjectRole(projectRole);
	}

	/**
	 * To get the list of all Project Role
	 * 
	 * @return list of all the Project Roles
	 */
	@Override
	public List<ProjectRole> listProjectRoles() {
		return this.projectRoleDAO.listProjectRoles();
	}

	/**
	 * To get a Project Role based on User Role id
	 * 
	 * @param id
	 *            id of an existing Project Role
	 * @return Project Role of an existing Project Role
	 */
	@Override
	public ProjectRole getProjectRoleByID(int id) {
		return this.projectRoleDAO.getProjectRoleByID(id);
	}

	/**
	 * To delete a Project Role based on Project Role id
	 * 
	 * @param id
	 *            of an existing Project Role
	 */
	@Override
	public void removeProjectRole(int id) {
		this.projectRoleDAO.removeProjectRole(id);
	}

}

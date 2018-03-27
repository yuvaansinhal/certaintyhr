package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.ProjectRole;

/**
 * 
 * DAO class implementing methods to access Project Role data from database
 * 
 */
@Repository
public class ProjectRoleDAOImpl implements ProjectRoleDAO {
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
	 * To get a Project Role based on User Role id
	 * 
	 * @param id
	 *            - Project Role id of an existing Project Role
	 * @return Project Role based on Project Role ID
	 */

	@Override
	public ProjectRole getProjectRoleByID(int id) {
		return template.get(ProjectRole.class, new Integer(id));
	}

	/**
	 * To list all the Project Roles
	 * 
	 * @return list of all the Project Roles
	 */

	@Override
	public List<ProjectRole> listProjectRoles() {
		List<ProjectRole> orderedProjectRoles = template.loadAll(ProjectRole.class);
		Collections.sort(orderedProjectRoles);
		return orderedProjectRoles;
	}

	/**
	 * To add a new Project Role
	 * 
	 * @param projectRole
	 *            of a new Project Role
	 */
	@Override
	public void addProjectRole(ProjectRole projectRole) {
		template.save(projectRole);
	}

	/**
	 * To delete a Project Role based on Project Role id
	 * 
	 * @param id
	 *            of an existing Project Role
	 */
	@Override
	public void removeProjectRole(int id) {
		ProjectRole pr = (ProjectRole) template.get(ProjectRole.class, new Integer(id));
		if (null != pr) {
			template.delete(pr);
		}
	}

	/**
	 * To update a Project Role for an existing Project Role
	 * 
	 * @param projectRole
	 *            of an existing Project Role
	 */

	@Override
	public void updateProjectRole(ProjectRole projectRole) {
		template.update(projectRole);
	}

}

package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.ProjectType;

/**
 * 
 * DAO class implementing methods to access Project Type data from database
 * 
 */
@Repository
public class ProjectTypeDAOImpl implements ProjectTypeDAO {
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
	 * To get a Project Type based on Project Type id
	 * 
	 * @param id
	 *            - Project Type id of an existing Project Type
	 * @return Project Type based on Project Type ID
	 */

	@Override
	public ProjectType getProjectTypeByID(int id) {
		return template.get(ProjectType.class, new Integer(id));
	}

	/**
	 * To list all the Project Types
	 * 
	 * @return list of all the Project Types
	 */

	@Override
	public List<ProjectType> listProjectTypes() {
		List<ProjectType> orderedProjectTypes = template.loadAll(ProjectType.class);
		Collections.sort(orderedProjectTypes);
		return orderedProjectTypes;
	}

	/**
	 * To add a new Project Type
	 * 
	 * @param projectType
	 *            of a new Project Type
	 */
	@Override
	public void addProjectType(ProjectType projectType) {
		template.save(projectType);
	}

	/**
	 * To delete a Project Type based on Project Type id
	 * 
	 * @param id
	 *            of an existing Project Type
	 */
	@Override
	public void removeProjectType(int id) {
		ProjectType pt = (ProjectType) template.get(ProjectType.class, new Integer(id));
		if (null != pt) {
			template.delete(pt);
		}
	}

	/**
	 * To update a ProjectType for an existing Project Type
	 * 
	 * @param projectType
	 *            of an existing Project Type
	 */

	@Override
	public void updateProjectType(ProjectType projectType) {
		template.update(projectType);
	}

}

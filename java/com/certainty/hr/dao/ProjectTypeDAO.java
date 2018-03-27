package com.certainty.hr.dao;

import java.util.List;
import com.certainty.hr.model.ProjectType;

/**
 * DAO interface declaring methods to access Project Type data
 * 
 *
 */

public interface ProjectTypeDAO {

	public ProjectType getProjectTypeByID(int id);

	public List<ProjectType> listProjectTypes();

	public void addProjectType(ProjectType projectType);

	public void removeProjectType(int id);

	public void updateProjectType(ProjectType projectType);

}

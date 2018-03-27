package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.ProjectType;

/**
 * Service interface delcaring methods to access Projet Type data
 * 
 *
 */

public interface ProjectTypeService {

	public void addProjectType(ProjectType projectType);

	public void updateProjectType(ProjectType projectType);

	public List<ProjectType> listProjectTypes();

	public ProjectType getProjectTypeByID(int id);

	public void removeProjectType(int id);

}

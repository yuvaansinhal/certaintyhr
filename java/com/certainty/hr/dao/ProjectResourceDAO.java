package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.ProjectResource;

/**
 * DAO interface declaring methods to access project Resource data
 * 
 */

public interface ProjectResourceDAO {

	public ProjectResource getProjectResourceByID(int id);

	public List<ProjectResource> listProjectResources();

	public void addProjectResource(ProjectResource projectResource);

	public void removeProjectResource(int id);

	public void updateProjectResource(ProjectResource projectResource);

}

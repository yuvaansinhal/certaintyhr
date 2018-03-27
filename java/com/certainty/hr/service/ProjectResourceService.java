package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.ProjectResource;

/**
 * Service interface delcaring methods to access project Resource data
 */

public interface ProjectResourceService {

	public void addProjectResource(ProjectResource projectResource);

	public void updateProjectResource(ProjectResource projectResource);

	public List<ProjectResource> listProjectResources();

	public ProjectResource getProjectResourceByID(int id);

	public void removeProjectResource(int id);

}

package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.ProjectRole;

/**
 * Service interface delcaring methods to access Project Role data
 * 
 *
 */

public interface ProjectRoleService {

	public void addProjectRole(ProjectRole projectRole);

	public void updateProjectRole(ProjectRole projectRole);

	public List<ProjectRole> listProjectRoles();

	public ProjectRole getProjectRoleByID(int id);

	public void removeProjectRole(int id);

}
package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.ProjectRole;

/**
 * DAO interface declaring methods to access Project Role data
 * 
 *
 */

public interface ProjectRoleDAO {

	public ProjectRole getProjectRoleByID(int id);

	public List<ProjectRole> listProjectRoles();

	public void addProjectRole(ProjectRole projectRole);

	public void removeProjectRole(int id);

	public void updateProjectRole(ProjectRole projectRole);

}

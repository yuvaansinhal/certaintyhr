package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.ProjectDetail;

/**
 * DAO interface declaring methods to access project detail data
 * 
 */

public interface ProjectDetailDAO {

	public ProjectDetail getProjectDetailByID(int id);

	public List<ProjectDetail> listOrderedProjectDetails();

	public List<ProjectDetail> listProjectDetails();

	public List<ProjectDetail> listOrderedProjectDetailsByClientID(int cdl);

	public void addProjectDetail(ProjectDetail projectDetail);

	public void removeProjectDetail(int id);

	public void updateProjectDetail(ProjectDetail projectDetail);

}

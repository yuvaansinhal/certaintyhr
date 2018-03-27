package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.ProjectDetail;

/**
 * Service interface delcaring methods to access project detail data
 */

public interface ProjectDetailService {

	public void addProjectDetail(ProjectDetail projectDetail);

	public void updateProjectDetail(ProjectDetail projectDetail);

	public List<ProjectDetail> listProjectDetails();
	
	public List<ProjectDetail> listOrderedProjectDetails();
	
	public List<ProjectDetail> listOrderedProjectDetailsByClientID(int id);

	public ProjectDetail getProjectDetailByID(int id);

	public void removeProjectDetail(int id);

}

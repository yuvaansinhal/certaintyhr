package com.certainty.hr.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.certainty.hr.dao.ProjectDetailDAO;
import com.certainty.hr.model.ProjectDetail;

/**
 * Service class implementing methods to access project detail data using DAO
 * methods
 * 
 *
 */

@Service
@Transactional
public class ProjectDetailServiceImpl implements ProjectDetailService {

	@Autowired
	private ProjectDetailDAO projectDetailDAO;

	/**
	 * Setting the autowired Project Detail DAO passed from Application Context
	 * 
	 * @param projectDetailDAO
	 *            the Project Detail DAO to set
	 */
	public void setProjectDetailDAO(ProjectDetailDAO projectDetailDAO) {
		this.projectDetailDAO = projectDetailDAO;
	}

	/**
	 * To add a new project detail
	 * 
	 * @param project
	 *            detail of a new project
	 */
	
	@Override
	public void addProjectDetail(ProjectDetail pdl) {
		this.projectDetailDAO.addProjectDetail(pdl);
	}
	/**
	 * To update an existing project detail
	 * 
	 * @param project
	 *            detail of an existing project
	 */
	@Override
	public void updateProjectDetail(ProjectDetail pdl) {
		this.projectDetailDAO.updateProjectDetail(pdl);
	}
	/**
	 * To get the list of all project details
	 * 
	 * @return list of all the project details
	 */
	@Override
	public List<ProjectDetail> listProjectDetails() {
		return this.projectDetailDAO.listProjectDetails();
	}
	/**
	 * To get the list of all project details in ascending order
	 * 
	 * @return list of all the project details in ascending order
	 */
	@Override
	public List<ProjectDetail> listOrderedProjectDetails() {
		return this.projectDetailDAO.listOrderedProjectDetails();
	}
	/**
	 * To get the list of all project details for a particular client idin ascending order
	 * @param client
	 *            id of an existing client
	 * @return list of all the project details for particular client in ascending order
	 */
	@Override
	public List<ProjectDetail> listOrderedProjectDetailsByClientID(int id) {
		return this.projectDetailDAO.listOrderedProjectDetailsByClientID(id);
	}
	/**
	 * To get a project detail based on project id
	 * 
	 * @param project
	 *            id of an existing project
	 * @return project detail of an existing project
	 */
	@Override
	public ProjectDetail getProjectDetailByID(int id) {
		return this.projectDetailDAO.getProjectDetailByID(id);
	}
	/**
	 * To delete a project detail based on project id
	 * 
	 * @param project
	 *            id of an existing project
	 */
	@Override
	public void removeProjectDetail(int id) {
		this.projectDetailDAO.removeProjectDetail(id);
		
	}
}

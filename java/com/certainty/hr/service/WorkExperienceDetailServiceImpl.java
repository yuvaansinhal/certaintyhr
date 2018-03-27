package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.WorkExperienceDetailDAO;
import com.certainty.hr.model.WorkExperienceDetail;

/**
 * Service class implementing methods to access WorkExperience detail data using
 * DAO methods
 * 
 *
 */
@Service
@Transactional
public class WorkExperienceDetailServiceImpl implements WorkExperienceDetailService {
	@Autowired
	private WorkExperienceDetailDAO workExperienceDetailDAO;

	/**
	 * Setting the autowired WorkExperience Detail DAO passed from Application
	 * Context
	 * 
	 * @param workExperienceDetailDAO
	 *            the WorkExperience Detail DAO to set
	 */
	public void setWorkExperienceDetailDAO(WorkExperienceDetailDAO workExperienceDetailDAO) {
		this.workExperienceDetailDAO = workExperienceDetailDAO;
	}

	/**
	 * To add a new WorkExperience detail
	 * 
	 * @param workExperienceDetail
	 *            detail of a new WorkExperience
	 */
	@Override
	public void addWorkExperienceDetail(WorkExperienceDetail workExperienceDetail) {
		this.workExperienceDetailDAO.addWorkExperienceDetail(workExperienceDetail);

	}

	/**
	 * To update an existing WorkExperience detail
	 * 
	 * @param workExperienceDetail
	 *            detail of an existing WorkExperience
	 */
	@Override
	public void updateWorkExperienceDetail(WorkExperienceDetail workExperienceDetail) {
		this.workExperienceDetailDAO.updateWorkExperienceDetail(workExperienceDetail);

	}

	/**
	 * To get the list of all WorkExperience details
	 * 
	 * @return list of all the WorkExperience details
	 */
	@Override
	public List<WorkExperienceDetail> listWorkExperienceDetails() {
		return this.workExperienceDetailDAO.listWorkExperienceDetails();
	}

	/**
	 * To get a WorkExperience Detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing WorkExperience
	 * @return WorkExperience detail of an existing WorkExperience
	 */
	@Override
	public WorkExperienceDetail getWorkExperienceDetailByID(int id) {
		return this.workExperienceDetailDAO.getWorkExperienceDetailByID(id);
	}

	/**
	 * To delete a WorkExperience detail based on id
	 * 
	 * @param id
	 *            id of an existing WorkExperience
	 */
	@Override
	public void removeWorkExperienceDetail(int id) {
		this.workExperienceDetailDAO.removeWorkExperienceDetail(id);

	}

}

package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.WorkExperienceDetail;

/**
 * DAO interface declaring methods to access WorkExperience Detail data
 * 
 *
 */
public interface WorkExperienceDetailDAO {

	public WorkExperienceDetail getWorkExperienceDetailByID(int id);

	public List<WorkExperienceDetail> listWorkExperienceDetails();

	public void addWorkExperienceDetail(WorkExperienceDetail workExperienceDetial);

	public void updateWorkExperienceDetail(WorkExperienceDetail workExperienceDetial);

	public void removeWorkExperienceDetail(int id);
}

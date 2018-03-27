package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.WorkExperienceDetail;

/**
 * Service interface delcaring methods to access WorkExperience Detail data
 * 
 *
 */
public interface WorkExperienceDetailService {

	public void addWorkExperienceDetail(WorkExperienceDetail workExperienceDetail);

	public void updateWorkExperienceDetail(WorkExperienceDetail workExperienceDetail);

	public List<WorkExperienceDetail> listWorkExperienceDetails();

	public WorkExperienceDetail getWorkExperienceDetailByID(int id);

	public void removeWorkExperienceDetail(int id);
}

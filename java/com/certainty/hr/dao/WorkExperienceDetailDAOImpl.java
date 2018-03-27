package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.WorkExperienceDetail;

/**
 * 
 * DAO class implementing methods to access WorkExperience detail data from
 * database
 * 
 */
@Repository
public class WorkExperienceDetailDAOImpl implements WorkExperienceDetailDAO {
	@Autowired
	private HibernateTemplate template;

	/**
	 * Setting the autowired Hibernate Template passed from Application Context
	 * 
	 * @param template
	 *            - HIbernatem Template
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * To get a WorkExperience detail based on id
	 * 
	 * @param id
	 *            - WorkExperience id of an existing WorkExperience detail
	 * @return WorkExperience detail based on WorkExperience detail
	 */
	@Override
	public WorkExperienceDetail getWorkExperienceDetailByID(int id) {
		return template.get(WorkExperienceDetail.class, new Integer(id));
	}

	/**
	 * To list all the WorkExperience details
	 * 
	 * @return list of all the WorkExperience details
	 */
	@Override
	public List<WorkExperienceDetail> listWorkExperienceDetails() {
		return template.loadAll(WorkExperienceDetail.class);
	}

	/**
	 * To add a new WorkExperience detail
	 * 
	 * @param workExperienceDetial
	 *            detail of a new WorkExperience
	 */
	@Override
	public void addWorkExperienceDetail(WorkExperienceDetail workExperienceDetial) {
		template.save(workExperienceDetial);
	}

	/**
	 * To update a WorkExperience detail for an existing WorkExperience
	 * 
	 * @param workExperienceDetial
	 *            detail of an existing WorkExperience
	 */
	@Override
	public void updateWorkExperienceDetail(WorkExperienceDetail workExperienceDetial) {
		template.update(workExperienceDetial);

	}

	/**
	 * To delete a WorkExperience detail based on id
	 * 
	 * @param id
	 *            id of an existing WorkExperience
	 */
	@Override
	public void removeWorkExperienceDetail(int id) {
		WorkExperienceDetail wed = (WorkExperienceDetail) template.get(WorkExperienceDetail.class, new Integer(id));
		if (null != wed) {
			template.delete(wed);
		}

	}

}

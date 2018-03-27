package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EducationCourse;
/**
 * 
 * DAO class implementing methods to access EducationCourse data from database
 * 
 */

@Repository
public class EducationCourseDAOImpl implements EducationCourseDAO {
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
	 * To get a educationCourse based on educationCourse id
	 * 
	 * @param id
	 *            - educationCourse id of an existing EducationCourse
	 * @return educationCourse based on educationCourse
	 */
	@Override
	public EducationCourse getEducationCourseByID(int id) {
		return template.get(EducationCourse.class, new Integer(id));
	}

	/**
	 * To list all the educationCourses
	 * 
	 * @return list of all the educationCourses
	 */
	@Override
	public List<EducationCourse> listEducationCourses() {
		List<EducationCourse> orderedEducationCourses = template.loadAll(EducationCourse.class);
		Collections.sort(orderedEducationCourses);
		return orderedEducationCourses;
	}

	/**
	 * To add a new EducationCourse
	 * 
	 * @param educationCourse
	 *            detail of a new EducationCourse
	 */
	@Override
	public void addEducationCourse(EducationCourse educationCourse) {
		template.save(educationCourse);
	}

	/**
	 * To delete a educationCourse based on educationCourse id
	 * 
	 * @param id
	 *            id of an existing educationCourse
	 */
	@Override
	public void removeEducationCourse(int id) {
		EducationCourse educationCourse = (EducationCourse) template.get(EducationCourse.class, new Integer(id));
		if (null != educationCourse)
			template.delete(educationCourse);

	}

	/**
	 * To update a educationCourse for an existing educationCourse
	 * 
	 * @param educationCourse
	 *            detail of an existing EducationCourse
	 */
	@Override
	public void updateEducationCourse(EducationCourse educationCourse) {
		template.update(educationCourse);

	}

	/**
	 * To list all the ordered educationCourses
	 * 
	 * @return list of all the ordered educationCourses
	 */
	@Override
	public List<EducationCourse> listOrderedEducationCourses() {
		List<EducationCourse> orderedProjectDetails = template.loadAll(EducationCourse.class);
		Collections.sort(orderedProjectDetails);
		return orderedProjectDetails;
		
	}
}

package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.Grade;

/**
 * 
 * DAO class implementing methods to access Grade data from database
 * 
 */
@Repository
public class GradeDAOImpl implements GradeDAO {

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
	 * To get an Grade Type based on Grade id
	 * 
	 * @param id
	 *            - Grade id of an existing Grade
	 * @return Grade based on Grade
	 */
	@Override
	public Grade getGradeByID(int id) {
		return template.get(Grade.class, new Integer(id));
	}

	/**
	 * To list all the Grades
	 * 
	 * @return list of all the Grades
	 */
	@Override
	public List<Grade> listGrades() {
		List<Grade> orderedGrades = template.loadAll(Grade.class);
		return orderedGrades;
	}

	/**
	 * To add a new Grade
	 * 
	 * @param grade
	 *            of a new Grade
	 */
	@Override
	public void addGrade(Grade grade) {
		template.save(grade);
	}

	/**
	 * To delete a Grade based on Grade id
	 * 
	 * @param id
	 *            of an existing Grade
	 */
	@Override
	public void removeGrade(int id) {
		Grade it = (Grade) template.get(Grade.class, new Integer(id));
		if (null != it) {
			template.delete(it);
		}
	}

	/**
	 * To update an Grade for an existing Grade
	 * 
	 * @param grade
	 *            of an existing Grade
	 */
	@Override
	public void updateGrade(Grade grade) {
		template.update(grade);
	}
}

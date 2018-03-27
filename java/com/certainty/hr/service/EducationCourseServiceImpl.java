package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EducationCourseDAO;
import com.certainty.hr.model.EducationCourse;

/**
 * Service class implementing methods to access Education Course data using DAO
 * methods
 * 
 *
 */
@Service
@Transactional
public class EducationCourseServiceImpl implements EducationCourseService {

	@Autowired
	private EducationCourseDAO educationCourseDAO;

	/**
	 * Setting the autowired Education Course DAO passed from Application
	 * Context
	 * 
	 * @param educationCourseDAO
	 *            the Education Course DAO to set
	 */
	public void setEducationCourseDAO(EducationCourseDAO educationCourseDAO) {
		this.educationCourseDAO = educationCourseDAO;
	}

	/**
	 * To add a new Education Course
	 * 
	 * @param educationCourse
	 *            detail of a new Education Course
	 */

	@Override
	public void addEducationCourse(EducationCourse educationCourse) {
		this.educationCourseDAO.addEducationCourse(educationCourse);
	}

	/**
	 * To update an existing EducationCourse
	 * 
	 * @param educationCourse
	 *            detail of an existing project
	 */
	@Override
	public void updateEducationCourse(EducationCourse educationCourse) {
		this.educationCourseDAO.updateEducationCourse(educationCourse);
	}

	/**
	 * To get the list of all Education Courses
	 * 
	 * @return list of all the Education Courses
	 */
	@Override
	public List<EducationCourse> listEducationCourses() {
		return this.educationCourseDAO.listEducationCourses();
	}

	/**
	 * To get a Education Course based on project id
	 * 
	 * @param id
	 *            id of an existing Education Course
	 * @return Education Course detail of an existing EducationCourse
	 */
	@Override
	public EducationCourse getEducationCourseByID(int id) {
		return this.educationCourseDAO.getEducationCourseByID(id);
	}

	/**
	 * To delete a Education Course based on Education Course id
	 * 
	 * @param id
	 *            id of an existing Education Course
	 */
	@Override
	public void removeEducationCourse(int id) {
		this.educationCourseDAO.removeEducationCourse(id);

	}
}

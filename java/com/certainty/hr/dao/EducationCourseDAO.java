package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EducationCourse;

/**
 * DAO interface declaring methods to access Education Course data
 * 
 *
 */
public interface EducationCourseDAO {

	public EducationCourse getEducationCourseByID(int id);

	public List<EducationCourse> listEducationCourses();

	public List<EducationCourse> listOrderedEducationCourses();

	public void addEducationCourse(EducationCourse educationCourse);

	public void removeEducationCourse(int id);

	public void updateEducationCourse(EducationCourse educationCourse);

}

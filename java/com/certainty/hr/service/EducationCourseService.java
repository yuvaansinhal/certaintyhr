package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EducationCourse;

/**
 * Service interface delcaring methods to access Education Course data
 * 
 *
 */
public interface EducationCourseService {

	public void addEducationCourse(EducationCourse educationCourse);

	public void updateEducationCourse(EducationCourse educationCourse);

	public List<EducationCourse> listEducationCourses();

	public EducationCourse getEducationCourseByID(int id);

	public void removeEducationCourse(int id);

}

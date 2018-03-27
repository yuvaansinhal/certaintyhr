package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.Grade;

/**
 * Service interface delcaring methods to access Grade data
 * 
 *
 */
public interface GradeService {

	public void addGrade(Grade Grade);

	public void updateGrade(Grade Grade);

	public List<Grade> listGrades();

	public Grade getGradeByID(int id);

	public void removeGrade(int id);

}

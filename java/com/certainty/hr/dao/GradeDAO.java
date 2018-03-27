package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.Grade;

/**
 * DAO interface declaring methods to access Grade data
 * 
 *
 */
public interface GradeDAO {

	public Grade getGradeByID(int id);

	public List<Grade> listGrades();

	public void addGrade(Grade Grade);

	public void removeGrade(int id);

	public void updateGrade(Grade Grade);
}

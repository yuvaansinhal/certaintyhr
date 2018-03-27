package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.Designation;

/**
 * DAO interface declaring methods to access Designation data
 * 
 *
 */
public interface DesignationDAO {

	public Designation getDesignationByID(int id);

	public List<Designation> listDesignations();

	public List<Designation> listOrderedDesignationsByGrade(int gradeId);

	public void addDesignation(Designation designation);

	public void removeDesignation(int id);

	public void updateDesignation(Designation designation);
}

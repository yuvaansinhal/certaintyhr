package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.Designation;

public interface DesignationService {

	public void addDesignation(Designation designation);

	public void updateDesignation(Designation designation);

	public List<Designation> listDesignations();

	public List<Designation> listOrderedDesignationsByGrade(int gradeId);

	public Designation getDesignationByID(int id);

	public void removeDesignation(int id);

}

package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.certainty.hr.dao.DesignationDAO;
import com.certainty.hr.model.Designation;

public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationDAO designationDAO;

	/**
	 * Setting the autowired Designation DAO passed from Application Context
	 * 
	 * @param designationDAO
	 *            the Designation DAO to set
	 */
	public void setDesignationDAO(DesignationDAO designationDAO) {
		this.designationDAO = designationDAO;
	}

	/**
	 * To add a new Designation
	 * 
	 * @param Designation
	 *            detail of a new Designation
	 */
	@Override
	public void addDesignation(Designation designation) {
		this.designationDAO.addDesignation(designation);
	}

	/**
	 * To update an existing Designation
	 * 
	 * @param designation
	 *            detail of an existing Designation
	 */
	@Override
	public void updateDesignation(Designation designation) {
		this.designationDAO.updateDesignation(designation);
	}

	/**
	 * To get the list of all designations
	 * 
	 * @return list of all the designations
	 */
	@Override
	public List<Designation> listDesignations() {
		return this.designationDAO.listDesignations();
	}

	/**
	 * To get a designation based on designation id
	 * 
	 * @param id
	 *            id of an existing designation
	 * @return designation of an existing designation
	 */
	@Override
	public Designation getDesignationByID(int id) {
		return this.designationDAO.getDesignationByID(id);
	}

	/**
	 * To delete a Designation based on designation id
	 * 
	 * @param id
	 *            id of an existing Designation
	 */
	@Override
	public void removeDesignation(int id) {
		this.designationDAO.removeDesignation(id);
	}

	/**
	 * To get the list of all Designation for a particular grade idin ascending
	 * order
	 * 
	 * @param client
	 *            id of an existing grade
	 * @return list of all the Designation for particular grade in ascending
	 *         order
	 */
	@Override
	public List<Designation> listOrderedDesignationsByGrade(int gradeId) {
		return this.designationDAO.listOrderedDesignationsByGrade(gradeId);
	}

}

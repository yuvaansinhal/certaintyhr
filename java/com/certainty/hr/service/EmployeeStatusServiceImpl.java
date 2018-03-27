package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.certainty.hr.dao.EmployeeStatusDAO;
import com.certainty.hr.model.EmployeeStatus;

/**
 * Service class implementing methods to access Emp Statusdata using DAO methods
 * 
 *
 */
public class EmployeeStatusServiceImpl implements EmployeeStatusService {

	@Autowired
	private EmployeeStatusDAO employeeStatusDAO;

	/**
	 * Setting the autowired EmployeeStatus DAO passed from Application Context
	 * 
	 * @param EmployeeStatusDAO
	 *            the EmployeeStatus DAO to set
	 */
	public void setEmployeeStatusDAO(EmployeeStatusDAO employeeStatusDAO) {
		this.employeeStatusDAO = employeeStatusDAO;
	}

	/**
	 * To add a new EmployeeStatus
	 * 
	 * @param EmployeeStatus
	 *            detail of a new EmployeeStatus
	 */
	@Override
	public void addEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatusDAO.addEmployeeStatus(employeeStatus);
	}

	/**
	 * To update an existing EmployeeStatus
	 * 
	 * @param EmployeeStatus
	 *            detail of an existing EmployeeStatus
	 */
	@Override
	public void updateEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatusDAO.updateEmployeeStatus(employeeStatus);
	}

	/**
	 * To get the list of all EmployeeStatuss
	 * 
	 * @return list of all the EmployeeStatuss
	 */
	@Override
	public List<EmployeeStatus> listEmployeeStatuses() {
		return this.employeeStatusDAO.listEmployeeStatuses();
	}

	/**
	 * To get a EmployeeStatus based on EmployeeStatus id
	 * 
	 * @param id
	 *            id of an existing EmployeeStatus
	 * @return EmployeeStatus of an existing EmployeeStatus
	 */
	@Override
	public EmployeeStatus getEmployeeStatusByID(int id) {
		return this.employeeStatusDAO.getEmployeeStatusByID(id);
	}

	/**
	 * To delete a EmployeeStatus based on EmployeeStatus id
	 * 
	 * @param id
	 *            id of an existing EmployeeStatus
	 */
	@Override
	public void removeEmployeeStatus(int id) {
		this.employeeStatusDAO.removeEmployeeStatus(id);
	}

}

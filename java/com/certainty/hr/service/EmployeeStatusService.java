package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmployeeStatus;

/**
 * Service interface delcaring methods to access Education Status data
 * 
 *
 */
public interface EmployeeStatusService {

	public void addEmployeeStatus(EmployeeStatus employeeStatus);

	public void updateEmployeeStatus(EmployeeStatus employeeStatus);

	public List<EmployeeStatus> listEmployeeStatuses();

	public EmployeeStatus getEmployeeStatusByID(int id);

	public void removeEmployeeStatus(int id);

}

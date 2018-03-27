package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmployeeStatus;

/**
 * DAO interface declaring methods to access Emp Status data
 * 
 *
 */
public interface EmployeeStatusDAO {
	public EmployeeStatus getEmployeeStatusByID(int id);

	public List<EmployeeStatus> listEmployeeStatuses();

	public void addEmployeeStatus(EmployeeStatus employeeStatus);

	public void removeEmployeeStatus(int id);

	public void updateEmployeeStatus(EmployeeStatus employeeStatus);
}

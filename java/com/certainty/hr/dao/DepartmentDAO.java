package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.Department;

/**
 * DAO interface declaring methods to access Department data
 * 
 *
 */
public interface DepartmentDAO {

	public Department getDepartmentByID(int id);

	public List<Department> listDepartments();

	public void addDepartment(Department department);

	public void removeDepartment(int id);

	public void updateDepartment(Department department);

}

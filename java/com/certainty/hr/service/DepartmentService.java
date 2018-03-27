package com.certainty.hr.service;

import java.util.List;
/**
 * Service interface delcaring methods to access Department data
 * 
 *
 */
import com.certainty.hr.model.Department;

public interface DepartmentService {
	
	public void addDepartment(Department department);

	public void updateDepartment(Department department);

	public List<Department> listDepartments();

	public Department getDepartmentByID(int id);

	public void removeDepartment(int id);
}

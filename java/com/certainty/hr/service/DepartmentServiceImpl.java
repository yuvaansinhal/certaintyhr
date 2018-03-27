package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.DepartmentDAO;
import com.certainty.hr.model.Department;

/**
 * Service class implementing methods to access Department data using DAO
 * methods
 * 
 *
 */

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDAO departmentDAO;

	/**
	 * Setting the autowired Department DAO passed from Application Context
	 * 
	 * @param departmentDAO
	 *            the Department DAO to set
	 */
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	/**
	 * To add a new Department
	 * 
	 * @param department
	 *            detail of a new department
	 */
	@Override
	public void addDepartment(Department department) {
		this.departmentDAO.addDepartment(department);
	}

	/**
	 * To update an existing department
	 * 
	 * @param department
	 *            detail of an existing department
	 */
	@Override
	public void updateDepartment(Department department) {
		this.departmentDAO.updateDepartment(department);
	}

	/**
	 * To get the list of all departments
	 * 
	 * @return list of all the departments
	 */
	@Override
	public List<Department> listDepartments() {
		return this.departmentDAO.listDepartments();
	}

	/**
	 * To get a department based on department id
	 * 
	 * @param id
	 *            id of an existing department
	 * @return department of an existing department
	 */
	@Override
	public Department getDepartmentByID(int id) {
		return this.departmentDAO.getDepartmentByID(id);
	}

	/**
	 * To delete a department based on department id
	 * 
	 * @param id
	 *            id of an existing department
	 */
	@Override
	public void removeDepartment(int id) {
		this.departmentDAO.removeDepartment(id);

	}

}

package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.Department;

/**
 * 
 * DAO class implementing methods to access Department data from database
 * 
 */
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	@Autowired
	private HibernateTemplate template;

	/**
	 * Setting the autowired Hibernate Template passed from Application Context
	 * 
	 * @param template
	 *            - HIbernatem Template
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * To get a department based on department id
	 * 
	 * @param id
	 *            - department id of an existing Department
	 * @return department based on department
	 */
	@Override
	public Department getDepartmentByID(int id) {
		return template.get(Department.class, new Integer(id));
	}

	/**
	 * To list all the departments
	 * 
	 * @return list of all the departments
	 */
	@Override
	public List<Department> listDepartments() {
		List<Department> orderedDepartments = template.loadAll(Department.class);
		Collections.sort(orderedDepartments);
		return orderedDepartments;
	}

	/**
	 * To add a new Department
	 * 
	 * @param department
	 *            detail of a new Department
	 */
	@Override
	public void addDepartment(Department department) {
		template.save(department);
	}

	/**
	 * To delete a department based on department id
	 * 
	 * @param id
	 *            id of an existing department
	 */
	@Override
	public void removeDepartment(int id) {
		Department department = (Department) template.get(Department.class, new Integer(id));
		if (null != department)
			template.delete(department);

	}

	/**
	 * To update a department for an existing department
	 * 
	 * @param department
	 *            detail of an existing Department
	 */
	@Override
	public void updateDepartment(Department department) {
		template.update(department);

	}
}

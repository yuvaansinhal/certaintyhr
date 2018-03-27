package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.certainty.hr.model.EmployeeStatus;

/**
 * 
 * DAO class implementing methods to access EmployeeStatus data from database
 * 
 */
public class EmployeeStatusDAOImpl implements EmployeeStatusDAO {
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
	 * To get a EmployeeStatus based on EmployeeStatus id
	 * 
	 * @param id
	 *            - EmployeeStatus id of an existing EmployeeStatus
	 * @return EmployeeStatus based on EmployeeStatus
	 */
	@Override
	public EmployeeStatus getEmployeeStatusByID(int id) {
		return template.get(EmployeeStatus.class, new Integer(id));
	}

	/**
	 * To list all the EmployeeStatuss
	 * 
	 * @return list of all the EmployeeStatuss
	 */
	@Override
	public List<EmployeeStatus> listEmployeeStatuses() {
		List<EmployeeStatus> orderedEmployeeStatuss = template.loadAll(EmployeeStatus.class);
		Collections.sort(orderedEmployeeStatuss);
		return orderedEmployeeStatuss;
	}

	/**
	 * To add a new EmployeeStatus
	 * 
	 * @param EmployeeStatus
	 *            detail of a new EmployeeStatus
	 */
	@Override
	public void addEmployeeStatus(EmployeeStatus employeeStatus) {
		template.save(employeeStatus);

	}

	/**
	 * To delete a EmployeeStatus based on EmployeeStatus id
	 * 
	 * @param id
	 *            id of an existing EmployeeStatus
	 */
	@Override
	public void removeEmployeeStatus(int id) {
		EmployeeStatus employeeStatus = (EmployeeStatus) template.get(EmployeeStatus.class, new Integer(id));
		if (null != employeeStatus)
			template.delete(employeeStatus);
	}

	/**
	 * To update a EmployeeStatus for an existing EmployeeStatus
	 * 
	 * @param EmployeeStatus
	 *            detail of an existing EmployeeStatus
	 */
	@Override
	public void updateEmployeeStatus(EmployeeStatus employeeStatus) {
		template.update(employeeStatus);

	}

}

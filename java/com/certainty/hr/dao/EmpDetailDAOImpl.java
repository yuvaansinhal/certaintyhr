package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EmpDetail;

/**
 * 
 * DAO class implementing methods to access Emp data from database
 * 
 */
@Repository
public class EmpDetailDAOImpl implements EmpDetailDAO {
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
	 * To get a Emp detail based on Emp id
	 * 
	 * @param id
	 *            - Emp id of an existing Emp detail
	 * @return Emp detail based on Emp detail
	 */
	@Override
	public EmpDetail getEmpDetailByID(int id) {
		return template.get(EmpDetail.class, new Integer(id));
	}

	/**
	 * To list all the Emp details
	 * 
	 * @return list of all the Emp details
	 */
	@Override
	public List<EmpDetail> listEmpDetails() {
		return template.loadAll(EmpDetail.class);
	}

	/**
	 * To list all the Emp details in ascending order
	 * 
	 * @return list of all the Emp details in ascending order
	 */
	@Override
	public List<EmpDetail> listOrderedEmpDetails() {
		List<EmpDetail> orderedEmpDetails = template.loadAll(EmpDetail.class);
		Collections.sort(orderedEmpDetails);
		return orderedEmpDetails;
	}

	/**
	 * To add a new Employee detail
	 * 
	 * @param empDetail
	 *            detail of a new Employee
	 */
	@Override
	public void addEmpDetail(EmpDetail empDetail) {
		template.save(empDetail);
	}

	/**
	 * To delete a Emp detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Employee
	 */
	@Override
	public void removeEmpDetail(int id) {
		EmpDetail emp = (EmpDetail) template.get(EmpDetail.class, new Integer(id));
		if (null != emp) {
			template.delete(emp);
		}
	}

	/**
	 * To update a Emp detail for an existing Emp
	 * 
	 * @param empDetail
	 *            detail of an existing Emp
	 */
	@Override
	public void updateEmpDetail(EmpDetail empDetail) {
		template.update(empDetail);

	}

}

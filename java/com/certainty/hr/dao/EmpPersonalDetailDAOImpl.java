package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EmpPersonalDetail;

/**
 * 
 * DAO class implementing methods to access Emp personal data from database
 * 
 */
@Repository
public class EmpPersonalDetailDAOImpl implements EmpPersonalDetailDAO {
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
	 * To get a Emp Personal personal detail based on Emp id
	 * 
	 * @param id
	 *            - EmpPersonal id of an existing Personal Emp detail
	 * @return Emp Personal detail based on Emp Personal detail
	 */
	@Override
	public EmpPersonalDetail getEmpPersonalDetailByID(int id) {
		return template.get(EmpPersonalDetail.class, new Integer(id));
	}

	/**
	 * To list all the Personal Emp details
	 * 
	 * @return list of all the Personal Emp details
	 */
	@Override
	public List<EmpPersonalDetail> listEmpPersonalDetails() {
		return template.loadAll(EmpPersonalDetail.class);
	}

	/**
	 * To add a new Personal Employee detail
	 * 
	 * @param empPersonalDetail
	 *            detail of a new Personal Employee
	 */
	@Override
	public void addEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		template.save(empPersonalDetail);

	}

	/**
	 * To delete a EmpPersonal detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Personal Employee
	 */
	@Override
	public void removeEmpPersonalDetail(int id) {
		EmpPersonalDetail epd = (EmpPersonalDetail) template.get(EmpPersonalDetail.class, new Integer(id));
		if (null != epd) {
			template.delete(epd);
		}

	}

	/**
	 * To update a Emp Personal detail for an existing Personal Emp
	 * 
	 * @param empPersonalDetail
	 *            detail of an existing Personal Emp
	 */
	@Override
	public void updateEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		template.update(empPersonalDetail);

	}

}

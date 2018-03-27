package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EmpPassportDetail;

/**
 * 
 * DAO class implementing methods to access Emp passport data from database
 * 
 */
@Repository
public class EmpPassportDetailDAOImpl implements EmpPassportDetailDAO {
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
	 * To get a Emp Passport detail based on Emp id
	 * 
	 * @param id
	 *            - Emppassport id of an existing Passport Emp detail
	 * @return Emp Passport detail based on Emp Passport detail
	 */
	@Override
	public EmpPassportDetail getEmpPassportDetailByID(int id) {
		return template.get(EmpPassportDetail.class, new Integer(id));
	}

	/**
	 * To list all the Passport Emp details
	 * 
	 * @return list of all the Passport Emp details
	 */
	@Override
	public List<EmpPassportDetail> listEmpPassportDetails() {
		return template.loadAll(EmpPassportDetail.class);
	}

	/**
	 * To add a new Passport Employee detail
	 * 
	 * @param empPassportDetail
	 *            detail of a new Passport Employee
	 */
	@Override
	public void addEmpPassportDetail(EmpPassportDetail empPassportDetail) {
		template.save(empPassportDetail);

	}

	/**
	 * To delete a Emp Passport detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Passport Employee
	 */
	@Override
	public void removeEmpPassportDetail(int id) {
		EmpPassportDetail epd = (EmpPassportDetail) template.get(EmpPassportDetail.class, new Integer(id));
		if (null != epd) {
			template.delete(epd);
		}

	}

	/**
	 * To update a Emp Passport detail for an existing Passport Emp
	 * 
	 * @param empPassportDetail
	 *            detail of an existing Passport Emp
	 */
	@Override
	public void updateEmpPassportDetail(EmpPassportDetail empPassportDetail) {
		template.update(empPassportDetail);

	}

}

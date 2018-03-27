package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EmpContactDetail;

/**
 * 
 * DAO class implementing methods to access Emp Contact detail data from database
 * 
 */
@Repository
public class EmpContactDetailDAOImpl implements EmpContactDetailDAO {
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
	 * To get a Emp Contact detail based on Emp id
	 * 
	 * @param id
	 *            - Emp Contact id of an existing Emp Contact detail
	 * @return Emp Contact detail based on Emp Contact detail
	 */
	@Override
	public EmpContactDetail getEmpContactDetailByID(int id) {
		return template.get(EmpContactDetail.class, new Integer(id));
	}

	/**
	 * To list all the Contact Emp details
	 * 
	 * @return list of all the Contact Emp details
	 */
	@Override
	public List<EmpContactDetail> listEmpContactDetails() {
		return template.loadAll(EmpContactDetail.class);
	}

	/**
	 * To add a new Emp Contact 
	 * 
	 * @param empContactDetail
	 *            detail of a new Emp Contact 
	 */
	@Override
	public void addEmpContactDetail(EmpContactDetail empContactDetail) {
		template.save(empContactDetail);

	}

	/**
	 * To delete a Empcontact detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Emp Contact 
	 */
	@Override
	public void removeEmpContactDetail(int id) {
		EmpContactDetail ecd = (EmpContactDetail) template.get(EmpContactDetail.class, new Integer(id));
		if (null != ecd) {
			template.delete(ecd);
		}
	}

	/**
	 * To update a Emp Contact detail for an existing Emp Contact
 	 * 
	 * @param empContactDetail
	 *            detail of an existing Emp Contact
	 */
	@Override
	public void updateEmpContactDetail(EmpContactDetail empContactDetail) {
		template.update(empContactDetail);

	}
}

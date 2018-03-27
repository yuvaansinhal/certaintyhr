package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EmpEducationDetail;

/**
 * 
 * DAO class implementing methods to access Emp Education detail data from
 * database
 * 
 */
@Repository
public class EmpEducationDetailDAOImpl implements EmpEducationDetailDAO {
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
	 * To get a Emp Education detail based on Emp id
	 * 
	 * @param id
	 *            - Emp Education id of an existing Emp Education detail
	 * @return Emp Education detail based on Emp Education detail
	 */
	@Override
	public EmpEducationDetail getEmpEducationDetailByID(int id) {
		return template.get(EmpEducationDetail.class, new Integer(id));
	}

	/**
	 * To list all the Emp Education details
	 * 
	 * @return list of all the Emp Education details
	 */
	@Override
	public List<EmpEducationDetail> listEmpEducationDetails() {
		return template.loadAll(EmpEducationDetail.class);
	}

	/**
	 * To add a new Emp Education
	 * 
	 * @param empEducationDetail
	 *            detail of a new Emp Education
	 */
	@Override
	public void addEmpEducationDetail(EmpEducationDetail empEducationDetail) {
		template.save(empEducationDetail);

	}

	/**
	 * To delete a EmpEducation detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Emp Education
	 */
	@Override
	public void removeEmpEducationDetail(int id) {
		EmpEducationDetail eed = (EmpEducationDetail) template.get(EmpEducationDetail.class, new Integer(id));
		if (null != eed) {
			template.delete(eed);
		}

	}

	/**
	 * To update a Emp Education detail for an existing Emp Education
	 * 
	 * @param empEducationDetail
	 *            detail of an existing Emp Education
	 */
	@Override
	public void updateEmpEducationDetail(EmpEducationDetail empEducationDetail) {
		template.update(empEducationDetail);

	}

}

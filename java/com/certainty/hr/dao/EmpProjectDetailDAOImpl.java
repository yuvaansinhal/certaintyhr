package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EmpProjectDetail;

/**
 * 
 * DAO class implementing methods to access EmpProject detail data from
 * database
 * 
 */
@Repository
public class EmpProjectDetailDAOImpl implements EmpProjectDetailDAO {
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
	 * To get a EmpProject detail based on id
	 * 
	 * @param id
	 *            - empProject id of an existing EmpProject detail
	 * @return EmpProject detail based on EmpProject detail
	 */
	@Override
	public EmpProjectDetail getEmpProjectDetailByID(int id) {
		return template.get(EmpProjectDetail.class, new Integer(id));
	}

	/**
	 * To list all the EmpProject details
	 * 
	 * @return list of all the EmpProject details
	 */
	@Override
	public List<EmpProjectDetail> listEmpProjectDetails() {
		return template.loadAll(EmpProjectDetail.class);
	}

	/**
	 * To add a new EmpProject detail
	 * 
	 * @param empProjectDetail
	 *            detail of a new EmpProject
	 */
	@Override
	public void addEmpProjectDetail(EmpProjectDetail empProjectDetail) {
		template.save(empProjectDetail);

	}

	/**
	 * To update a EmpProject detail for an existing EmpProject
	 * 
	 * @param empProjectDetail
	 *            detail of an existing EmpProject
	 */
	@Override
	public void updateEmpProjectDetail(EmpProjectDetail empProjectDetail) {
		template.update(empProjectDetail);

	}

	/**
	 * To delete a EmpProject detail based on id
	 * 
	 * @param id
	 *            id of an existing EmpProject
	 */
	@Override
	public void removeEmpProjectDetail(int id) {
		EmpProjectDetail epd = (EmpProjectDetail) template.get(EmpProjectDetail.class, new Integer(id));
		if (null != epd) {
			template.delete(epd);
		}
	}

}

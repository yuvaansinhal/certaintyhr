package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.EmpSkillDetail;

/**
 * 
 * DAO class implementing methods to access Emp Skill detail data from database
 * 
 */
@Repository
public class EmpSkillDetailDAOImpl implements EmpSkillDetailDAO {
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
	 * To get a Emp Skill detail based on Emp id
	 * 
	 * @param id
	 *            - EmpSkill id of an existing Emp Skill detail
	 * @return Emp Skill detail based on Emp Skill detail
	 */
	@Override
	public EmpSkillDetail getEmpSkillDetailByID(int id) {
		return template.get(EmpSkillDetail.class, new Integer(id));
	}

	/**
	 * To list all the Skill Emp details
	 * 
	 * @return list of all the Skill Emp details
	 */
	@Override
	public List<EmpSkillDetail> listEmpSkillDetails() {
		return template.loadAll(EmpSkillDetail.class);
	}

	/**
	 * To add a new Emp Skill detail
	 * 
	 * @param empSkillDetail
	 *            detail of a new Emp Skill
	 */
	@Override
	public void addEmpSkillDetail(EmpSkillDetail empSkillDetail) {
		template.save(empSkillDetail);

	}

	/**
	 * To delete a EmpSkill detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Emp Skill
	 */
	@Override
	public void removeEmpSkillDetail(int id) {
		EmpSkillDetail epd = (EmpSkillDetail) template.get(EmpSkillDetail.class, new Integer(id));
		if (null != epd) {
			template.delete(epd);
		}

	}

	/**
	 * To update a Emp Skill detail for an existing Emp Skill
	 * 
	 * @param empSkillDetail
	 *            detail of an existing Emp Skill
	 */
	@Override
	public void updateEmpSkillDetail(EmpSkillDetail empSkillDetail) {
		template.update(empSkillDetail);

	}

}

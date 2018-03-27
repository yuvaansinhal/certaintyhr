package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.SkillType;

/**
 * 
 * DAO class implementing methods to access SkillType data from database
 * 
 */

@Repository
public class SkillTypeDAOImpl implements SkillTypeDAO {

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
	 * To get a SkillType based on project id
	 * 
	 * @param id
	 *            - project id of an existing SkillType
	 * @return SkillType based on SkillType
	 */
	@Override
	public SkillType getSkillTypeByID(int id) {
		return template.get(SkillType.class, new Integer(id));
	}

	/**
	 * To list all the SkillTypes
	 * 
	 * @return list of all the SkillTypes
	 */
	@Override
	public List<SkillType> listSkillTypes() {
		List<SkillType> orderedSkillTypes = template.loadAll(SkillType.class);
		Collections.sort(orderedSkillTypes);
		return orderedSkillTypes;
	}

	/**
	 * To add a new SkillType
	 * 
	 * @param project
	 *            detail of a new project
	 */
	@Override
	public void addSkillType(SkillType skillType) {
		template.save(skillType);
	}

	/**
	 * To delete a SkillType based on project id
	 * 
	 * @param project
	 *            id of an existing project
	 */
	@Override
	public void removeSkillType(int id) {
		SkillType skillType = (SkillType) template.get(SkillType.class, new Integer(id));
		if (null != skillType)
			template.delete(skillType);
	}

	/**
	 * To update a SkillType for an existing project
	 * 
	 * @param project
	 *            detail of an existing project
	 */
	@Override
	public void updateSkillType(SkillType skillType) {
		template.update(skillType);
	}
}

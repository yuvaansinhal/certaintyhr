package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.SkillTypeDAO;
import com.certainty.hr.model.SkillType;

/**
 * Service class implementing methods to access SkillType data using DAO
 * methods
 */

@Service
@Transactional
public class SkillTypeServiceImpl implements SkillTypeService {

	@Autowired
	private SkillTypeDAO skillTypeDAO;

	/**
	 * Setting the autowired SkillType DAO passed from Application Context
	 * 
	 * @param SkillTypeDAO
	 *            the SkillType Detail DAO to set
	 */
	public void setSkillTypeDAO(SkillTypeDAO skillTypeDAO) {
		this.skillTypeDAO = skillTypeDAO;
	}

	/**
	 * To add a new SkillType
	 * 
	 * @param SkillType
	 *            detail of a new SkillType
	 */
	@Override
	public void addSkillType(SkillType skillType) {
		this.skillTypeDAO.addSkillType(skillType);
	}

	/**
	 * To update an existing SkillType
	 * 
	 * @param SkillType
	 *            detail of an existing SkillType
	 */
	@Override
	public void updateSkillType(SkillType skillType) {
		this.skillTypeDAO.updateSkillType(skillType);
	}

	/**
	 * To get the list of all SkillType
	 * 
	 * @return list of all the SkillType
	 */
	@Override
	public List<SkillType> listSkillTypes() {
		return this.skillTypeDAO.listSkillTypes();
	}

	/**
	 * To get a SkillType based on SkillType id
	 * 
	 * @param SkillType
	 *            id of an existing SkillType
	 * @return SkillType of an existing SkillType
	 */
	@Override
	public SkillType getSkillTypeByID(int id) {
		return this.skillTypeDAO.getSkillTypeByID(id);
	}

	/**
	 * To delete a SkillType based on SkillType id
	 * 
	 * @param id
	 *            of an existing SkillType
	 */
	@Override
	public void removeSkillType(int id) {
		this.skillTypeDAO.removeSkillType(id);
	}

	
}

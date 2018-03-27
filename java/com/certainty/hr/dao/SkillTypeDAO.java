package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.SkillType;

/**
 * DAO interface declaring methods to access SkillType data
 * 
 */

public interface SkillTypeDAO {

	public SkillType getSkillTypeByID(int id);

	public List<SkillType> listSkillTypes();

	public void addSkillType(SkillType skillType);

	public void removeSkillType(int id);

	public void updateSkillType(SkillType skillType);

}

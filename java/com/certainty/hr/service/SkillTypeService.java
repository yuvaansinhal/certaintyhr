package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.SkillType;

/**
 * Service interface delcaring methods to access project detail data
 */

public interface SkillTypeService {

	public void addSkillType(SkillType SkillType);

	public void updateSkillType(SkillType SkillType);

	public List<SkillType> listSkillTypes();
	
	public SkillType getSkillTypeByID(int id);

	public void removeSkillType(int id);

}

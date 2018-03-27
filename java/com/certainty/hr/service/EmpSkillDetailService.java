package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmpSkillDetail;

/**
 * Service interface delcaring methods to access Emp Skill Detail data
 * 
 *
 */
public interface EmpSkillDetailService {

	public void addEmpSkillDetail(EmpSkillDetail empSkillDetail);

	public void updateEmpSkillDetail(EmpSkillDetail empSkillDetail);

	public List<EmpSkillDetail> listEmpSkillDetails();

	public EmpSkillDetail getEmpSkillDetailByID(int id);

	public void removeEmpSkillDetail(int id);
}

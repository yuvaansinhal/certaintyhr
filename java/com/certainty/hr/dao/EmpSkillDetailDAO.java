package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmpSkillDetail;

/**
 * DAO interface declaring methods to access Emp Skill Detail data
 * 
 *
 */
public interface EmpSkillDetailDAO {

	public EmpSkillDetail getEmpSkillDetailByID(int id);

	public List<EmpSkillDetail> listEmpSkillDetails();

	public void addEmpSkillDetail(EmpSkillDetail empSkillDetail);

	public void removeEmpSkillDetail(int id);

	public void updateEmpSkillDetail(EmpSkillDetail empSkillDetail);
}

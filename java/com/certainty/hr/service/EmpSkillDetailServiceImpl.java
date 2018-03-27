package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EmpSkillDetailDAO;
import com.certainty.hr.model.EmpSkillDetail;

/**
 * Service class implementing methods to access Emp Skill detail data using DAO
 * methods
 * 
 *
 */
@Service
@Transactional
public class EmpSkillDetailServiceImpl implements EmpSkillDetailService {
	@Autowired
	private EmpSkillDetailDAO empSkillDetailDAO;

	/**
	 * Setting the autowired Emp Skill Detail DAO passed from Application Context
	 * 
	 * @param empSkillDetailDAO
	 *            the Emp Detail DAO to set
	 */
	public void setEmpSkillDetailDAO(EmpSkillDetailDAO empSkillDetailDAO) {
		this.empSkillDetailDAO = empSkillDetailDAO;
	}

	/**
	 * To add a new EmpSkill detail
	 * 
	 * @param empSkillDetail
	 *            detail of a new Emp Skill
	 */
	@Override
	public void addEmpSkillDetail(EmpSkillDetail empSkillDetail) {
		this.empSkillDetailDAO.addEmpSkillDetail(empSkillDetail);

	}

	/**
	 * To update an existing Emp Skill detail
	 * 
	 * @param empSkillDetail
	 *            detail of an existing Emp Skill
	 */
	@Override
	public void updateEmpSkillDetail(EmpSkillDetail empSkillDetail) {
		this.empSkillDetailDAO.updateEmpSkillDetail(empSkillDetail);

	}

	/**
	 * To get the list of all Emp Skill details
	 * 
	 * @return list of all the Emp Skill details
	 */
	@Override
	public List<EmpSkillDetail> listEmpSkillDetails() {
		return this.empSkillDetailDAO.listEmpSkillDetails();
	}

	/**
	 * To get a Emp Skill detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Emp Skill
	 * @return Emp Skill detail of an existing Emp Skill
	 */
	@Override
	public EmpSkillDetail getEmpSkillDetailByID(int id) {
		return this.empSkillDetailDAO.getEmpSkillDetailByID(id);
	}

	/**
	 * To delete a Emp Skill detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Emp Skill
	 */
	@Override
	public void removeEmpSkillDetail(int id) {
		this.empSkillDetailDAO.removeEmpSkillDetail(id);

	}

}

package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EmpProjectDetailDAO;
import com.certainty.hr.model.EmpProjectDetail;

/**
 * Service class implementing methods to access EmpProject detail data using DAO
 * methods
 * 
 *
 */
@Service
@Transactional

public class EmpProjectDetailServiceImpl implements EmpProjectDetailService {
	@Autowired
	private EmpProjectDetailDAO empProjectDetailDAO;

	/**
	 * Setting the autowired EmpProject Detail DAO passed from Application Context
	 * 
	 * @param empProjectDetailDAO
	 *            the EmpProject Detail DAO to set
	 */
	public void setEmpProjectDetailDAO(EmpProjectDetailDAO empProjectDetailDAO) {
		this.empProjectDetailDAO = empProjectDetailDAO;
	}

	/**
	 * To add a new EmpProject detail
	 * 
	 * @param empProjectDetail
	 *            detail of a new EmpProject
	 */
	@Override
	public void addEmpProjectDetail(EmpProjectDetail empProjectDetail) {
		this.empProjectDetailDAO.addEmpProjectDetail(empProjectDetail);

	}

	/**
	 * To update an existing EmpProject detail
	 * 
	 * @param empProjectDetail
	 *            detail of an existing EmpProject
	 */
	@Override
	public void updateEmpProjectDetail(EmpProjectDetail empProjectDetail) {
		this.empProjectDetailDAO.updateEmpProjectDetail(empProjectDetail);

	}

	/**
	 * To get the list of all EmpProject details
	 * 
	 * @return list of all the EmpProject details
	 */
	@Override
	public List<EmpProjectDetail> listEmpProjectDetails() {
		return this.empProjectDetailDAO.listEmpProjectDetails();
	}

	/**
	 * To get a EmpProject Detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing EmpProject
	 * @return EmpProject detail of an existing EmpProject
	 */
	@Override
	public EmpProjectDetail getEmpProjectDetailByID(int id) {
		return this.empProjectDetailDAO.getEmpProjectDetailByID(id);
	}

	/**
	 * To delete a EmpProject detail based on id
	 * 
	 * @param id
	 *            id of an existing EmpProject
	 */
	@Override
	public void removeEmpProjectDetail(int id) {
		this.empProjectDetailDAO.removeEmpProjectDetail(id);

	}

}

package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EmpEducationDetailDAO;
import com.certainty.hr.model.EmpEducationDetail;

/**
 * Service class implementing methods to access Emp Education detail data using
 * DAO methods
 * 
 *
 */
@Service
@Transactional
public class EmpEducationDetailServiceImpl implements EmpEducationDetailService {
	@Autowired
	private EmpEducationDetailDAO empEducationDetailDAO;

	/**
	 * Setting the autowired Emp Education Detail DAO passed from Application Context
	 * 
	 * @param empEducationDetailDAO
	 *            the Emp Education Detail DAO to set
	 */
	public void setEmpEducationDetailDAO(EmpEducationDetailDAO empEducationDetailDAO) {
		this.empEducationDetailDAO = empEducationDetailDAO;
	}

	/**
	 * To add a new Emp Education detail
	 * 
	 * @param empEducationDetail
	 *            detail of a new Emp Education
	 */
	@Override
	public void addEmpEducationDetail(EmpEducationDetail empEducationDetail) {
		this.empEducationDetailDAO.addEmpEducationDetail(empEducationDetail);

	}

	/**
	 * To update an existing Emp Education detail
	 * 
	 * @param empEducationDetail
	 *            detail of an existing Emp Education
	 */
	@Override
	public void updateEmpEducationDetail(EmpEducationDetail empEducationDetail) {
		this.empEducationDetailDAO.updateEmpEducationDetail(empEducationDetail);

	}

	/**
	 * To get the list of all Emp Education details
	 * 
	 * @return list of all the Emp Education details
	 */
	@Override
	public List<EmpEducationDetail> listEmpEducationDetails() {
		return this.empEducationDetailDAO.listEmpEducationDetails();
	}

	/**
	 * To get a Emp Education detail based on Emp education id
	 * 
	 * @param id
	 *            id of an existing Emp Education
	 * @return Emp Education detail of an existing Emp Education
	 */
	@Override
	public EmpEducationDetail getEmpEducationDetailByID(int id) {
		return this.empEducationDetailDAO.getEmpEducationDetailByID(id);
	}

	/**
	 * To delete a Emp Education detail based on Emp Education id
	 * 
	 * @param id
	 *            id of an existing Emp Education
	 */
	@Override
	public void removeEmpEducationDetail(int id) {
		this.empEducationDetailDAO.removeEmpEducationDetail(id);

	}

}

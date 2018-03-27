package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EmpPersonalDetailDAO;
import com.certainty.hr.model.EmpPersonalDetail;

/**
 * Service class implementing methods to access Emp Personal detail data using
 * DAO methods
 * 
 *
 */
@Service
@Transactional
public class EmpPersonalDetailServiceImpl implements EmpPersonalDetailService {
	@Autowired
	private EmpPersonalDetailDAO empPersonalDetailDAO;

	/**
	 * Setting the autowired Emp Personal Detail DAO passed from Application Context
	 * 
	 * @param empPersonalDetailDAO
	 *            the Emp Personal Detail DAO to set
	 */
	public void setEmpPersonalDetailDAO(EmpPersonalDetailDAO empPersonalDetailDAO) {
		this.empPersonalDetailDAO = empPersonalDetailDAO;
	}

	/**
	 * To add a new Emp Personal detail
	 * 
	 * @param empPersonalDetail
	 *            detail of a new Personal Emp
	 */
	@Override
	public void addEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		this.empPersonalDetailDAO.addEmpPersonalDetail(empPersonalDetail);
	}

	/**
	 * To update an existing Emp Personal detail
	 * 
	 * @param empPersonalDetail
	 *            detail of an existing Personal Employee
	 */
	@Override
	public void updateEmpPersonalDetail(EmpPersonalDetail empPersonalDetail) {
		this.empPersonalDetailDAO.updateEmpPersonalDetail(empPersonalDetail);

	}

	/**
	 * To get the list of all Emp Personal details
	 * 
	 * @return list of all the Emp Personal details
	 */
	@Override
	public List<EmpPersonalDetail> listEmpPersonalDetails() {
		return this.empPersonalDetailDAO.listEmpPersonalDetails();
	}

	/**
	 * To get a Emp Personal detail based on Emp personal id
	 * 
	 * @param id
	 *            id of an existing Personal Employee
	 * @return Emp detail of an existing Personal Employee
	 */
	@Override
	public EmpPersonalDetail getEmpPersonalDetailByID(int id) {
		return this.empPersonalDetailDAO.getEmpPersonalDetailByID(id);
	}

	/**
	 * To delete a Emp Personal detail based on Emp personal id
	 * 
	 * @param id
	 *            id of an existing Personal Emp
	 */
	@Override
	public void removeEmpPersonalDetail(int id) {
		this.empPersonalDetailDAO.removeEmpPersonalDetail(id);
	}

}

package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EmpContactDetailDAO;
import com.certainty.hr.model.EmpContactDetail;

/**
 * Service class implementing methods to access Emp Contact detail data using
 * DAO methods
 * 
 *
 */
@Service
@Transactional
public class EmpContactDetailServiceImpl implements EmpContactDetailService {
	@Autowired
	private EmpContactDetailDAO empContactDetailDAO;

	/**
	 * Setting the autowired Emp Contact Detail DAO passed from Application Context
	 * 
	 * @param empContactDetailDAO
	 *            the Emp Contact Detail DAO to set
	 */
	public void setEmpContactDetailDAO(EmpContactDetailDAO empContactDetailDAO) {
		this.empContactDetailDAO = empContactDetailDAO;
	}

	/**
	 * To add a new Emp Contact detail
	 * 
	 * @param empContactDetail
	 *            detail of a new Emp Contact 
	 */
	@Override
	public void addEmpContactDetail(EmpContactDetail empContactDetail) {
		this.empContactDetailDAO.addEmpContactDetail(empContactDetail);

	}
	/**
	 * To update an existing Emp Contact detail
	 * 
	 * @param empContactDetail
	 *            detail of an existing Emp Contact 
	 */
	@Override
	public void updateEmpContactDetail(EmpContactDetail empContactDetail) {
		this.empContactDetailDAO.updateEmpContactDetail(empContactDetail);
	}
	/**
	 * To get the list of all Emp Contact details
	 * 
	 * @return list of all the Emp Contact details
	 */
	@Override
	public List<EmpContactDetail> listEmpContactDetails() {
		return this.empContactDetailDAO.listEmpContactDetails();
	}
	/**
	 * To get a Emp Contact detail based on Emp personal id
	 * 
	 * @param id
	 *            id of an existing Emp Contact 
	 * @return Emp contact detail of an existing Emp Contact
	 */
	@Override
	public EmpContactDetail getEmpContactDetailByID(int id) {
		return this.empContactDetailDAO.getEmpContactDetailByID(id);
	}
	/**
	 * To delete a Emp Personal detail based on Emp Contact id
	 * 
	 * @param id
	 *            id of an existing Contact Emp
	 */
	@Override
	public void removeEmpContactDetail(int id) {
		this.empContactDetailDAO.removeEmpContactDetail(id);

	}

}

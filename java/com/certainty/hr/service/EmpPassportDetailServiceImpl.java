package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EmpPassportDetailDAO;
import com.certainty.hr.model.EmpPassportDetail;

/**
 * Service class implementing methods to access Emp Passport detail data using
 * DAO methods
 * 
 *
 */
@Service
@Transactional
public class EmpPassportDetailServiceImpl implements EmpPassportDetailService {
	@Autowired
	private EmpPassportDetailDAO empPassportDetailDAO;

	/**
	 * Setting the autowired Emp Passport Detail DAO passed from Application Context
	 * 
	 * @param empContactDetailDAO
	 *            the Emp Passport Detail DAO to set
	 */
	public void setEmpPassportDetailDAO(EmpPassportDetailDAO empPassportDetailDAO) {
		this.empPassportDetailDAO = empPassportDetailDAO;
	}

	/**
	 * To add a new Emp Passport detail
	 * 
	 * @param empPassportDetail
	 *            detail of a new Emp Passport
	 */
	@Override
	public void addEmpPassportDetail(EmpPassportDetail empPassportDetail) {
		this.empPassportDetailDAO.addEmpPassportDetail(empPassportDetail);

	}

	/**
	 * To update an existing Emp Passport detail
	 * 
	 * @param empPassportDetail
	 *            detail of an existing Emp Passport
	 */
	@Override
	public void updateEmpPassportDetail(EmpPassportDetail empPassportDetail) {
		this.empPassportDetailDAO.updateEmpPassportDetail(empPassportDetail);

	}

	/**
	 * To get the list of all Emp Passport details
	 * 
	 * @return list of all the Emp Passport details
	 */
	@Override
	public List<EmpPassportDetail> listEmpPassportDetails() {
		return this.empPassportDetailDAO.listEmpPassportDetails();
	}

	/**
	 * To get a Emp Passport detail based on Emp personal id
	 * 
	 * @param id
	 *            id of an existing Emp Passport
	 * @return Emp passport detail of an existing Emp Passport
	 */
	@Override
	public EmpPassportDetail getEmpPassportDetailByID(int id) {
		return this.empPassportDetailDAO.getEmpPassportDetailByID(id);
	}

	/**
	 * To delete a Emp passport detail based on Emp Passport id
	 * 
	 * @param id
	 *            id of an existing Emp Passport
	 */
	@Override
	public void removeEmpPassportDetail(int id) {
		this.empPassportDetailDAO.removeEmpPassportDetail(id);

	}

}

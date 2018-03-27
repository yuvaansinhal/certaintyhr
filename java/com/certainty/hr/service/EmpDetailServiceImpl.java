package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.EmpDetailDAO;
import com.certainty.hr.model.EmpDetail;

/**
 * Service class implementing methods to access Emp detail data using DAO
 * methods
 * 
 *
 */
@Service
@Transactional
public class EmpDetailServiceImpl implements EmpDetailService {
	@Autowired
	private EmpDetailDAO empDetailDAO;

	/**
	 * Setting the autowired Emp Detail DAO passed from Application Context
	 * 
	 * @param empDetailDAO
	 *            the Emp Detail DAO to set
	 */
	public void setEmpDetailDAO(EmpDetailDAO empDetailDAO) {
		this.empDetailDAO = empDetailDAO;
	}

	/**
	 * To add a new Emp detail
	 * 
	 * @param empdetail
	 *            detail of a new Employee
	 */
	@Override
	public void addEmpDetail(EmpDetail empDetail) {
		this.empDetailDAO.addEmpDetail(empDetail);
	}

	/**
	 * To update an existing Emp detail
	 * 
	 * @param empDetail
	 *            detail of an existing Employee
	 */
	@Override
	public void updateEmpDetail(EmpDetail empDetail) {
		this.empDetailDAO.updateEmpDetail(empDetail);

	}

	/**
	 * To get the list of all Emp details
	 * 
	 * @return list of all the Emp details
	 */
	@Override
	public List<EmpDetail> listEmpDetails() {
		return this.empDetailDAO.listEmpDetails();
	}

	/**
	 * To get the list of all Emp details in ascending order
	 * 
	 * @return list of all the Emp details in ascending order
	 */
	@Override
	public List<EmpDetail> listOrderedEmpDetails() {
		return this.empDetailDAO.listOrderedEmpDetails();
	}

	/**
	 * To get a Emp detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Employee
	 * @return Emp detail of an existing Employee
	 */
	@Override
	public EmpDetail getEmpDetailByID(int id) {
		return this.empDetailDAO.getEmpDetailByID(id);
	}

	/**
	 * To delete a Emp detail based on Emp id
	 * 
	 * @param id
	 *            id of an existing Emp
	 */
	@Override
	public void removeEmpDetail(int id) {
		this.empDetailDAO.removeEmpDetail(id);
	}
}

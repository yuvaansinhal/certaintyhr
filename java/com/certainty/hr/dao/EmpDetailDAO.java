package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmpDetail;

/**
 * DAO interface declaring methods to access Emp detail data
 * 
 *
 */
public interface EmpDetailDAO {
	
	public EmpDetail getEmpDetailByID(int id);

	public List<EmpDetail> listEmpDetails();

	public List<EmpDetail> listOrderedEmpDetails();

	public void addEmpDetail(EmpDetail empDetail);

	public void removeEmpDetail(int id);

	public void updateEmpDetail(EmpDetail empDetail);
}

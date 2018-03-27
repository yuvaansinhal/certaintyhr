package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmpEducationDetail;

/**
 * DAO interface declaring methods to access Emp Education detail data
 * 
 *
 */
public interface EmpEducationDetailDAO {
	
	public EmpEducationDetail getEmpEducationDetailByID(int id);

	public List<EmpEducationDetail> listEmpEducationDetails();

	public void addEmpEducationDetail(EmpEducationDetail empEducationDetail);

	public void removeEmpEducationDetail(int id);

	public void updateEmpEducationDetail(EmpEducationDetail empEducationDetail);
}

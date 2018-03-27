package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmpPersonalDetail;

/**
 * DAO interface declaring methods to access Emp Personal detail data
 * 
 *
 */
public interface EmpPersonalDetailDAO {

	public EmpPersonalDetail getEmpPersonalDetailByID(int id);

	public List<EmpPersonalDetail> listEmpPersonalDetails();

	public void addEmpPersonalDetail(EmpPersonalDetail empPersonalDetail);

	public void removeEmpPersonalDetail(int id);

	public void updateEmpPersonalDetail(EmpPersonalDetail empPersonalDetail);
}

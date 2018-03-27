package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmpPassportDetail;

/**
 * DAO interface declaring methods to access Emp Passport detail data
 * 
 *
 */
public interface EmpPassportDetailDAO {
	
	public EmpPassportDetail getEmpPassportDetailByID(int id);

	public List<EmpPassportDetail> listEmpPassportDetails();

	public void addEmpPassportDetail(EmpPassportDetail empPassportDetail);

	public void removeEmpPassportDetail(int id);

	public void updateEmpPassportDetail(EmpPassportDetail empPassportDetail);
}

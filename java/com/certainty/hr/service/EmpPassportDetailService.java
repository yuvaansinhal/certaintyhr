package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmpPassportDetail;

/**
 * Service interface delcaring methods to access Emp Passport Detail data
 * 
 *
 */
public interface EmpPassportDetailService {
	
	public void addEmpPassportDetail(EmpPassportDetail empPassportDetail);

	public void updateEmpPassportDetail(EmpPassportDetail empPassportDetail);

	public List<EmpPassportDetail> listEmpPassportDetails();

	public EmpPassportDetail getEmpPassportDetailByID(int id);

	public void removeEmpPassportDetail(int id);

}

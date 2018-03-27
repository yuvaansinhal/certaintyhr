package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmpEducationDetail;

/**
 * Service interface delcaring methods to access Emp Education Detail data
 * 
 *
 */
public interface EmpEducationDetailService {
	
	public void addEmpEducationDetail(EmpEducationDetail empEducationDetail);

	public void updateEmpEducationDetail(EmpEducationDetail empEducationDetail);

	public List<EmpEducationDetail> listEmpEducationDetails();

	public EmpEducationDetail getEmpEducationDetailByID(int id);

	public void removeEmpEducationDetail(int id);
}

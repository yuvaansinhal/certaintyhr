package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmpDetail;
/**
 * Service interface delcaring methods to access Emp detail data
 * 
 *
 */
public interface EmpDetailService {
	
	public void addEmpDetail(EmpDetail empDetail);

	public void updateEmpDetail(EmpDetail empDetail);

	public List<EmpDetail> listEmpDetails();
	
	public List<EmpDetail> listOrderedEmpDetails();

	public EmpDetail getEmpDetailByID(int id);

	public void removeEmpDetail(int id);

}

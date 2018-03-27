package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmpPersonalDetail;

/**
 * Service interface delcaring methods to access Emp Personal Detail data
 * 
 *
 */
public interface EmpPersonalDetailService {

	public void addEmpPersonalDetail(EmpPersonalDetail empPersonalDetail);

	public void updateEmpPersonalDetail(EmpPersonalDetail empPersonalDetail);

	public List<EmpPersonalDetail> listEmpPersonalDetails();

	public EmpPersonalDetail getEmpPersonalDetailByID(int id);

	public void removeEmpPersonalDetail(int id);
}

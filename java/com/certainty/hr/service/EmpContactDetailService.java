package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmpContactDetail;

/**
 * Service interface delcaring methods to access Emp Contact Detail data
 * 
 *
 */
public interface EmpContactDetailService {

	public void addEmpContactDetail(EmpContactDetail empContactDetail);

	public void updateEmpContactDetail(EmpContactDetail empContactDetail);

	public List<EmpContactDetail> listEmpContactDetails();

	public EmpContactDetail getEmpContactDetailByID(int id);

	public void removeEmpContactDetail(int id);
}

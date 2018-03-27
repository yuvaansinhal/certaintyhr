package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.EmpProjectDetail;

/**
 * Service interface delcaring methods to access EmpProject Detail data
 * 
 *
 */
public interface EmpProjectDetailService {

	public void addEmpProjectDetail(EmpProjectDetail empProjectDetail);

	public void updateEmpProjectDetail(EmpProjectDetail empProjectDetail);

	public List<EmpProjectDetail> listEmpProjectDetails();

	public EmpProjectDetail getEmpProjectDetailByID(int id);

	public void removeEmpProjectDetail(int id);
}

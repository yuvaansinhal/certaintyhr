package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmpProjectDetail;

/**
 * DAO interface declaring methods to access Emp Project detail data
 * 
 *
 */

public interface EmpProjectDetailDAO {
	
	public EmpProjectDetail getEmpProjectDetailByID(int id);

	public List<EmpProjectDetail> listEmpProjectDetails();

	public void addEmpProjectDetail(EmpProjectDetail empProjectDetail);

	public void updateEmpProjectDetail(EmpProjectDetail empProjectDetail);
	
	public void removeEmpProjectDetail(int id);
}

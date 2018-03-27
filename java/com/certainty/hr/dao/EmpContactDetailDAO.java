package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.EmpContactDetail;

/**
 * DAO interface declaring methods to access Emp Conatact detail data
 * 
 *
 */
public interface EmpContactDetailDAO {

	public EmpContactDetail getEmpContactDetailByID(int id);

	public List<EmpContactDetail> listEmpContactDetails();

	public void addEmpContactDetail(EmpContactDetail empContactDetail);

	public void removeEmpContactDetail(int id);

	public void updateEmpContactDetail(EmpContactDetail empContactDetail);
}

package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.IndustryType;

/**
 * DAO interface declaring methods to access Industry Type data
 * 
 *
 */
public interface IndustryTypeDAO {

	public IndustryType getIndustryTypeByID(int id);

	public List<IndustryType> listIndustryTypes();

	public void addIndustryType(IndustryType industryType);

	public void removeIndustryType(int id);

	public void updateIndustryType(IndustryType industryType);

}

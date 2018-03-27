package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.IndustryType;

/**
 * Service interface delcaring methods to access Industry Type data
 * 
 *
 */

public interface IndustryTypeService {

	public void addIndustryType(IndustryType industryType);

	public void updateIndustryType(IndustryType industryType);

	public List<IndustryType> listIndustryTypes();

	public IndustryType getIndustryTypeByID(int id);

	public void removeIndustryType(int id);

}
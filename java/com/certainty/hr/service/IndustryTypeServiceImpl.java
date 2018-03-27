package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.IndustryTypeDAO;
import com.certainty.hr.model.IndustryType;

/**
 * Service class implementing methods to access Industry Type data using DAO
 * methods
 */

@Service
@Transactional
public class IndustryTypeServiceImpl implements IndustryTypeService {

	@Autowired
	private IndustryTypeDAO industryTypeDAO;

	/**
	 * Setting the autowired Industry Type DAO passed from Application Context
	 * 
	 * @param industryTypeDAO
	 *            the Industry Type Detail DAO to set
	 */
	public void setIndustryTypeDAO(IndustryTypeDAO industryTypeDAO) {
		this.industryTypeDAO = industryTypeDAO;
	}

	/**
	 * To add a new Industry Type
	 * 
	 * @param industryType
	 *            detail of a new Industry Type
	 */
	@Override
	public void addIndustryType(IndustryType industryType) {
		this.industryTypeDAO.addIndustryType(industryType);
	}

	/**
	 * To update an existing Industry Type
	 * 
	 * @param industryType
	 *            detail of an existing Industry Type
	 */
	@Override
	public void updateIndustryType(IndustryType industryType) {
		this.industryTypeDAO.updateIndustryType(industryType);
	}

	/**
	 * To get the list of all Industry Type
	 * 
	 * @return list of all the Industry Type
	 */
	@Override
	public List<IndustryType> listIndustryTypes() {
		return this.industryTypeDAO.listIndustryTypes();
	}

	/**
	 * To get a Industry Type based on Industry Type id
	 * 
	 * @param industryType
	 *            id of an existing Industry Type
	 * @return Industry Type of an existing Industry Type
	 */
	@Override
	public IndustryType getIndustryTypeByID(int id) {
		return this.industryTypeDAO.getIndustryTypeByID(id);
	}

	/**
	 * To delete a Industry Type based on Industry Type id
	 * 
	 * @param id
	 *            of an existing Industry Type
	 */
	@Override
	public void removeIndustryType(int id) {
		this.industryTypeDAO.removeIndustryType(id);
	}

}

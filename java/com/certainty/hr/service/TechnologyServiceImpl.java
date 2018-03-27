package com.certainty.hr.service;

import java.util.List;
/**
 * Service class implementing methods to access Technology detail data using
 * DAO methods
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.TechnologyDAO;
import com.certainty.hr.model.Technology;

/**
 * Service class implementing methods to access Technology data using DAO
 * methods
 *
 */
@Service
@Transactional
public class TechnologyServiceImpl implements TechnologyService {

	@Autowired
	private TechnologyDAO technologyDAO;

	/**
	 * Setting the autowired Technology DAO passed from Application Context
	 * 
	 * @param technologyDAO
	 *            the Technology DAO to set
	 */
	public void setTechnologyDAO(TechnologyDAO technologyDAO) {
		this.technologyDAO = technologyDAO;
	}

	/**
	 * To add a new Technology
	 * 
	 * @param technology
	 *            of a new Technology
	 */

	@Override
	public void addTechnology(Technology technology) {
		this.technologyDAO.addTechnology(technology);

	}

	/**
	 * To update an existing Technology
	 * 
	 * @param technology
	 *            detail of an existing Technology
	 */

	@Override
	public void updateTechnology(Technology technology) {
		this.technologyDAO.updateTechnology(technology);

	}

	/**
	 * To get the list of all Technologies
	 * 
	 * @return list of all the Technologies
	 */

	@Override
	public List<Technology> listTechnologies() {
		return this.technologyDAO.listTechnologies();
	}

	/**
	 * To get a Technology based on Technology id
	 * 
	 * @param id
	 *            of an existing Technology
	 * @return Technology detail of an existing Technology
	 */
	@Override
	public Technology getTechnologyByID(int id) {
		return this.technologyDAO.getTechnologyByID(id);
	}

	/**
	 * To delete a Technology detail based on Technology id
	 * 
	 * @param id
	 *            of an existing Technology
	 */

	@Override
	public void removeTechnology(int id) {
		this.technologyDAO.removeTechnology(id);

	}

}

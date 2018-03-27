package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.SpecializationStreamDAO;
import com.certainty.hr.model.SpecializationStream;

/**
 * Service class implementing methods to access SpecializationStream data using
 * DAO methods
 * 
 *
 */
@Service
@Transactional
public class SpecializationStreamServiceImpl implements SpecializationStreamService {

	@Autowired
	private SpecializationStreamDAO specializationStreamDAO;

	/**
	 * Setting the autowired SpecializationStream DAO passed from Application
	 * Context
	 * 
	 * @param SpecializationStreamDAO
	 *            the Client Detail DAO to set
	 */

	public void setSpecializationStreamDAO(SpecializationStreamDAO specializationStreamDAO) {
		this.specializationStreamDAO = specializationStreamDAO;
	}

	/**
	 * To add a new SpecializationStream
	 * 
	 * @param specializationStream
	 *            detail of a new SpecializationStream Type
	 */
	@Override
	public void addSpecializationStream(SpecializationStream specializationStream) {
		this.specializationStreamDAO.addSpecializationStream(specializationStream);
	}

	/**
	 * To update an existing SpecializationStream
	 * 
	 * @param specializationStream
	 *            detail of an existing SpecializationStream
	 */
	@Override
	public void updateSpecializationStream(SpecializationStream specializationStream) {
		this.specializationStreamDAO.updateSpecializationStream(specializationStream);
	}

	/**
	 * To get the list of all SpecializationStream
	 * 
	 * @return list of all the SpecializationStream
	 */
	@Override
	public List<SpecializationStream> listSpecializationStreams() {
		return this.specializationStreamDAO.listSpecializationStreams();
	}

	/**
	 * To get a SpecializationStream based on SpecializationStream id
	 * 
	 * @param specializationStream
	 *            id of an existing SpecializationStream
	 * @return SpecializationStream of an existing SpecializationStream
	 */

	@Override
	public SpecializationStream getSpecializationStreamByID(int id) {
		return this.specializationStreamDAO.getSpecializationStreamByID(id);
	}

	/**
	 * To delete a SpecializationStream based on SpecializationStream id
	 * 
	 * @param id
	 *            of an existing SpecializationStream
	 */
	@Override
	public void removeSpecializationStream(int id) {
		this.specializationStreamDAO.removeSpecializationStream(id);
	}

}

package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.UtilizationStatusDAO;
import com.certainty.hr.model.UtilizationStatus;

/**
 * Service class implementing methods to access UtilizationStatus data using DAO
 * methods
 */

@Service
@Transactional
public class UtilizationStatusServiceImpl implements UtilizationStatusService {

	@Autowired
	private UtilizationStatusDAO utilizationStatusDAO;

	/**
	 * Setting the autowired UtilizationStatus DAO passed from Application Context
	 * 
	 * @param UtilizationStatusDAO
	 *            the UtilizationStatus Detail DAO to set
	 */
	public void setUtilizationStatusDAO(UtilizationStatusDAO utilizationStatusDAO) {
		this.utilizationStatusDAO = utilizationStatusDAO;
	}

	/**
	 * To add a new UtilizationStatus
	 * 
	 * @param UtilizationStatus
	 *            detail of a new UtilizationStatus
	 */
	@Override
	public void addUtilizationStatus(UtilizationStatus utilizationStatus) {
		this.utilizationStatusDAO.addUtilizationStatus(utilizationStatus);
	}

	/**
	 * To update an existing UtilizationStatus
	 * 
	 * @param UtilizationStatus
	 *            detail of an existing UtilizationStatus
	 */
	@Override
	public void updateUtilizationStatus(UtilizationStatus utilizationStatus) {
		this.utilizationStatusDAO.updateUtilizationStatus(utilizationStatus);
	}

	/**
	 * To get the list of all UtilizationStatus
	 * 
	 * @return list of all the UtilizationStatus
	 */
	@Override
	public List<UtilizationStatus> listUtilizationStatuses() {
		return this.utilizationStatusDAO.listUtilizationStatuses();
	}

	/**
	 * To get a UtilizationStatus based on UtilizationStatus id
	 * 
	 * @param UtilizationStatus
	 *            id of an existing UtilizationStatus
	 * @return UtilizationStatus of an existing UtilizationStatus
	 */
	@Override
	public UtilizationStatus getUtilizationStatusByID(int id) {
		return this.utilizationStatusDAO.getUtilizationStatusByID(id);
	}

	/**
	 * To delete a UtilizationStatus based on UtilizationStatus id
	 * 
	 * @param id
	 *            of an existing UtilizationStatus
	 */
	@Override
	public void removeUtilizationStatus(int id) {
		this.utilizationStatusDAO.removeUtilizationStatus(id);
	}

}

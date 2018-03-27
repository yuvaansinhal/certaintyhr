package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.ClientDetailDAO;
import com.certainty.hr.model.ClientDetail;

/**
 * Service class implementing methods to access client detail data using DAO
 * methods
 * 
 *
 */
@Service
@Transactional
public class ClientDetailServiceImpl implements ClientDetailService {

	@Autowired
	private ClientDetailDAO clientDetailDAO;

	/**
	 * Setting the autowired Client Detail DAO passed from Application Context
	 * 
	 * @param clientDetailDAO
	 *            the Client Detail DAO to set
	 */
	public void setClientDetailDAO(ClientDetailDAO clientDetailDAO) {
		this.clientDetailDAO = clientDetailDAO;
	}

	/**
	 * To add a new client detail
	 * 
	 * @param cdl
	 *            detail of a new client
	 */
	@Override
	public void addClientDetail(ClientDetail cdl) {
		this.clientDetailDAO.addClientDetail(cdl);
	}

	/**
	 * To update an existing client detail
	 * 
	 * @param cdl
	 *            detail of an existing client
	 */
	@Override
	public void updateClientDetail(ClientDetail cdl) {
		this.clientDetailDAO.updateClientDetail(cdl);
	}

	/**
	 * To get the list of all client details
	 * 
	 * @return list of all the client details
	 */
	@Override
	public List<ClientDetail> listClientDetails() {
		return this.clientDetailDAO.listClientDetails();
	}

	/**
	 * To get the list of all client details in ascending order
	 * 
	 * @return list of all the client details in ascending order
	 */
	@Override
	public List<ClientDetail> listOrderedClientDetails() {
		return this.clientDetailDAO.listOrderedClientDetails();
	}

	/**
	 * To get a client detail based on client id
	 * 
	 * @param id
	 *            id of an existing client
	 * @return client detail of an existing client
	 */
	@Override
	public ClientDetail getClientDetailByID(int id) {
		return this.clientDetailDAO.getClientDetailByID(id);
	}

	/**
	 * To delete a client detail based on client id
	 * 
	 * @param id
	 *            id of an existing client
	 */
	@Override
	public void removeClientDetail(int id) {
		this.clientDetailDAO.removeClientDetail(id);
	}
}

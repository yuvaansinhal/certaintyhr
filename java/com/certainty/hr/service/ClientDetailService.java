package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.ClientDetail;

/**
 * Service interface delcaring methods to access client detail data
 * 
 *
 */

public interface ClientDetailService {
	
	public void addClientDetail(ClientDetail clientDetail);

	public void updateClientDetail(ClientDetail clientDetail);

	public List<ClientDetail> listClientDetails();
	
	public List<ClientDetail> listOrderedClientDetails();

	public ClientDetail getClientDetailByID(int id);

	public void removeClientDetail(int id);
}
package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.ClientDetail;

/**
 * DAO interface declaring methods to access client detail data
 * 
 *
 */
public interface ClientDetailDAO {

	public ClientDetail getClientDetailByID(int id);

	public List<ClientDetail> listClientDetails();

	public List<ClientDetail> listOrderedClientDetails();

	public void addClientDetail(ClientDetail clientDetail);

	public void removeClientDetail(int id);

	public void updateClientDetail(ClientDetail clientDetail);

}

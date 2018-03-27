package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.ClientDetail;

/**
 * 
 * DAO class implementing methods to access client detail data from database
 * 
 */
@Repository
public class ClientDetailDAOImpl implements ClientDetailDAO {

	@Autowired
	private HibernateTemplate template;

	/**
	 * Setting the autowired Hibernate Template passed from Application Context
	 * 
	 * @param template
	 *            - HIbernatem Template
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * To get a client detail based on client id
	 * 
	 * @param id
	 *            - client id of an existing client detail
	 * @return client detail based on client detail
	 */
	@Override
	public ClientDetail getClientDetailByID(int id) {
		return template.get(ClientDetail.class, new Integer(id));
	}

	/**
	 * To list all the client details
	 * 
	 * @return list of all the client details
	 */
	@Override
	public List<ClientDetail> listClientDetails() {
		return template.loadAll(ClientDetail.class);
	}
	/**
	 * To list all the client details in ascending order
	 * 
	 * @return list of all the client details in ascending order
	 */
	@Override
	public List<ClientDetail> listOrderedClientDetails() {
		List<ClientDetail> orderedClientDetails = template.loadAll(ClientDetail.class);
		Collections.sort(orderedClientDetails);
		return orderedClientDetails;
	}
	/**
	 * To add a new client detail
	 * 
	 * @param client
	 *            detail of a new client
	 */
	@Override
	public void addClientDetail(ClientDetail cdl) {
		template.save(cdl);
	}

	/**
	 * To delete a client detail based on client id
	 * 
	 * @param client
	 *            id of an existing client
	 */
	@Override
	public void removeClientDetail(int id) {
		ClientDetail cdl = (ClientDetail) template.get(ClientDetail.class, new Integer(id));
		if (null != cdl) {
			template.delete(cdl);
		}
	}

	/**
	 * To update a client detail for an existing client
	 * 
	 * @param client
	 *            detail of an existing client
	 */
	@Override
	public void updateClientDetail(ClientDetail cdl) {
		template.update(cdl);
	}
}

package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.ClientDetail;
import com.certainty.hr.service.ClientDetailService;

/**
 * Controller class to handle HTTP requests for client detail
 * 
 *
 */
@Controller
public class ClientDetailController {
	@Autowired
	private ClientDetailService clientDetailService;

	/**
	 * To handle request for client detail list
	 * 
	 * @return the list of all client details
	 */
	@RequestMapping(value = "/listClientDetails", method = RequestMethod.GET)
	public @ResponseBody List<ClientDetail> listClientDetails() {
		return this.clientDetailService.listClientDetails();

	}

	/**
	 * To handle request for client detail list in ascending order
	 * 
	 * @return the list of all client details in ascending order
	 */
	@RequestMapping(value = "/listOrderedClientDetails", method = RequestMethod.GET)
	public @ResponseBody List<ClientDetail> listOrderedClientDetails() {
		return this.clientDetailService.listOrderedClientDetails();

	}

	/**
	 * To provide client detail management view
	 * 
	 * @return client detail management page
	 */
	@RequestMapping(value = "/clientDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "ClientDetailManagement";
	}

	/**
	 * To handle request for adding a new client detail
	 * 
	 * @param cdl
	 *            - detail of a new client
	 * @return redirecting to client detail page
	 */
	@RequestMapping(value = "/addClientDetail", method = RequestMethod.POST)
	public String addClientDetail(@RequestBody ClientDetail cdl) {

		this.clientDetailService.addClientDetail(cdl);
		return "redirect:/clientDetail";

	}

	/**
	 * To handle request for updating an existing client detail
	 * 
	 * @param cdl
	 *            - detail of an existing client
	 * @return client detail management page
	 */
	@RequestMapping(value = "/updateClientDetail", method = RequestMethod.POST)
	public String editclientDetail(@RequestBody ClientDetail cdl) {
		this.clientDetailService.updateClientDetail(cdl);
		return "redirect:/clientDetail";

	}

	/**
	 * To handle request for deleting an existing client detail
	 * 
	 * @param id
	 *            - client id for an existing client passed in query string
	 * @return client detail management page
	 */
	@RequestMapping(value = "/deleteClientDetail/{id}", method = RequestMethod.GET)
	public String deleteClientDetail(@PathVariable("id") int id) {
		this.clientDetailService.removeClientDetail(id);
		return "redirect:/clientDetail";
	}
}

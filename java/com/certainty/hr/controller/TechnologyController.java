package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.Technology;
import com.certainty.hr.service.TechnologyService;

/**
 * Controller class to handle HTTP requests for Technology 
 *
 */
@Controller
public class TechnologyController {

	@Autowired
	private TechnologyService technologyService;

	/**
	 * To handle request for Technology list
	 * 
	 * @return the list of all technologies
	 */
	@RequestMapping(value = "/listTechnologies", method = RequestMethod.GET)
	public @ResponseBody List<Technology> listTechnologies() {
		return this.technologyService.listTechnologies();

	}

	/**
	 * To provide technology management view
	 * 
	 * @return technology management page
	 */
	@RequestMapping(value = "/technology", method = RequestMethod.GET)
	public String goToIndex() {
		return "TechnologyManagement";
	}

	/**
	 * To handle request for adding a new technology
	 * 
	 * @param technology
	 *            - detail of a new technology
	 * @return redirecting to techology page
	 */
	@RequestMapping(value = "/addTechnology", method = RequestMethod.POST)
	public String addTechnology(@RequestBody Technology technology) {

		this.technologyService.addTechnology(technology);
		return "redirect:/technology";

	}

	/**
	 * To handle request for updating an existing technology 
	 * 
	 * @param technology
	 *            - detail of an existing technology
	 * @return technology management page
	 */
	@RequestMapping(value = "/updateTechnology", method = RequestMethod.POST)
	public String editTechnology(@RequestBody Technology technology) {
		this.technologyService.updateTechnology(technology);
		return "redirect:/technology";

	}

	/**
	 * To handle request for deleting an existing technology 
	 * 
	 * @param id
	 *            - technology id for an existing technology passed in query string
	 * @return technology management page
	 */
	@RequestMapping(value = "/deleteTechnology/{id}", method = RequestMethod.GET)
	public String deleteTechnology(@PathVariable("id") int id) {
		this.technologyService.removeTechnology(id);
		return "redirect:/technology";
	}

}

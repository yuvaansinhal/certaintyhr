package com.certainty.hr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.SpecializationStream;
import com.certainty.hr.service.SpecializationStreamService;

/**
 * Controller class to handle HTTP requests for Specialization Stream
 * 
 *
 */
@Controller
public class SpecializationStreamController {
	@Autowired
	private SpecializationStreamService specializationStreamService;

	/**
	 * To handle request for Specialization Stream list
	 * 
	 * @return the list of all Specialization Streams
	 */
	@RequestMapping(value = "/listSpecializationStreams", method = RequestMethod.GET)
	public @ResponseBody List<SpecializationStream> listSpecializationStreams() {
		return this.specializationStreamService.listSpecializationStreams();

	}

	/**
	 * To provide specialization Stream management view
	 * 
	 * @return Specialization Stream management page
	 */
	@RequestMapping(value = "/specializationStream", method = RequestMethod.GET)
	public String goToIndex() {
		return "SpecializationStreamManagement";
	}

	/**
	 * To handle request for adding a new Specialization Stream
	 * 
	 * @param specializationStream
	 *            - detail of a new specialization Stream
	 * @return redirecting to specialization Stream management page
	 */
	@RequestMapping(value = "/addSpecializationStream", method = RequestMethod.POST)
	public String addSpecializationStream(@RequestBody SpecializationStream specializationStream) {

		this.specializationStreamService.addSpecializationStream(specializationStream);
		return "redirect:/specializationStream";

	}

	/**
	 * To handle request for updating an existing Specialization Stream
	 * 
	 * @param specializationStream
	 *            - detail of an existing Specialization Stream
	 * @return Specialization Stream management page
	 */
	@RequestMapping(value = "/updateSpecializationStream", method = RequestMethod.POST)
	public String editSpecializationStream(@RequestBody SpecializationStream specializationStream) {
		this.specializationStreamService.updateSpecializationStream(specializationStream);
		return "redirect:/specializationStream";

	}

	/**
	 * To handle request for deleting an existing Specialization Stream 
	 * 
	 * @param id
	 *            - Specialization Stream id for an existing specializationStream passed in query
	 *            string
	 * @return Specialization Stream management page
	 */
	@RequestMapping(value = "/deleteSpecializationStream/{id}", method = RequestMethod.GET)
	public String deleteSpecializationStream(@PathVariable("id") int id) {
		this.specializationStreamService.removeSpecializationStream(id);
		return "redirect:/specializationStream";
	}

}

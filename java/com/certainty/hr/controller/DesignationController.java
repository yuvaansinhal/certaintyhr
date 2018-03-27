package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.Designation;
import com.certainty.hr.service.DesignationService;

/**
 * Controller class to handle HTTP requests for Designation
 *
 */
@Controller
public class DesignationController {
	@Autowired
	private DesignationService designationService;

	/**
	 * To handle request for Designation list
	 * 
	 * @return the list of all designations
	 */
	@RequestMapping(value = "/listDesignations", method = RequestMethod.GET)
	public @ResponseBody List<Designation> listDesignations() {
		return this.designationService.listDesignations();
	}

	/**
	 * To handle request for Designations in ascending order
	 * 
	 * @return the list of all Designations in ascending order
	 */
	@RequestMapping(value = "/listOrderedDesignationsByGrade/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Designation> listOrderedDesignationsByGrade(@PathVariable("id") int id) {
		return this.designationService.listOrderedDesignationsByGrade(id);

	}
	
	
	/**
	 * To provide Designation management view
	 * 
	 * @return Designation management page
	 */
	@RequestMapping(value = "/designation", method = RequestMethod.GET)
	public String goToIndex() {
		return "DesignationManagement";
	}

	/**
	 * To handle request for adding a new Designation
	 * 
	 * @param d
	 *            - detail of a new Designation
	 * @return redirecting to Designation page
	 */
	@RequestMapping(value = "/addDesignation", method = RequestMethod.POST)
	public String adddesignation(@RequestBody Designation d) {
		this.designationService.addDesignation(d);
		return "redirect:/designation";
	}

	/**
	 * To handle request for updating an existing Designation
	 * 
	 * @param d
	 *            - detail of an existing Designation
	 * @return Designation management page
	 */
	@RequestMapping(value = "/updateDesignation", method = RequestMethod.POST)
	public String editdesignation(@RequestBody Designation d) {
		this.designationService.updateDesignation(d);
		return "redirect:/designation";
	}

	/**
	 * To handle request for deleting an existing designation
	 * 
	 * @param id
	 *            - designation id for an existing Designation passed in query
	 *            string
	 * @return Designation management page
	 */
	@RequestMapping(value = "/deleteDesignation/{id}", method = RequestMethod.GET)
	public String deleteDesignation(@PathVariable("id") int id) {
		this.designationService.removeDesignation(id);
		return "redirect:/designation";
	}
}

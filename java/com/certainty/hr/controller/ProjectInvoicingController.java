package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.ProjectInvoicing;
import com.certainty.hr.service.ProjectInvoicingService;

/**
 * Controller class to handle HTTP requests for Project Invoicing
 * 
 *
 */
@Controller
public class ProjectInvoicingController {
	@Autowired
	private ProjectInvoicingService projectInvoicingService;

	/**
	 * To handle request for Project Invoice list
	 * 
	 * @return the list of all Project Invoices
	 */
	@RequestMapping(value = "/listProjectInvoicings", method = RequestMethod.GET)
	public @ResponseBody List<ProjectInvoicing> listProjectInvoicings() {
		return this.projectInvoicingService.listProjectInvoicings();

	}

	/**
	 * To provide Project Invoicing management view
	 * 
	 * @return Project Invoicing management page
	 */
	@RequestMapping(value = "/projectInvoicing", method = RequestMethod.GET)
	public String goToIndex() {
		return "ProjectInvoicingManagement";
	}

	/**
	 * To handle request for adding a new Project Invoice
	 * 
	 * @param projectInvoicing
	 *            - detail of a new Project Invoice
	 * @return redirecting to Project Invoicing page
	 */
	@RequestMapping(value = "/addProjectInvoicing", method = RequestMethod.POST)
	public String addProjectInvoicing(@RequestBody ProjectInvoicing projectInvoicing) {

		this.projectInvoicingService.addProjectInvoicing(projectInvoicing);
		return "redirect:/projectInvoicing";

	}

	/**
	 * To handle request for updating an existing Project Invoice
	 * 
	 * @param projectInvoicing
	 *            - detail of an existing Project Invoice
	 * @return Project Invoicing management page
	 */
	@RequestMapping(value = "/updateProjectInvoicing", method = RequestMethod.POST)
	public String editProjectInvoicing(@RequestBody ProjectInvoicing projectInvoicing) {
		this.projectInvoicingService.updateProjectInvoicing(projectInvoicing);
		return "redirect:/projectInvoicing";

	}

	/**
	 * To handle request for deleting an existing Project Invoice
	 * 
	 * @param id
	 *            - Project Invoice id for an existing Project Invoice passed in
	 *            query string
	 * @return Project Invoicing management page
	 */
	@RequestMapping(value = "/deleteProjectInvoicing/{id}", method = RequestMethod.GET)
	public String deleteProjectInvoicing(@PathVariable("id") int id) {
		this.projectInvoicingService.removeProjectInvoicing(id);
		return "redirect:/projectInvoicing";
	}
}

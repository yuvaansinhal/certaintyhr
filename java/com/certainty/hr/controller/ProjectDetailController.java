package com.certainty.hr.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.certainty.hr.model.ProjectDetail;
import com.certainty.hr.service.ProjectDetailService;

/**
 * Controller class to handle HTTP requests for project detail
 * 
 *
 */
@Controller
public class ProjectDetailController {
	@Autowired
	private ProjectDetailService projectDetailService;

	/**
	 * To handle request for project detail list
	 * 
	 * @return the list of all Projects details
	 */
	@RequestMapping(value = "/listProjectDetails", method = RequestMethod.GET)
	public @ResponseBody List<ProjectDetail> listProjectDetails() {
		return this.projectDetailService.listProjectDetails();

	}
	
	/**
	 * To handle request for project detail list in ascending order
	 * 
	 * @return the list of all Projects details in ascending order
	 */
	@RequestMapping(value = "/listOrderedProjectDetails", method = RequestMethod.GET)
	public @ResponseBody List<ProjectDetail> listOrderedProjectDetails() {
		return this.projectDetailService.listOrderedProjectDetails();

	}

	/**
	 * To handle request for project detail list in ascending order
	 * 
	 * @return the list of all Projects details in ascending order
	 */
	@RequestMapping(value = "/listOrderedProjectDetailsByClient/{id}", method = RequestMethod.GET)
	public @ResponseBody List<ProjectDetail> listOrderedProjectDetailsByClientID(@PathVariable("id") int id) {
		return this.projectDetailService.listOrderedProjectDetailsByClientID(id);

	}

	/**
	 * To provide project detail management view
	 * 
	 * @return project detail management page
	 */
	@RequestMapping(value = "/projectDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "ProjectDetailManagement";
	}

	/**
	 * To handle request for adding a new project detail
	 * 
	 * @param pdl
	 *            - detail of a new Project
	 * @return redirecting to project detail page
	 */
	@RequestMapping(value = "/addProjectDetail", method = RequestMethod.POST)
	public String addProjectDetail(@RequestBody ProjectDetail pdl) {
		this.projectDetailService.addProjectDetail(pdl);
		return "redirect:/projectDetail";

	}

	/**
	 * To handle request for updating an existing project detail
	 * 
	 * @param pdl
	 *            - detail of an existing project
	 * @return project detail management page
	 */
	@RequestMapping(value = "/updateProjectDetail", method = RequestMethod.POST)
	public String editProjectDetail(@RequestBody ProjectDetail pdl) {
		this.projectDetailService.updateProjectDetail(pdl);
		return "redirect:/projectDetail";

	}

	/**
	 * To handle request for deleting an existing project detail
	 * 
	 * @param id
	 *            - project id for an existing project passed in query string
	 * @return project detail management page
	 */
	@RequestMapping(value = "/deleteProjectDetail/{id}", method = RequestMethod.GET)
	public String deleteProjectDetail(@PathVariable("id") int id) {
		this.projectDetailService.removeProjectDetail(id);
		return "redirect:/projectDetail";
	}
}

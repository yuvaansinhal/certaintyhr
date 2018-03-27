package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.ProjectType;
import com.certainty.hr.service.ProjectTypeService;

/**
 * Controller class to handle HTTP requests for Project Type
 *
 */

@Controller
public class ProjectTypeController {

	@Autowired
	private ProjectTypeService projectTypeService;

	/**
	 * To handle request for Project Type list
	 * 
	 * @return the list of all project Types
	 */
	@RequestMapping(value = "/listProjectTypes", method = RequestMethod.GET)
	public @ResponseBody List<ProjectType> listProjectTypes() {
		return this.projectTypeService.listProjectTypes();
	}

	/**
	 * To provide project Type management view
	 * 
	 * @return project Type management page
	 */
	@RequestMapping(value = "/projectType", method = RequestMethod.GET)
	public String goToIndex() {
		return "ProjectTypeManagement";
	}

	/**
	 * To handle request for adding a new project Type
	 * 
	 * @param projectType
	 *            - detail of a new Project Type
	 * @return redirecting to projectType detail page
	 */
	@RequestMapping(value = "/addProjectType", method = RequestMethod.POST)
	public String addProjectType(@RequestBody ProjectType projectType) {
		this.projectTypeService.addProjectType(projectType);
		return "redirect:/projectType";

	}

	/**
	 * To handle request for updating an existing Project Type
	 * 
	 * @param projectType
	 *            - detail of an existing Project Type
	 * @return Project Type management page
	 */
	@RequestMapping(value = "/updateProjectType", method = RequestMethod.POST)
	public String editproejctType(@RequestBody ProjectType projectType) {
		this.projectTypeService.updateProjectType(projectType);
		return "redirect:/projectType";

	}

	/**
	 * To handle request for deleting an existing Project Type
	 * 
	 * @param id
	 *            - projectType id for an existing Project Type passed in query
	 *            string
	 * @return Project Type management page
	 */
	@RequestMapping(value = "/deleteProjectType/{id}", method = RequestMethod.GET)
	public String deleteProjectType(@PathVariable("id") int id) {
		this.projectTypeService.removeProjectType(id);
		return "redirect:/projectType";
	}

}

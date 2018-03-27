package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.ProjectResource;
import com.certainty.hr.service.ProjectResourceService;

/**
 * Controller class to handle HTTP requests for project Resource
 * 
 *
 */
@Controller
public class ProjectResourceController {
	@Autowired
	private ProjectResourceService projectResourceService;

	/**
	 * To handle request for project Resource list
	 * 
	 * @return the list of all Projects Resources
	 */
	@RequestMapping(value = "/listProjectResources", method = RequestMethod.GET)
	public @ResponseBody List<ProjectResource> listProjectResources() {
		return this.projectResourceService.listProjectResources();
	}

	/**
	 * To provide project Resource management view
	 * 
	 * @return project Resource management page
	 */
	@RequestMapping(value = "/projectResource", method = RequestMethod.GET)
	public String goToIndex() {
		return "ProjectResourceManagement";
	}

	/**
	 * To handle request for adding a new project Resource
	 * 
	 * @param projectResource
	 *            - detail of a new Project Resource
	 * @return redirecting to project Resource management page
	 */
	@RequestMapping(value = "/addProjectResource", method = RequestMethod.POST)
	public String addProjectDetail(@RequestBody ProjectResource projectResource) {
		this.projectResourceService.addProjectResource(projectResource);
		return "redirect:/projectResource";

	}

	/**
	 * To handle request for updating an existing project Resource
	 * 
	 * @param projectResource
	 *            - detail of an existing project Resource
	 * @return project Resource management page
	 */
	@RequestMapping(value = "/updateProjectResource", method = RequestMethod.POST)
	public String editProjectResource(@RequestBody ProjectResource projectResource) {
		this.projectResourceService.updateProjectResource(projectResource);
		return "redirect:/projectResource";

	}

	/**
	 * To handle request for deleting an existing project Resource
	 * 
	 * @param id
	 *            - Resource id for an existing project Resource passed in query
	 *            string
	 * @return project Resource management page
	 */
	@RequestMapping(value = "/deleteProjectResource/{id}", method = RequestMethod.GET)
	public String deleteProjectResource(@PathVariable("id") int id) {
		this.projectResourceService.removeProjectResource(id);
		return "redirect:/projectResource";
	}
}

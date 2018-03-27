package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.ProjectRole;
import com.certainty.hr.service.ProjectRoleService;

/**
 * Controller class to handle HTTP requests for Project Role
 *
 */

@Controller
public class ProjectRoleController {

	@Autowired
	private ProjectRoleService projectRoleService;

	/**
	 * To handle request for Project Role list
	 * 
	 * @return the list of all Project Roles
	 */
	@RequestMapping(value = "/listProjectRoles", method = RequestMethod.GET)
	public @ResponseBody List<ProjectRole> listProjectRoles() {
		return this.projectRoleService.listProjectRoles();
	}

	/**
	 * To provide Project Role management view
	 * 
	 * @return Project Role management page
	 */
	@RequestMapping(value = "/projectRole", method = RequestMethod.GET)
	public String goToIndex() {
		return "ProjectRoleManagement";
	}

	/**
	 * To handle request for adding a new Project Role
	 * 
	 * @param projectRole
	 *            - detail of a new Project Role
	 * @return redirecting to Project Role management page
	 */
	@RequestMapping(value = "/addProjectRole", method = RequestMethod.POST)
	public String addProjectRole(@RequestBody ProjectRole projectRole) {
		this.projectRoleService.addProjectRole(projectRole);
		return "redirect:/projectRole";

	}

	/**
	 * To handle request for updating an existing Project Role
	 * 
	 * @param projectRole
	 *            - detail of an existing Project Role
	 * @return Project Role management page
	 */
	@RequestMapping(value = "/updateProjectRole", method = RequestMethod.POST)
	public String editProjectRole(@RequestBody ProjectRole projectRole) {
		this.projectRoleService.updateProjectRole(projectRole);
		return "redirect:/projectRole";

	}

	/**
	 * To handle request for deleting an existing Project Role
	 * 
	 * @param id
	 *            - Project Role id for an existing Project Role passed in query
	 *            string
	 * @return Project Role management page
	 */
	@RequestMapping(value = "/deleteProjectRole/{id}", method = RequestMethod.GET)
	public String deleteProjectRole(@PathVariable("id") int id) {
		this.projectRoleService.removeProjectRole(id);
		return "redirect:/projectRole";
	}

}

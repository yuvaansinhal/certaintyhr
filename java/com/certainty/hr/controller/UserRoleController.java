package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.UserRole;
import com.certainty.hr.service.UserRoleService;

/**
 * Controller class to handle HTTP requests for User Role
 *
 */

@Controller
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	/**
	 * To handle request for User Role list
	 * 
	 * @return the list of all User Roles
	 */
	@RequestMapping(value = "/listUserRoles", method = RequestMethod.GET)
	public @ResponseBody List<UserRole> listUserRoles() {
		return this.userRoleService.listUserRoles();
	}

	/**
	 * To provide User Role management view
	 * 
	 * @return User Role management page
	 */
	@RequestMapping(value = "/userRole", method = RequestMethod.GET)
	public String goToIndex() {
		return "UserRoleManagement";
	}

	/**
	 * To handle request for adding a new User Role
	 * 
	 * @param userRole
	 *            - detail of a new User Role
	 * @return redirecting to User Role management page
	 */
	@RequestMapping(value = "/addUserRole", method = RequestMethod.POST)
	public String addUserRole(@RequestBody UserRole userRole) {
		this.userRoleService.addUserRole(userRole);
		return "redirect:/userRole";

	}

	/**
	 * To handle request for updating an existing User Role
	 * 
	 * @param userRole
	 *            - detail of an existing User Role
	 * @return User Role management page
	 */
	@RequestMapping(value = "/updateUserRole", method = RequestMethod.POST)
	public String editUserRole(@RequestBody UserRole userRole) {
		this.userRoleService.updateUserRole(userRole);
		return "redirect:/userRole";

	}

	/**
	 * To handle request for deleting an existing User Role
	 * 
	 * @param id
	 *            - User Role id for an existing User Role passed in query
	 *            string
	 * @return User Role management page
	 */
	@RequestMapping(value = "/deleteUserRole/{id}", method = RequestMethod.GET)
	public String deleteUserRole(@PathVariable("id") int id) {
		this.userRoleService.removeUserRole(id);
		return "redirect:/userRole";
	}

}

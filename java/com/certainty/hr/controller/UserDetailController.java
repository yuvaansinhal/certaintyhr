package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.UserDetail;
import com.certainty.hr.service.UserDetailService;

/**
 * Controller class to handle HTTP requests for User detail
 * 
 *
 */
@Controller
public class UserDetailController {
	@Autowired
	private UserDetailService userDetailService;

	/**
	 * To handle request for User detail list
	 * 
	 * @return the list of all User details
	 */
	@RequestMapping(value = "/listUserDetails", method = RequestMethod.GET)
	public @ResponseBody List<UserDetail> listUserDetails() {
		return this.userDetailService.listUserDetails();

	}

	/**
	 * To provide User detail management view
	 * 
	 * @return User detail management page
	 */
	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "UserDetailManagement";
	}

	/**
	 * To handle request for adding a new User detail
	 * 
	 * @param udl
	 *            - detail of a new User
	 * @return redirecting to User detail page
	 */
	@RequestMapping(value = "/addUserDetail", method = RequestMethod.POST)
	public String addUserDetail(@RequestBody UserDetail udl) {
		this.userDetailService.addUserDetail(udl);
		return "redirect:/userDetail";

	}

	/**
	 * To handle request for updating an existing User detail
	 * 
	 * @param udl
	 *            - detail of an existing User
	 * @return User detail management page
	 */
	@RequestMapping(value = "/updateUserDetail", method = RequestMethod.POST)
	public String editUserDetail(@RequestBody UserDetail udl) {
		this.userDetailService.updateUserDetail(udl);
		return "redirect:/userDetail";

	}

	/**
	 * To handle request for deleting an existing User detail
	 * 
	 * @param id
	 *            - User id for an existing User passed in query string
	 * @return User detail management page
	 */
	@RequestMapping(value = "/deleteUserDetail/{id}", method = RequestMethod.GET)
	public String deleteUserDetail(@PathVariable("id") int id) {
		this.userDetailService.removeUserDetail(id);
		return "redirect:/userDetail";
	}
}

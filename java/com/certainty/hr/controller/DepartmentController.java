package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.Department;
import com.certainty.hr.service.DepartmentService;

/**
 * Controller class to handle HTTP requests for Department
 *
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	/**
	 * To handle request for Department list
	 * 
	 * @return the list of all Departments
	 */
	@RequestMapping(value = "/listDepartments", method = RequestMethod.GET)
	public @ResponseBody List<Department> listDepartments() {
		return this.departmentService.listDepartments();
	}

	/**
	 * To provide Department management view
	 * 
	 * @return Department management page
	 */
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String goToIndex() {
		return "DepartmentManagement";
	}

	/**
	 * To handle request for adding a new department
	 * 
	 * @param d
	 *            - detail of a new department
	 * @return redirecting to department page
	 */
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public String addDepartment(@RequestBody Department d) {
		this.departmentService.addDepartment(d);
		return "redirect:/department";
	}

	/**
	 * To handle request for updating an existing department
	 * 
	 * @param d
	 *            - detail of an existing department
	 * @return department management page
	 */
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
	public String editDepartment(@RequestBody Department d) {
		this.departmentService.updateDepartment(d);
		return "redirect:/department";
	}

	/**
	 * To handle request for deleting an existing department
	 * 
	 * @param id
	 *            - department id for an existing department passed in query string
	 * @return department management page
	 */
	@RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.GET)
	public String deleteDepartment(@PathVariable("id") int id) {
		this.departmentService.removeDepartment(id);
		return "redirect:/department";
	}
}

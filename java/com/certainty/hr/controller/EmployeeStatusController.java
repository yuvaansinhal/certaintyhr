package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmployeeStatus;
import com.certainty.hr.service.EmployeeStatusService;

/**
 * Controller class to handle HTTP requests for Employee Status detail
 * 
 *
 */
@Controller
public class EmployeeStatusController {
	@Autowired
	private EmployeeStatusService employeeStatusService;

	/**
	 * To handle request for Emp status list
	 * 
	 * @return the list of all Emp statuses
	 */
	@RequestMapping(value = "/listEmployeeStatus", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeStatus> listEmployeeStatuss() {
		return this.employeeStatusService.listEmployeeStatuses();
	}
	/**
	 * To provide Emp status management view
	 * 
	 * @return Employee status management page
	 */
	@RequestMapping(value = "/EmployeeStatus", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmployeeStatusManagement";
	}

	/**
	 * To handle request for adding a new Emp status
	 * 
	 * @param emp
	 *            - detail of a new Employee status
	 * @return redirecting to Emp status management page
	 */
	@RequestMapping(value = "/addEmployeeStatus", method = RequestMethod.POST)
	public String addEmployeeStatus(@RequestBody EmployeeStatus emp) {
		this.employeeStatusService.addEmployeeStatus(emp);
		return "redirect:/employeeStatus";
	}

	/**
	 * To handle request for updating an existing Emp status
	 * 
	 * @param emp
	 *            - detail of an existing Employee status
	 * @return Emp status management page
	 */
	@RequestMapping(value = "/updateEmployeeStatus", method = RequestMethod.POST)
	public String editEmployeeStatus(@RequestBody EmployeeStatus emp) {
		this.employeeStatusService.updateEmployeeStatus(emp);
		return "redirect:/employeeStatus";
	}

	/**
	 * To handle request for deleting an existing Emp status
	 * 
	 * @param id
	 *            - Emp id for an existing Emp status passed in query string
	 * @return Emp status management page
	 */
	@RequestMapping(value = "/deleteEmployeeStatus/{id}", method = RequestMethod.GET)
	public String deleteEmployeeStatus(@PathVariable("id") int id) {
		this.employeeStatusService.removeEmployeeStatus(id);
		return "redirect:/employeeStatus";
	}
}

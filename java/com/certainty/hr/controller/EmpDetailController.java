package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmpDetail;
import com.certainty.hr.service.EmpDetailService;

/**
 * Controller class to handle HTTP requests for Emp detail
 * 
 *
 */
@Controller
public class EmpDetailController {
	@Autowired
	private EmpDetailService empDetailService;

	/**
	 * To handle request for Emp detail list
	 * 
	 * @return the list of all Emp details
	 */
	@RequestMapping(value = "/listEmpDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpDetail> listEmpDetails() {
		return this.empDetailService.listEmpDetails();
	}

	/**
	 * To handle request for Emp detail list in ascending order
	 * 
	 * @return the list of all Emp details in ascending order
	 */
	@RequestMapping(value = "/listOrderedEmpDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpDetail> listOrderedEmpDetails() {
		return this.empDetailService.listOrderedEmpDetails();
	}

	/**
	 * To provide Emp detail management view
	 * 
	 * @return Employee management page
	 */
	@RequestMapping(value = "/empDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmpDetailManagement";
	}

	/**
	 * To handle request for adding a new Emp detail
	 * 
	 * @param emp
	 *            - detail of a new Employee
	 * @return redirecting to Emp detail page
	 */
	@RequestMapping(value = "/addEmpDetail", method = RequestMethod.POST)
	public String addEmpDetail(@RequestBody EmpDetail emp) {
		this.empDetailService.addEmpDetail(emp);
		return "redirect:/empDetail";
	}

	/**
	 * To handle request for updating an existing Emp detail
	 * 
	 * @param emp
	 *            - detail of an existing Employee
	 * @return Emp detail management page
	 */
	@RequestMapping(value = "/updateEmpDetail", method = RequestMethod.POST)
	public String editEmpDetail(@RequestBody EmpDetail emp) {
		this.empDetailService.updateEmpDetail(emp);
		return "redirect:/empDetail";
	}

	/**
	 * To handle request for deleting an existing Emp detail
	 * 
	 * @param id
	 *            - Emp id for an existing Emp passed in query string
	 * @return Emp detail management page
	 */
	@RequestMapping(value = "/deleteEmpDetail/{id}", method = RequestMethod.GET)
	public String deleteEmpDetail(@PathVariable("id") int id) {
		this.empDetailService.removeEmpDetail(id);
		return "redirect:/empDetail";
	}
}

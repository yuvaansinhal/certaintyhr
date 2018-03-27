package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmpPersonalDetail;
import com.certainty.hr.service.EmpPersonalDetailService;

/**
 * Controller class to handle HTTP requests for Emp Personal Detail
 * 
 *
 */
@Controller
public class EmpPersonalDetailController {
	@Autowired
	private EmpPersonalDetailService empPersonalDetailService;

	/**
	 * To handle request for Emp Personal detail list
	 * 
	 * @return the list of all Emp Personal details
	 */
	@RequestMapping(value = "/listEmpPersonalDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpPersonalDetail> listEmpPersonalDetails() {
		return this.empPersonalDetailService.listEmpPersonalDetails();
	}

	/**
	 * To provide Emp Personal detail management view
	 * 
	 * @return Emp Personal detail management page
	 */
	@RequestMapping(value = "/empPersonalDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmpPersonalDetailManagement";
	}

	/**
	 * To handle request for adding a new Emp Personal detail
	 * 
	 * @param epd
	 *            - detail of a new Employee Personal detail
	 * @return redirecting to Emp Personal detail page
	 */
	@RequestMapping(value = "/addEmpPersonalDetail", method = RequestMethod.POST)
	public String addEmpPersonalDetail(@RequestBody EmpPersonalDetail epd) {

		this.empPersonalDetailService.addEmpPersonalDetail(epd);
		return "redirect:/empPersonalDetail";
	}

	/**
	 * To handle request for updating an existing Emp Personal detail
	 * 
	 * @param epd
	 *            - detail of an existing Personal Emp
	 * @return Emp Personal detail management page
	 */
	@RequestMapping(value = "/updateEmpPersonalDetail", method = RequestMethod.POST)
	public String editEmpPersonalDetail(@RequestBody EmpPersonalDetail epd) {
		this.empPersonalDetailService.updateEmpPersonalDetail(epd);
		return "redirect:/empPersonalDetail";
	}

	/**
	 * To handle request for deleting an existing Emp Personal detail
	 * 
	 * @param id
	 *            - Emp id for an existing Emp Personal passed in query string
	 * @return Emp Personal detail management page
	 */
	@RequestMapping(value = "/deleteEmpPersonalDetail/{id}", method = RequestMethod.GET)
	public String deleteEmpPersonalDetail(@PathVariable("id") int id) {
		this.empPersonalDetailService.removeEmpPersonalDetail(id);
		return "redirect:/empPersonalDetail";
	}
}

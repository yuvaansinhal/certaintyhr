package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmpEducationDetail;
import com.certainty.hr.service.EmpEducationDetailService;

/**
 * Controller class to handle HTTP requests for Emp Education Detail
 * 
 *
 */
@Controller
public class EmpEducationDetailController {
	@Autowired
	private EmpEducationDetailService empEducationDetailService;

	/**
	 * To handle request for Emp Education detail list
	 * 
	 * @return the list of all Emp Education details
	 */
	@RequestMapping(value = "/listEmpEducationDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpEducationDetail> listEmpEducationDetails() {
		return this.empEducationDetailService.listEmpEducationDetails();
	}

	/**
	 * To provide Emp Education detail management view
	 * 
	 * @return Emp Education detail management page
	 */
	@RequestMapping(value = "/empEducationDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmpEducationDetailManagement";
	}

	/**
	 * To handle request for adding a new Emp Education detail
	 * 
	 * @param esd
	 *            - detail of a new Employee Education detail
	 * @return redirecting to Emp Education detail page
	 */
	@RequestMapping(value = "/addEmpEducationDetail", method = RequestMethod.POST)
	public String addEmpEducationDetail(@RequestBody EmpEducationDetail esd) {

		this.empEducationDetailService.addEmpEducationDetail(esd);
		return "redirect:/empEducationDetail";
	}

	/**
	 * To handle request for updating an existing Emp Education detail
	 * 
	 * @param epd
	 *            - detail of an existing Education Emp
	 * @return Emp Education detail management page
	 */
	@RequestMapping(value = "/updateEmpEducationDetail", method = RequestMethod.POST)
	public String editEmpEducationDetail(@RequestBody EmpEducationDetail epd) {
		this.empEducationDetailService.updateEmpEducationDetail(epd);
		return "redirect:/empEducationDetail";
	}

	/**
	 * To handle request for deleting an existing Emp Education detail
	 * 
	 * @param id
	 *            - Emp id for an existing Emp Education passed in query string
	 * @return Emp Education detail management page
	 */
	@RequestMapping(value = "/deleteEmpEducationDetail/{id}", method = RequestMethod.GET)
	public String deleteEmpEducationDetail(@PathVariable("id") int id) {
		this.empEducationDetailService.removeEmpEducationDetail(id);
		return "redirect:/empEducationDetail";
	}
}

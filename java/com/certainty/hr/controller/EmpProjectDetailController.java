package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmpProjectDetail;
import com.certainty.hr.service.EmpProjectDetailService;

/**
 * Controller class to handle HTTP requests for EmpProject detail
 * 
 *
 */
@Controller
public class EmpProjectDetailController {
	@Autowired
	private EmpProjectDetailService empProjectDetailService;

	/**
	 * To handle request for empProject detail list
	 * 
	 * @return the list of all empProject details
	 */
	@RequestMapping(value = "/listEmpProjectDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpProjectDetail> listEmpProjectDetails() {
		return this.empProjectDetailService.listEmpProjectDetails();

	}

	/**
	 * To provide empProjectDetail management view
	 * 
	 * @return empProjectDetail management page
	 */
	@RequestMapping(value = "/empProjectDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmpProjectDetailManagement";
	}

	/**
	 * To handle request for adding a new empProjectDetail
	 * 
	 * @param empProjectDetail
	 *            - detail of a new empProject
	 * @return redirecting to empProjectDetail page
	 */
	@RequestMapping(value = "/addEmpProjectDetail", method = RequestMethod.POST)
	public String addEmpProjectDetail(@RequestBody EmpProjectDetail empProjectDetail) {

		this.empProjectDetailService.addEmpProjectDetail(empProjectDetail);
		return "redirect:/empProjectDetail";

	}

	/**
	 * To handle request for updating an existing empProject Detail
	 * 
	 * @param empProjectDetail
	 *            - detail of an existing empProject
	 * @return empProject Detail management page
	 */
	@RequestMapping(value = "/updateEmpProjectDetail", method = RequestMethod.POST)
	public String editEmpProjectDetail(@RequestBody EmpProjectDetail empProjectDetail) {
		this.empProjectDetailService.updateEmpProjectDetail(empProjectDetail);
		return "redirect:/empProjectDetail";

	}

	/**
	 * To handle request for deleting an existing empProject Detail
	 * 
	 * @param id
	 *            - empProject id for an existing client passed in query string
	 * @return empProject Detail management page
	 */
	@RequestMapping(value = "/deleteEmpProjectDetail/{id}", method = RequestMethod.GET)
	public String deleteEmpProjectDetail(@PathVariable("id") int id) {
		this.empProjectDetailService.removeEmpProjectDetail(id);
		return "redirect:/empProjectDetail";
	}
}

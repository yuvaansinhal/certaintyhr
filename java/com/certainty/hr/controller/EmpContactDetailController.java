package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmpContactDetail;
import com.certainty.hr.service.EmpContactDetailService;

/**
 * Controller class to handle HTTP requests for Emp Contact detail
 * 
 *
 */
@Controller
public class EmpContactDetailController {
	@Autowired
	private EmpContactDetailService empContactDetailService;

	/**
	 * To handle request for empContact detail list
	 * 
	 * @return the list of all empContact details
	 */
	@RequestMapping(value = "/listEmpContactDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpContactDetail> listEmpContactDetails() {
		return this.empContactDetailService.listEmpContactDetails();

	}

	/**
	 * To provide empContactDetail management view
	 * 
	 * @return empContactDetail management page
	 */
	@RequestMapping(value = "/empContactDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmpContactDetailManagement";
	}

	/**
	 * To handle request for adding a new empContactDetail
	 * 
	 * @param empContactDetail
	 *            - detail of a new empContact
	 * @return redirecting to empContactDetail page
	 */
	@RequestMapping(value = "/addEmpContactDetail", method = RequestMethod.POST)
	public String addEmpContactDetail(@RequestBody EmpContactDetail empContactDetail) {

		this.empContactDetailService.addEmpContactDetail(empContactDetail);
		return "redirect:/empContactDetail";

	}

	/**
	 * To handle request for updating an existing empContact Detail
	 * 
	 * @param empContactDetail
	 *            - detail of an existing empContact
	 * @return empContact Detail management page
	 */
	@RequestMapping(value = "/updateEmpContactDetail", method = RequestMethod.POST)
	public String editEmpContactDetail(@RequestBody EmpContactDetail empContactDetail) {
		this.empContactDetailService.updateEmpContactDetail(empContactDetail);
		return "redirect:/empContactDetail";

	}

	/**
	 * To handle request for deleting an existing empContact Detail
	 * 
	 * @param id
	 *            - empContact id for an existing client passed in query string
	 * @return empContact Detail management page
	 */
	@RequestMapping(value = "/deleteEmpContactDetail/{id}", method = RequestMethod.GET)
	public String deleteEmpContactDetail(@PathVariable("id") int id) {
		this.empContactDetailService.removeEmpContactDetail(id);
		return "redirect:/empContactDetail";
	}
}

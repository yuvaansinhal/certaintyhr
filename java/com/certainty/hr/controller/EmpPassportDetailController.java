package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmpPassportDetail;
import com.certainty.hr.service.EmpPassportDetailService;

/**
 * Controller class to handle HTTP requests for Emp Passport detail
 * 
 *
 */
@Controller
public class EmpPassportDetailController {
	@Autowired
	private EmpPassportDetailService empPassportDetailService;

	/**
	 * To handle request for emp Passport detail list
	 * 
	 * @return the list of all empPassport details
	 */
	@RequestMapping(value = "/listEmpPassportDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpPassportDetail> listEmpPassportDetails() {
		return this.empPassportDetailService.listEmpPassportDetails();

	}

	/**
	 * To provide empPassportDetail management view
	 * 
	 * @return empPassportDetail management page
	 */
	@RequestMapping(value = "/empPassportDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmpPassportDetailManagement";
	}

	/**
	 * To handle request for adding a new empPassportDetail
	 * 
	 * @param empPassportDetail
	 *            - detail of a new empPassport
	 * @return redirecting to empPassportDetail page
	 */
	@RequestMapping(value = "/addEmpPassportDetail", method = RequestMethod.POST)
	public String addEmpPassportDetail(@RequestBody EmpPassportDetail empPassportDetail) {

		this.empPassportDetailService.addEmpPassportDetail(empPassportDetail);
		return "redirect:/empPassportDetail";

	}

	/**
	 * To handle request for updating an existing empPassport Detail
	 * 
	 * @param empPassportDetail
	 *            - detail of an existing empPassport
	 * @return empPassport Detail management page
	 */
	@RequestMapping(value = "/updateEmpPassportDetail", method = RequestMethod.POST)
	public String editEmpPassportDetail(@RequestBody EmpPassportDetail empPassportDetail) {
		this.empPassportDetailService.updateEmpPassportDetail(empPassportDetail);
		return "redirect:/empPassportDetail";

	}

	/**
	 * To handle request for deleting an existing empPassport Detail
	 * 
	 * @param id
	 *            - empPassport id for an existing client passed in query string
	 * @return empPassport Detail management page
	 */
	@RequestMapping(value = "/deleteEmpPassportDetail/{id}", method = RequestMethod.GET)
	public String deleteEmpPassportDetail(@PathVariable("id") int id) {
		this.empPassportDetailService.removeEmpPassportDetail(id);
		return "redirect:/empPassportDetail";
	}
}

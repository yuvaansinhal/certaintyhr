package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.IndustryType;
import com.certainty.hr.service.IndustryTypeService;

/**
 * Controller class to handle HTTP requests for Industry Type
 * 
 *
 */
@Controller
public class IndustryTypeController {
	@Autowired
	private IndustryTypeService industryTypeService;

	/**
	 * To handle request for Industry Type list
	 * 
	 * @return the list of all industry Types
	 */
	@RequestMapping(value = "/listIndustryTypes", method = RequestMethod.GET)
	public @ResponseBody List<IndustryType> listIndustryTypes() {
		return this.industryTypeService.listIndustryTypes();

	}

	/**
	 * To provide industry Type management view
	 * 
	 * @return Industry Type management page
	 */
	@RequestMapping(value = "/industryType", method = RequestMethod.GET)
	public String goToIndex() {
		return "IndustryTypeManagement";
	}

	/**
	 * To handle request for adding a new Industry Type
	 * 
	 * @param industryType
	 *            - detail of a new industry Type
	 * @return redirecting to industry Type page
	 */
	@RequestMapping(value = "/addIndustryType", method = RequestMethod.POST)
	public String addIndustryType(@RequestBody IndustryType industryType) {

		this.industryTypeService.addIndustryType(industryType);
		return "redirect:/industryType";

	}

	/**
	 * To handle request for updating an existing Industry Type
	 * 
	 * @param industryType
	 *            - detail of an existing Industry Type
	 * @return Industry Type management page
	 */
	@RequestMapping(value = "/updateIndustryType", method = RequestMethod.POST)
	public String editIndustryType(@RequestBody IndustryType industryType) {
		this.industryTypeService.updateIndustryType(industryType);
		return "redirect:/industryType";

	}

	/**
	 * To handle request for deleting an existing Industry Type 
	 * 
	 * @param id
	 *            - Industry Type id for an existing industry Type passed in query
	 *            string
	 * @return Industry Type management page
	 */
	@RequestMapping(value = "/deleteIndustryType/{id}", method = RequestMethod.GET)
	public String deleteIndustryType(@PathVariable("id") int id) {
		this.industryTypeService.removeIndustryType(id);
		return "redirect:/industryType";
	}

}

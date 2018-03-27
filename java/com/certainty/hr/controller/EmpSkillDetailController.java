package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.EmpSkillDetail;
import com.certainty.hr.service.EmpSkillDetailService;

/**
 * Controller class to handle HTTP requests for Emp Skill Detail
 * 
 *
 */
@Controller
public class EmpSkillDetailController {
	@Autowired
	private EmpSkillDetailService empSkillDetailService;

	/**
	 * To handle request for Emp Skill detail list
	 * 
	 * @return the list of all Emp Skill details
	 */
	@RequestMapping(value = "/listEmpSkillDetails", method = RequestMethod.GET)
	public @ResponseBody List<EmpSkillDetail> listEmpSkillDetails() {
		return this.empSkillDetailService.listEmpSkillDetails();
	}

	/**
	 * To provide Emp Skill detail management view
	 * 
	 * @return Emp Skill detail management page
	 */
	@RequestMapping(value = "/empSkillDetail", method = RequestMethod.GET)
	public String goToIndex() {
		return "EmpSkillDetailManagement";
	}

	/**
	 * To handle request for adding a new Emp Skill detail
	 * 
	 * @param esd
	 *            - detail of a new Employee Skill detail
	 * @return redirecting to Emp Skill detail page
	 */
	@RequestMapping(value = "/addEmpSkillDetail", method = RequestMethod.POST)
	public String addEmpSkillDetail(@RequestBody EmpSkillDetail esd) {

		this.empSkillDetailService.addEmpSkillDetail(esd);
		return "redirect:/empSkillDetail";
	}

	/**
	 * To handle request for updating an existing Emp Skill detail
	 * 
	 * @param epd
	 *            - detail of an existing Skill Emp
	 * @return Emp Skill detail management page
	 */
	@RequestMapping(value = "/updateEmpSkillDetail", method = RequestMethod.POST)
	public String editEmpSkillDetail(@RequestBody EmpSkillDetail epd) {
		this.empSkillDetailService.updateEmpSkillDetail(epd);
		return "redirect:/empSkillDetail";
	}

	/**
	 * To handle request for deleting an existing Emp Skill detail
	 * 
	 * @param id
	 *            - Emp id for an existing Emp Skill passed in query string
	 * @return Emp Skill detail management page
	 */
	@RequestMapping(value = "/deleteEmpSkillDetail/{id}", method = RequestMethod.GET)
	public String deleteEmpSkillDetail(@PathVariable("id") int id) {
		this.empSkillDetailService.removeEmpSkillDetail(id);
		return "redirect:/empSkillDetail";
	}
}

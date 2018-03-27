package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.SkillType;
import com.certainty.hr.service.SkillTypeService;

/**
 * Controller class to handle HTTP requests for skill types
 * 
 *
 */

@Controller
public class SkillTypeController {
	@Autowired
	private SkillTypeService skillTypeService;

	/**
	 * To handle request for Skill Type list
	 * 
	 * @return the list of all SkillTypes
	 */
	@RequestMapping(value = "/listSkillTypes", method = RequestMethod.GET)
	public @ResponseBody List<SkillType> listSkillTypes() {
		return this.skillTypeService.listSkillTypes();

	}

	/**
	 * To provide SkillType management view
	 * 
	 * @return SkillType Type management page
	 */
	@RequestMapping(value = "/SkillType", method = RequestMethod.GET)
	public String goToIndex() {
		return "SkillTypeManagement";
	}

	/**
	 * To handle request for adding a new SkillType Type
	 * 
	 * @param SkillType
	 *            - detail of a new SkillType
	 * @return redirecting to SkillType page
	 */
	@RequestMapping(value = "/addSkillType", method = RequestMethod.POST)
	public String addSkillType(@RequestBody SkillType skillType) {

		this.skillTypeService.addSkillType(skillType);
		return "redirect:/SkillType";

	}

	/**
	 * To handle request for updating an existing SkillType Type
	 * 
	 * @param SkillType
	 *            - detail of an existing SkillType Type
	 * @return SkillType Type management page
	 */
	@RequestMapping(value = "/updateSkillType", method = RequestMethod.POST)
	public String editSkillType(@RequestBody SkillType skillType) {
		this.skillTypeService.updateSkillType(skillType);
		return "redirect:/SkillType";

	}

	/**
	 * To handle request for deleting an existing SkillType Type
	 * 
	 * @param id
	 *            - SkillType id for an existing SkillType passed in query
	 *            string
	 * @return SkillType Type management page
	 */
	@RequestMapping(value = "/deleteSkillType/{id}", method = RequestMethod.GET)
	public String deleteSkillType(@PathVariable("id") int id) {
		this.skillTypeService.removeSkillType(id);
		return "redirect:/SkillType";
	}

}

package com.certainty.hr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.Grade;
import com.certainty.hr.service.GradeService;

/**
 * Controller class to handle HTTP requests for Grade
 * 
 *
 */
@Controller
public class GradeController {
	@Autowired
	private GradeService gradeService;

	/**
	 * To handle request for Grade list
	 * 
	 * @return the list of all Grades
	 */
	@RequestMapping(value = "/listGrades", method = RequestMethod.GET)
	public @ResponseBody List<Grade> listGrades() {
		return this.gradeService.listGrades();

	}

	/**
	 * To provide grade management view
	 * 
	 * @return Grade management page
	 */
	@RequestMapping(value = "/grade", method = RequestMethod.GET)
	public String goToIndex() {
		return "GradeManagement";
	}

	/**
	 * To handle request for adding a new Grade
	 * 
	 * @param grade
	 *            - detail of a new grade
	 * @return redirecting to grade page
	 */
	@RequestMapping(value = "/addGrade", method = RequestMethod.POST)
	public String addGrade(@RequestBody Grade grade) {

		this.gradeService.addGrade(grade);
		return "redirect:/grade";

	}

	/**
	 * To handle request for updating an existing Grade
	 * 
	 * @param grade
	 *            - detail of an existing Grade
	 * @return Grade management page
	 */
	@RequestMapping(value = "/updateGrade", method = RequestMethod.POST)
	public String editGrade(@RequestBody Grade grade) {
		this.gradeService.updateGrade(grade);
		return "redirect:/grade";

	}

	/**
	 * To handle request for deleting an existing Grade 
	 * 
	 * @param id
	 *            - Grade id for an existing grade passed in query
	 *            string
	 * @return Grade management page
	 */
	@RequestMapping(value = "/deleteGrade/{id}", method = RequestMethod.GET)
	public String deleteGrade(@PathVariable("id") int id) {
		this.gradeService.removeGrade(id);
		return "redirect:/grade";
	}

}

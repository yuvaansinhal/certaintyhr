package com.certainty.hr.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.certainty.hr.model.EducationCourse;
import com.certainty.hr.service.EducationCourseService;

/**
 * Controller class to handle HTTP requests for Education course
 * 
 *
 */
@Controller
public class EducationCourseController {
	@Autowired
	private EducationCourseService educationCourseService;

	/**
	 * To handle request for Education course list
	 * 
	 * @return the list of all Education courses
	 */
	@RequestMapping(value = "/listEducationCourses", method = RequestMethod.GET)
	public @ResponseBody List<EducationCourse> listEducationCourses() {
		return this.educationCourseService.listEducationCourses();

	}
	
	/**
	 * To provide Education course management view
	 * 
	 * @return Education course management page
	 */
	@RequestMapping(value = "/educationCourse", method = RequestMethod.GET)
	public String goToIndex() {
		return "EducationCourseManagement";
	}

	/**
	 * To handle request for adding a new Education course
	 * 
	 * @param educationCourse
	 *            - detail of a new Education course
	 * @return redirecting to Education course management page
	 */
	@RequestMapping(value = "/addEducationCourse", method = RequestMethod.POST)
	public String addEducationCourse(@RequestBody EducationCourse educationCourse) {
		this.educationCourseService.addEducationCourse(educationCourse);
		return "redirect:/educationCourse";

	}

	/**
	 * To handle request for updating an existing Education course
	 * 
	 * @param educationCourse
	 *            - detail of an existing Education course
	 * @return Education course management page
	 */
	@RequestMapping(value = "/updateEducationCourse", method = RequestMethod.POST)
	public String editEducationCourse(@RequestBody EducationCourse educationCourse) {
		this.educationCourseService.updateEducationCourse(educationCourse);
		return "redirect:/educationCourse";

	}

	/**
	 * To handle request for deleting an existing Education course
	 * 
	 * @param id
	 *            - Education course id for an existing Education course passed in query string
	 * @return Education course management page
	 */
	@RequestMapping(value = "/deleteEducationCourse/{id}", method = RequestMethod.GET)
	public String deleteEducationCourse(@PathVariable("id") int id) {
		this.educationCourseService.removeEducationCourse(id);
		return "redirect:/educationCourse";
	}
}

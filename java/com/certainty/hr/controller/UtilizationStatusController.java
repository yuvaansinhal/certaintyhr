package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.UtilizationStatus;
import com.certainty.hr.service.UtilizationStatusService;


/**
 * Controller class to handle HTTP requests for Utilization status
 * 
 *
 */
@Controller
public class UtilizationStatusController {
	@Autowired
	private UtilizationStatusService utilizationStatusService;

	/**
	 * To handle request for UtilizationStatus Type list
	 * 
	 * @return the list of all UtilizationStatuss
	 */
	@RequestMapping(value = "/listUtilizationStatuses", method = RequestMethod.GET)
	public @ResponseBody List<UtilizationStatus> listUtilizationStatuses() {
		return this.utilizationStatusService.listUtilizationStatuses();

	}

	/**
	 * To provide UtilizationStatus management view
	 * 
	 * @return UtilizationStatus Type management page
	 */
	@RequestMapping(value = "/utilizationStatus", method = RequestMethod.GET)
	public String goToIndex() {
		return "UtilizationStatusManagement";
	}

	/**
	 * To handle request for adding a new UtilizationStatus Type
	 * 
	 * @param utilizationStatus
	 *            - detail of a new UtilizationStatus
	 * @return redirecting to UtilizationStatus page
	 */
	@RequestMapping(value = "/addUtilizationStatus", method = RequestMethod.POST)
	public String addUtilizationStatus(@RequestBody UtilizationStatus utilizationStatus) {

		this.utilizationStatusService.addUtilizationStatus(utilizationStatus);
		return "redirect:/utilizationStatus";

	}

	/**
	 * To handle request for updating an existing UtilizationStatus Type
	 * 
	 * @param utilizationStatus
	 *            - detail of an existing UtilizationStatus Type
	 * @return UtilizationStatus Type management page
	 */
	@RequestMapping(value = "/updateUtilizationStatus", method = RequestMethod.POST)
	public String editUtilizationStatus(@RequestBody UtilizationStatus utilizationStatus) {
		this.utilizationStatusService.updateUtilizationStatus(utilizationStatus);
		return "redirect:/utilizationStatus";

	}

	/**
	 * To handle request for deleting an existing UtilizationStatus Type 
	 * 
	 * @param id - UtilizationStatus id for an existing UtilizationStatus passed in query
	 *            string
	 * @return UtilizationStatus Type management page
	 */
	@RequestMapping(value = "/deleteUtilizationStatus/{id}", method = RequestMethod.GET)
	public String deleteUtilizationStatus(@PathVariable("id") int id) {
		this.utilizationStatusService.removeUtilizationStatus(id);
		return "redirect:/utilizationStatus";
	}

}

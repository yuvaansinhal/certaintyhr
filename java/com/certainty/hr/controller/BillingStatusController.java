package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.BillingStatus;
import com.certainty.hr.service.BillingStatusService;

/**
 * Controller class to handle HTTP requests for BillingStatus
 *
 */
@Controller
public class BillingStatusController {
	@Autowired
	private BillingStatusService billingStatusService;

	/**
	 * To handle request for BillingStatus list
	 * 
	 * @return the list of all billingStatuses
	 */
	@RequestMapping(value = "/listBillingStatuses", method = RequestMethod.GET)
	public @ResponseBody List<BillingStatus> listBillingStatuses() {
		return this.billingStatusService.listBillingStatuses();
	}

	/**
	 * To provide BillingStatus management view
	 * 
	 * @return BillingStatus management page
	 */
	@RequestMapping(value = "/billingStatus", method = RequestMethod.GET)
	public String goToIndex() {
		return "BillingStatusManagement";
	}

	/**
	 * To handle request for adding a new BillingStatus
	 * 
	 * @param billingStatus
	 *            - detail of a new BillingStatus
	 * @return redirecting to BillingStatus page
	 */
	@RequestMapping(value = "/addBillingStatus", method = RequestMethod.POST)
	public String addBillingStatus(@RequestBody BillingStatus billingStatus) {
		this.billingStatusService.addBillingStatus(billingStatus);
		return "redirect:/billingStatus";
	}

	/**
	 * To handle request for updating an existing BillingStatus
	 * 
	 * @param billingStatus
	 *            - detail of an existing BillingStatus
	 * @return BillingStatus management page
	 */
	@RequestMapping(value = "/updateBillingStatus", method = RequestMethod.POST)
	public String editBillingStatus(@RequestBody BillingStatus billingStatus) {
		this.billingStatusService.updateBillingStatus(billingStatus);
		return "redirect:/billingStatus";
	}

	/**
	 * To handle request for deleting an existing billingStatus
	 * 
	 * @param id
	 *            - billingStatus id for an existing BillingStatus passed in query
	 *            string
	 * @return BillingStatus management page
	 */
	@RequestMapping(value = "/deleteBillingStatus/{id}", method = RequestMethod.GET)
	public String deleteBillingStatus(@PathVariable("id") int id) {
		this.billingStatusService.removeBillingStatus(id);
		return "redirect:/billingStatus";
	}
}

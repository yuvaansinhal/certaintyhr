package com.certainty.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.certainty.hr.model.Location;
import com.certainty.hr.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	private LocationService locationService;

	/**
	 * To handle request for Location list
	 * 
	 * @return the list of all Locations
	 */
	@RequestMapping(value = "/listLocations", method = RequestMethod.GET)
	public @ResponseBody List<Location> listLocations() {
		return this.locationService.listLocations();

	}

	/**
	 * To provide Location management view
	 * 
	 * @return Location management page
	 */
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String goToIndex() {
		return "LocationManagement";
	}

	/**
	 * To handle request for adding a new Location
	 * 
	 * @param location
	 *            - detail of a new Location
	 * @return redirecting to Location management page
	 */
	@RequestMapping(value = "/addLocation", method = RequestMethod.POST)
	public String addLocation(@RequestBody Location location) {

		this.locationService.addLocation(location);
		return "redirect:/location";

	}

	/**
	 * To handle request for updating an existing Location
	 * 
	 * @param location
	 *            - detail of an existing Location
	 * @return Location management page
	 */
	@RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
	public String editLocation(@RequestBody Location location) {
		this.locationService.updateLocation(location);
		return "redirect:/location";

	}

	/**
	 * To handle request for deleting an existing Location
	 * 
	 * @param id
	 *            - Location id for an existing Location passed in query string
	 * @return Location management page
	 */
	@RequestMapping(value = "/deleteLocation/{id}", method = RequestMethod.GET)
	public String deleteLocation(@PathVariable("id") int id) {
		this.locationService.removeLocation(id);
		return "redirect:/location";
	}

}

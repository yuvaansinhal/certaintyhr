package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.LocationDAO;
import com.certainty.hr.model.Location;

/**
 * Service class implementing methods to access Location data using DAO methods
 */

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDAO locationDAO;

	/**
	 * Setting the autowired Location DAO passed from Application Context
	 * 
	 * @param LocationDAO
	 *            the Location Detail DAO to set
	 */
	public void setLocationDAO(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}

	/**
	 * To add a new Location
	 * 
	 * @param Location
	 *            detail of a new Location
	 */
	@Override
	public void addLocation(Location Location) {
		this.locationDAO.addLocation(Location);
	}

	/**
	 * To update an existing Location
	 * 
	 * @param Location
	 *            detail of an existing Location
	 */
	@Override
	public void updateLocation(Location Location) {
		this.locationDAO.updateLocation(Location);
	}

	/**
	 * To get the list of all Location
	 * 
	 * @return list of all the Location
	 */
	@Override
	public List<Location> listLocations() {
		return this.locationDAO.listLocations();
	}

	/**
	 * To get a Location based on Location id
	 * 
	 * @param Location
	 *            id of an existing Location
	 * @return Location of an existing Location
	 */
	@Override
	public Location getLocationByID(int id) {
		return this.locationDAO.getLocationByID(id);
	}

	/**
	 * To delete a Location based on Location id
	 * 
	 * @param id
	 *            of an existing Location
	 */
	@Override
	public void removeLocation(int id) {
		this.locationDAO.removeLocation(id);
	}

}

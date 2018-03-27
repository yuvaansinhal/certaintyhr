package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.Location;

/**
 * Service interface delcaring methods to access Location data
 * 
 *
 */

public interface LocationService {

	public void addLocation(Location Location);

	public void updateLocation(Location Location);

	public List<Location> listLocations();

	public Location getLocationByID(int id);

	public void removeLocation(int id);

}
package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.Location;

/**
 * DAO interface declaring methods to access Location data
 * 
 *
 */
public interface LocationDAO {

	public Location getLocationByID(int id);

	public List<Location> listLocations();

	public void addLocation(Location Location);

	public void removeLocation(int id);

	public void updateLocation(Location Location);
}

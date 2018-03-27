package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.Location;

/**
 * 
 * DAO class implementing methods to access Location data from database
 * 
 */
@Repository
public class LocationDAOImpl implements LocationDAO {

	@Autowired
	private HibernateTemplate template;

	/**
	 * Setting the autowired Hibernate Template passed from Application Context
	 * 
	 * @param template
	 *            - HIbernatem Template
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * To get an Location based on Location id
	 * 
	 * @param id
	 *            - Location id of an existing Location
	 * @return Location based on Location
	 */
	@Override
	public Location getLocationByID(int id) {
		return template.get(Location.class, new Integer(id));
	}

	/**
	 * To list all the Locations
	 * 
	 * @return list of all the Locations
	 */
	@Override
	public List<Location> listLocations() {
		List<Location> orderedLocations = template.loadAll(Location.class);
		Collections.sort(orderedLocations);
		return orderedLocations;
	}

	/**
	 * To add a new Location
	 * 
	 * @param Location
	 *            of a new Location
	 */
	@Override
	public void addLocation(Location Location) {
		template.save(Location);
	}

	/**
	 * To delete a Location based on Location id
	 * 
	 * @param id
	 *            of an existing Location
	 */
	@Override
	public void removeLocation(int id) {
		Location it = (Location) template.get(Location.class, new Integer(id));
		if (null != it) {
			template.delete(it);
		}
	}

	/**
	 * To update an Location for an existing Location
	 * 
	 * @param Location
	 *            of an existing Location
	 */
	@Override
	public void updateLocation(Location Location) {
		template.update(Location);
	}
}

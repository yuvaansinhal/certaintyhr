package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.Technology;

/**
 * DAO interface declaring methods to access Technology data
 * 
 *
 */
public interface TechnologyDAO {
	
	public Technology getTechnologyByID(int id);

	public List<Technology> listTechnologies();

	public void addTechnology(Technology technology);

	public void removeTechnology(int id);

	public void updateTechnology(Technology technology);

}

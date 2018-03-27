package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.Technology;

/**
 * Service interface delcaring methods to access Technology data
 * 
 *
 */

public interface TechnologyService {
	public void addTechnology(Technology technology);

	public void updateTechnology(Technology technology);

	public List<Technology> listTechnologies();

	public Technology getTechnologyByID(int id);

	public void removeTechnology(int id);


}

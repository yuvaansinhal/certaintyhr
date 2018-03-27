package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.SpecializationStream;

/**
 * Service interface delcaring methods to access SpecializationStream data
 * 
 *
 */
public interface SpecializationStreamService {

	public void addSpecializationStream(SpecializationStream specializationStream);

	public void updateSpecializationStream(SpecializationStream specializationStream);

	public List<SpecializationStream> listSpecializationStreams();

	public SpecializationStream getSpecializationStreamByID(int id);

	public void removeSpecializationStream(int id);

}

package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.SpecializationStream;

/**
 * DAO interface declaring methods to access Specialization Stream data
 * 
 *
 */
public interface SpecializationStreamDAO {

	public SpecializationStream getSpecializationStreamByID(int id);

	public List<SpecializationStream> listSpecializationStreams();

	public void addSpecializationStream(SpecializationStream specializationStream);

	public void removeSpecializationStream(int id);

	public void updateSpecializationStream(SpecializationStream specializationStream);
}

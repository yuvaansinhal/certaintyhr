package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.UtilizationStatus;

/**
 * Service interface delcaring methods to access UtilizationStatus data
 * 
 *
 */

public interface UtilizationStatusService {

	public void addUtilizationStatus(UtilizationStatus utilizationStatus);

	public void updateUtilizationStatus(UtilizationStatus utilizationStatus);

	public List<UtilizationStatus> listUtilizationStatuses();

	public UtilizationStatus getUtilizationStatusByID(int id);

	public void removeUtilizationStatus(int id);

}
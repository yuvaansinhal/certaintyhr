package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.UtilizationStatus;

/**
 * 
 * DAO interface declaring methods to access UtilizationStatus Detail data
 * 
 *
 */
public interface UtilizationStatusDAO {

	public UtilizationStatus getUtilizationStatusByID(int id);

	public List<UtilizationStatus> listUtilizationStatuses();

	public void addUtilizationStatus(UtilizationStatus utilizationStatus);

	public void removeUtilizationStatus(int id);

	public void updateUtilizationStatus(UtilizationStatus utilizationStatus);

}

package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.ProjectInvoicing;

/**
 * Service interface delcaring methods to access Project Invoicing data
 * 
 *
 */

public interface ProjectInvoicingService {

	public void addProjectInvoicing(ProjectInvoicing projectInvoicing);

	public void updateProjectInvoicing(ProjectInvoicing projectInvoicing);

	public List<ProjectInvoicing> listProjectInvoicings();

	public ProjectInvoicing getProjectInvoicingByID(int id);

	public void removeProjectInvoicing(int id);

}
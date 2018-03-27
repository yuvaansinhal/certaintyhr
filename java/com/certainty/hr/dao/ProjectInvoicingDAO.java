package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.ProjectInvoicing;

/**
 * DAO interface declaring methods to access Project Invoicing data
 * 
 *
 */
public interface ProjectInvoicingDAO {

	public ProjectInvoicing getProjectInvoicingByID(int id);

	public List<ProjectInvoicing> listProjectInvoicings();

	public void addProjectInvoicing(ProjectInvoicing projectInvoicing);

	public void removeProjectInvoicing(int id);

	public void updateProjectInvoicing(ProjectInvoicing projectInvoicing);

}

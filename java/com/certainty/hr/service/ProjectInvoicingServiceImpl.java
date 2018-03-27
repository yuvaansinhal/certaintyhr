package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.ProjectInvoicingDAO;
import com.certainty.hr.model.ProjectInvoicing;

/**
 * Service class implementing methods to access Project Invoicing data using DAO
 * methods
 * 
 *
 */

@Service
@Transactional
public class ProjectInvoicingServiceImpl implements ProjectInvoicingService {

	@Autowired
	private ProjectInvoicingDAO projectInvoicingDAO;

	/**
	 * Setting the autowired Project Invoicing DAO passed from Application
	 * Context
	 * 
	 * @param projectInvoicingDAO
	 *            the Project Invoicing DAO to set
	 */
	public void setProjectInvoicingDAO(ProjectInvoicingDAO projectInvoicingDAO) {
		this.projectInvoicingDAO = projectInvoicingDAO;
	}

	/**
	 * To add a new Project Invoice
	 * 
	 * @param Project
	 *            Invoice detail of a new Project Invoice
	 */
	@Override
	public void addProjectInvoicing(ProjectInvoicing projectInvoicing) {
		this.projectInvoicingDAO.addProjectInvoicing(projectInvoicing);
	}

	/**
	 * To update an existing Project Invoice
	 * 
	 * @param Project
	 *            Invoice detail of an existing Project Invoice
	 */
	@Override
	public void updateProjectInvoicing(ProjectInvoicing projectInvoicing) {
		this.projectInvoicingDAO.updateProjectInvoicing(projectInvoicing);
	}

	/**
	 * To get the list of all Project Invoices
	 * 
	 * @return list of all the Project Invoices
	 */
	@Override
	public List<ProjectInvoicing> listProjectInvoicings() {
		return this.projectInvoicingDAO.listProjectInvoicings();
	}

	/**
	 * To get a Project Invoice based on Project Invoice id
	 * 
	 * @param Project
	 *            Invoice id of an existing Project Invoice
	 * @return Project Invoice detail of an existing Project Invoice
	 */
	@Override
	public ProjectInvoicing getProjectInvoicingByID(int id) {
		return this.projectInvoicingDAO.getProjectInvoicingByID(id);
	}

	/**
	 * To delete a Project Invoicebased on Project Invoice id
	 * 
	 * @param Project
	 *            Invoice id of an existing Project Invoice
	 */
	@Override
	public void removeProjectInvoicing(int id) {
		this.projectInvoicingDAO.removeProjectInvoicing(id);
	}
}

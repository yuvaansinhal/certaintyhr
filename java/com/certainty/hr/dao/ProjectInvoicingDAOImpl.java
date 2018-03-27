package com.certainty.hr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.ProjectInvoicing;

/**
 * 
 * DAO class implementing methods to access Project Invoicing data from database
 * 
 */
@Repository
public class ProjectInvoicingDAOImpl implements ProjectInvoicingDAO {

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
	 * To get a Project Invoice based on id
	 * 
	 * @param id
	 *            - project invoice id of an existing Project Invoice
	 * @return Project Invoice based on Project Invoice id
	 */
	@Override
	public ProjectInvoicing getProjectInvoicingByID(int id) {
		return template.get(ProjectInvoicing.class, new Integer(id));
	}

	/**
	 * To list all the Project Invoices
	 * 
	 * @return list of all the Project Invoices
	 */
	@Override
	public List<ProjectInvoicing> listProjectInvoicings() {
		return template.loadAll(ProjectInvoicing.class);
	}

	/**
	 * To add a new Project Invoice
	 * 
	 * @param Project
	 *            Invoice detail of a new client
	 */
	@Override
	public void addProjectInvoicing(ProjectInvoicing projectInvoicing) {
		template.save(projectInvoicing);
	}

	/**
	 * To delete a Project Invoice based on client Project Invoice id
	 * 
	 * @param Project
	 *            Invoice id of an existing Project Invoice
	 */
	@Override
	public void removeProjectInvoicing(int id) {
		ProjectInvoicing projectInvoicing = template.get(ProjectInvoicing.class, new Integer(id));
		if (null != projectInvoicing) {
			template.delete(projectInvoicing);
		}
	}

	/**
	 * To update detailfor an existing project invoice
	 * 
	 * @param Project
	 *            Invoice detail of an existing project invoice
	 */
	@Override
	public void updateProjectInvoicing(ProjectInvoicing projectInvoicing) {
		template.update(projectInvoicing);
	}
}

package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.SpecializationStream;

/**
 * 
 * DAO class implementing methods to access SpecializationStream Type data from
 * database
 * 
 */
@Repository
public class SpecializationStreamDAOImpl implements SpecializationStreamDAO {

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
	 * To get an SpecializationStream Type based on SpecializationStream Type id
	 * 
	 * @param id
	 *            - SpecializationStream id of an existing SpecializationStream
	 *            Type
	 * @return SpecializationStream based on SpecializationStream Type
	 */
	@Override
	public SpecializationStream getSpecializationStreamByID(int id) {
		return template.get(SpecializationStream.class, new Integer(id));
	}

	/**
	 * To list all the SpecializationStream Types
	 * 
	 * @return list of all the SpecializationStream Types
	 */
	@Override
	public List<SpecializationStream> listSpecializationStreams() {
		List<SpecializationStream> orderedSpecializationStreams = template.loadAll(SpecializationStream.class);
		Collections.sort(orderedSpecializationStreams);
		return orderedSpecializationStreams;
	}

	/**
	 * To add a new SpecializationStream Type
	 * 
	 * @param SpecializationStream
	 *            of a new SpecializationStream Type
	 */
	@Override
	public void addSpecializationStream(SpecializationStream specializationStream) {
		template.save(specializationStream);
	}

	/**
	 * To delete a SpecializationStream Type based on SpecializationStream Type
	 * id
	 * 
	 * @param id
	 *            of an existing SpecializationStream Type
	 */
	@Override
	public void removeSpecializationStream(int id) {
		SpecializationStream it = (SpecializationStream) template.get(SpecializationStream.class, new Integer(id));
		if (null != it) {
			template.delete(it);
		}
	}

	/**
	 * To update an SpecializationStream Type for an existing
	 * SpecializationStream Type
	 * 
	 * @param SpecializationStream
	 *            of an existing SpecializationStream Type
	 */
	@Override
	public void updateSpecializationStream(SpecializationStream specializationStream) {
		template.update(specializationStream);
	}
}

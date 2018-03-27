package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.GradeDAO;
import com.certainty.hr.model.Grade;

/**
 * Service class implementing methods to access Grade data using DAO methods
 * 
 *
 */
@Service
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDAO gradeDAO;

	/**
	 * Setting the autowired Grade DAO passed from Application Context
	 * 
	 * @param GradeDAO
	 *            the Client Detail DAO to set
	 */

	public void setGradeDAO(GradeDAO gradeDAO) {
		this.gradeDAO = gradeDAO;
	}

	/**
	 * To add a new Grade
	 * 
	 * @param grade
	 *            detail of a new Grade Type
	 */
	@Override
	public void addGrade(Grade grade) {
		this.gradeDAO.addGrade(grade);
	}

	/**
	 * To update an existing Grade
	 * 
	 * @param grade
	 *            detail of an existing Grade
	 */
	@Override
	public void updateGrade(Grade grade) {
		this.gradeDAO.updateGrade(grade);
	}

	/**
	 * To get the list of all Grade
	 * 
	 * @return list of all the Grade
	 */
	@Override
	public List<Grade> listGrades() {
		return this.gradeDAO.listGrades();
	}

	/**
	 * To get a Grade based on Grade id
	 * 
	 * @param grade
	 *            id of an existing Grade
	 * @return Grade of an existing Grade
	 */

	@Override
	public Grade getGradeByID(int id) {
		return this.gradeDAO.getGradeByID(id);
	}

	/**
	 * To delete a Grade based on Grade id
	 * 
	 * @param id
	 *            of an existing Grade
	 */
	@Override
	public void removeGrade(int id) {
		this.gradeDAO.removeGrade(id);
	}

}

package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.UserRoleDAO;
import com.certainty.hr.model.UserRole;

/**
 * Service class implementing methods to access User Role data using DAO methods
 */

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;

	/**
	 * Setting the autowired User Role DAO passed from Application Context
	 * 
	 * @param userRoleDAO
	 *            the User Role DAO to set
	 */
	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	/**
	 * To add a new User Role
	 * 
	 * @param userRole
	 *            detail of a new User Role
	 */
	@Override
	public void addUserRole(UserRole userRole) {
		this.userRoleDAO.addUserRole(userRole);
	}

	/**
	 * To update an existing User Role
	 * 
	 * @param userRole
	 *            detail of an existing User Role
	 */
	@Override
	public void updateUserRole(UserRole userRole) {
		this.userRoleDAO.updateUserRole(userRole);
	}

	/**
	 * To get the list of all User Role
	 * 
	 * @return list of all the User Role
	 */
	@Override
	public List<UserRole> listUserRoles() {
		return this.userRoleDAO.listUserRoles();
	}

	/**
	 * To get a User Role based on User Role id
	 * 
	 * @param id
	 *            id of an existing User Role
	 * @return User Role of an existing User Role
	 */
	@Override
	public UserRole getUserRoleByID(int id) {
		return this.userRoleDAO.getUserRoleByID(id);
	}

	/**
	 * To delete a User Role based on User Role id
	 * 
	 * @param id
	 *            of an existing User Role
	 */
	@Override
	public void removeUserRole(int id) {
		this.userRoleDAO.removeUserRole(id);
	}

}

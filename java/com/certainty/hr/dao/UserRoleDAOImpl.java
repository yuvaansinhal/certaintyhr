package com.certainty.hr.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.UserRole;

/**
 * 
 * DAO class implementing methods to access User Role data from database
 * 
 */
@Repository
public class UserRoleDAOImpl implements UserRoleDAO {
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
	 * To get a User Role based on User Role id
	 * 
	 * @param id
	 *            - User Role id of an existing User Role
	 * @return User Role based on User Role ID
	 */

	@Override
	public UserRole getUserRoleByID(int id) {
		return template.get(UserRole.class, new Integer(id));
	}

	/**
	 * To list all the User Roles
	 * 
	 * @return list of all the User Roles
	 */

	@Override
	public List<UserRole> listUserRoles() {
		List<UserRole> orderedUserRoles = template.loadAll(UserRole.class);
		Collections.sort(orderedUserRoles);
		return orderedUserRoles;
	}

	/**
	 * To add a new User Role
	 * 
	 * @param userRole
	 *            of a new User Role
	 */
	@Override
	public void addUserRole(UserRole userRole) {
		template.save(userRole);
	}

	/**
	 * To delete a User Role based on User Role id
	 * 
	 * @param id
	 *            of an existing User Role
	 */
	@Override
	public void removeUserRole(int id) {
		UserRole ur = (UserRole) template.get(UserRole.class, new Integer(id));
		if (null != ur) {
			template.delete(ur);
		}
	}

	/**
	 * To update a User Role for an existing User Role
	 * 
	 * @param userRole
	 *            of an existing User Role
	 */

	@Override
	public void updateUserRole(UserRole userRole) {
		template.update(userRole);
	}

}

package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.UserRole;

/**
 * DAO interface declaring methods to access User Role data
 * 
 *
 */

public interface UserRoleDAO {

	public UserRole getUserRoleByID(int id);

	public List<UserRole> listUserRoles();

	public void addUserRole(UserRole userRole);

	public void removeUserRole(int id);

	public void updateUserRole(UserRole userRole);

}

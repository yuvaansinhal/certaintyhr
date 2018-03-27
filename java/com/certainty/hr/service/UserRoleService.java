package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.UserRole;

/**
 * Service interface delcaring methods to access User Role data
 * 
 *
 */

public interface UserRoleService {

	public void addUserRole(UserRole userRole);

	public void updateUserRole(UserRole userRole);

	public List<UserRole> listUserRoles();

	public UserRole getUserRoleByID(int id);

	public void removeUserRole(int id);

}
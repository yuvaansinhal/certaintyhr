package com.certainty.hr.dao;

import java.util.List;

import com.certainty.hr.model.UserDetail;

/**
 * DAO interface declaring methods to access User Detail data
 * 
 *
 */
public interface UserDetailDAO {

	public UserDetail getUserDetailByID(int id);

	public UserDetail getUserDetailByUserID(String userId);

	public List<UserDetail> listUserDetails();

	public void addUserDetail(UserDetail userDetail);

	public void removeUserDetail(int id);

	public void updateUserDetail(UserDetail userDetail);

	public boolean isUserActive(UserDetail userDetail);
}

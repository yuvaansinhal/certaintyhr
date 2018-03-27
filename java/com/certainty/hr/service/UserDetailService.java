package com.certainty.hr.service;

import java.util.List;

import com.certainty.hr.model.UserDetail;

/**
 * Service interface delcaring methods to access User Detail data
 * 
 *
 */
public interface UserDetailService {

	public void addUserDetail(UserDetail userDetail);

	public void updateUserDetail(UserDetail userDetail);

	public List<UserDetail> listUserDetails();

	public UserDetail getUserDetailByID(int id);

	public UserDetail getUserDetailByUserID(String userId);

	public void removeUserDetail(int id);
}

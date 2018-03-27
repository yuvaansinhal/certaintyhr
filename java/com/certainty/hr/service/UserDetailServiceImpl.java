package com.certainty.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.UserDetailDAO;
import com.certainty.hr.model.UserDetail;

/**
 * Service class implementing methods to access User detail data using DAO
 * methods
 * 
 *
 */
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	private UserDetailDAO userDetailDAO;

	/**
	 * Setting the autowired User Detail DAO passed from Application Context
	 * 
	 * @param userDetailDAO
	 *            the Emp Detail DAO to set
	 */
	public void setUserDetailDAO(UserDetailDAO userDetailDAO) {
		this.userDetailDAO = userDetailDAO;
	}

	/**
	 * To add a new User detail
	 * 
	 * @param userDetail
	 *            detail of a new User
	 */
	@Override
	public void addUserDetail(UserDetail userDetail) {
		this.userDetailDAO.addUserDetail(userDetail);

	}

	/**
	 * To update an existing User detail
	 * 
	 * @param userDetail
	 *            detail of an existing User
	 */
	@Override
	public void updateUserDetail(UserDetail userDetail) {
		this.userDetailDAO.updateUserDetail(userDetail);

	}

	/**
	 * To get the list of all User details
	 * 
	 * @return list of all the User details
	 */
	@Override
	public List<UserDetail> listUserDetails() {
		return this.userDetailDAO.listUserDetails();
	}

	/**
	 * To get a User detail based on User id
	 * 
	 * @param id
	 *            id of an existing User
	 * @return User detail of an existing User
	 */
	@Override
	public UserDetail getUserDetailByID(int id) {
		return this.userDetailDAO.getUserDetailByID(id);
	}

	/**
	 * To delete a User detail based on User id
	 * 
	 * @param id
	 *            id of an existing User
	 */
	@Override
	public void removeUserDetail(int id) {
		this.userDetailDAO.removeUserDetail(id);

	}

	/**
	 * To find a user based on based on User id
	 * 
	 * @param userId
	 *             of an existing User
	 */
	@Override
	public UserDetail getUserDetailByUserID(String userId) {
		return userDetailDAO.getUserDetailByUserID(userId);
	}
}

package com.certainty.hr.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certainty.hr.dao.UserDetailDAO;

/**
 * Service class implementing methods to access User detail data using DAO
 * methods to provide user details for security
 * 
 *
 */

@Service
@Transactional
public class AppUserDetailsServiceImpl implements UserDetailsService {

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
	 * Retrieve Spring Security User base on model User
	 * 
	 * @param userId
	 *            the user id
	 * @return Spring Security User
	 */
	@Override
	public UserDetails loadUserByUsername(final String userId) throws UsernameNotFoundException {

		com.certainty.hr.model.UserDetail userDetail = userDetailDAO.getUserDetailByUserID(userId);
		List<GrantedAuthority> authorities = buildUserAuthority(userDetail.getUserRole());

		return buildUserForAuthentication(userDetail, authorities);

	}

	/**
	 * Converts model UserDetail to Spring Security User
	 * 
	 * @param userDetail
	 *            a particular user
	 * @param authorities
	 * @return Spring Security User
	 */
	private User buildUserForAuthentication(com.certainty.hr.model.UserDetail userDetail,
			List<GrantedAuthority> authorities) {
		User user = new User(userDetail.getUserId(), userDetail.getPwd(), userDetailDAO.isUserActive(userDetail), true,
				true, true, authorities);
		return user;
	}

	/**
	 * To buld User Authtority for security
	 * 
	 * @param userRoles
	 * @return Granted Authority
	 */
	private List<GrantedAuthority> buildUserAuthority(com.certainty.hr.model.UserRole userRole) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(userRole.getUserRoleName()));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
}

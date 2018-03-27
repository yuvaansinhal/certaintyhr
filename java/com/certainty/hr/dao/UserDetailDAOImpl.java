package com.certainty.hr.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.certainty.hr.model.UserDetail;

/**
 * 
 * DAO class implementing methods to access User detail data from database
 * 
 */
@Repository
public class UserDetailDAOImpl implements UserDetailDAO {
	private final static String ACTIVE = "ACTIVE";
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
	 * To get a User detail based on User id
	 * 
	 * @param id
	 *            - User id of an existing User
	 * @return User detail based on User
	 */
	@Override
	public UserDetail getUserDetailByID(int id) {
		return template.get(UserDetail.class, new Integer(id));
	}

	/**
	 * To list all the User details
	 * 
	 * @return list of all the User details
	 */
	@Override
	public List<UserDetail> listUserDetails() {
		return template.loadAll(UserDetail.class);
	}

	/**
	 * To add a new User detail
	 * 
	 * @param userDetail
	 *            detail of a new User
	 */
	@Override
	public void addUserDetail(UserDetail userDetail) {
		template.save(userDetail);

	}

	/**
	 * To delete a User detail based on User id
	 * 
	 * @param id
	 *            id of an existing User
	 */
	@Override
	public void removeUserDetail(int id) {
		UserDetail ud = (UserDetail) template.get(UserDetail.class, new Integer(id));
		if (null != ud) {
			template.delete(ud);
		}

	}

	/**
	 * To update a User detail for an existing User
	 * 
	 * @param userDetail
	 *            detail of an existing User
	 */
	@Override
	public void updateUserDetail(UserDetail userDetail) {
		template.update(userDetail);

	}

	/**
	 * To find a user based on based on User id
	 * 
	 * @param userId
	 *            of an existing User
	 */
	@Override
	@SuppressWarnings("unchecked")
	public UserDetail getUserDetailByUserID(String userId) {
		// TODO to find out better way to query using hibernate template and
		// remove the warning
		DetachedCriteria criteria = DetachedCriteria.forClass(UserDetail.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<UserDetail> userDetails = (List<UserDetail>) (List) template.findByCriteria(criteria);
		return userDetails.get(0);
	}

	@Override
	public boolean isUserActive(UserDetail userDetail) {
		return userDetail.getUserDetailStatusName().equals(ACTIVE);
	}

}

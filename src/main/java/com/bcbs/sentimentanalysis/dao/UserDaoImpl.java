package com.bcbs.sentimentanalysis.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bcbs.sentimentanalysis.model.User;





@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public void saveUser(User userdetails) {
		 persist(userdetails);
		
	}

	@Override
	 @SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		 Criteria criteria = getSession().createCriteria(User.class);
	        return (List<User>) criteria.list();
	}
	

	@Override
	public void deleteUsersbyEmail(String email) {
		 Query query = getSession().createSQLQuery("delete from userdetails where email = :email");
	        query.setString("email", email);
	        query.executeUpdate();
		
	}

	@Override
	public User findByEmail(String email) {
		 Criteria criteria = getSession().createCriteria(User.class);
	        criteria.add(Restrictions.eq("email",email));
	        return (User) criteria.uniqueResult();
	}

	@Override
	public void updateUser(User userdetails) {
		 getSession().update(userdetails);
		
	}
	
	
}

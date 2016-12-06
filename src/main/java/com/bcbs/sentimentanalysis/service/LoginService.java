package com.bcbs.sentimentanalysis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcbs.sentimentanalysis.dao.UserDao;
import com.bcbs.sentimentanalysis.dao.UserDaoImpl;
import com.bcbs.sentimentanalysis.model.User;



@Service

public class LoginService {
	@Autowired

    private UserDao userDao;
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Transactional
	 public User findByEmail(String email) {
	        return userDao.findByEmail(email);
	        
	    }
	@Transactional
	public void saveRegisteredUser(User userdetails) {
		 userDao.saveUser(userdetails);
	}
}

package com.bcbs.sentimentanalysis.dao;

import java.util.List;

import com.bcbs.sentimentanalysis.model.User;




public interface UserDao {

	void saveUser(User userdetails);
     
    List<User> findAllUsers();
     
    void deleteUsersbyEmail(String ssn);
     
    User findByEmail(String ssn);
     
    void updateUser(User userdetails);
}


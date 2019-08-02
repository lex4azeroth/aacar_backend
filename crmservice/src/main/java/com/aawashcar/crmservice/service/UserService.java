package com.aawashcar.crmservice.service;

import java.util.List;

import com.aawashcar.crmservice.entities.User;
import com.aawashcar.crmservice.model.UserModel;

public interface UserService {
	
	int validateUuid(String uuid);
	
	int validateOpenId(String openId);
	
	User findUser(int userId);
	
	int addUser(String validId, String phoneNumber);
	
	int applyAsWorker(String validId);
	
	boolean addWorker(User user, String validId);
	
	List<User> findAllUser();
	
	String findOpenIdByPhoneNumber(String phoneNumber);
	
	int findUserIdByPhoneNumber(String phoneNumber);
	
	int updateUserPhoneNumber(int userId, String phoneNumber);
	
	int disableUserById(int id);
	
	int updateUser(UserModel userModel);
}

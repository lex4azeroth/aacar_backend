package com.aawashcar.crmservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.crmservice.entities.User;


@Mapper
public interface UserMapper {
	
	int addUser(User user);
		
	int updateUserStatusById(@Param("id") int id, @Param("enabled") boolean enabled);
	
	int updateUserInfo(User user);
	
	int deleteUserById(int id);
	
	int disableUserById(int id);
	
	User findUserByUserId(int id);
	
	User findUserByPhoneNumber(String phoneNumber);
	
	int findUserIdByPhoneNumber(String phoneNumber);
	
	List<User> listUsers();
	
	int addWorker(User user);
	
	int updateWorkerInfo(User user);
	
	String findOpenIdByPhoneNumber(String phoneNumber);
	
	int updateUserPhoneNumber(@Param("userid") int userId, @Param("phonenumber") String phoneNumber);
}

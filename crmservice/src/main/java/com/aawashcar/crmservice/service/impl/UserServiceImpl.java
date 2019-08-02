package com.aawashcar.crmservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.aawashcar.crmservice.entities.RUserUuid;
import com.aawashcar.crmservice.entities.User;
import com.aawashcar.crmservice.mappers.RUserUuidMapper;
import com.aawashcar.crmservice.mappers.UserMapper;
import com.aawashcar.crmservice.model.UserModel;
import com.aawashcar.crmservice.service.UserService;

@Service()
public class UserServiceImpl implements UserService {

	@Autowired
	private RUserUuidMapper rUserUuidMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public int validateUuid(String uuid) {
		if (StringUtils.isEmpty(uuid)) {
			return -1;
		}

		RUserUuid rUserUuid = rUserUuidMapper.findRUserUuidByUuid(uuid);
		return rUserUuid == null ? -1 : rUserUuid.getUserId();
	}

	@Override
	public User findUser(int userId) {
		User user = userMapper.findUserByUserId(userId);
		return user;
	}

	@Override
	@Transactional
	public int addUser(String validId, String phoneNumber) {
//		int userId = validateUuid(uuid);
		int userId = validateOpenId(validId);
		
		if (userId > 0) {
			return userId;
		}
		
		User user = new User();
		user.setPhoneNumber(phoneNumber);
		userMapper.addUser(user);
		RUserUuid rUserUuid = new RUserUuid();
		rUserUuid.setUserId(user.getId());
		rUserUuid.setOpenId(validId);
		rUserUuidMapper.addUserUuidPair(rUserUuid);
		return user.getId();
	}

	@Override
	public int validateOpenId(String openId) {
		if (StringUtils.isEmpty(openId)) {
			return -1;
		}

		RUserUuid rUserUuid = rUserUuidMapper.findRUserUuidByOpenId(openId);
		return rUserUuid == null ? -1 : rUserUuid.getUserId();
	}

	@Transactional
	@Override
	public int applyAsWorker(String validId) {
		if (rUserUuidMapper.checkExists(validId) == null) {
			rUserUuidMapper.applyAsWorker(validId);
			return rUserUuidMapper.findIdByOpenId(validId);
		} else {
			return -1;
		}
	}

	@Override
	public List<User> findAllUser() {
		return userMapper.listUsers();
	}

	@Transactional
	@Override
	public boolean addWorker(User user, String validId) {
//		userMapper.addWorker(user);
//		user = userMapper.findUserByPhoneNumber(user.getPhoneNumber());
//		int result = rUserUuidMapper.approvedAsWorker(validId, user.getId());
//		return result == 1;
		
//		age:0
//		firstName:"bbb"
//		identityId:"3123123123124123"
//		lastName:"aaa"
//		nickName:"aaabbb"
//		phoneNumber:"13636641840"
//		validId:"oRQp75UeakLTO52B619-CCxv9xO0"
		
		User existedUser = userMapper.findUserByPhoneNumber(user.getPhoneNumber());
		if (existedUser == null) {
			// new worker
			userMapper.addWorker(user);
			
		} else {
			// update worker
			userMapper.updateWorkerInfo(user);
		}
		
		user = userMapper.findUserByPhoneNumber(user.getPhoneNumber());
		int result = rUserUuidMapper.approvedAsWorker(validId, user.getId());
		return result == 1;
	}

	@Override
	public String findOpenIdByPhoneNumber(String phoneNumber) {
		return userMapper.findOpenIdByPhoneNumber(phoneNumber);
	}

	@Override
	public int findUserIdByPhoneNumber(String phoneNumber) {
		return userMapper.findUserIdByPhoneNumber(phoneNumber);
	}

	@Override
	public int updateUserPhoneNumber(int userId, String phoneNumber) {
		return userMapper.updateUserPhoneNumber(userId, phoneNumber);
	}

	@Override
	public int disableUserById(int id) {
		return userMapper.disableUserById(id);
	}

	@Override
	public int updateUser(UserModel userModel) {
		User user = new User();
		user.setId(userModel.getId());
		user.setAge(userModel.getAge());
		user.setCityId(userModel.getCityId());
		user.setCountyId(userModel.getCountyId());
		user.setDetailLocation(userModel.getDetailLocation());
		user.setDistrictId(userModel.getDistrictId());
		user.setFirstName(userModel.getFirstName());
		user.setGenderId(userModel.getGenderId());
		user.setLastName(userModel.getLastName());
		user.setNickName(userModel.getNickName());
		user.setPhoneNumber(userModel.getPhoneNumber());
		user.setProvinceId(userModel.getProvinceId());
		user.setResiQuartId(userModel.getResiQuartId());
		return userMapper.updateUserInfo(user);
	}
}

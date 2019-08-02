package com.aawashcar.crmservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.crmservice.entities.User;
import com.aawashcar.crmservice.model.PhoneOpenIdPair;
import com.aawashcar.crmservice.model.UserModel;
import com.aawashcar.crmservice.service.UserService;

@RequestMapping("/")
@ResponseBody
@Controller
public class CrmController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="echo", method=RequestMethod.GET)
	public String echo() {
		return "echo from crm service";
	}
	
	@RequestMapping(value="user/{validid}", method=RequestMethod.GET)
	public User getUser(@PathVariable("validid") String validId) {
		int userId = userService.validateOpenId(validId);
		
		if (userId == -1) {
			return new User();
		}
		
		User user = userService.findUser(userId);
		
		return user;
	}
	
	@RequestMapping(value="user/{validid}/{phoneNumber}", method=RequestMethod.POST)
	public int newUserIfNotExists(@PathVariable("validid") String validId, @PathVariable("phoneNumber") String phoneNumber) {
		return userService.addUser(validId, phoneNumber);
	}
	
	@RequestMapping(value="user/info/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable("id") int userId) {
		return userService.findUser(userId);
	}
	
	@RequestMapping(value="/washer/apply/{validid}", method=RequestMethod.POST)
	public int apply(@PathVariable("validid") String validId) {
		return userService.applyAsWorker(validId);
	}
	
	@RequestMapping(value="/user/listall", method = RequestMethod.GET)
	public List<User> listAllUsers() {
		return userService.findAllUser();
	}
	
	@RequestMapping(value="worker/new/{validid}", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean addWorker(@PathVariable("validid") String validId, @RequestBody User user) {
		return userService.addWorker(user, validId);
	}
	
	@RequestMapping(value="worker/openid/{phonenumber}", method = RequestMethod.GET)
	public PhoneOpenIdPair queryOpenIdByPhoneNumber(@PathVariable("phonenumber") String phoneNumber) {
		String openId =  userService.findOpenIdByPhoneNumber(phoneNumber);
		PhoneOpenIdPair pair = new PhoneOpenIdPair();
		pair.setOpenId(openId);
		pair.setPhoneNumber(phoneNumber);
		return pair;
	}
	
	@RequestMapping(value="userid/{phonenumber}", method=RequestMethod.GET)
	public int getUserId(@PathVariable("phonenumber") String phoneNumber) {
		return userService.findUserIdByPhoneNumber(phoneNumber);
	}
	
	@RequestMapping(value="user/updatephonenumber/{userid}/{phonenumber}", method=RequestMethod.PUT)
	public int updateUserPhoneNumber(@PathVariable("userid") int userId, @PathVariable("phonenumber") String phoneNumber) {
		return userService.updateUserPhoneNumber(userId, phoneNumber);
	}
	
	@RequestMapping(value="user/disable/{userid}", method=RequestMethod.PUT)
	public boolean disableUser(@PathVariable("userid") int userId) {
		return userService.disableUserById(userId) == 1;
	}
	
	@RequestMapping(value="user", method=RequestMethod.PUT)
	public boolean updateUser(@RequestBody UserModel user) {
		return userService.updateUser(user) == 1;
	}
}

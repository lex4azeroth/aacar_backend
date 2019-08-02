package com.aawashcar.zuul.zuul.service;

public interface AuthenticationService {

	boolean checkOpenId(String openId);
	
	int getUserIdByOpenId(String openId);
}

package com.aawashcar.zuul.zuul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aawashcar.zuul.zuul.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${mcw.service.crm.url.prefix}")
	protected String crmUrlPrefix;
	
	@Override
	public boolean checkOpenId(String openId) {
		return getUserIdByOpenIdFromDB(openId) > 0;
	}
	
	private int getUserIdByOpenIdFromDB(String openId) {
		String url = "%s/getUserIdByOpenId/%s";
		url = String.format(url, crmUrlPrefix, openId);
		int userId = restTemplate.getForObject(url, Integer.class);
		
		return userId;
	}

	@Override
	public int getUserIdByOpenId(String openId) {
		return getUserIdByOpenIdFromDB(openId);
	}

}

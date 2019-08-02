package com.aawashcar.opsservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.opsservice.entities.MiniAuthEntity;
import com.aawashcar.opsservice.mappers.MiniProgAuthMapper;
import com.aawashcar.opsservice.service.MiniProgramAuthService;

@Service()
public class MiniProgramAuthServiceImpl implements MiniProgramAuthService {

	@Autowired
	private MiniProgAuthMapper mapper;

	@Override
	public int addMiniProgramAuth(MiniAuthEntity miniAuth) {
		mapper.addMiniProgAuth(miniAuth);
		return miniAuth.getId();
	}

	@Override
	public MiniAuthEntity findMiniAuthByName(String name) {
		return mapper.findMiniAuthByName(name);
	}

	@Override
	public void disableMiniAuthById(int id) {
		mapper.disableMiniAuthById(id);
	}

}

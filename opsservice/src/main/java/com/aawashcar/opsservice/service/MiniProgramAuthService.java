package com.aawashcar.opsservice.service;

import com.aawashcar.opsservice.entities.MiniAuthEntity;

public interface MiniProgramAuthService {
	
	int addMiniProgramAuth(MiniAuthEntity miniAuth);
	
	MiniAuthEntity findMiniAuthByName(String name);
	
	void disableMiniAuthById(int id);

}

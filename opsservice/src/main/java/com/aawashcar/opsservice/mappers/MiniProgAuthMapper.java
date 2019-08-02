package com.aawashcar.opsservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.MiniAuthEntity;

@Mapper()
public interface MiniProgAuthMapper {
	
	int addMiniProgAuth(MiniAuthEntity miniAuth);
	
	MiniAuthEntity findMiniAuthByName(String miniProgName);
	
	void disableMiniAuthById(int id);
}

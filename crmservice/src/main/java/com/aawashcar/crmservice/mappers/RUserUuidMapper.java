package com.aawashcar.crmservice.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.crmservice.entities.RUserUuid;

@Mapper
public interface RUserUuidMapper {
	
	int addUserUuidPair(RUserUuid rUserUuid);
	
	RUserUuid findRUserUuidByUuid(String uuid);
	
	RUserUuid findRUserUuidByOpenId(String openId);
	
	int applyAsWorker(@Param("validid") String validId);
	
	int approvedAsWorker(@Param("validid") String validId, @Param("userid") int userid);
	
	Integer checkExists(@Param("validid") String validId);
	
	int findIdByOpenId(@Param("validid") String validId);
}

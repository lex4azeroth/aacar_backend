package com.aawashcar.omsservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.omsservice.entities.Balance;

@Mapper
public interface BalanceMapper {
	
	int addBalance(Balance balance);
	
	Balance findBalanceByUserId(int userId);
	
	int deleteBalanceByUserId(int userId);
}

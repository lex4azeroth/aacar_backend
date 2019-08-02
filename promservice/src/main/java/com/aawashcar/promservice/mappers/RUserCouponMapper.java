package com.aawashcar.promservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.promservice.entities.RUserCoupon;

@Mapper
public interface RUserCouponMapper {
	
	int addRUserCoupon(RUserCoupon rUserCoupon);
	
	int disableRUserCouponById(@Param("userId") int userId, @Param("couponId") int couponId);
	
	List<RUserCoupon> listRUserCouponsByUserId(int userId);
	
	RUserCoupon findRUserCouponByUserId(int userId);
	
	RUserCoupon findRUserCouponByUserIdAndCouponId(@Param("userId") int userId, @Param("couponId") int couponId);
}

package com.aawashcar.promservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.promservice.entities.Coupon;

@Mapper
public interface CouponMapper {
	
	int addCoupon(Coupon coupon);
	
	void disableCouponById(int id);
	
	List<Coupon> listCoupons();
	
	Coupon findCouponById(int id);
	
	List<Coupon> findMyCouponsByUserId(int userId);
	
	Coupon validateCoupon(@Param("userId") int userId, @Param("couponId") int couponId);
}

package com.aawashcar.promservice.service;

import java.util.List;

import com.aawashcar.promservice.entities.Coupon;

public interface CouponService {
	
	int addCoupon(Coupon coupon);
	
	int addCouponUser(int userId, int couponId);
	
	void disableCouponById(int id);
	
	int consumeCoupon(int userId, int couponId);
	
	List<Coupon> listAllCoupons();
	
	Coupon findCouponById(int id);
	
	List<Coupon> listMyCoupons(int userId);
	
	boolean applyCoupon(int couponId, String phoneNumber);
	
	Coupon validateCoupon(int userId, int couponId);
}

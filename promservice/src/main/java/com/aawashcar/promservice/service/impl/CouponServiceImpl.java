package com.aawashcar.promservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.promservice.entities.Coupon;
import com.aawashcar.promservice.entities.RUserCoupon;
import com.aawashcar.promservice.mappers.CouponMapper;
import com.aawashcar.promservice.mappers.RUserCouponMapper;
import com.aawashcar.promservice.service.CouponService;

@Service()
public class CouponServiceImpl extends BaseService implements CouponService {

	@Autowired
	private CouponMapper couponMapper;
	
	@Autowired
	private RUserCouponMapper rUserCouponMapper;
	
	@Override
	public int addCoupon(Coupon coupon) {
		couponMapper.addCoupon(coupon);
		return coupon.getId();
	}

	@Override
	public void disableCouponById(int id) {
		couponMapper.disableCouponById(id);
	}

	@Override
	public Coupon findCouponById(int id) {
		return couponMapper.findCouponById(id);
	}

	@Override
	public List<Coupon> listAllCoupons() {
		return couponMapper.listCoupons();
	}

	@Override
	public List<Coupon> listMyCoupons(int userId) {
		return couponMapper.findMyCouponsByUserId(userId);
	}

	@Override
	public int addCouponUser(int userId, int couponId) {
		RUserCoupon ruc = new RUserCoupon();
		ruc.setUserId(userId);
		ruc.setEnabled(true);
		ruc.setCouponId(couponId);
		return rUserCouponMapper.addRUserCoupon(ruc);
	}

	@Override
	public boolean applyCoupon(int couponId, String phoneNumber) {
		if (couponMapper.findCouponById(couponId) == null) {
			return false;
		}
		
		String url = crmUrlPrefix + "userid/" + phoneNumber;
		System.out.println(url);
		Integer response = restTemplate.getForObject(url, Integer.class);
		
		if (response == null) {
			return false;
		}
		
		int userId = response.intValue();
		if (rUserCouponMapper.findRUserCouponByUserIdAndCouponId(userId, couponId) != null) {
			return false;
		}
		
		int result = addCouponUser(userId, couponId);
		return result > 0;
	}

	@Override
	public Coupon validateCoupon(int userId, int couponId) {
		return couponMapper.validateCoupon(userId, couponId);
	}

	@Override
	public int consumeCoupon(int userId, int couponId) {
		return rUserCouponMapper.disableRUserCouponById(userId, couponId);
	}
}

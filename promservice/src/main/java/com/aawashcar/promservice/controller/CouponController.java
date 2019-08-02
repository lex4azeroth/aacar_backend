package com.aawashcar.promservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.promservice.entities.Coupon;
import com.aawashcar.promservice.service.CouponService;

@RequestMapping("coupon/")
@Controller
@ResponseBody
public class CouponController {
	@Autowired
	private CouponService couponService;

	@RequestMapping(value = "new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int newCoupon(@RequestBody Coupon coupon) {
		return couponService.addCoupon(coupon);
	}

	@RequestMapping(value = "listall", method = RequestMethod.GET)
	public List<Coupon> listAll() {
		return couponService.listAllCoupons();
	}

	@RequestMapping(value = "mylist/{userid}", method = RequestMethod.GET)
	public List<Coupon> listMyCoupons(@PathVariable("userid") int userId) {
		return couponService.listMyCoupons(userId);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("id") int id) {
		return couponService.findCouponById(id);
	}
	
	@RequestMapping(value="apply/{couponId}/{phoneNumber}", method = RequestMethod.POST)
	public boolean applyCoupon(@PathVariable("couponId") int couponId, @PathVariable("phoneNumber") String phoneNumber) {
		return couponService.applyCoupon(couponId, phoneNumber);
	}
	
	@RequestMapping(value="validatecoupon/{userId}/{couponId}", method = RequestMethod.GET)
	public Coupon validteCoupon(@PathVariable("userId") int userId, @PathVariable("couponId") int couponId) {
		return couponService.validateCoupon(userId, couponId);
	}
	
	@RequestMapping(value="consumeone/{userId}/{couponId}", method = RequestMethod.PUT)
	public int consumeCoupon(@PathVariable("userId") int userId, @PathVariable("couponId") int couponId) {
		return couponService.consumeCoupon(userId, couponId);
	}
	
}

package com.aawashcar.promservice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aawashcar.promservice.entities.Promotion;
import com.aawashcar.promservice.entities.PromotionTransaction;
import com.aawashcar.promservice.entities.PromotionWeixinTransaction;
import com.aawashcar.promservice.entities.PromotionWithServices;
import com.aawashcar.promservice.entities.RUserConsumeService;
import com.aawashcar.promservice.entities.RUserPromotion;
import com.aawashcar.promservice.mappers.PromotionMapper;
import com.aawashcar.promservice.mappers.PromotionTransactionMapper;
import com.aawashcar.promservice.mappers.PromotionWeixinTransactionMapper;
import com.aawashcar.promservice.mappers.RUserConsumeServiceMapper;
import com.aawashcar.promservice.mappers.RUserPromotionMapper;
import com.aawashcar.promservice.service.PromotionService;

@Service()
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private PromotionMapper promotionMapper;
	

	@Autowired
	private RUserPromotionMapper rUserPromotionMapper;
	
	@Autowired
	private RUserConsumeServiceMapper rUserConsumeServiceMapper;
	
	@Autowired
	private PromotionTransactionMapper promotionTransactionMapper;
	
	@Autowired
	private PromotionWeixinTransactionMapper promotionWeixinTransactionMapper;

	@Override
	public int addPromotion(Promotion promotion) {
		promotionMapper.addPromotion(promotion);
		return promotion.getId();
	}

	@Override
	public Promotion findPromotionById(int id) {
		return promotionMapper.findPromotionById(id);
	}

	@Override
	public List<Promotion> listPromotions() {
		return promotionMapper.listPromotions();
	}

	@Override
	public List<PromotionWithServices> listPromotionsWithServices() {
		return promotionMapper.listPromotionsWithServices();
	}
	
	@Override
	public void disablePromotionById(int id) {
		promotionMapper.disablePromotionById(id);
	}

	@Override
	public List<Promotion> listMyPromotions(int userId) {
		return promotionMapper.listMyPromotions(userId);
	}

	@Override
	public Integer validatePromotion(int userId, int serviceId, int promotionId) {
		return promotionMapper.validatePromotion(userId, serviceId, promotionId);
	}

	@Override
	public Integer consumePromotionService(int userId, int serviceId, int promotionId) {
		return promotionMapper.consumePromtionService(userId, serviceId, promotionId);
	}

	@Override
	public List<Promotion> listMyPromotionsByService(int userId, int serviceId) {
		return promotionMapper.listMyPromotionsByService(userId, serviceId);
	}

	@Override
	public PromotionTransaction findPromotionTransactionById(int id) {
		return promotionTransactionMapper.findPromotionTransactionById(id);
	}

	@Override
	public int findPromotionTransactionIdByUserAndPromotionId(int userId, int promotionId, double price) {
		Integer result = promotionTransactionMapper.findPromotionTransactionIdByUserAndPromotionId(userId, promotionId, price);
		return result == null ? 0 : result.intValue();
	}

	@Override
	public int newPromotionTransaction(PromotionTransaction promotionTransaction) {
		promotionTransactionMapper.addPromotionTransaction(promotionTransaction);
		return promotionTransaction.getId();
	}

	@Override
	public int recordRUserPromotion(int userId, int promotionId) {
		RUserPromotion rUserPromotion = new RUserPromotion();
		rUserPromotion.setUserId(userId);
		rUserPromotion.setPromotionId(promotionId);
		return rUserPromotionMapper.addRUserPromotion(rUserPromotion);
	}

	@Transactional
	@Override
	public boolean purchase(int promotionTransactionId, PromotionWeixinTransaction weixinTransaction) {
		System.out.println("Promotion Transaction Id " + promotionTransactionId);
		// find promotion id , user id, from prom_promotion_transaction by
		// promotionTransactionId
		PromotionTransaction promotionTransaction = promotionTransactionMapper.findPromotionTransactionById(promotionTransactionId);
		
		if (promotionTransaction == null) {
			// log error
			return false;
		}
		
		System.out.println("Promotion Transaction found " + promotionTransactionId);
		
		// add new relation between user and promotion in prom_r_user_promotion
		RUserPromotion rUserPromotion = new RUserPromotion();
		rUserPromotion.setUserId(promotionTransaction.getUserId());
		rUserPromotion.setPromotionId(promotionTransaction.getPromotionId());
		rUserPromotionMapper.addRUserPromotion(rUserPromotion);

		// add new relation among user, promotion, service in
		// prom_r_user_consume_service
		int promotionId = promotionTransaction.getPromotionId();
		List<Integer> serviceIds = promotionMapper.findServicesIdByPromotionId(promotionId);
		System.out.println("Service IDs " + serviceIds.toString() + " of promotion id " + promotionId);
		serviceIds.stream().forEach(serviceId -> {
			System.out.println("user id " + promotionTransaction.getUserId() + " promotion id " + promotionId + " service id " + serviceId);
			RUserConsumeService rUserConsumeService = new RUserConsumeService();
			rUserConsumeService.setUserId(promotionTransaction.getUserId());
			rUserConsumeService.setPromotionId(promotionId);
			rUserConsumeService.setServiceId(serviceId);
			rUserConsumeService.setConsumedCount(0);
			rUserConsumeServiceMapper.addRUserConsumeService(rUserConsumeService);
		});
		
		// update prom_promotion_transaction to paied
		promotionTransactionMapper.completePromotionTransaction(promotionTransaction.getPrice(), promotionTransaction.getId());
		
		// record promotion weixin transaction
		weixinTransaction.setPromotionId(promotionTransaction.getPromotionId());
		weixinTransaction.setUserId(promotionTransaction.getUserId());
		promotionWeixinTransactionMapper.addPromotionWeixinTransaction(weixinTransaction);
		
		return true;
	}

	@Override
	public List<Promotion> listNotMyPromotions(int userId) {
		List<Promotion> all = listPromotions();
		List<Promotion> myList = listMyPromotions(userId);
		
		HashMap<Integer, Promotion> promotionMap = new HashMap<>();
		for (Promotion prom : all) {
			promotionMap.put(prom.getId(), prom);
		}
		
		for (Promotion prom : myList) {
			if (promotionMap.containsKey(prom.getId())) {
				promotionMap.remove(prom.getId());
			}
		}
		
		return promotionMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public List<PromotionWithServices> listNotMyPromotionsWithServices(int userId) {
		List<PromotionWithServices> all = listPromotionsWithServices();
		List<PromotionWithServices> myList = listMyPromotionsWithServices(userId);
		
		List<Integer> ids = myList.stream().map(item -> item.getId()).distinct().collect(Collectors.toList());
		List<PromotionWithServices> result = all.stream().filter(item -> isNotMySerivceId(item.getId(), ids)).collect(Collectors.toList());
		
		return result;
	}
	
	private boolean isNotMySerivceId(int id, List<Integer> ids) {
		System.out.println("id:" + id);
		return !ids.contains(id);
	}


	@Override
	public List<PromotionWithServices> listMyPromotionsWithServices(int userId) {
		return promotionMapper.listMyPromotionsWithServices(userId);
	}

	@Override
	public List<PromotionWithServices> listMyPromotionsWithServicesCount(int userId) {
		return promotionMapper.listMyPromotionsWithServicesCount(userId);
	}
}

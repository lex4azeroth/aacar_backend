package com.aawashcar.promservice.service;

import java.util.List;

import com.aawashcar.promservice.entities.Promotion;
import com.aawashcar.promservice.entities.PromotionTransaction;
import com.aawashcar.promservice.entities.PromotionWeixinTransaction;
import com.aawashcar.promservice.entities.PromotionWithServices;

public interface PromotionService {

	int addPromotion(Promotion promotion);
	
	Promotion findPromotionById(int id);
	
	List<Promotion> listPromotions();
	
	List<PromotionWithServices> listPromotionsWithServices();
	
	void disablePromotionById(int id);
	
	List<Promotion> listMyPromotions(int userId);

	List<PromotionWithServices> listMyPromotionsWithServices(int userId);
	
	List<Promotion> listNotMyPromotions(int userId);
	
	List<PromotionWithServices> listNotMyPromotionsWithServices(int userId);
	
	List<PromotionWithServices> listMyPromotionsWithServicesCount(int userId);
	
	List<Promotion> listMyPromotionsByService(int userId, int serviceId);
	
	Integer validatePromotion(int userId, int serviceId, int promotionId);
	
	Integer consumePromotionService(int userId, int serviceId, int promotionId);
	
	PromotionTransaction findPromotionTransactionById(int id);
	
	int findPromotionTransactionIdByUserAndPromotionId(int userId, int promotionId, double price);
	
	int newPromotionTransaction(PromotionTransaction promotionTransaction);
	
	boolean purchase(int promotionTransactionId, PromotionWeixinTransaction weixinTransaction);
	
	int recordRUserPromotion(int userId, int promotionId);
	
}

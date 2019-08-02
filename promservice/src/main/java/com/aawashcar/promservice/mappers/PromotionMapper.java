package com.aawashcar.promservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.promservice.entities.Promotion;
import com.aawashcar.promservice.entities.PromotionWithServices;

@Mapper
public interface PromotionMapper {
	
	int addPromotion(Promotion promotion);
	
	int disablePromotionById(int id);
	
	List<Promotion> listPromotions();
	
	Promotion findPromotionById(int id);
	
	List<Promotion> listMyPromotions(int userId);
	
	List<PromotionWithServices> listMyPromotionsWithServices(int userId);
	
	List<PromotionWithServices> listMyPromotionsWithServicesCount(int userId);
	
	List<Promotion> listMyPromotionsByService(@Param("userId") int userId, @Param("serviceId") int serviceId);
	
	Integer validatePromotion(@Param("userId") int userId, @Param("serviceId") int serviceId, @Param("promotionId") int promotionId);
	
	Integer consumePromtionService(@Param("userId") int userId, @Param("serviceId") int serviceId, @Param("promotionId") int promotionId);

	List<PromotionWithServices> listPromotionsWithServices();
	
	List<Integer> findServicesIdByPromotionId(int id);
}

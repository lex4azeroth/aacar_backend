package com.aawashcar.promservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.promservice.entities.RUserPromotion;

@Mapper
public interface RUserPromotionMapper {
	
	int addRUserPromotion(RUserPromotion rUserPromotion);
	
	int disableRUserPromotionById(int id);
	
	List<RUserPromotion> listRUserPromotionByUserId(int userId);
	
	RUserPromotion findRUserPromotionByUserId(int userId);
}

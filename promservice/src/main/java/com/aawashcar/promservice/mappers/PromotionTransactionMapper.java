package com.aawashcar.promservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aawashcar.promservice.entities.PromotionTransaction;

public interface PromotionTransactionMapper {

	int addPromotionTransaction(PromotionTransaction promotionTransaction);

	List<PromotionTransaction> listPromotionTransactions();

	void disablePromotionTransactionById(int id);

	PromotionTransaction findPromotionTransactionById(int id);

	Integer findPromotionTransactionIdByUserAndPromotionId(@Param("userId") int userId,
			@Param("promotionId") int promotionId, @Param("price") double price);
	
	int completePromotionTransaction(@Param("price") double price, @Param("id") int id);
}

package com.aawashcar.omsservice.mappers;

import java.util.List;

import com.aawashcar.omsservice.entities.PromotionTransaction;

public interface PromotionTransactionMapper {

	int addPromotionTransaction(PromotionTransaction promotionTransaction);

	List<PromotionTransaction> listPromotionTransactions();

	void disablePromotionTransactionById(int id);
}

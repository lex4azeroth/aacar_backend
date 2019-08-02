package com.aawashcar.omsservice.mappers;

import java.util.List;

import com.aawashcar.omsservice.entities.PointTransaction;

public interface PointTransactionMapper {
	
	int addPointTransaction(PointTransaction pointTransaction);
	
	List<PointTransaction> listPointTransactions();

	void disablePointTransactionById(int id);

}

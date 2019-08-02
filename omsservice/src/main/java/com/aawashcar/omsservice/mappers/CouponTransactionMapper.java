package com.aawashcar.omsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.omsservice.entities.CouponTransaction;
import com.aawashcar.omsservice.entities.ServiceTransaction;

@Mapper
public interface CouponTransactionMapper {

	int addCouponTransaction(CouponTransaction couponTransaction);

	List<CouponTransaction> listCouponTransactions();

	int disableCouponTransactionById(int orderId);
}

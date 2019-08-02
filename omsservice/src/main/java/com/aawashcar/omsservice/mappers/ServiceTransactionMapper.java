package com.aawashcar.omsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.omsservice.entities.ServiceTransaction;

@Mapper
public interface ServiceTransactionMapper {

	int addServiceTransaction(ServiceTransaction serviceTransaction);

	List<ServiceTransaction> listServiceTransactions();

	int disableServiceTransactionById(int orderId);
}

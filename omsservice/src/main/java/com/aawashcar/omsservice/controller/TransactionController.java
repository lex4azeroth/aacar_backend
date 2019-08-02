package com.aawashcar.omsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.omsservice.entities.CouponTransaction;
import com.aawashcar.omsservice.entities.OrderTransaction;
import com.aawashcar.omsservice.entities.PointTransaction;
import com.aawashcar.omsservice.entities.PromotionTransaction;
import com.aawashcar.omsservice.entities.ServiceTransaction;
import com.aawashcar.omsservice.service.TransactionService;

@RequestMapping("transaction/")
@Controller
@ResponseBody
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "recordOrderTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int recordOrderTransaction(@RequestBody OrderTransaction orderTransaction) {
		return transactionService.recordOrderTransaction(orderTransaction);
	}

	@RequestMapping(value = "recordPointTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int recordPointTransaction(@RequestBody PointTransaction pointTransaction) {
		return transactionService.recordPointTransaction(pointTransaction);
	}

	@RequestMapping(value = "recordCouponTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int recordCouponTransaction(@RequestBody CouponTransaction couponTransaction) {
		return transactionService.recordCouponTransaction(couponTransaction);
	}

	@RequestMapping(value = "recordServiceTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int recordServiceTransaction(@RequestBody ServiceTransaction serviceTransaction) {
		return transactionService.recordServiceTransaction(serviceTransaction);
	}

	@RequestMapping(value = "recordPromotionTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int recordPromotionTransaction(@RequestBody PromotionTransaction promotionTransaction) {
		return transactionService.recordPromotionTransaction(promotionTransaction);
	}
	
	@RequestMapping(value = "findOrderTransactionId/{orderid}", method = RequestMethod.GET)
	public int findOrderTransactionId(@PathVariable("orderid") int orderId) {
		return transactionService.findOrderTransactionId(orderId);
	}
	
	@RequestMapping(value = "updateOrderTransactionAmount/{id}/{amount}", method = RequestMethod.PUT)
	public int updateOrderTransactionAmount(@PathVariable("id") int id, @PathVariable("amount") double amount) {
		return transactionService.updateOrderTransactionAmount(id, amount);
	}
	
	@RequestMapping(value = "updateOrderTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int updateOrderTransaction(@RequestBody OrderTransaction orderTransaction) {
		return transactionService.updateOrderTransactionByOrderId(orderTransaction);
	}
}

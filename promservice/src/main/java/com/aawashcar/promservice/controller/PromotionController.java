package com.aawashcar.promservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aawashcar.promservice.entities.Promotion;
import com.aawashcar.promservice.entities.PromotionTransaction;
import com.aawashcar.promservice.entities.PromotionWeixinTransaction;
import com.aawashcar.promservice.entities.PromotionWithServices;
import com.aawashcar.promservice.service.PromotionService;

@RequestMapping("promotion/")
@Controller
@ResponseBody
public class PromotionController {

	@Autowired
	private PromotionService promotionService;

	@RequestMapping(value = "new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int newCoupon(@RequestBody Promotion promotion) {
		return promotionService.addPromotion(promotion);
	}

	@RequestMapping(value = "listall", method = RequestMethod.GET)
	public List<Promotion> listAll() {
		return promotionService.listPromotions();
	}
	
	@RequestMapping(value = "listallwtihservices", method = RequestMethod.GET)
	public List<PromotionWithServices> listAllWithServices() {
		return promotionService.listPromotionsWithServices();
	}

	@RequestMapping(value = "mylist/{userid}", method = RequestMethod.GET)
	public List<Promotion> listMyPromotions(@PathVariable("userid") int userId) {
		return promotionService.listMyPromotions(userId);
	}
	
	@RequestMapping(value = "mylistwithservices/{userid}", method = RequestMethod.GET)
	public List<PromotionWithServices> listMyPromotionsWithServices(@PathVariable("userid") int userId) {
		return promotionService.listMyPromotionsWithServices(userId);
	}
	
	@RequestMapping(value = "listmypromotionswithservicescount/{userid}", method = RequestMethod.GET)
	public List<PromotionWithServices> listMyPromotionsWithServicesCount(@PathVariable("userid") int userId) {
		return promotionService.listMyPromotionsWithServicesCount(userId);
	}
	
	@RequestMapping(value = "notmylist/{userid}", method = RequestMethod.GET)
	public List<Promotion> listNotMyPromotions(@PathVariable("userid") int userId) {
		return promotionService.listNotMyPromotions(userId);
	}

	@RequestMapping(value = "notmylistwithservices/{userid}", method = RequestMethod.GET)
	public List<PromotionWithServices> listNotMyPromotionsWithServices(@PathVariable("userid") int userId) {
		return promotionService.listNotMyPromotionsWithServices(userId);
	}
	
	@RequestMapping(value = "mylistbyservice/{userid}/{serviceid}", method = RequestMethod.GET)
	public List<Promotion> listMyPromotionsByService(@PathVariable("userid") int userId, @PathVariable("serviceid") int serviceId) {
		return promotionService.listMyPromotionsByService(userId, serviceId);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Promotion getPromotion(@PathVariable("id") int id) {
		return promotionService.findPromotionById(id);
	}
	
	@RequestMapping(value="validpromotion/{userid}/{serviceid}/{promotionid}", method=RequestMethod.GET)
	public Integer validPromotion(@PathVariable("userid") int userId, @PathVariable("serviceid") int serviceId, @PathVariable("promotionid") int promotionId) {
		return promotionService.validatePromotion(userId, serviceId, promotionId);
	}
	
	@RequestMapping(value="consumepromotionservice/{userid}/{serviceid}/{promotionid}", method=RequestMethod.PUT)
	public Integer consumePromotionService(@PathVariable("userid") int userId, @PathVariable("serviceid") int serviceId, @PathVariable("promotionid") int promotionId) {
		return promotionService.consumePromotionService(userId, serviceId, promotionId);
	}
	
	@RequestMapping(value="promotiontransaction/{promotionid}/{userid}/{price}", method = RequestMethod.GET)
	public int checkPromotionTransaction(@PathVariable("promotionid") int promotionId, @PathVariable("userid") int userId, @PathVariable("price") double price) {
		return promotionService.findPromotionTransactionIdByUserAndPromotionId(userId, promotionId, price);
	}
	
	@RequestMapping(value="promotiontransaction/new", method = RequestMethod.POST)
	public int newPromotionTransaction(@RequestBody PromotionTransaction promotionTransaction) {
		return promotionService.newPromotionTransaction(promotionTransaction);
	}
	
	@RequestMapping(value="/transaction/{id}", method=RequestMethod.GET)
	public PromotionTransaction getPromotionTransaction(@PathVariable("id") int id) {
		return promotionService.findPromotionTransactionById(id);
	}
	
	@RequestMapping(value="purchase/{promotionTransactionId}", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean purchase(@PathVariable("promotionTransactionId") int promotionTransactionId, @RequestBody PromotionWeixinTransaction weixinTransaction) {
		return promotionService.purchase(promotionTransactionId, weixinTransaction);
	}
}

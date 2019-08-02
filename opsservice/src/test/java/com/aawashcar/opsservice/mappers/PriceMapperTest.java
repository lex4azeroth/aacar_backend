package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.Price;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PriceMapperTest {

	@Autowired
	private PriceMapper priceMapper;

	@Test
	public void testAddPrice() {
		int result = priceMapper.addPrice(generatePrice(45d));
		Assert.assertTrue(result == 1);
		
		priceMapper.addPrice(generatePrice(30d));
	}
	
	@Test
	public void testListPrices() {
		List<Price> prices = priceMapper.listPrices();
		
		Assert.assertTrue(prices.size() > 1);
	}
	
	@Test
	public void testUpdatePriceOnly() {
		int id = priceMapper.listPrices().get(0).getId();
		priceMapper.updatePriceOnly(id, 100d);
		Assert.assertTrue(100 == priceMapper.listPrices().get(0).getPrice());
	}
	
	@Test
	public void testUpdatePriceStatus() {
		int id = priceMapper.listPrices().get(0).getId();
		priceMapper.updatePriceStatus(id, false);
		Assert.assertFalse(priceMapper.listPrices().get(0).isEnabled());
	}

	private Price generatePrice(double priceValue) {
		Price price = new Price();
		price.setEnabled(true);
		price.setPrice(priceValue);
		price.setVehicleCategoryId(1);
		price.setVehicleTypeId(2);
		price.setServiceId(1);
		return price;
	}
}

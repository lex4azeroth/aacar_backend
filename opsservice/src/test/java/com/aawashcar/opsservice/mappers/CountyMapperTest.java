package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.County;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountyMapperTest {
	
	@Autowired
	private CountyMapper countyMapper;
	
	@Test
	public void testAddCounty() {
		int result = countyMapper.addCounty(generateCounty());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void testFindCountyById() {
		County county = countyMapper.findCountyById(1);
		Assert.assertTrue(county.getCountyId() == 1);
	}
	
	@Test
	public void testRemoveCountyById() {
		int result = countyMapper.deleteCountyById(1);
		Assert.assertTrue(result == 1);
		County county = countyMapper.findCountyById(1);
		Assert.assertNull(county);
	}
	
	private County generateCounty() {
		County county = new County();
		county.setCountyId(1);
		county.setDescription("Shanghai");
		county.setName("上海");
		county.setProvinceId(1);
		return county;
	}
}

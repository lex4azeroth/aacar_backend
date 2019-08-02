package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.City;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CityMapperTest {

	@Autowired
	private CityMapper cityMapper;

	@Test
	public void testAddCity() {
		int result = cityMapper.addCity(generateCity());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testFindCityById() {
		City city = cityMapper.findCityById(1);
		Assert.assertTrue(city.getCityId() == 1);
	}

	@Test
	public void testRemoveCityById() {
		int result = cityMapper.deleteCityById(1);
		Assert.assertTrue(result == 1);
		City city = cityMapper.findCityById(1);
		Assert.assertNull(city);
	}

	private City generateCity() {
		City city = new City();
		city.setCityId(1);
		city.setCountyId(1);
		city.setDescription("shanghai");
		city.setName("上海");
		city.setProvinceId(1);
		return city;
	}
}

package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.Province;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProvinceMapperTest {

	@Autowired
	private ProvinceMapper provinceMapper;

	@Test
	public void testAddCity() {
		int result = provinceMapper.addProvince(generateProvince());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testFindCityById() {
		Province province = provinceMapper.findProvinceById(1);
		Assert.assertTrue(province.getProvinceId() == 1);
	}

	@Test
	public void testRemoveCityById() {
		int result = provinceMapper.deleteProvinceById(1);
		Assert.assertTrue(result == 1);
		Province province = provinceMapper.findProvinceById(1);
		Assert.assertNull(province);
	}

	private Province generateProvince() {
		Province province = new Province();
		province.setDescription("shanghai");
		province.setName("上海");
		province.setProvinceId(1);
		return province;
	}
}

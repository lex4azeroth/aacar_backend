package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.District;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DistrictMapperTest {

	@Autowired
	private DistrictMapper districtMapper;

	@Test
	public void testAddDistrict() {
		int result = districtMapper.addDistrict(generateDistrict());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testFindDistrictById() {
		District district = districtMapper.findDistrictById(1);
		Assert.assertTrue(district.getCityId() == 1);
	}

	@Test
	public void testRemoveDistrictById() {
		int result = districtMapper.deleteDistrictById(1);
		Assert.assertTrue(result == 1);
		District district = districtMapper.findDistrictById(1);
		Assert.assertNull(district);
	}

	private District generateDistrict() {
		District district = new District();
		district.setCityId(1);
		district.setCountyId(1);
		district.setDistrictId(1);
		district.setDescription("baoshan");
		district.setName("宝山区");
		district.setProvinceId(1);
		return district;
	}
}

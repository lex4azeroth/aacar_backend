package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.ResidentialQuarter;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResidentialQuarterMapperTest {

	@Autowired
	private ResidentialQuarterMapper residentialQuarterMapper;

	@Test
	public void testAddResidentialQuarter() {
		int result = residentialQuarterMapper.addResidentialQuarter(generateResidentialQuarter());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testFindResidentialQuarterById() {
		ResidentialQuarter residentialQuarter = residentialQuarterMapper.findResidentialQuarterById(1);
		Assert.assertTrue(residentialQuarter.getProvinceId() == 1);
	}

	@Test
	public void testRemoveResidentialQuarterById() {
		int result = residentialQuarterMapper.deleteResidentialQuarterById(1);
		Assert.assertTrue(result == 1);
		ResidentialQuarter residentialQuarter = residentialQuarterMapper.findResidentialQuarterById(1);
		Assert.assertNull(residentialQuarter);
	}

	private ResidentialQuarter generateResidentialQuarter() {
		ResidentialQuarter residentialQuarter = new ResidentialQuarter();
		residentialQuarter.setDescription("大华");
		residentialQuarter.setName("大华");
		residentialQuarter.setProvinceId(1);
		residentialQuarter.setCountyId(1);
		residentialQuarter.setCityId(1);
		residentialQuarter.setDistrictId(1);
		residentialQuarter.setResiQuatId(1);
		return residentialQuarter;
	}
}

package com.aawashcar.opsservice.mappers;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.Location;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocationMapperTest {
	
	@Autowired
	private LocationMapper locationMapper;
	
	@Test
	public void testAddLocation() {
		int result = locationMapper.addLocation(generateLocation());
		Assert.assertTrue(result == 1);
	}
	
	private Location generateLocation() {
		Location location = new Location();
		location.setDetailAddress("大华新村1号");
		location.setLatitude(BigDecimal.valueOf(31.279614976933726d));
		location.setLongitude(BigDecimal.valueOf(121.31256018996311d));
		
		return location;
	}

}

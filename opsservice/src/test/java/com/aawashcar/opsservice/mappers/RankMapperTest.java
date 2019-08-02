package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.Rank;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RankMapperTest {
	@Autowired
	private RankMapper rankMapper;
	
	@Test
	public void testAddRank() {
		int result = rankMapper.addRank(generateRank());
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void testModifyAndFindRank() {
		rankMapper.updateRankScore(1, 40);
		Rank rank = rankMapper.findRankById(1);
		Assert.assertTrue(rank.getScore() == 40);
	}
	
	@Test
	public void testRemoveRank() {
		int result = rankMapper.deleteRankById(1);
		Assert.assertTrue(result == 1);
		Rank rank = rankMapper.findRankById(1);
		Assert.assertNull(rank);
	}
	
	private Rank generateRank() {
		Rank rank = new Rank();
		rank.setDescription("test");
		rank.setRankId(1);
		rank.setName("tests");
		rank.setScore(20);
		
		return rank;
	}
}

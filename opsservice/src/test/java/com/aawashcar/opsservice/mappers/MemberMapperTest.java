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

import com.aawashcar.opsservice.entities.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;

	@Test
	public void testAddPrice() {
		int result = memberMapper.addMember(generateMember("老马"));
		Assert.assertTrue(result == 1);
		
		memberMapper.addMember(generateMember("老莫"));
	}
	
	@Test
	public void testListPrices() {
		List<Member> members = memberMapper.listMembers();
		
		Assert.assertTrue(members.size() > 1);
	}
	
	@Test
	public void testUpdatePromotionId() {
		int id = memberMapper.listMembers().get(0).getId();
		memberMapper.updatePromotionId(id, 2);
		Assert.assertTrue(2 == memberMapper.listMembers().get(0).getPromotionId());
	}
	
	@Test
	public void testUpdateMemberStatus() {
		int id = memberMapper.listMembers().get(0).getId();
		memberMapper.updateMemberStatus(id, false);
		Assert.assertFalse(memberMapper.listMembers().get(0).isEnabled());
	}

	private Member generateMember(String name) {
		Member member = new Member();
		member.setDescription("会员1");
		member.setName(name);
		member.setEnabled(true);
		member.setPromotionId(1);
		return member;
	}
}

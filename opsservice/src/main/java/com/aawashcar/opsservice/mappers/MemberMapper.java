package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.Member;

@Mapper
public interface MemberMapper {

	int addMember(Member price);

	int updatePromotionId(@Param("id") int id, @Param("promotionId") int promotionId);

	int updateMemberStatus(@Param("id") int id, @Param("enabled") boolean enabled);

	List<Member> listMembers();
}

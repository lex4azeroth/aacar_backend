package com.aawashcar.opsservice.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aawashcar.opsservice.entities.Rank;

@Mapper
public interface RankMapper {
	
	int addRank(Rank rank);
	
	Rank findRankById(int rankId);
	
	int deleteRankById(int rankId);
	
	void updateRankScore(@Param("rankId") int rankId, @Param("score") int score);
}

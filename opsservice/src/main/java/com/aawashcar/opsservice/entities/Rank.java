package com.aawashcar.opsservice.entities;

public class Rank extends BaseInfoEntity {
	private int rankId;
	private int score;

	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.WorkerLevel;

@Mapper
public interface WorkerLevelMapper {
	
	int addWorkerLevel(WorkerLevel workerLevel);
	
	WorkerLevel findWorkerLevelById(int id);
	
	List<WorkerLevel> listWorkerLevels();
	
	void disableWorkerLevelById(int id);
	
	void enableWorkerLevelById(int id);
}

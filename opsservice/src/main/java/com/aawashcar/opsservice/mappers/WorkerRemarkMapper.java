package com.aawashcar.opsservice.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.WorkerRemark;

@Mapper
public interface WorkerRemarkMapper {
	
	int addWorkerRemark(WorkerRemark workerRemark);
}

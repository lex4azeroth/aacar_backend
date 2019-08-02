package com.aawashcar.opsservice.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.aawashcar.opsservice.entities.WorkerRemark;

@Mapper
public interface RemarksMapper {
	
	int addRemarks(WorkerRemark remark);
	
	WorkerRemark findRemarkById(int id);
	
	void disableRemarkById(int id);
	
	void updateRemark(WorkerRemark remark);
	
	List<WorkerRemark> listRemarks();
	
	List<WorkerRemark> listAcceptRemarks();
	
	List<WorkerRemark> listRejectRemarks();
	
	List<WorkerRemark> listCompleteRemarks();
}

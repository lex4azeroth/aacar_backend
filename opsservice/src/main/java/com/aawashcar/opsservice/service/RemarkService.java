package com.aawashcar.opsservice.service;

import java.util.List;

import com.aawashcar.opsservice.entities.WorkerRemark;

public interface RemarkService {
	
	int addRemark(WorkerRemark remark);
	
	List<WorkerRemark> listRemarks();
	
	List<WorkerRemark> listAcceptRemarks();
	
	List<WorkerRemark> listRejectRemarks();
	
	List<WorkerRemark> listCompleteRemarks();
	
	void disableWorkerRemark(int id);
	
	void updateWorkerRemark(WorkerRemark remark);
	
	WorkerRemark findRemarkById(int id);
}

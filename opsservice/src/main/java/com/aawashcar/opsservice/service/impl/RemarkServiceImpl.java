package com.aawashcar.opsservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aawashcar.opsservice.entities.WorkerRemark;
import com.aawashcar.opsservice.mappers.RemarksMapper;
import com.aawashcar.opsservice.service.RemarkService;

@Service()
public class RemarkServiceImpl implements RemarkService {

	@Autowired
	private RemarksMapper remarksMapper;
	
	@Override
	public int addRemark(WorkerRemark remark) {
		remarksMapper.addRemarks(remark);
		return remark.getId();
	}

	@Override
	public List<WorkerRemark> listRemarks() {
		return remarksMapper.listRemarks();
	}

	@Override
	public void disableWorkerRemark(int id) {
		remarksMapper.disableRemarkById(id);
	}

	@Override
	public void updateWorkerRemark(WorkerRemark remark) {
		remarksMapper.updateRemark(remark);
	}

	@Override
	public WorkerRemark findRemarkById(int id) {
		return remarksMapper.findRemarkById(id);
	}

	@Override
	public List<WorkerRemark> listAcceptRemarks() {
		return remarksMapper.listAcceptRemarks();
	}

	@Override
	public List<WorkerRemark> listRejectRemarks() {
		return remarksMapper.listRejectRemarks();
	}

	@Override
	public List<WorkerRemark> listCompleteRemarks() {
		return remarksMapper.listCompleteRemarks();
	}
}

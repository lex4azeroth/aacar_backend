package com.aawashcar.opsservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.opsservice.entities.Worker;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkerMapperTest {

	@Autowired
	private WorkerMapper workerMapper;

	@Test
	public void testAddWorker() {
		int result = workerMapper.addWorker(generateWorker());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testFindWorkerByIdentityId() {
		Worker worker = workerMapper.findWorkerByIdentityId("abc");
		Assert.assertEquals("raymond", worker.getNickName());
	}

	@Test
	public void testListWorkers() {
		int size = workerMapper.listWorkers().size();
		Assert.assertTrue(size == 1);
	}

	@Test
	public void testRemoveCityById() {
		int result = workerMapper.deleteWorkerByIdentityId("abc");
		Assert.assertTrue(result == 1);
		Worker worker = workerMapper.findWorkerByIdentityId("abc");
		Assert.assertNull(worker);
	}

	private Worker generateWorker() {
		Worker worker = new Worker();
		worker.setFirstName("xuanhao");
		worker.setLastName("ma");
		worker.setIdentityId("abc");
		worker.setLevel("aaa");
		worker.setNickName("raymond");
		worker.setPhoneNumber("13817255172");
		return worker;
	}
}

package com.aawashcar.crmservice.mappers;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aawashcar.crmservice.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testAddUser() {
		int result = userMapper.addUser(generateUser());
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testDisableUserById() {
		int id = userMapper.listUsers().get(0).getId();
		userMapper.updateUserStatusById(id, false);
		Assert.assertFalse(userMapper.listUsers().get(0).isEnabled());
	}

	@Test
	public void testModifyUserInfo() {
		User user = userMapper.listUsers().get(0);
		user.setAge(20);
		userMapper.updateUserInfo(user);
		Assert.assertTrue(20 == userMapper.listUsers().get(0).getAge());
	}
	
	@Test
	public void testFindUserById() {
		int id = userMapper.listUsers().get(0).getId();
		User user = userMapper.findUserByUserId(id);
		Assert.assertTrue(20 == user.getAge());
	}

	@Test
	public void testRemoveUserById() {
		int id = userMapper.listUsers().get(0).getId();
		int result = userMapper.deleteUserById(id);
		Assert.assertTrue(1 == result);
		int size = userMapper.listUsers().size();
		Assert.assertTrue(0 == size);
	}

	private User generateUser() {
		User user = new User();
		user.setAge(1);
		user.setCountyId(1);
		user.setDetailLocation("aaa");
		user.setDistrictId(1);
		user.setGenderId(1);
		user.setNickName("lex");
		user.setPhoneNumber("13817255172");
		user.setEnabled(true);
		return user;
	}
}

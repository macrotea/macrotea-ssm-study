package com.mtea.ssm;

import java.util.Date;
import java.util.Random;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mtea.ssm.dao.UserDao;
import com.mtea.ssm.model.User;

/**
 * UserDao测试类
 * 
 * @author macrotea@qq.com
 * @date 2012-11-30 下午9:25:15
 * @version 1.0
 * @note
 */
public class UserDaoTest extends AbstractTestCase {

	@Autowired
	private UserDao userDao;

	@Test
	public void save() {
		User u = mockUser();
		userDao.save(u);
		Assert.assertTrue(u.getId() != null);
	}

	@Test
	public void findById() {
		User u = mockUser();
		userDao.save(u);
		User result = userDao.findById(u.getId());
		Assert.assertTrue(result.getId().longValue() == u.getId().longValue());
	}

	/**
	 * 模拟用户
	 * @return
	 * @author liangqiye
	 * @date 2012-12-12上午9:16:35
	 */
	private User mockUser() {
		int r = new Random().nextInt(10);
		User u = new User();
		u.setUsername("macrotea-" + r);
		u.setPassword("茶叶" + r);
		u.setEmail("macrotea@qq.com-" +  r);
		u.setAddTime(new Date());
		return u;
	}

}

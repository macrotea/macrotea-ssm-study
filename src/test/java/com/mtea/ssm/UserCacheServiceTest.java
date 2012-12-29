package com.mtea.ssm;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import com.google.code.ssm.api.format.SerializationType;
import com.google.code.ssm.providers.CacheException;
import com.mtea.ssm.dao.UserDao;
import com.mtea.ssm.model.User;
import com.mtea.ssm.service.UserCacheService;
import com.mtea.ssm.util.PrintUtil;

/**
 * @author macrotea@qq.com
 * @date 2012-12-29 上午2:38:18
 * @version 1.0
 * @note
 */
public class UserCacheServiceTest extends AbstractTestCase {
	
	@Autowired
	private UserCacheService userCacheService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	com.google.code.ssm.Cache cache;
	
	@Test
	public void getUserByIdFromCache() throws InterruptedException, TimeoutException, CacheException {
		
		while (true) {
			User u = mockUser();
			userDao.save(u);
			
			//userFirstLoad
			StopWatch watch = new StopWatch();
			watch.start();
			User userFirstLoad = userCacheService.getUserByIdFromCache(u.getId());
			PrintUtil.formatPrint("userFirstLoad: " + userFirstLoad.toString());
			watch.stop();

			long t1 = watch.getTotalTimeMillis();
			PrintUtil.formatPrint("首次从数据库中加载User放入缓存中,而加载时间为: " + t1);
			
			System.out.println();

			//userFromCache
			watch.start();
			User userFromCache = userCacheService.getUserByIdFromCache(u.getId());
			for (int i = 0; i < 10; i++) {
				userCacheService.getUserByIdFromCache(u.getId());
			}
			PrintUtil.formatPrint("userFromCache: " + userFromCache.toString());
			watch.stop();

			long t2 = watch.getTotalTimeMillis();
			PrintUtil.formatPrint("从缓存中加载User且执行10次,而加载时间为: " + t2);
			
			//manualLoadUserFromCache
			User manualLoadUserFromCache = cache.get(u.getId().toString(), SerializationType.PROVIDER);//SerializationType.PROVIDER |　SerializationType.JAVA
			if (manualLoadUserFromCache != null) {
				PrintUtil.formatPrint("manualLoadUser: " + manualLoadUserFromCache.toString());
			}

			// NOTICE lqy/2012-12-29 
			//若在缓存中,则为true,否则说明缓存不起效果
			Assert.assertTrue(t1 > t2);
			
			Thread.sleep(5000);
		}
	
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

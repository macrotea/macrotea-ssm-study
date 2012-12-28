package com.mtea.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.mtea.ssm.dao.UserDao;
import com.mtea.ssm.model.User;
import com.mtea.ssm.service.UserCacheService;

/**
 * @author macrotea@qq.com
 * @date 2012-12-29 上午2:36:19
 * @version 1.0
 * @note
 */
@Service
public class UserCacheServiceImpl implements UserCacheService{
	
	private static final String CACHE_NS_NAME = "UserCache";

	@Autowired
	private UserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.mtea.ssm.service.UserCacheService#getUserByIdFromCache(java.lang.Long)
	 */
	@ReadThroughSingleCache(namespace = CACHE_NS_NAME, expiration = 3600)
	public User getUserByIdFromCache(@ParameterValueKeyProvider Long id) {
		return userDao.findById(id);
	}

}

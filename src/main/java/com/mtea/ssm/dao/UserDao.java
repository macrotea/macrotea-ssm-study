package com.mtea.ssm.dao;

import com.mtea.ssm.model.User;

/**
 * @author macrotea@qq.com
 * @date 2012-12-29 上午2:04:38
 * @version 1.0
 * @note
 */
public interface UserDao {

	/**
	 * 根据Id查找
	 * @author macrotea@qq.com
	 * @date 2012-12-29 上午2:04:47
	 * @param id
	 * @return
	 */
	User findById(long id);
	
	/**
	 * 保存
	 * @author macrotea@qq.com
	 * @date 2012-12-29 上午2:20:12
	 * @param modelInstance
	 * @return
	 */
	User save(User modelInstance);

}

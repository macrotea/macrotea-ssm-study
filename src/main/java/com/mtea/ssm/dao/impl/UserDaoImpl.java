package com.mtea.ssm.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.mtea.ssm.dao.UserDao;
import com.mtea.ssm.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;
	
	private ParameterizedBeanPropertyRowMapper<User> mapper;
	
	private SimpleJdbcInsert insertActor;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.mapper = ParameterizedBeanPropertyRowMapper.newInstance(User.class);
		this.insertActor = new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("tb_user").usingColumns("username","password","email","addTime").usingGeneratedKeyColumns("id");
	}
	
	/* (non-Javadoc)
	 * @see com.mtea.ssm.dao.UserDao#findById(long)
	 */
	public User findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM tb_user WHERE id = ?", new Object[] { id }, mapper);
	}


	/* (non-Javadoc)
	 * @see com.mtea.ssm.dao.UserDao#save(com.mtea.ssm.model.User)
	 */
	public User save(User modelInstance) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(modelInstance);
        Number newId = insertActor.executeAndReturnKey(parameters);
        modelInstance.setId(newId.longValue());
        return modelInstance;
	}

}
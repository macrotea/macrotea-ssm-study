package com.mtea.ssm.model;

import java.io.Serializable;
import java.util.Date;

import com.google.code.ssm.api.CacheKeyMethod;

/**
 * 用户表
 * 
 * @author macrotea@qq.com
 * @date 2012-11-29 下午9:13:13
 * @version 1.0
 * @note
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String password;

	private String email;

	private Date addTime;

	public User() {
		super();
	}

	@CacheKeyMethod
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", addTime=" + addTime + "]";
	}
	
}
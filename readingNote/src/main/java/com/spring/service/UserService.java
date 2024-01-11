package com.spring.service;

import java.sql.SQLException;

import com.spring.dto.UserVO;

public interface UserService {
	
	UserVO detail(String id) throws SQLException;
	void modifyPwd(UserVO member) throws SQLException;
	void modifyName(UserVO member) throws SQLException;
	void modifyEmail(UserVO member) throws SQLException;
	void remove(String id) throws SQLException;
}

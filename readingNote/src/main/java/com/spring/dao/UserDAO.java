package com.spring.dao;

import java.sql.SQLException;

import com.spring.dto.UserVO;

public interface UserDAO {
	
	UserVO selectMemberById(String id) throws SQLException;
	String selectSearchId(String email) throws SQLException;
	String selectSearchPwd(UserVO member) throws SQLException;
	
	void updatePwd(UserVO member) throws SQLException;
	void updateName(UserVO member) throws SQLException;
	void updateEmail(UserVO member) throws SQLException;
	
	void deleteMember(String id) throws SQLException;
}

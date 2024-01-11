package com.spring.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.UserVO;

public class UserDAOImpl implements UserDAO {
	
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public UserVO selectMemberById(String id) throws SQLException {
		return session.selectOne("User-Mapper.selectMemberById", id);
	}
	@Override
	public String selectSearchId(String email) throws SQLException {
		return session.selectOne("User-Mapper.selectSearchId", email);

	}
	@Override
	public String selectSearchPwd(UserVO member) throws SQLException {
		return session.selectOne("User-Mapper.selectSearchPwd", member);
		
	}
	@Override
	public void updatePwd(UserVO member) throws SQLException {
		session.update("User-Mapper.updatePwd", member);
		
	}
	@Override
	public void updateName(UserVO member) throws SQLException {
		session.update("User-Mapper.updateName", member);
		
	}
	@Override
	public void updateEmail(UserVO member) throws SQLException {
		session.update("User-Mapper.updateEmail", member);
		
	}
	@Override
	public void deleteMember(String id) throws SQLException {
		session.update("User-Mapper.deleteMember", id);
		
	}
	
	
}

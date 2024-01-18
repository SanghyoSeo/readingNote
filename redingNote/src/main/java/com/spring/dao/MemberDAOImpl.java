package com.spring.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		return session.selectOne("Member-Mapper.selectMemberById", id);
	}
	@Override
	public String selectSearchId(String email) throws SQLException {
		return session.selectOne("Member-Mapper.selectSearchId", email);

	}
	@Override
	public String selectSearchPwd(MemberVO member) throws SQLException {
		return session.selectOne("Member-Mapper.selectSearchPwd", member);
		
	}
	@Override
	public void updatePwd(MemberVO member) throws SQLException {
		session.update("Member-Mapper.updatePwd", member);
		
	}
	@Override
	public void updateName(MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateName", member);
		
	}
	@Override
	public void updateEmail(MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateEmail", member);
		
	}
	@Override
	public void deleteMember(MemberVO member) throws SQLException {
		session.update("Member-Mapper.deleteMember", member);
		
	}
	
}

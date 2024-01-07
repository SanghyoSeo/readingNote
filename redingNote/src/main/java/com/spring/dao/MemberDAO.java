package com.spring.dao;

import java.sql.SQLException;

import com.spring.dto.MemberVO;

public interface MemberDAO {
	
	MemberVO selectMemberById(String id) throws SQLException;
	String selectSearchId(String email) throws SQLException;
	String selectSearchPwd(MemberVO member) throws SQLException;
	void updatePwd(MemberVO member) throws SQLException;
	void updateName(MemberVO member) throws SQLException;
	void updateEmail(MemberVO member) throws SQLException;
	void deleteMember(MemberVO member) throws SQLException;
}

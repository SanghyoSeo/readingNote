package com.spring.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
@Transactional
public class TestMemberDAOImpl {
	
	@Autowired
	private UserDAO memberDAO;
	
	@Test
	public void testSelectMemberById() throws Exception {
		String testId = "chorus";
		UserVO member = memberDAO.selectMemberById(testId);
		Assert.assertEquals(member.getId(), testId);
	}
	
	@Test
	public void testSelectSearchId() throws Exception {
		String testId = "chorus";
		String testEmail = "chorus@naver.com";
		String getId = memberDAO.selectSearchId(testEmail);
		Assert.assertEquals(getId, testId);
	}
	
	@Test
	public void testSelectSearchPwd() throws Exception {
		UserVO member = new UserVO();
		member.setId("chorus");
		member.setName("양유주");
		member.setEmail("chorus@naver.com");
		member.setPwd("chorus");
		String getPwd = memberDAO.selectSearchPwd(member);
		
		Assert.assertEquals(member.getPwd(), getPwd);
	}
	
	@Test
	@Rollback
	public void testUpdatePwd() throws Exception {
		String testId = "chorus";
		String testPwd = "chorusaaaa";
		UserVO targetMember = memberDAO.selectMemberById(testId);
		
		Assert.assertNotNull(targetMember);
		Assert.assertNotEquals(testPwd, targetMember.getPwd());
		
		targetMember.setPwd(testPwd);
		memberDAO.updatePwd(targetMember);
		
		UserVO getMember = memberDAO.selectMemberById(testId);
		
		Assert.assertEquals(testPwd, getMember.getPwd());
	}
	
	@Test
	@Rollback
	public void testUpdateEmail() throws Exception {
		String testId = "chorus";
		String testEmail = "choruschorus@naver.com";
		UserVO targetMember = memberDAO.selectMemberById(testId);
		
		Assert.assertNotNull(targetMember);
		Assert.assertNotEquals(testEmail, targetMember.getEmail());
		
		targetMember.setEmail(testEmail);
		memberDAO.updateEmail(targetMember);
		
		UserVO getMember = memberDAO.selectMemberById(testId);
		
		Assert.assertEquals(testEmail, getMember.getEmail());
	}
	
	@Test
	@Rollback
	public void testUpdateName() throws Exception {
		String testId = "chorus";
		String testName = "킹양유주";
		UserVO targetMember = memberDAO.selectMemberById(testId);
		
		Assert.assertNotNull(targetMember);
		Assert.assertNotEquals(testName, targetMember.getName());
		
		targetMember.setName(testName);
		memberDAO.updateName(targetMember);
		
		UserVO getMember = memberDAO.selectMemberById(testId);
		
		Assert.assertEquals(testName, getMember.getName());
	}
	
	@Test
	@Rollback
	public void testDeleteMember() throws Exception {
		String testId = "chorus";
		Date today = new Date();
		
//		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
//		String todayStr = format.format(today);
//		java.sql.Date sqlDate = java.sql.Date.valueOf(todayStr);
		
		long milliSeconds = today.getTime();
	    java.sql.Date sqlDate = new java.sql.Date(milliSeconds);
		
		UserVO targetMember = memberDAO.selectMemberById(testId);
		
		System.out.println("탈퇴일 : " + sqlDate);
		System.out.println("get 탈퇴일 : " + targetMember.getQuitDate());
		
		Assert.assertNotNull(targetMember);
		Assert.assertNotEquals(sqlDate, targetMember.getQuitDate());
		
		targetMember.setQuitDate(sqlDate);
//		memberDAO.deleteMember(targetMember);
		
		UserVO getMember = memberDAO.selectMemberById(testId);
		
		System.out.println("get 탈퇴일 : " + getMember.getQuitDate());
		
		Assert.assertEquals(sqlDate, getMember.getQuitDate());
	}
}

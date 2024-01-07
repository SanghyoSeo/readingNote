package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.dto.MemberVO;
import com.spring.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void login() {}
	
	@GetMapping("/commons/main")
	public void main() {}
	
	@GetMapping("/admin/main")
	public void adminMain() {}
	
	@PostMapping("login")
	public String login(String id, String pwd, HttpSession session) throws SQLException {
		String url = "redirect:/commons/main";
		
		MemberVO member = memberService.detail(id);
		
		if (member.getId() != null && id.equals(member.getId())) {
			if (pwd.equals(member.getPwd())) {
				session.setAttribute("loginUser", id);
				session.setMaxInactiveInterval(30*60);
			} else {
				url = "redirect:/login?error=2";
			}
		} else {
			url = "redirect:/login?error=1";
		}
		
		return url;
	}
}
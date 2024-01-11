package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.dto.UserVO;
import com.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService memberService;

	@GetMapping("/login")
	public void login() {
	}

	@GetMapping("/commons/myInfo")
	public void myInfo() {
	}

	@GetMapping("/admin/main")
	public void adminMain() {
	}

	@PostMapping("/login")
	public String login(String id, String pwd, HttpSession session) throws SQLException {
		String url = "redirect:/commons/profile";

		UserVO member = memberService.detail(id);

		if (member != null && id.equals(member.getId())) {
			if (pwd.equals(member.getPwd())) {
				session.setAttribute("loginUser", id);
				session.setMaxInactiveInterval(30 * 60);
			} else {
				url = "redirect:/login?error=2";
			}
		} else {
			url = "redirect:/login?error=1";
		}

		return url;
	}

	@GetMapping("/commons/profile")
	public String profile(String id) {
		String url = "/commons/profile";
		
		return url;
	}

	@GetMapping("/remove")
	public String remove() throws Exception {
		String url = "/commons/remove_success";
		
//		MemberVO member = memberService.detail(id);
//		
//		memberService.remove(member);
//		
		return url;
	}

}

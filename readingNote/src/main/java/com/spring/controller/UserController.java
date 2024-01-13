package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.UserDAO;
import com.spring.dto.UserVO;
import com.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService memberService;
	
	@Autowired
	private UserDAO memberDAO;

	@GetMapping("/commons/login")
	public ModelAndView login(ModelAndView mnv) {
		String url = "/commons/login";
		
		mnv.setViewName(url);
		
		return mnv;
	}

	@GetMapping("/commons/myInfo")
	public void myInfo() {
	}

	@PostMapping("/commons/login")
	public ModelAndView login(String id, String pwd, 
						HttpSession session,
						RedirectAttributes rttr,
						ModelAndView mnv) throws Exception {
		
		String url = "redirect:/commons/profile?id=" + id;

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
		
		if (member.getId().equals("운영자")) {
			url = "redirect:/member/join";
		}

		return null;
	}
	
	@GetMapping("/commons/logout")
	public String logout(HttpSession session) {
		String url = "/logout_success";
		
		session.invalidate();
		
		return url;
	}

	@GetMapping("/commons/profile")
	public String profile(String id, HttpSession session, Model model) throws SQLException {
		String url = "/commons/profile";
		
//		String id = (String) session.getAttribute(id);
		
		
		UserVO member = memberService.detail(id);
		
		
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

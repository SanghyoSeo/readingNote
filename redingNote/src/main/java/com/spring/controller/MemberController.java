package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIdentityException;
import com.spring.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDAO memberDAO;

	@GetMapping("/commons/login")
	public ModelAndView login(ModelAndView mnv) {
		String url = "/commons/login";
		
		mnv.setViewName(url);
		
		return mnv;
	}

	@PostMapping("/commons/login")
	public ModelAndView login(String id, String pwd, 
							  HttpSession session,
							  RedirectAttributes rttr,
							  ModelAndView mnv) throws SQLException {
		
		String url = "redirect:/commons/profile";

		try {
			memberService.login(id, pwd);
			
			MemberVO member = memberDAO.selectMemberById(id);
			session.setAttribute("loginUser", member);
			session.setMaxInactiveInterval(30 * 60);
			
		} catch (NotFoundIdentityException | InvalidPasswordException e) {
			url = "redirect:/commons/login";
			rttr.addFlashAttribute("message", e.getMessage());
		}
		
		mnv.setViewName(url);

		return mnv;
	}
	
	@GetMapping("/commons/logout")
	public ModelAndView logout(String id, HttpSession session, ModelAndView mnv) {
		String url = "redirect:/";
		
		session.invalidate();
		mnv.setViewName(url);
		
		return mnv;
	}

	@GetMapping("/commons/profile")
	public ModelAndView profile(ModelAndView mnv, HttpSession session) {
		String url = "/commons/profile";
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/modifyName")
	public ModelAndView modifyName(String id, String name, ModelAndView mnv, HttpSession session) throws SQLException {
		
		MemberVO member = memberService.detail(id);
		member.setName(name);
		memberService.modifyName(member);
		
		session.setAttribute("loginUser", member);
		
		System.out.println();
		System.out.println(id);
		System.out.println(name);
		System.out.println();
		
		String url = "/commons/success_modify_name";
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/modifyEmail")
	public ModelAndView modifyEmail(String id, String email, ModelAndView mnv, HttpSession session) throws SQLException {
		
		MemberVO member = memberService.detail(id);
		member.setEmail(email);
		memberService.modifyEmail(member);
		
		session.setAttribute("loginUser", member);
		
		System.out.println();
		System.out.println(id);
		System.out.println(email);
		System.out.println();
		
		String url = "/commons/success_modify_email";
		mnv.setViewName(url);
		
		return mnv;
	}

	@GetMapping("/commons/remove")
	public String remove() throws Exception {
		String url = "/commons/remove_success";
		
//		MemberVO member = memberService.detail(id);
//		
//		memberService.remove(member);
//		
		return url;
	}

}

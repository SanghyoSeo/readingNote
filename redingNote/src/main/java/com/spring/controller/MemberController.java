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
	public ModelAndView login(String id, String pwd, HttpSession session,
							  RedirectAttributes rttr, ModelAndView mnv) throws SQLException {
		
		String url = "redirect:/commons/profile";

		try {
			memberService.login(id, pwd);
			
			MemberVO member = memberDAO.selectMemberById(id);
			
			if (member.getAuthority().equals("탈퇴")) {
				url = "redirect:/commons/login";
				System.out.println(url);
			}
			
			session.setAttribute("loginUser", member);
			session.setMaxInactiveInterval(5 * 60 * 60);
			
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

	@GetMapping("/commons/checkPwd")
	public ModelAndView checkPwd(ModelAndView mnv) {
		String url = "/commons/check_pwd";
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/checkPwd")
	public ModelAndView checkPwd(String id, String pwd, ModelAndView mnv, HttpSession session) throws SQLException {
		String url;
		
		MemberVO member = memberService.detail(id);
		
		if (pwd.equals(member.getPwd())) {
			url = "redirect:/commons/modifyPwd";
		} else {
			url = "commons/checkPwd?error=1";
		}
				
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@GetMapping("/commons/modifyPwd")
	public ModelAndView modifyPwd(ModelAndView mnv) {
		String url = "/commons/modify_pwd";
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/modifyPwd")
	public ModelAndView modifyPwd(String id, String pwd, ModelAndView mnv, HttpSession session) throws SQLException {
		String url = "/commons/success_modify_pwd";
		
		MemberVO member = memberService.detail(id);
		member.setPwd(pwd);
		memberService.modifyPwd(member);
		
		session.setAttribute("loginUser", member);
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/modifyName")
	public ModelAndView modifyName(String id, String name, ModelAndView mnv, HttpSession session) throws SQLException {
		
		MemberVO member = memberService.detail(id);
		member.setName(name);
		memberService.modifyName(member);
		
		session.setAttribute("loginUser", member);
		
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
	public ModelAndView remove(HttpSession session, ModelAndView mnv) throws Exception {
		String url = "/commons/remove";
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/remove")
	public ModelAndView remove(String id, String pwd, HttpSession session, ModelAndView mnv) throws Exception {
		String url;
		
		MemberVO member = memberDAO.selectMemberById(id);
		
		
		if (member != null && member.getId().equals(id)) {
			if (member.getPwd().equals(pwd)) {
				System.out.println();
				System.out.println("아이디 : " + member.getId());
				System.out.println("비밀번호 : " + pwd);
				System.out.println();
				url = "/commons/remove_success";
				session.invalidate();
				memberService.remove(member);
			} else {
				url = "redirect:/commons/remove?error=2";
			}
		} else {
			url = "redirect:/commons/remove?error=1";
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@GetMapping("/commons/myReviewList")
	public ModelAndView remove(ModelAndView mnv) throws Exception {
		String url = "/commons/myReviewList";
		
		mnv.setViewName(url);
		
		return mnv;
	}

	@GetMapping("/commons/searchPwd")
	public ModelAndView searchPwd(ModelAndView mnv) {
		String url = "/commons/searchPwd";
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/searchPwd")
	public ModelAndView searchPwd(String id, String name, String email, 
								  ModelAndView mnv, HttpSession session) throws SQLException {
		
		String url = "redirect:/commons/searchPwd?success=1";
		
		MemberVO member = memberDAO.selectMemberById(id);

		
		if (member != null && id.equals(member.getId()) 
				&& name.equals(member.getName()) && email.equals(member.getEmail())) {
			
			String searchPwd = memberDAO.selectSearchPwd(member);
			mnv.addObject("searchPwd", searchPwd);
		} else {
			url = "redirect:/commons/searchPwd?error=1";
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@GetMapping("/commons/searchId")
	public ModelAndView searchId(ModelAndView mnv) {
		String url = "/commons/searchId";
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@PostMapping("/commons/searchId")
	public ModelAndView searchId(String email, ModelAndView mnv, HttpSession session, 
								 RedirectAttributes rttr) throws SQLException {
		
		String url = "redirect:/commons/searchId?success=1";
		String searchEmail = memberDAO.selectSearchId(email);
		
		System.out.println(searchEmail);
		
		if (searchEmail != null) {
			mnv.addObject("searchEmail", searchEmail);
		} else {
			url = "redirect:/commons/searchId?error=1";
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
}

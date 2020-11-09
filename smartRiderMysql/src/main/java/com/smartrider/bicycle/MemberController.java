package com.smartrider.bicycle;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartrider.bicycle.mapper.MemberSQLMapper;
import com.smartrider.bicycle.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	@RequestMapping("/main_page.do")
	public String main() {
		return "main_page";
	}
	
	// 로그인 페이지
	@RequestMapping("/login_page.do")
	public String loginPage() {
		
		return "login_page";
		
	}
	
	// 회원가입 페이지
	@RequestMapping("/join_member_page.do")
	public String joinMemberPage() {
		
		return "join_member_page";
		
	}
	
	@RequestMapping("/join_member_process.do")
	public String joinMemberProcess(MemberVo memberVo) {
		memberSQLMapper.insert(memberVo);
		
		return "redirect:./main_page.do";
	}
	

	
	@RequestMapping("/login_process.do")
	public String loginProcess(MemberVo vo, HttpSession session) {
		
		MemberVo memberVo = memberSQLMapper.selectByIdAndPw(vo);
		
		if (memberVo != null) {
			session.setAttribute("sessionUserData", memberVo);
			return "redirect:./main_page.do";
			
		} else {
			return "login_fail";
		}
	}
	
	@RequestMapping("/logout_process.do")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		return "redirect:./main_page.do";
	}

}

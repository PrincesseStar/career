package com.career.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.career.model.vo.MemberVO;
import com.career.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/member/*", method = RequestMethod.GET)
public class MemberController {
	
	@Inject
	MemberService memberService;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public ModelAndView login(MemberVO memberVO, BindingResult bindingResult) {
		logger.info("view forward");
		ModelAndView forward = new ModelAndView();
		forward.addObject("memberVO", memberVO);
		forward.setViewName("member/login");
		return forward;
	}
	
	/**
	 * 
	 * @param vo
	 * @param session
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "loginChk.do", method = RequestMethod.POST)
	public ModelAndView loginCheck(@Valid MemberVO memberVO, BindingResult bindingResult, HttpSession session, HttpServletRequest request) {
		logger.info("Login Check...");
		
		if(bindingResult.hasErrors()) {		
			logger.info("Vaild Check..."+bindingResult.toString());
			ModelAndView forward = new ModelAndView();
			forward.addObject("memberVo", memberVO);
			forward.setViewName("member/login");
			return forward;
		}

		boolean check = memberService.memberCheck(memberVO, session);
		
		String url = "";
		ModelAndView forward = new ModelAndView();

		if(check) {
			url = "redirect:/content/list.do";
		}else {
			url = "member/login";
			bindingResult.rejectValue("userPw", "notMatch", "아이디 또는 패스워드가 일치하지 않습니다");
		}
		
		forward.setViewName(url);
		return forward;
	}	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "logOut.do", method = RequestMethod.GET)
	public ModelAndView logOut(HttpSession session, HttpServletRequest request) {
		logger.info("LogOut...");
		memberService.memberLogOut(session);
		ModelAndView forward = new ModelAndView();
		MemberVO memberVo = new MemberVO();
		forward.addObject("memberVO", memberVo);
		forward.setViewName("redirect:/content/list.do");
		return forward;
	}
	
}

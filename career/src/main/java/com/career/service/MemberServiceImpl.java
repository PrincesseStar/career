package com.career.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.career.controller.MemberController;
import com.career.model.dao.MemberDAO;
import com.career.model.vo.MemberVO;

/**
 * 
 * @author ChangHyun
 *
 */
@Service
public class MemberServiceImpl implements MemberService{
	
	@Override
	public void memberLogOut(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	}

	@Inject
	MemberDAO memberDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);	
	
	/**
	 * 
	 */
	@Override
	public boolean memberCheck(MemberVO vo, HttpSession session) {
		// TODO Auto-generated method stub
		boolean memberCheck = memberDao.memberCheck(vo);
		
		//로그인정보 Session 셋팅
		if(memberCheck) {
			MemberVO vo1 = memberDao.memberView(vo);
			session.setAttribute("userId", vo1.getUserId());
			session.setAttribute("userName", vo1.getUserName());
		}
		
		return memberCheck;
	}

}

package com.career.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.career.model.vo.MemberVO;

/**
 * 
 * @author ChangHyun
 *
 */
@Repository
public interface MemberService {
	public boolean memberCheck(MemberVO vo, HttpSession session);
	public void memberLogOut(HttpSession session);
}

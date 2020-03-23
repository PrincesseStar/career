package com.career.model.dao;

import com.career.model.vo.MemberVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface MemberDAO {
	public boolean memberCheck(MemberVO vo);
	public MemberVO memberView(MemberVO vo);
}

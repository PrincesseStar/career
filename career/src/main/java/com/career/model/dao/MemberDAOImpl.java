package com.career.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.career.controller.MemberController;
import com.career.model.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);		
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public boolean memberCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		logger.info("MemberDAO Start...");
		
		String name = sqlSession.selectOne("com.career.member.memberCheck", vo);

		return (name != null) ? true:false;
	}

	@Override
	public MemberVO memberView(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.career.member.memberView", vo);
	}

}

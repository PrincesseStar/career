package com.career.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.career.model.vo.CommonVO;

@Repository
public class CommonDAOImpl implements CommonDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<CommonVO> searchCd(String mstCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchCd", mstCode);
	}

}

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
	public List<CommonVO> searchCd(String mstCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchCd", mstCode);
	}
	
	@Override
	public List<CommonVO> searchSkill() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchSkill");
	}

	@Override
	public List<CommonVO> searchFState() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchFState");
	}

	@Override
	public List<CommonVO> searchNState() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchNState");
	}

	@Override
	public List<CommonVO> searchBusiness() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchBusiness");
	}

	@Override
	public List<CommonVO> searchImport() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchImport");
	}

	@Override
	public List<CommonVO> searchLicense() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.career.common.searchLicense");
	}	

}

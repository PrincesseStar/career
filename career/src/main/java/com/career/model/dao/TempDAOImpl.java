package com.career.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.career.controller.MemberController;
import com.career.model.vo.ContentVO;
import com.career.model.vo.TempVO;

/**
 * 
 * @author ChangHyun
 *
 */
@Repository
public class TempDAOImpl implements TempDAO{

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private SqlSession sqlSession;	
	
	@Override
	public List<TempVO> listAll(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		logger.info("ContentDAOImpl Start...");
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyward", keyward);
		return sqlSession.selectList("com.career.temp.list", searchMap);
	}

	@Override
	public void insertTemp(TempVO vo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("temp Insert...");
		sqlSession.insert("com.career.temp.insertTemp", vo);
	}

	@Override
	public TempVO detail(int seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.career.temp.detailTemp", seq);
	}

	@Override
	public void modifyTemp(TempVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("com.career.temp.modifyTemp", vo);
	}
	
}

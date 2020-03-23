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

/**
 * 
 * @author ChangHyun
 *
 */
@Repository
public class ContentDAOImpl implements ContentDAO{

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private SqlSession sqlSession;	
	
	@Override
	public List<ContentVO> listAll(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		logger.info("ContentDAOImpl Start...");
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyward", keyward);
		return sqlSession.selectList("com.career.content.list", searchMap);
	}

	@Override
	public void projectInsert(ContentVO vo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Project Info Insert...");
		sqlSession.insert("com.career.content.projectInsert", vo);
	}

	@Override
	public int selectSeq() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.career.content.selectSeq");
	}		
	
}

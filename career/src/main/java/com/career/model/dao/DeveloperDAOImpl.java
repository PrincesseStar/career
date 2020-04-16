package com.career.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.career.controller.DeveloperController;
import com.career.model.vo.CommonVO;
import com.career.model.vo.DeveloperVO;


/**
 * 
 * @author ChangHyun
 *
 */
@Repository
public class DeveloperDAOImpl implements DeveloperDAO{

	private static final Logger logger = LoggerFactory.getLogger(DeveloperController.class);

	@Inject
	private SqlSession sqlSession;	
	
	@Override
	public List<DeveloperVO> list(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		logger.info("DeveloperList Select...");
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyward", keyward);
		return sqlSession.selectList("com.career.developer.list", searchMap);
	}

}

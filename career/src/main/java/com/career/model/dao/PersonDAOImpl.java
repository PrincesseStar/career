package com.career.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.career.controller.PersonController;
import com.career.model.vo.CommonVO;
import com.career.model.vo.PersonVO;


/**
 * 
 * @author ChangHyun
 *
 */
@Repository
public class PersonDAOImpl implements PersonDAO{

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Inject
	private SqlSession sqlSession;	
	
	@Override
	public List<PersonVO> list(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		logger.info("DeveloperList Select...");
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("searchOption", searchOption);
		searchMap.put("keyward", keyward);
		return sqlSession.selectList("com.career.person.selectlist", searchMap);
	}

	@Override
	public void insertPerson(PersonVO developerVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("com.career.person.insertPerson", developerVO);
	}

	@Override
	public PersonVO detailPersion(int seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.career.person.detailPerson", seq);
	}

	@Override
	public void modifyPerson(PersonVO personVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("com.career.person.modifyPerson", personVO);
	}

	@Override
	public String checkTelno(String telno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.career.person.checkTelno", telno);
	}

}

package com.career.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.career.controller.MemberController;
import com.career.model.vo.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO{

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);	
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ProjectVO> projectList() throws Exception {
		// TODO Auto-generated method stub
		logger.info("ProjectDAO Start...");
		return sqlSession.selectList("com.career.project.projectList");
	}

	@Override
	public ProjectVO projectDetail(int seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.career.project.projectDetail", seq);
	}

}

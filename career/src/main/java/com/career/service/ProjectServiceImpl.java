package com.career.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.career.controller.MemberController;
import com.career.model.dao.ProjectDAO;
import com.career.model.vo.ProjectVO;

/**
 * 
 * @author ChangHyun
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService{

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	ProjectDAO projectDao;
	
	@Override
	public List<ProjectVO> projectList() throws Exception {
		// TODO Auto-generated method stub
		logger.info("ProjectService Start...");
		return projectDao.projectList();
	}

	@Override
	public ProjectVO projectDetail(int seq) throws Exception {
		// TODO Auto-generated method stub
		return projectDao.projectDetail(seq);
	}

}

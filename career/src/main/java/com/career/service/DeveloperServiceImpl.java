package com.career.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.career.controller.MemberController;
import com.career.model.dao.ContentDAO;
import com.career.model.dao.DeveloperDAO;
import com.career.model.vo.CommonVO;
import com.career.model.vo.ContentVO;
import com.career.model.vo.DeveloperVO;


/**
 * 
 * @author ChangHyun
 *
 */
@Service
public class DeveloperServiceImpl implements DeveloperService{

	@Inject
	DeveloperDAO developerDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);		
	
	@Override
	public List<DeveloperVO> list(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		return developerDAO.list(searchOption, keyward);
	}

}

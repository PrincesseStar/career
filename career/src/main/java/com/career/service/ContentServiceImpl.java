package com.career.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.career.controller.MemberController;
import com.career.model.dao.ContentDAO;
import com.career.model.vo.ContentVO;


/**
 * 
 * @author ChangHyun
 *
 */
@Service
public class ContentServiceImpl implements ContentService{

	@Inject
	ContentDAO contentDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);		
	
	@Override
	public List<ContentVO> listAll(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		return contentDao.listAll(searchOption, keyward);
	}

	@Override
	public void projectInsert(ContentVO vo, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.info("SEQ : "+contentDao.selectSeq());
		vo.setSeq(contentDao.selectSeq());
		vo.setRegId((String)session.getAttribute("userName"));
		contentDao.projectInsert(vo);
	}

}

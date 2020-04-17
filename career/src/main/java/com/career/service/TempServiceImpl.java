package com.career.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.career.controller.MemberController;
import com.career.model.dao.ContentDAO;
import com.career.model.dao.TempDAO;
import com.career.model.vo.ContentVO;
import com.career.model.vo.TempVO;


/**
 * 
 * @author ChangHyun
 *
 */
@Service
public class TempServiceImpl implements TempService{

	@Inject
	TempDAO tempDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);		
	
	@Override
	public List<TempVO> listAll(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		return tempDao.listAll(searchOption, keyward);
	}

	@Override
	public void insertTemp(TempVO vo, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		vo.setRegId((String)session.getAttribute("userId"));
		tempDao.insertTemp(vo);
	}

	@Override
	public TempVO detailTemp(int seq) throws Exception {
		// TODO Auto-generated method stub
		return tempDao.detail(seq);
	}

	@Override
	public void modifyTemp(TempVO vo) throws Exception {
		// TODO Auto-generated method stub
		tempDao.modifyTemp(vo);
	}	

}

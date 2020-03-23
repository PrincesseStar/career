package com.career.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.career.controller.MemberController;
import com.career.model.dao.CommonDAO;
import com.career.model.vo.CommonVO;

/**
 * 
 * @author ChangHyun
 *
 */
@Service
public class CommonServiceImpl implements CommonService{

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);	
	
	@Inject
	CommonDAO commonDao;
	
	@Override
	public List<CommonVO> searchCd(String mstCode) {
		// TODO Auto-generated method stub
		logger.info("CommonService Start...");
		return commonDao.searchCd(mstCode);
	}

}

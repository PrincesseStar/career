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
	public List<CommonVO> searchCd(String mstCode) throws Exception {
		// TODO Auto-generated method stub
		logger.info("CommonService Start...");
		return commonDao.searchCd(mstCode);
	}

	@Override
	public List<CommonVO> searchSkill() throws Exception {
		// TODO Auto-generated method stub
		return commonDao.searchSkill();
	}

	@Override
	public List<CommonVO> searchFState() throws Exception {
		// TODO Auto-generated method stub
		return commonDao.searchFState();
	}

	@Override
	public List<CommonVO> searchNState() throws Exception {
		// TODO Auto-generated method stub
		return commonDao.searchNState();
	}

	@Override
	public List<CommonVO> searchBusiness() throws Exception {
		// TODO Auto-generated method stub
		return commonDao.searchBusiness();
	}

	@Override
	public List<CommonVO> searchImport() throws Exception {
		// TODO Auto-generated method stub
		return commonDao.searchImport();
	}

	@Override
	public List<CommonVO> searchLicense() throws Exception {
		// TODO Auto-generated method stub
		return commonDao.searchLicense();
	}

}

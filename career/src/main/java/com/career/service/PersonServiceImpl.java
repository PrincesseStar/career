package com.career.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.career.controller.MemberController;
import com.career.model.dao.ContentDAO;
import com.career.model.dao.PersonDAO;
import com.career.model.vo.CommonVO;
import com.career.model.vo.ContentVO;
import com.career.model.vo.PersonVO;


/**
 * 
 * @author ChangHyun
 *
 */
@Service
public class PersonServiceImpl implements PersonService{

	@Inject
	PersonDAO personDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);		
	
	@Override
	public List<PersonVO> list(String searchOption, String keyward) throws Exception {
		// TODO Auto-generated method stub
		return personDAO.list(searchOption, keyward);
	}

	@Override
	public void insertPerson(PersonVO developerVO) throws Exception {
		// TODO Auto-generated method stub
		personDAO.insertPerson(developerVO);
	}

	@Override
	public PersonVO detailPerson(int seq) throws Exception {
		// TODO Auto-generated method stub
		logger.info(this.getClass().toString());
		return personDAO.detailPersion(seq);
	}

	@Override
	public void modifyPerson(PersonVO personVO) throws Exception {
		// TODO Auto-generated method stub
		personDAO.modifyPerson(personVO);
	}

	@Override
	public String checkTelno(String telno) throws Exception {
		// TODO Auto-generated method stub
		return personDAO.checkTelno(telno);
	}

}

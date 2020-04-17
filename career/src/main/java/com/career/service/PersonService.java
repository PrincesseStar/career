package com.career.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.career.model.vo.CommonVO;
import com.career.model.vo.ContentVO;
import com.career.model.vo.PersonVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface PersonService {
	public List<PersonVO> list(String searchOption, String keyward) throws Exception;
	public void insertPerson(PersonVO personVO) throws Exception;
	public PersonVO detailPerson(int seq) throws Exception;
	public void modifyPerson(PersonVO personVO) throws Exception;
	public String checkTelno(String telno) throws Exception;
} 

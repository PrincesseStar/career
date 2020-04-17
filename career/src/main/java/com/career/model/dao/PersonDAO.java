package com.career.model.dao;

import java.util.List;

import com.career.model.vo.CommonVO;
import com.career.model.vo.ContentVO;
import com.career.model.vo.PersonVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface PersonDAO {
	public List<PersonVO> list(String searchOption, String keyward) throws Exception;
	public void insertPerson(PersonVO personVO) throws Exception;
	public PersonVO detailPersion(int seq) throws Exception;
	public void modifyPerson(PersonVO personVO) throws Exception;
	public String checkTelno(String telno) throws Exception;
}

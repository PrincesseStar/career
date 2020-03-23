package com.career.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.career.model.vo.ContentVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface ContentService {
	public List<ContentVO> listAll(String searchOption, String keyward) throws Exception;
	public void projectInsert(ContentVO vo, HttpSession session) throws Exception;
}

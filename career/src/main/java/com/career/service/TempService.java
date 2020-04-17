package com.career.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.career.model.vo.ContentVO;
import com.career.model.vo.TempVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface TempService {
	public List<TempVO> listAll(String searchOption, String keyward) throws Exception;
	public void insertTemp(TempVO vo, HttpSession session) throws Exception;
	public TempVO detailTemp(int seq) throws Exception;
	public void modifyTemp(TempVO vo) throws Exception;
}

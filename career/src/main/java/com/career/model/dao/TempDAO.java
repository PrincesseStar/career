package com.career.model.dao;

import java.util.List;

import com.career.model.vo.ContentVO;
import com.career.model.vo.TempVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface TempDAO {
	public List<TempVO> listAll(String searchOption, String keyward) throws Exception;
	public void insertTemp(TempVO vo) throws Exception;
}

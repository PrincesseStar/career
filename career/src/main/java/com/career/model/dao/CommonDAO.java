package com.career.model.dao;

import java.util.List;

import com.career.model.vo.CommonVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface CommonDAO {
	public List<CommonVO> searchCd(String mstCode);
}

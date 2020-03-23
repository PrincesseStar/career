package com.career.service;

import java.util.List;

import com.career.model.vo.CommonVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface CommonService {
	public List<CommonVO> searchCd(String mstCode);
}

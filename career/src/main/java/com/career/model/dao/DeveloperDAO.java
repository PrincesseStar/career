package com.career.model.dao;

import java.util.List;

import com.career.model.vo.CommonVO;
import com.career.model.vo.ContentVO;
import com.career.model.vo.DeveloperVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface DeveloperDAO {
	public List<DeveloperVO> list(String searchOption, String keyward) throws Exception;
}

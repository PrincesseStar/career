package com.career.model.dao;

import java.util.List;

import com.career.model.vo.ContentVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface ContentDAO {
	public List<ContentVO> listAll(String searchOption, String keyward) throws Exception;
	public int selectSeq() throws Exception;
	public void projectInsert(ContentVO vo) throws Exception;
}

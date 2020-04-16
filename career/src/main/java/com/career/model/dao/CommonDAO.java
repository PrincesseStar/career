package com.career.model.dao;

import java.util.List;

import com.career.model.vo.CommonVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface CommonDAO {
	public List<CommonVO> searchCd(String mstCode) throws Exception;
	public List<CommonVO> searchSkill() throws Exception;
	public List<CommonVO> searchFState() throws Exception;
	public List<CommonVO> searchNState() throws Exception;
	public List<CommonVO> searchBusiness() throws Exception;
	public List<CommonVO> searchImport() throws Exception;
	public List<CommonVO> searchLicense() throws Exception;
}

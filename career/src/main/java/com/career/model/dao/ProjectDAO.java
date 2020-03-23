package com.career.model.dao;

import java.util.List;

import com.career.model.vo.ProjectVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface ProjectDAO {
	public List<ProjectVO> projectList() throws Exception;
	public ProjectVO projectDetail(int seq) throws Exception;
}

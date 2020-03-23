package com.career.service;

import java.util.List;

import com.career.model.vo.ProjectVO;

/**
 * 
 * @author ChangHyun
 *
 */
public interface ProjectService {
	public List<ProjectVO> projectList() throws Exception;
	public ProjectVO projectDetail(int seq) throws Exception;
}

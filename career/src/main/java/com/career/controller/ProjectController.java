package com.career.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.career.model.vo.ProjectVO;
import com.career.service.CommonService;
import com.career.service.ProjectService;

/**
 * @author ChangHyun
 *
 */
@Controller
@RequestMapping(value = "/project/*", method = RequestMethod.GET)
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
	
	@Inject
	CommonService commonService;	
	@Inject
	ProjectService projectService;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "prjList.do", method = RequestMethod.GET)
	public ModelAndView projectList(Locale locale, Model model) throws Exception {
		logger.info("prjList.do call...", locale);
		/* 데이터조회 */
		//List<CommonVO> searchCd = commonService.searchCd();
		List<ProjectVO> projectList = projectService.projectList();
		/* Return View 셋팅 */
		ModelAndView forward = new ModelAndView();
		forward.setViewName("project/projectList");
		//forward.addObject("searchCd", searchCd);
		forward.addObject("projectList", projectList);
		return forward;
	}
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "prjDtl.do", method = RequestMethod.GET)
	public ModelAndView projectDtl(@RequestParam int seq, HttpSession session, Locale locale, Model model) throws Exception {
		logger.info("prjDtl.do call...", locale);
		logger.info("parameter : " + seq, locale);
		/* 데이터조회 */		
		ProjectVO projectDetail = projectService.projectDetail(seq);
		logger.info("end");
		/* Return View 셋팅 */		
		ModelAndView forward = new ModelAndView();
		forward.setViewName("project/projectDetail");
		forward.addObject("projectDetail", projectDetail);
		return forward;
	}
	
}

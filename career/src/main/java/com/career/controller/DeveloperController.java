package com.career.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.career.model.vo.CommonVO;
import com.career.model.vo.ContentVO;
import com.career.model.vo.DeveloperVO;
import com.career.service.CommonService;
import com.career.service.ContentService;
import com.career.service.DeveloperService;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/developer/*", method = RequestMethod.GET)
public class DeveloperController {
	
	@Inject
	DeveloperService developerService;
	@Inject
	CommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(DeveloperController.class);
	
	/**
	 * 
	 * @param keyward
	 * @param searchOption
	 * @param locale
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	public ModelAndView list(@RequestParam(defaultValue="") String keyward, 
			                      @RequestParam(defaultValue="NAME") String searchOption, Locale locale, Model model) throws Exception {
		logger.info("list.do call...", locale);
		logger.info("keyward : "+keyward);
		logger.info("searchOption : "+searchOption);
		List<DeveloperVO> list = developerService.list(searchOption, keyward);
		List<CommonVO> searchCd = commonService.searchCd("MST01");
		ModelAndView forward = new ModelAndView();
		forward.setViewName("developer/list");
		forward.addObject("keyward", keyward);
		forward.addObject("searchOption", searchOption);
		forward.addObject("list", list);
		forward.addObject("searchCd", searchCd);
		return forward;
	}
	
	/**
	 * 
	 * @param developerVo
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "write.do", method = RequestMethod.POST)
	public ModelAndView write(DeveloperVO developerVo, BindingResult bindingResult) throws Exception{
		//코드성데이터 조회
		List<CommonVO> skill = commonService.searchSkill();
		List<CommonVO> firstStatus = commonService.searchFState();
		List<CommonVO> nowStatus = commonService.searchNState();
		List<CommonVO> businessStatus = commonService.searchBusiness();
		List<CommonVO> importStatus = commonService.searchImport();
		List<CommonVO> licenseStatus = commonService.searchLicense();
		
		ModelAndView forward = new ModelAndView();
		forward.addObject("developer", developerVo);
		forward.addObject("skill", skill);
		forward.addObject("firstStatus", firstStatus);
		forward.addObject("nowStatus", nowStatus);
		forward.addObject("businessStatus", businessStatus);
		forward.addObject("importStatus", importStatus);
		forward.addObject("licenseStatus", licenseStatus);
		forward.setViewName("developer/write");
		return forward;
	}	
	
	/**
	 * 
	 * @param developerVo
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "save.do", method = RequestMethod.POST)	
	public ModelAndView save(DeveloperVO developerVo, HttpSession session) throws Exception{
		logger.debug("License : "+developerVo.getLicense());
		logger.debug("MEMO : "+developerVo.getMemo());
		developerService.insertPerson(developerVo);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/developer/list.do");
		return view;
	}
	
	@RequestMapping(value = "detail.do", method = RequestMethod.POST)
	public ModelAndView detail(@RequestParam int seq, HttpSession session) throws Exception {
		//코드성데이터 조회
		List<CommonVO> skill = commonService.searchSkill();
		List<CommonVO> firstStatus = commonService.searchFState();
		List<CommonVO> nowStatus = commonService.searchNState();
		List<CommonVO> businessStatus = commonService.searchBusiness();
		List<CommonVO> importStatus = commonService.searchImport();
		List<CommonVO> licenseStatus = commonService.searchLicense();		
		logger.info("Seq: "+seq);
		DeveloperVO developerVo = developerService.detailPerson(seq);
		ModelAndView view = new ModelAndView();
		view.addObject("developer", developerVo);
		view.addObject("skill", skill);
		view.addObject("firstStatus", firstStatus);
		view.addObject("nowStatus", nowStatus);
		view.addObject("businessStatus", businessStatus);
		view.addObject("importStatus", importStatus);
		view.addObject("licenseStatus", licenseStatus);		
		view.setViewName("developer/detail");
		return view;
	}	
	
}

package com.career.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
import com.career.model.vo.PersonVO;
import com.career.service.CommonService;
import com.career.service.ContentService;
import com.career.service.PersonService;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/person/*", method = RequestMethod.GET)
public class PersonController {
	
	@Inject
	PersonService personService;
	@Inject
	CommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
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
		List<PersonVO> list = personService.list(searchOption, keyward);
		List<CommonVO> searchCd = commonService.searchCd("MST01");
		ModelAndView forward = new ModelAndView();
		forward.setViewName("person/list");
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
	public ModelAndView write(PersonVO personVo, BindingResult bindingResult) throws Exception{
		//코드성데이터 조회
		List<CommonVO> skill = commonService.searchSkill();
		List<CommonVO> firstStatus = commonService.searchFState();
		List<CommonVO> nowStatus = commonService.searchNState();
		List<CommonVO> businessStatus = commonService.searchBusiness();
		List<CommonVO> importStatus = commonService.searchImport();
		List<CommonVO> licenseStatus = commonService.searchLicense();
		
		ModelAndView forward = new ModelAndView();
		forward.addObject("person", personVo);
		forward.addObject("skill", skill);
		forward.addObject("firstStatus", firstStatus);
		forward.addObject("nowStatus", nowStatus);
		forward.addObject("businessStatus", businessStatus);
		forward.addObject("importStatus", importStatus);
		forward.addObject("licenseStatus", licenseStatus);
		forward.setViewName("person/write");
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
	public ModelAndView save(PersonVO personVo, HttpSession session) throws Exception{
		logger.debug("License : "+personVo.getLicense());
		logger.debug("MEMO : "+personVo.getMemo());
		personService.insertPerson(personVo);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/person/list.do");
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
		PersonVO personVo = personService.detailPerson(seq);
		ModelAndView view = new ModelAndView();
		view.addObject("person", personVo);
		view.addObject("skill", skill);
		view.addObject("firstStatus", firstStatus);
		view.addObject("nowStatus", nowStatus);
		view.addObject("businessStatus", businessStatus);
		view.addObject("importStatus", importStatus);
		view.addObject("licenseStatus", licenseStatus);		
		view.setViewName("person/detail");
		return view;
	}	
	
	/**
	 * 
	 * @param developerVo
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "modify.do", method = RequestMethod.POST)	
	public ModelAndView modify(PersonVO personVo, HttpSession session) throws Exception{
		logger.debug("License : "+personVo.getLicense());
		logger.debug("MEMO : "+personVo.getMemo());
		personService.modifyPerson(personVo);
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/person/list.do");
		return view;
	}	
	
	@RequestMapping(value = "check.do", method = RequestMethod.GET)
	public Map check(HttpServletRequest request) throws Exception{
		String telno = request.getParameter("telno");
		logger.debug("Telno : "+telno);
		String result = personService.checkTelno(telno);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", map);
		return map;
	}
	
}

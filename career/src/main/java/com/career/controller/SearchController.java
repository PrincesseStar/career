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
import com.career.model.vo.PersonVO;
import com.career.service.CommonService;
import com.career.service.ContentService;
import com.career.service.PersonService;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/search/*", method = RequestMethod.GET)
public class SearchController {
	
	@Inject
	PersonService personService;
	@Inject
	CommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
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
		forward.addObject("keyward", keyward);
		forward.addObject("searchOption", searchOption);
		forward.addObject("list", list);
		forward.addObject("searchCd", searchCd);
		forward.setViewName("search/list");
		return forward;
	}

}

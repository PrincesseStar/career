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
import com.career.model.vo.TempVO;
import com.career.service.CommonService;
import com.career.service.ContentService;
import com.career.service.TempService;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/temp/*", method = RequestMethod.GET)
public class TempController {
	
	@Inject
	TempService tempService;
	@Inject
	CommonService commonService;

	private static final Logger logger = LoggerFactory.getLogger(TempController.class);
	
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
	public ModelAndView selectAll(@RequestParam(defaultValue="") String keyward, 
			                      @RequestParam(defaultValue="TITLE") String searchOption, Locale locale, Model model) throws Exception {
		logger.info("list.do call...", locale);
		logger.info("keyward : "+keyward);
		logger.info("searchOption : "+searchOption);
		List<TempVO> list = tempService.listAll(searchOption, keyward);
		logger.info("Size : "+list.size());
		List<CommonVO> searchCd = commonService.searchCd("MST03");
		ModelAndView forward = new ModelAndView();
		forward.setViewName("content/temp");
		forward.addObject("keyward", keyward);
		forward.addObject("searchOption", searchOption);
		forward.addObject("list", list);
		forward.addObject("searchCd", searchCd);
		return forward;
	}
	
	@RequestMapping(value = "write.do", method = RequestMethod.POST)
	public ModelAndView contentWrite(ContentVO contentVo, BindingResult bindingResult) {
		//코드성데이터 조회
		List<CommonVO> searchCd = commonService.searchCd("MST03");
		ModelAndView forward = new ModelAndView();
		forward.addObject("Content", contentVo);
		forward.addObject("language", searchCd);
		forward.setViewName("content/writeTemp");
		return forward;
	}

	@RequestMapping(value = "save.do", method = RequestMethod.POST)
	public ModelAndView contentSave(TempVO tempVo, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("Gubun : "+tempVo.getGubun());
		logger.info("Content : "+tempVo.getContent());
		tempService.insertTemp(tempVo, session);
		ModelAndView forward = new ModelAndView();		
		forward.setViewName("redirect:/temp/list.do");
		return forward;
	}
	
}

package com.career.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.career.controller.ContentController;

/**
 * Request요청 전 Session 값 확인
 * @author ChangHyun
 *
 */
public class SessionInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("SessionInterceptor Call...");
		
		HttpSession session = request.getSession(true);
		logger.info("Session Name : "+session.getAttribute("userName"));
		
		/**
		 * Session 값이 Null일경우 로그인 페이지로 이동
		 */
		if(session.getAttribute("userName") == null) {
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false;
		}
		return true;
		//return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}

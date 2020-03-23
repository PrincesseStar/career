package com.career.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author ChangHyun
 *
 */
@Controller
@RequestMapping(value = "/common/*", method = RequestMethod.GET)
public class CommonController {

}

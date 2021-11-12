package com.hoya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : HomeController
 * date : 2021-11-04
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-04   오후 2:16     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Controller
public class HomeController {

	@RequestMapping("/a")
	public String home() {
		return "index";
	}
}

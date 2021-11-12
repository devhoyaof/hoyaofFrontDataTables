package com.hoya.controller;

import com.hoya.service.AdminService;
import com.hoya.vo.ArticleVO;
import com.hoya.vo.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : HoyaBoardController
 * date : 2021-11-02
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-02   오전 10:44     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Controller
@RequestMapping(value = "/bbs")
public class HoyaBoardController {

	private static final Logger logger = LoggerFactory.getLogger(HoyaBoardController.class);

	@Autowired
	private AdminService adminService;

	@GetMapping(value = "/dataTableList")
	public void dataTables() {
		logger.info("데이터 테이블스()..");
	}

	@PostMapping(value = "/dataTableList.do")
	public @ResponseBody ResponseEntity<Object> dataTable(@ModelAttribute Search search) throws Exception {
		logger.info("/boardList.do() init....");

		return adminService.boardListAll();
	}



	@GetMapping("/list.do")
	public String boardList() {
		logger.info("/List.do() init....");

		return "boardList";
	}


	@GetMapping(value = "/boardList1.do", headers = "Accept=application/json")
	public @ResponseBody ResponseEntity<Object> boardList(@ModelAttribute Search search) throws Exception {
		logger.info("/boardList.do() init....");

		return adminService.boardListAll();
	}

	@GetMapping({"/view", "edit"})
	public void view () {

	}


	@GetMapping(value = "/view.do")
	public @ResponseBody ResponseEntity<Object> detailView(@RequestParam Integer articleNo) throws Exception {
		logger.info("/게시판 상세 데이터 ()");

		return adminService.boardDetail(articleNo);
	}

	@PostMapping(value = "/modify.do")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody Search search) throws Exception {
		logger.info("/게시판 수정 데이터 ()");

		return adminService.boardModify(search);
	}

	@PostMapping(value = "/bnoDelEval.do")
	public @ResponseBody ResponseEntity<Object> delEval(@RequestBody Search del) throws Exception {
		logger.info("/게시판 삭제 데이터 ()");

		return adminService.boardDelEval(del);
	}


	/*@GetMapping(value = "/view.do")
	public @ResponseBody ResponseEntity<Object> detailView(@RequestParam Integer articleNo, Model model) throws Exception {
		logger.info("/게시판 상세 ()");

		model.addAttribute("boardContent", adminService.boardDetail(articleNo);

		return "/bbs/view";
	}*/


	@GetMapping("/write.do")
	public String write() throws Exception {
		logger.info("등록페이지..() init");

		return "write";
	}

	@PostMapping("/save.do")
	public ResponseEntity<Object> save(@RequestBody ArticleVO articleVO) throws Exception {
		logger.info("등록시작..() init");

		return adminService.boardSave(articleVO);
	}


	@PostMapping("/testData")
	public ResponseEntity<Object> testData() throws Exception {

		return adminService.boardTestSave();
	}

}

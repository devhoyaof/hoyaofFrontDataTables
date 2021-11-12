package com.hoya.service;

import com.hoya.vo.ArticleVO;
import com.hoya.vo.Search;
import org.springframework.http.ResponseEntity;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : AdminService
 * date : 2021-11-05
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-05   오후 3:09     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */
public interface AdminService {

	ResponseEntity<Object> boardListAll() throws Exception;

	ResponseEntity<Object> boardSave(ArticleVO articleVO) throws Exception;

	ResponseEntity<Object> boardDetail(Integer articleNo) throws Exception;

	//ResponseEntity<Object> boardModify(Integer articleNo, Search search);

	ResponseEntity<Object> boardModify(Search search) throws Exception;

	ResponseEntity<Object> boardDelEval(Search del) throws Exception;

	Object boardList(Search search) throws Exception;

	ResponseEntity<Object> boardTestSave();
}

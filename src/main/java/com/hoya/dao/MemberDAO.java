package com.hoya.dao;

import com.hoya.vo.ArticleVO;
import com.hoya.vo.Search;

import java.util.List;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberDAO
 * date : 2021-11-04
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-04   오후 1:28     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */
public interface MemberDAO {

	// 현재시간체크
	public String getTime();

	List<Search> boardListAll() throws Exception;

	Integer addProc(ArticleVO articleVO);

	int updateViewCnt(Integer articleNo);

	Search selectView(Integer articleNo);

	int updateBoard(Search search);

	int deleteList(Search del);
}

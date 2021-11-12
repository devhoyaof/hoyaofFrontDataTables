package com.hoya.service.impl;

import com.hoya.dao.MemberDAO;
import com.hoya.service.AdminService;
import com.hoya.vo.ArticleVO;
import com.hoya.vo.Search;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : AdminServiceImpl
 * date : 2021-11-05
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-05   오후 3:09     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public ResponseEntity<Object> boardListAll() throws Exception {
		try {
			List<Search> result = memberDAO.boardListAll();
			//return memberDAO.boardListAll();
			return new ResponseEntity<Object>(result, null, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Object> boardDetail(Integer articleNo) throws Exception {
		try {
			memberDAO.updateViewCnt(articleNo);
			Search result = memberDAO.selectView(articleNo);
			return new ResponseEntity<Object>(result, null, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Object> boardModify(Search search) {

		try {
		 	int result = memberDAO.updateBoard(search);
		 	if (result > 0) {
		 		search.setArticleNo(search.getArticleNo());
		 		return new ResponseEntity<Object>(result, null, HttpStatus.OK);
		    } else {
		 		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		    }
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Object> boardDelEval(Search del) throws Exception {
		int result = 0;

		try {
			if(del.getIds() != null && del.getIds().length > 0) {

				for(int i = 0; i < del.getIds().length; i++) {
					int articleNo = del.getIds()[i];
					if(articleNo > 0) {
						Search search = new Search();
						search.setArticleNo(articleNo);

						result = memberDAO.deleteList(search);
						if(result > 0) {
							return new ResponseEntity<Object>(result,null, HttpStatus.OK);
						} else {
							return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
						}
					}
				}
				if (result > 0) {
					return new ResponseEntity<Object>(null, HttpStatus.OK);
				} else {
					return new ResponseEntity<Object>(null, HttpStatus.NOT_IMPLEMENTED);
				}
			}
			return new ResponseEntity<Object>(null, HttpStatus.NOT_IMPLEMENTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Object boardList(Search search) throws Exception {
		List<Search> result = memberDAO.boardListAll();

		return result;
	}



/*	@Override
	public ResponseEntity<Object> boardModify(Integer articleNo, Search search) {
		return null;
	}*/

	@Override
	public ResponseEntity<Object> boardSave(ArticleVO articleVO) throws Exception {
		try {
			Integer result = memberDAO.addProc(articleVO);
			if(result > 0) {
				return new ResponseEntity<Object>(result, null, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}

		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}


	@Override
	public ResponseEntity<Object> boardTestSave() {
		String title = "제목";
		String content = "내용입니다. 내용입니다. 내용입니다. 내용입니다.";
		String writer = "작성자";
		int viewCnt = 0;

		for (int i = 0; i < 10000; i++) {
			ArticleVO data = new ArticleVO();
			data.setTitle(title + Integer.toString(i));
			data.setContent(content + Integer.toString(i));
			data.setWriter(writer + Integer.toString(i));
			data.setViewCnt(viewCnt);

			Integer result = memberDAO.addProc(data);

			System.err.println(result);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);

	}




}

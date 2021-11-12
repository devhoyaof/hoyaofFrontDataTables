package com.hoya.dao.impl;

import com.hoya.dao.MemberDAO;
import com.hoya.vo.ArticleVO;
import com.hoya.vo.Search;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberDAOIMpl
 * date : 2021-11-04
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-04   오후 1:35     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@Repository
public class MemberDAOImpl implements MemberDAO {

	private static final String NAMESPACE = "com.hoya.mapper.MemberMapper";
	private final SqlSession sqlSession;

	@Inject
	public MemberDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}


	@Override
	public List<Search> boardListAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll2");
	}

	@Override
	public Integer addProc(ArticleVO articleVO) {
		return sqlSession.insert(NAMESPACE + ".create", articleVO);
	}

	@Override
	public int updateViewCnt(Integer articleNo) {
		return sqlSession.update(NAMESPACE + ".updateViewCnt", articleNo);
	}

	@Override
	public Search selectView(Integer articleNo) {
		return sqlSession.selectOne(NAMESPACE + ".selectDetail", articleNo);
	}

	@Override
	public int updateBoard(Search search) {
		return sqlSession.update(NAMESPACE + ".cnupdateBoard", search);
	}

	@Override
	public int deleteList(Search del) {
		return sqlSession.update(NAMESPACE + ".deleteList", del);
	}


}

package test;

import com.hoya.dao.MemberDAO;
import com.hoya.vo.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * @author : hoyao
 * @name : hoyao
 * <PRE>
 * </PRE>
 * @class : MemberDAOTest
 * date : 2021-11-04
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-04   오후 1:38     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO memberDAO;

	// 현재시간 출력 테스트
	@Test
	public void testTime() throws Exception {
		System.out.println(memberDAO.getTime());
	}
}

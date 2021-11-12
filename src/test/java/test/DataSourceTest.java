package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
 * @class : DataSourceTest
 * date : 2021-11-03
 * @History <PRE>
 * NO  Date         time          Author                                      Desc
 * --------------------------------------------------------------------------------------------------------------
 * 1   2021-11-03   오후 6:23     hoyao (hoyaof@lgupluspartners.co.kr)        최초작성
 * </PRE>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class DataSourceTest {

	@Inject
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testFactory() {
		System.out.println(sqlSessionFactory);
	}

	@Test
	public void testSession() throws Exception {
		try(SqlSession session = sqlSessionFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

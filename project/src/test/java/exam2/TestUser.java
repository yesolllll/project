package exam2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import user.UserDAO;
import user.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@WebAppConfiguration
public class TestUser {
	@Autowired
	UserDAO dao;
	

	@Test
	public void count() {
		UserVO vo = new UserVO();
		int cunt = dao.count(vo);
		assertTrue(cunt>0);
	}
	
	@Test
	public void selectAll() { 
		UserVO bv = new UserVO();
		List<UserVO> list = dao.selectAll(bv);
		assertNotNull(list);
	}
}

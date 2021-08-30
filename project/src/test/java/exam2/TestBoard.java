package exam2;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import board.BoardDAO;
import board.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@WebAppConfiguration
public class TestBoard {
	@Autowired
	BoardDAO dao;
	
	@Test
	public void count() {
		BoardVO vo = new BoardVO();
		int cunt = dao.count(vo);
		assertTrue(cunt>0);
	}
	
	@Test
	public void selectAll() { 
		BoardVO bv = new BoardVO();
		List<BoardVO> list = dao.selectAll(bv);
		assertNotNull(list);
	}
}






	

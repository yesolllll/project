package exam;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import board.BoardDAO;
import board.BoardVO;

@ExtendWith(SpringExtension.class) 
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
@WebAppConfiguration
public class TestBoard {
	@Autowired
	BoardDAO dao;
	
	@Test
	void count() {
		BoardVO vo = new BoardVO();
		int cunt = dao.count(vo);
		assertTrue(cunt>0);
	}
	
	@Test
	void selectAllTest() { 
		BoardVO bv = new BoardVO();
		List<BoardVO> list = dao.selectAll(bv);
		assertNotNull(list); 
	}
}

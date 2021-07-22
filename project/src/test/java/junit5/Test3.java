package junit5;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import board.BoardDAO;
import board.BoardVO;
import user.UserVO;

@ExtendWith(SpringExtension.class) //스프링 테스트
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //순서 지정
@WebAppConfiguration
public class Test3 {
	
	@Autowired
	BoardDAO dao;
	
	//가상 MVC 객체
	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext ctx;
	MockHttpSession session;
	
	@BeforeEach //각 테스트가 실행되기전 먼저 실행
	void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		
		//세션
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		UserVO vo = new UserVO();
		vo.setNo(999); //db에 없어도 상관없음. 
		session = new MockHttpSession();
		session.setAttribute("userInfo", vo);
		request.setSession(session);
		
	}
	
	@Order(1) //1번으로 실행
	@Test
	void selectAllTest() { //2페이지 제목만 출력 테스트 
		BoardVO bv = new BoardVO();
		bv.setReqPage(2); 
		List<BoardVO> list = dao.selectAll(bv);
		for(BoardVO vo : list) {
			System.out.println(vo.getTitle());
		}		
	}

	@Order(2) //2번으로 실행 
	@Test
	void detailTest() { //1번 제목만 출력 테스트 
		System.out.println("detail");
		BoardVO bv = new BoardVO();
		bv.setNo(1);
		BoardVO vo = dao.detail(bv);
		System.out.println(vo.getTitle());
		}
	
	// /board/index.do로 접속 테스트
	@Order(3)
	@Test	
	void boardIndex() throws Exception{
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do"); //context-path 넣으면안됨.
		mockMvc.perform(req);
	}
	
	@Order(4)
	@Test	
	void boardIndex2() throws Exception{
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do").param("reqPage","2"); //reqPage=2 
		mockMvc.perform(req);
	}

	@Order(5)
	@Test	
	void mypage() throws Exception{
		RequestBuilder req = MockMvcRequestBuilders.get("/user/mypage.do").session(session); //마이페이지에 세션객체 넣기
		mockMvc.perform(req);
	}

	@Order(6)
	@Test	
	void login(){ //로그인 기능이 정상적으로 실행되는지 테스트 
		RequestBuilder req = MockMvcRequestBuilders.post("/user/login.do").param("id","sol").param("pwd","111");
		try {
			mockMvc.perform(req);
		}catch(Exception e) {
			System.out.println(1);
		}
	}	
	
}
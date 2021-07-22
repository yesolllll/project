package junit4;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
//junit4 에서 RunWith
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/context-servlet.xml"})
@WebAppConfiguration
public class Test3 {
	
	@Autowired
	BoardDAO dao;
	
	//가상 MVC 객체
	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext ctx;
	MockHttpSession session;
	
	@Before //각 테스트가 실행되기전 먼저 실행
	public void init() {
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
	
	@Test
	public void selectAllTest() { //2페이지 제목만 출력 테스트 
		BoardVO bv = new BoardVO();
		bv.setReqPage(2); 
		List<BoardVO> list = dao.selectAll(bv);
		for(BoardVO vo : list) {
			System.out.println(vo.getTitle());
		}		
	}

	@Test
	public void detailTest() { //1번 제목만 출력 테스트 
		System.out.println("detail");
		BoardVO bv = new BoardVO();
		bv.setNo(1);
		BoardVO vo = dao.detail(bv);
		System.out.println(vo.getTitle());
		}
	
	// /board/index.do로 접속 테스트
	@Test	
	public void boardIndex() throws Exception{
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do"); //context-path 넣으면안됨.
		mockMvc.perform(req);
	}
	
	@Test	
	public void boardIndex2() throws Exception{
		RequestBuilder req = MockMvcRequestBuilders.get("/board/index.do").param("reqPage","2"); //reqPage=2 
		mockMvc.perform(req);
	}

	@Test	
	public void mypage() throws Exception{
		RequestBuilder req = MockMvcRequestBuilders.get("/user/mypage.do").session(session); //마이페이지에 세션객체 넣기
		mockMvc.perform(req);
	}

	@Test	
	public void login(){ //로그인 기능이 정상적으로 실행되는지 테스트 
		RequestBuilder req = MockMvcRequestBuilders.post("/user/login.do").param("id","sol").param("pwd","111");
		try {
			mockMvc.perform(req);
		}catch(Exception e) {
			System.out.println(1);
		}
	}	
	
}
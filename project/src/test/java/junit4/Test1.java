package junit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 {
	//junit4 ( beforEach가 없음 - static )
	//Befor → Tetst → After
	//5처럼 순서를 정할수 없음, 메서드 이름 순으로 실행이 됨
	
	@Before
	public void befor() {
		System.out.println("Before");
	}
	@Test
	public void test() {
		System.out.println("Test");
	}
	@Test
	public void test2() {
		System.out.println("Test2");
	}
	@After
	public void after() {
		System.out.println("After");
	}
}

package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteTest();
	}
	
	private static void insertTest() {
		System.out.println("insert test-----------------");
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		
		vo1.setNo(1);
		vo1.setName("강민호");
		vo1.setNumber("01051035912");
		vo1.setEmail("elsin92@gmail.com");
		vo1.setPassword("elel92");
		
		dao.insert(vo1);
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------");
		UserDao dao = new UserDao();
		
		List<UserVo> list = dao.getList();
		
		for(UserVo l : list) {
			System.out.println(l.getNo() + ", " + l.getName() + ", " + l.getNumber() + "," + l.getEmail());
		}
	}
	
	private static void deleteTest() {
		new UserDao().delete();
	}
}

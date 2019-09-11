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
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		
		vo1.setName("강민호");
		vo1.setNumber("01051035912");
		vo1.setEmail("elsin92@gmail.com");
		vo1.setPassword("elel92");
		
		dao.insert(vo1);
		
		UserVo vo2 = new UserVo();
		
		vo2.setName("땡땡떙");
		vo2.setNumber("01011112222");
		vo2.setEmail("rkdalsghek@naver.com");
		vo2.setPassword("alsals92");
		
		dao.insert(vo2);
		System.out.println("insert 완료");
	}
	
	public static void selectTest() {
		UserDao dao = new UserDao();
		
		List<UserVo> list = dao.getList();
		
		System.out.println("Table : User");
		System.out.println("");
		
		for(UserVo l : list) {
			System.out.println("[회원 번호 : " + l.getNo() + "] [성명 : " + l.getName() + "] [연락처 : " + l.getNumber() + "] [이메일 : " + l.getEmail() + "]");
			System.out.println("");
		}
	}
	
	private static void deleteTest() {
		new UserDao().delete();
		
		System.out.println("delete 완료");
	}
}

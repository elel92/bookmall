package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteTest();
	}
	
	private static void insertTest() {
		System.out.println("insert test-----------------");
		CartDao dao = new CartDao();
		
		CartVo vo1 = new CartVo();
		
		vo1.setNo(1);
		vo1.setBook_no(1);
		dao.insert(vo1);
	}
	
	private static void deleteTest() {
		new CartDao().delete();
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------");
		CartDao dao = new CartDao();
		
		List<CartVo> list = dao.getList();
		
		for(CartVo l : list) {
			System.out.println(l.getNo() + ", " + l.getBook_no());
		}
	}
}

package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		//ident();
		//insertTest();
		selectTest();
		//deleteTest();
	}
	
	public static void ident() {
		new BookDaoTest().selectTest();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("");
		new UserDaoTest().selectTest();
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("Book 테이블, User 테이블 확인");
	}
	
	private static void insertTest() {
		CartDao dao = new CartDao();
		
		CartVo vo1 = new CartVo();
		
		vo1.setNo(1);
		vo1.setAmount(1);
		vo1.setPrice(12000);
		vo1.setBook_no(1);
		vo1.setUser_no(1);
		dao.insert(vo1);
		
		CartVo vo2 = new CartVo();
		
		vo2.setNo(2);
		vo2.setAmount(3);
		vo2.setPrice(36000);
		vo2.setBook_no(2);
		vo2.setUser_no(2);
		dao.insert(vo2);
		
		System.out.println("insert 완료");
	}
	
	private static void deleteTest() {
		new CartDao().delete();
		
		System.out.println("delete 완료");
	}
	
	public static List<CartVo> select(int no) {
		CartDao dao = new CartDao();
		
		List<CartVo> list = dao.getList();
		
		return list;
	}
	
	public static void selectTest() {
		CartDao dao = new CartDao();
		
		List<CartVo> list = dao.getList();
		
		System.out.println("Table : Cart");
		System.out.println("");
		
		for(CartVo l : list) {
			System.out.println("[번호 : " + l.getNo() + "] [주문 수량 : " + l.getAmount() + "] [가격 : " + l.getPrice() + "] [도서 번호 : " + l.getBook_no() + "] [회원 번호 : " + l.getUser_no() + "]");
			System.out.println("");
		}
	}
}

package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.Book_OrderDao;
import kr.co.itcen.bookmall.vo.Book_OrderVo;

public class Book_OrderDaoTest {
	public static void main(String[] args) {
		//insertTest();
		//selectTest();
		deleteTest();
	}
	
	private static void insertTest() {
		Book_OrderDao dao = new Book_OrderDao();
		
		Book_OrderVo vo1 = new Book_OrderVo();
		
		vo1.setOrder_no(1);
		vo1.setBook_no(1);
		vo1.setAmount(1);
		dao.insert(vo1);
	}
	
	private static void deleteTest() {
		new Book_OrderDao().delete();
		
		System.out.println("delete 완료");
	}
	
	public static void selectTest() {
		Book_OrderDao dao = new Book_OrderDao();
		
		List<Book_OrderVo> list = dao.getList();
		
		System.out.println("Table : Book_Order");
		System.out.println("");
		
		for(Book_OrderVo l : list) {
			System.out.println("[번호 : " + l.getNo() + "] [주문 번호 : " + l.getOrder_no() + "] [도서 번호 : " + l.getBook_no() + "] [주문 수량 : " + l.getAmount() + "]");
		}
	}
}

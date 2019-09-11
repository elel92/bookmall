package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.Book_OrderDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.Book_OrderVo;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		//ident();
		//insertTest();
		//selectTest();
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
		OrderDao dao = new OrderDao();
		
		OrderVo vo1 = new OrderVo();
		int user_no = 1;
		CartVo c_vo1 = new CartDao().getSelect(user_no);
		vo1.setNo(c_vo1.getNo());
		vo1.setPayment(c_vo1.getPrice());
		vo1.setAddress("경기도 고양시");
		vo1.setAmount(c_vo1.getAmount());
		vo1.setUser_no(user_no);
		dao.insert(vo1);
		new BookDao().update_stock(c_vo1.getBook_no(), c_vo1.getAmount());
		new Book_OrderDao().insertBook_Order(user_no);
		
		
		OrderVo vo2 = new OrderVo();
		user_no = 2;
		CartVo c_vo2 = new CartDao().getSelect(user_no);
		vo2.setNo(c_vo2.getNo());
		vo2.setPayment(c_vo2.getPrice());
		vo2.setAddress("충청북도 충주시");
		vo2.setAmount(c_vo2.getAmount());
		vo2.setUser_no(user_no);
		dao.insert(vo2);
		new BookDao().update_stock(c_vo2.getBook_no(), c_vo2.getAmount());
		new Book_OrderDao().insertBook_Order(user_no);
		
		System.out.println("insert 완료");
	}
	
	private static void deleteTest() {
		new OrderDao().delete();
		
		System.out.println("delete 완료");
	}
	
	public static void selectTest() {
		OrderDao dao = new OrderDao();
		
		List<OrderVo> list = dao.getList();
		
		System.out.println("Table : Order");
		System.out.println("");
		
		for(OrderVo l : list) {
			System.out.println("[번호 : " + l.getNo() + "] [결제 금액 : " + l.getPayment() + "] [배송지 : " + l.getAddress() + "] [주문 수량 :" + l.getAmount() + "] [회원 번호 : " + l.getUser_no() + "]");
			System.out.println("");
		}
	}
}

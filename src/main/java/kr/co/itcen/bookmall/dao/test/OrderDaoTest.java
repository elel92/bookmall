package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		ident();
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
	
	private static void updateBookAmount() {
		
	}
	
	private static void updateOrderBookTest(OrderVo vo) {
		
	}
	
	private static void insertTest() {
		OrderDao dao = new OrderDao();
		
		OrderVo vo1 = new OrderVo();
		
		vo1.setNo(1);
		vo1.setPayment(12000);
		vo1.setAddress("경기도 고양시");
		vo1.setAmount(1);
		vo1.setUser_no(1);
		dao.insert(vo1);
		
		
		OrderVo vo2 = new OrderVo();
		
		vo2.setNo(2);
		vo2.setPayment(12000);
		vo2.setAddress("충청북도 충주시");
		vo2.setAmount(1);
		vo2.setUser_no(1);
		dao.insert(vo2);
		
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

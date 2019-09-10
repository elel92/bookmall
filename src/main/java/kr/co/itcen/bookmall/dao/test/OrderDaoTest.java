package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteTest();
	}
	
	private static void insertTest() {
		System.out.println("insert test-----------------");
		OrderDao dao = new OrderDao();
		
		OrderVo vo1 = new OrderVo();
		
		vo1.setNo(1);
		vo1.setPayment(12000);
		vo1.setAddress("경기도 고양시");
		vo1.setUser_no(1);
		dao.insert(vo1);
	}
	
	private static void deleteTest() {
		new OrderDao().delete();
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------");
		OrderDao dao = new OrderDao();
		
		List<OrderVo> list = dao.getList();
		
		for(OrderVo l : list) {
			System.out.println(l.getNo() + ", " + l.getPayment() + ", " + l.getAddress() + ", " + l.getUser_no());
		}
	}
}

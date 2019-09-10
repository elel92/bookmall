package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteTest();
	}
	
	private static void insertTest() {
		System.out.println("insert test-----------------");
		BookDao dao = new BookDao();
		
		BookVo vo1 = new BookVo();
		
		vo1.setNo(1);
		vo1.setName("연금술사");
		vo1.setPrice(12000);
		vo1.setCategory_no(1);
		vo1.setAmount(50);
		
		dao.insert(vo1);
	}
	
	private static void deleteTest() {
		new BookDao().delete();
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------");
		BookDao dao = new BookDao();
		
		List<BookVo> list = dao.getList();
		
		for(BookVo l : list) {
			System.out.println("[도서 번호 : " + l.getNo() + "] [도서 제목 : " + l.getName() + "] [가격 : " + l.getPrice() + "] [카테고리 번호 : " + l.getCategory_no() + "] [재고 : " + l.getAmount()+"]");
		}
	}
}

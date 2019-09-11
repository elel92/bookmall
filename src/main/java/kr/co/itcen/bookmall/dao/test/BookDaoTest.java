package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteTest();
	}
	
	private static void insertTest() {
		BookDao dao = new BookDao();
		
		BookVo vo1 = new BookVo();
		
		vo1.setName("연금술사");
		vo1.setPrice(12000);
		vo1.setCategory_no(1);
		vo1.setStock(50);
		
		dao.insert(vo1);
		
		BookVo vo2 = new BookVo();
		
		vo2.setName("워드 프로세서 기본서");
		vo2.setPrice(21000);
		vo2.setCategory_no(3);
		vo2.setStock(25);
		
		dao.insert(vo2);
		
		BookVo vo3 = new BookVo();
		
		vo3.setName("프렌즈 베트남");
		vo3.setPrice(14000);
		vo3.setCategory_no(4);
		vo3.setStock(10);
		
		dao.insert(vo3);
		System.out.println("insert 완료");
	}
	
	private static void deleteTest() {
		new BookDao().delete();
		
		System.out.println("delete 완료");
	}
	
	public static void selectTest() {
		BookDao dao = new BookDao();
		
		List<BookVo> list = dao.getList();
		
		System.out.println("Table : Book");
		System.out.println("");
		
		for(BookVo l : list) {
			System.out.println("[도서 번호 : " + l.getNo() + "] [도서 제목 : " + l.getName() + "] [가격 : " + l.getPrice() + "] [카테고리 번호 : " + l.getCategory_no() + "] [수량 : " + l.getStock()+"]");
			System.out.println("");
		}
	}
}

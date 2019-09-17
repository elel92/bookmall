package kr.co.itcen.bookmall.main;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.dao.test.BookDaoTest;
import kr.co.itcen.bookmall.dao.test.Book_OrderDaoTest;
import kr.co.itcen.bookmall.dao.test.CartDaoTest;
import kr.co.itcen.bookmall.dao.test.CategoryDaoTest;
import kr.co.itcen.bookmall.dao.test.OrderDaoTest;
import kr.co.itcen.bookmall.dao.test.UserDaoTest;

public class Main {

	public static void main(String[] args) {
		//카테고리 테이블
		//new CategoryDaoTest().selectTest();
		
		//도서 테이블
		//new BookDaoTest().selectTest();
		
		//회원 테이블
		//new UserDaoTest().selectTest();
		
		//카트 테이블
		//new CartDaoTest().selectTest();
		
		//주문 테이블
		//new OrderDaoTest().selectTest();
		
		//도서_주문 테이블
		//new Book_OrderDaoTest().selectTest();
		
		//---------데이터 삽입---------------
		
		//카테고리 테이블
		//new CategoryDao().insert(new CategoryDao().category_Data(15, "잡지"));
		
		//도서 테이블
		//new BookDao().insert(new BookDao().book_data(4, "원피스", 7000, 80, 11));
		
		//회원 테이블
		//new UserDao().insert(new UserDao().user_data("임꺽정", "01033332222", "elel92@nate.com", "1234"));
		
		//카트 테이블
		//new CartDao().insert(new CartDao().cart_data(3, 36000, 1, 2));
		
		//주문 테이블
		//new OrderDao().insert(new OrderDao().order_date(1, "서울시 강남"));
	}
}

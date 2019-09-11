package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		//insertTest();
		selectTest();
		//deleteTest();
	}
	
	private static void insertTest() {
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		
		vo1.setName("소설");
		dao.insert(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		
		vo2.setName("에세이");
		dao.insert(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		
		vo3.setName("수험서");
		dao.insert(vo3);
		
		CategoryVo vo4 = new CategoryVo();
		
		vo4.setName("만화");
		dao.insert(vo4);
		
		System.out.println("insert 완료");
	}
	
	private static void deleteTest() {
		new CategoryDao().delete();
		
		System.out.println("delete 완료");
	}
	
	public static void selectTest() {
		CategoryDao dao = new CategoryDao();
		
		List<CategoryVo> list = dao.getList();
		
		System.out.println("Table : Category");
		System.out.println("");
		
		for(CategoryVo l : list) {
			System.out.println("[카테고리 번호 : " + l.getNo() + "] [카테고리 이름 : " + l.getName() + "]");
			System.out.println("");
		}
	}
}

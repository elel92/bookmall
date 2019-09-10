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
		System.out.println("insert test-----------------");
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		
		vo1.setNo(1);
		vo1.setName("판타지");
		dao.insert(vo1);
	}
	
	private static void deleteTest() {
		new CategoryDao().delete();
	}
	
	private static void selectTest() {
		System.out.println("select test-----------------");
		CategoryDao dao = new CategoryDao();
		
		List<CategoryVo> list = dao.getList();
		
		for(CategoryVo l : list) {
			System.out.println(l.getNo() + ", " + l.getName());
		}
	}
}

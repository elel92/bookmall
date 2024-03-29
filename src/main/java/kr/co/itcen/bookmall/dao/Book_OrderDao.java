package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.Book_OrderVo;
import kr.co.itcen.bookmall.vo.CartVo;

public class Book_OrderDao {
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mariadb://192.168.1.80:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public boolean insert(Book_OrderVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into book_order(amount, book_no, order_no) values(?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getAmount());
			pstmt.setInt(2, vo.getBook_no());
			pstmt.setInt(3, vo.getOrder_no());
			
			int count = pstmt.executeUpdate();
			
			result = (count == 1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "delete from book_order";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Book_OrderVo> getList() {
		List<Book_OrderVo> result = new ArrayList<Book_OrderVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "select no, order_no, book_no, amount from book_order order by order_no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				int order_no = rs.getInt(2);
				int book_no = rs.getInt(3);
				int amount = rs.getInt(4);
				
				Book_OrderVo vo = new Book_OrderVo();
				
				vo.setNo(no);
				vo.setOrder_no(order_no);
				vo.setBook_no(book_no);
				vo.setAmount(amount);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public void insertBook_Order(int user_no) {
		CartVo c_vo = new CartDao().getSelect(user_no);
		
		Book_OrderVo b_oVo = new Book_OrderVo();
		b_oVo.setBook_no(c_vo.getBook_no());
		b_oVo.setAmount(c_vo.getAmount());
		b_oVo.setOrder_no(c_vo.getNo());
		new Book_OrderDao().insert(b_oVo);
	}
}

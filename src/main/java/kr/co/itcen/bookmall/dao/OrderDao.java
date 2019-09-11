package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDao {
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
	
	public OrderVo order_date(int user_no, String addr) {
		OrderVo vo = new OrderVo();
		CartVo c_vo = new CartDao().getSelect(user_no);
		vo.setNo(c_vo.getNo());
		vo.setPayment(c_vo.getPrice());
		vo.setAddress(addr);
		vo.setAmount(c_vo.getAmount());
		vo.setUser_no(user_no);

		return vo;
	}
	
	public boolean insert(OrderVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into bookmall.order values(?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getNo());
			pstmt.setInt(2, vo.getPayment());
			pstmt.setString(3, vo.getAddress());
			pstmt.setInt(4, vo.getAmount());
			pstmt.setInt(5, vo.getUser_no());
			
			int count = pstmt.executeUpdate();
			
			result = (count == 1);
			
			CartVo c_vo = new CartDao().getSelect(vo.getUser_no());
			new BookDao().update_stock(c_vo.getBook_no(), c_vo.getAmount());
			new Book_OrderDao().insertBook_Order(vo.getUser_no());
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
			
			String sql = "delete from bookmall.order";
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
	
	public List<OrderVo> getList() {
		List<OrderVo> result = new ArrayList<OrderVo>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "select no, payment, address, amount, user_no from bookmall.order order by no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				int payment = rs.getInt(2);
				String address = rs.getString(3);
				int amount = rs.getInt(4);
				int user_no = rs.getInt(5);
				
				OrderVo vo = new OrderVo();
				
				vo.setNo(no);
				vo.setPayment(payment);
				vo.setAddress(address);
				vo.setAmount(amount);
				vo.setUser_no(user_no);
				
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
}

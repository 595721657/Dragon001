package utils;
/**
 * 
 * @author Dragon
 *数据库工具类
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButils {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获得连接
	private static Connection conn = null;
	private static Connection getConnection(){
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hafood?useUnicode=true&"
					+ "characterEncoding=UTF-8","root", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//释放资源
	public static void closeAll(ResultSet rst,PreparedStatement pst,Connection conn) {
		try {
			if(rst != null) {
				rst.close();
				}if(pst != null){
					pst.close();
				}if(conn != null) {
					conn.close();
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//通用的增删改的方法
	public static int updateAll(String sql,Object [] params) {
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			//判断参数是否为空
			if(params != null) {
				//就为SQL语句赋值
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
				return pst.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(null, pst, conn);
		}
		return 0;
	}
	
	//通用的查询方法
	public static ResultSet queryAll(String sql,Object [] params) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			if(params != null) {
				//就为SQL语句赋值
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			rst =  pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
	//书写分页的一个类
	public static ResultSet getPage(String sql,int currpage,int pagesize) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		conn = getConnection();
		try {
			pst = conn.prepareStatement(sql);
			//limit 偏移值/显示数
			pst.setObject(1, (currpage-1)*pagesize);
			pst.setObject(2, pagesize);
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
		
	}
	public static ResultSet getPage(String sql,int tid,int currpage,int pagesize) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		conn = getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setObject(1, tid);
			//limit 偏移值/显示数
			pst.setObject(2, (currpage-1)*pagesize);
			pst.setObject(3, pagesize);
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
		
	}
	//书写一个带参数pname的值得分页方法
	public static ResultSet getPageYe(String sql,int currpage,int pagesize,String pname) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		conn = getConnection();
		try {
			pst = conn.prepareStatement(sql);
			//limit 偏移值/显示数
			pst.setObject(1, (currpage-1)*pagesize);
			pst.setObject(2, pagesize);
			pst.setObject(3, pname);
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
		
	}
}

package utils;
/**
 * 
 * @author Dragon
 *���ݿ⹤����
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
	//�������
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
	//�ͷ���Դ
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
	
	//ͨ�õ���ɾ�ĵķ���
	public static int updateAll(String sql,Object [] params) {
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			//�жϲ����Ƿ�Ϊ��
			if(params != null) {
				//��ΪSQL��丳ֵ
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
	
	//ͨ�õĲ�ѯ����
	public static ResultSet queryAll(String sql,Object [] params) {
		ResultSet rst = null;
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			if(params != null) {
				//��ΪSQL��丳ֵ
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
	//��д��ҳ��һ����
	public static ResultSet getPage(String sql,int currpage,int pagesize) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		conn = getConnection();
		try {
			pst = conn.prepareStatement(sql);
			//limit ƫ��ֵ/��ʾ��
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
			//limit ƫ��ֵ/��ʾ��
			pst.setObject(2, (currpage-1)*pagesize);
			pst.setObject(3, pagesize);
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rst;
		
	}
	//��дһ��������pname��ֵ�÷�ҳ����
	public static ResultSet getPageYe(String sql,int currpage,int pagesize,String pname) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		conn = getConnection();
		try {
			pst = conn.prepareStatement(sql);
			//limit ƫ��ֵ/��ʾ��
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

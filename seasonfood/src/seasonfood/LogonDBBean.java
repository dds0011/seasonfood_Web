package seasonfood;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class LogonDBBean {
	private static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstnce() {
		return instance;
	}
	private LogonDBBean() {
	}
	private static Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/seasonfood");
		return ds.getConnection();
	}
	
	public void insertMember(LogonDataBean member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			System.out.println(member.getUser_id() + " " + member.getUser_passwd() + " " + member.getUser_email() + " " +member.getUser_gender() + " "+member.getUser_join_date());
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into User_info values (0,?,?,?,?,?)");
			pstmt.setString(1, member.getUser_id());
			pstmt.setString(2, member.getUser_passwd());
			pstmt.setString(3, member.getUser_email());
			pstmt.setString(4, String.valueOf(member.getUser_gender()));
			pstmt.setTimestamp(5, member.getUser_join_date());
			pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {pstmt.close();}catch (SQLException ex) { }
			}
			if(conn != null) {
				try {conn.close();}catch(SQLException ex){}
			}
		}
	}
	public int userCheck(String id, String passwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select User_passwd from User_info where User_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("User_passwd");
				if(dbpasswd.equals(passwd))
					x=1;
				else 
					x=0;
			}else
				x= -1;
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			
			}finally {
				try{rs.close();}catch(SQLException sqle){}
				if(pstmt!=null)
					try{pstmt.close();}catch(SQLException sqle){}
				if(conn!=null)
					try{conn.close();}catch(SQLException sqle){}
		}
		
		return x;
		
	}
	public static boolean check(String id) throws Exception {
		Connection conn = getConnection();
		String sql= "select User_id from User_info";
		
		try {
			PreparedStatement pstnt = conn.prepareStatement(sql);
			ResultSet rs = pstnt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("User_id").equals(id)) {
					return true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

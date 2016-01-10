package com.u4f.tools;


	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

	

	public class DBTools {
		static Connection conn=null;
	    static PreparedStatement ps=null;
	    static ResultSet rs=null;
	    
	    public static Connection getConn(Connection conn){
	    	try{
	    		
			    Class.forName("com.mysql.jdbc.Driver");
				System.out.println("驱动加载");
	    		conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/travel","root","");
	    		System.out.println("连接数据库");
	    	}catch(Exception se){   
	    	    System.out.println("fail");   
	    	    se.printStackTrace() ;   
	    	 }
			return conn;   
	    }
	    
	    

	    public static PreparedStatement prepare(Connection conn,String sql){
	    	PreparedStatement ps=null;
	    	try {
				ps=conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return ps;
	    }
	    public static void close(Connection conn,Statement stmt,ResultSet rs){
	    	
	    	if (conn != null) {
	             try {
	                 conn.close();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	         }
	    	if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    	 if (rs != null) {
		            try {
		                rs.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
	    }
	    
	  

	    
	         
	
	
}

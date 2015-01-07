package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class DB {
	
//	private final String url = "jdbc:oracle:thin:@w4111k.cs.columbia.edu:1521:ADB";
//	private final String driver = "oracle.jdbc.driver.OracleDriver";
//	private final String username = "ww2383";	 
//	private final String password = "wuweixin";
	private Connection conn = null;   
	public static Statement stmt;//定义STMT     
	public ResultSet rs;//定义结果集    
	
	
	
	public DB() {
		
		try {
			
			OracleDataSource ods = new oracle.jdbc.pool.OracleDataSource();
			//ods.setDriverType("thin");
			//ods.setServerName("@w411k.cs.columbia.edu");
			//ods.setPortNumber(1521);
			//ods.setDatabaseName("ADB");
            ods.setURL("jdbc:oracle:thin://@w4111k.cs.columbia.edu:1521/ADB");
            ods.setUser("ww2383");
            ods.setPassword("wuweixin");
            conn = ods.getConnection();
//			conn = DriverManager.getConnection(url,username,password);
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
 
		// print to console if failure to make a connection to the database
		if (conn == null) {
			System.out.println("Failed to make connection to the database!");
			
		}
		else
			System.out.println("Success to make connection to the database!");
			
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	
	//执行插入     
    public void doInsert(String sql) {     
     try {     
         stmt = conn.createStatement();     
         int i = stmt.executeUpdate(sql);     
     } catch(SQLException sqlexception) {     
         System.err.println("db.executeInset:" + sqlexception.getMessage());     
     }finally{     
              
     }     
 }     
 //执行删除     
	 public void doDelete(String sql) {     
	     try {     
	         stmt = conn.createStatement();     
	         int i = stmt.executeUpdate(sql);     
	     } catch(SQLException sqlexception) {     
	         System.err.println("db.executeDelete:" + sqlexception.getMessage());     
	     }     
	 }     
 //执行更新     
	 public void doUpdate(String sql) {     
	     try {     
	         stmt = conn.createStatement();     
	         int i = stmt.executeUpdate(sql);     
	     } catch(SQLException sqlexception) {     
	         System.err.println("db.executeUpdate:" + sqlexception.getMessage());     
	     }     
	 }     
 //查询结果集     
	 public ResultSet doSelect(String sql) {     
	     try {  
	         stmt = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);       
	         rs = stmt.executeQuery(sql);   
	         System.out.println("取得结果集");  
	     } catch(SQLException sqlexception) {     
	         System.err.println("db.executeQuery: " + sqlexception.getMessage());     
	     }     
	     return rs;     
	 }     
 
	  public void close(ResultSet rs) throws SQLException, Exception {     
	 
	    if (rs != null) {     
	      rs.close();     
	      rs = null;     
	    }     
	 
	    if (stmt != null) {     
	      stmt.close();     
	      stmt = null;     
	    }     
	 
	    if (conn != null) {     
	      conn.close();     
	      conn = null;     
	    }     
	  }     
 
	 
	  public void close() throws SQLException, Exception {     
	    if (stmt != null) {     
	      stmt.close();     
	      stmt = null;     
	    }     
	 
	    if (conn != null) {     
	      conn.close();     
	      conn = null;     
	    }     
	  }  

}
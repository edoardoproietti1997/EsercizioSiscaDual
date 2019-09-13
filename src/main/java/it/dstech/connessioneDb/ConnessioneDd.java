package it.dstech.connessioneDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDd {

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	  public static final String DB_URL="jdbc:mysql://127.0.0.1:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	  public static final String USER="root";
	  public static final String PASS="";
	  
	  public static Connection connectionDb() throws SQLException, ClassNotFoundException
	  {
	    Class.forName(JDBC_DRIVER);
	    Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
	    return conn;
	  }
	  
	
	
	
	
	
	
	
	
	
	
}

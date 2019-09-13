package it.dstech.connessioneDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnessioneDb {

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	  public static final String DB_URL="jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	  public static final String USER="root";
	  public static final String PASS="dstech";
	  
	  public static Connection connectionDb() throws SQLException, ClassNotFoundException
	  {
	    Class.forName(JDBC_DRIVER);
	    Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
	    return conn;
	  }
	  
	
	  public ArrayList<String> cercaContinenti() throws ClassNotFoundException, SQLException {
		    ArrayList<String> lista = new ArrayList<String>();
		    String query = "SELECT distinct Continent FROM world.country;";
		    PreparedStatement prep = connectionDb().prepareStatement(query);
		    ResultSet result = prep.executeQuery();
		    while (result.next()) {
		      String stato = result.getString(1);
		      lista.add(stato);
		    }
		    return lista;
		  }
		  
	  public ArrayList<String> cercaStati(String continente) throws SQLException, ClassNotFoundException {
		  ArrayList<String> lista = new ArrayList<String>();
		  String query = "SELECT Name FROM world.country where Continent = ?;";
		  PreparedStatement prep = connectionDb().prepareStatement(query);
		  prep.setString(1, continente);
		  ResultSet result = prep.executeQuery();
		  while(result.next()) {
			String nano =  result.getString(1);
			  lista.add(nano);
		  }
		  return lista;
	  }
	 
}

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


import model.HistoryModel;


@Path("/controller")
public class Controller {
	
	private static final String USER_NAME = "sum17cs3750";
	private static final String PASSWORD = "sum17cs3750";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://localhost:3306/sum17cs3750?useSSL=false&verifyServerCertificate=false";
	
	private static Connection getDBConnection() {
		 Connection dbConnection = null;
		
		try {
			Class.forName(DRIVER);
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dbConnection =  DriverManager.getConnection(CONNECTION, USER_NAME, PASSWORD);
			//dbConnection = open
			return dbConnection;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return dbConnection;
	}
	
	private Connection openConnection(String url, String user, String password) {
	    Properties properties = new Properties();
	    properties.put("user", user);
	    properties.put("password", password);
	    properties.put("characterEncoding", "UTF-8");
	    properties.put("useUnicode", "true");

	    Connection c;
	    try {
	        //Class.forName("com.mysql.jdbc.Driver").newInstance();
	        c = DriverManager.getConnection(url, properties);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }

	    return c;
	}
	
	@GET
	@Produces("application/json")
	@Path("/getHistory")
	public List<HistoryModel> hello() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		List<HistoryModel> data = new ArrayList<HistoryModel>();
		
		String queryString = "select * from star_student";
		Connection c = null;
		PreparedStatement s = null;
		
		try {
		
			c = getDBConnection();


			s = c.prepareStatement(queryString);
		
			ResultSet rs = s.executeQuery(queryString);
	     
	     
			while(rs.next()) {
				/*HistoryModel hModel = new HistoryModel();
			
				hModel.setComments(rs.getString("COMMENTS"));
				hModel.setResult(rs.getString("RESULT"));
				hModel.setDate(rs.getDate("DATE"));
			
				data.add(hModel);*/
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			c.close();
		}

		return data;
	}
}

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

import javax.ws.rs.*;
import javax.ws.rs.core.*;


import model.HistoryModel;


@Path("/controller")
public class Controller {
	
	private static final String USER_NAME = "sum17cs3750";
	private static final String PASSWORD = "sum17cs3750";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://icarus.cs.weber.edu:22/OurDBName";
	
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		
		try {
			Class.forName(DRIVER);
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dbConnection = DriverManager.getConnection(CONNECTION, USER_NAME, PASSWORD);
			return dbConnection;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return dbConnection;
	}
	
	@GET
	@Produces("application/json")
	@Path("/getHistory")
	public List<HistoryModel> hello() throws SQLException {
		List<HistoryModel> data = new ArrayList<HistoryModel>();
		
		//String queryString = "select * from something";
		
		
		Connection c = getDBConnection();
		/*PreparedStatement s = null;
		s = c.prepareStatement(queryString);
		
	    ResultSet rs = s.executeQuery(queryString);
	     
	     
		while(rs.next()) {
			HistoryModel hModel = new HistoryModel();
			
			hModel.setComments(rs.getString("COMMENTS"));
			hModel.setResult(rs.getString("RESULT"));
			hModel.setDate(rs.getDate("DATE"));
			
			data.add(hModel);
		}*/

		return data;
	}
}

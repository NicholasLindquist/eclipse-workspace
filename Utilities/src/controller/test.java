package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	      // JDBC driver name and database URL
	      final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	      final String DB_URL="jdbc:mysql://localhost:3306/sum17cs3750";

	      //  Database credentials
	      final String USER = "sum17cs3750";
	      final String PASS = "Hello123";

	      // Set response content type
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Database Result";
	      Connection conn = null;
	      
	      try {
	          // Register JDBC driver
	          Class.forName("com.mysql.jdbc.Driver");

	          // Open a connection
	          conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      } catch(SQLException se) {
	          //Handle errors for JDBC
	          se.printStackTrace();
	       } catch(Exception e) {
	          //Handle errors for Class.forName
	          e.printStackTrace();
	       } finally {
	          try {
	             if(conn !=null)
	            	 conn.close();
	          } catch(SQLException se) {
	             se.printStackTrace();
	          } //end finally try
	       } //end try
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

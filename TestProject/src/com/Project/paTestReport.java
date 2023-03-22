package com.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paTestReport")
public class paTestReport extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.sendRedirect("Ptestpg.jsp");

		// String qry="SELECT * FROM Scans ORDER BY Fname,Lname";
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// } catch (ClassNotFoundException e) {e.printStackTrace();}
		//
		// try {
		// Connection conn=
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC",
		// "root", "Spark@3000");
		// Statement st= conn.createStatement();
		//
		// ResultSet rs=st.executeQuery(qry);
		// while(rs.next())
		// {
		// System.out.println( rs.getString("PID")+" "+rs.getString("Fname")+"
		// "+rs.getString("Lname")+" "+rs.getString("MobNum")+"
		// "+rs.getString("Scans") );
		// }//while
		//
		// } catch (SQLException e) {e.printStackTrace();}

	}// ME

}

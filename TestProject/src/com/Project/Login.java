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


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String sid=req.getParameter("sid");
		String pswrd=req.getParameter("spswrd");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");
			Statement st= conn.createStatement();
			
			String query="select * from Staff where PID='"+sid+"';";
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
				System.out.println("user Exist");
				String spswrd= rs.getString("Pswrd");
				if(spswrd.equals(pswrd))
				{
					System.out.println("Pswrd Correct");
					res.sendRedirect("SubmitRep.jsp");
				}
				else
				{
					System.out.println("Pswrd Incorrect");
					res.sendRedirect("error.jsp");
				}
				
			}
			else
			{
				System.out.println("User Not Exist");
				res.sendRedirect("Login.jsp");
			}
			
			
		} catch (SQLException e) {e.printStackTrace();}
		
		
	}//me

}

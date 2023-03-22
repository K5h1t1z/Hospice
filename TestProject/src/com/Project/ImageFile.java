package com.Project;
import java.util.*;
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
import javax.servlet.http.HttpSession;


@WebServlet("/ImageFile")
public class ImageFile extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String pid=(String)session.getAttribute("pid");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");
			Statement st= con.createStatement();
			
			String query="select * from Scans where PID='"+pid+"';";
			ResultSet rs= st.executeQuery(query);
			
			if(rs.next())
			{
				//fileName
				String[] fileName= rs.getString("TestName").split(",");
				for(int i=0;i<fileName.length;i++)
				{
					fileName[i]=fileName[i].trim();
				}
				
				//fileReport
				String[] fileReport= rs.getString("TestReport").split(",");
				for(int i=0;i<fileReport.length;i++)
				{
					fileReport[i]=fileReport[i].trim();
				}
				
				//files
				String[] files= rs.getString("TestFile").split(",");
				
				for(int i=0;i<files.length;i++)
				{
					files[i]=files[i].trim();
				}

				HttpSession ses= req.getSession();
				ses.setAttribute("files", files);
				ses.setAttribute("fileName", fileName);
				ses.setAttribute("fileReport", fileReport);
				
				res.sendRedirect("ImageFile.jsp");
			}//exist
			
		}
		catch (SQLException e) {e.printStackTrace();}
	}//ME

}

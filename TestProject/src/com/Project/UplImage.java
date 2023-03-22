package com.Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/upl")
public class UplImage extends HttpServlet {
	
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			System.out.println("in File Upload");
			res.setContentType("text/html");
			
			//upload File
			MultipartRequest m=new MultipartRequest(req,"C://Users//ganvi//Desktop//TECHNICAL//Eclipse All Files//WorkSpace//TestProject//WebContent//Img");
			String imgName=m.getOriginalFileName("imgf");
			System.out.print(imgName+" successfuly uploaded \n");
			
			//Get Attribute
			HttpSession session= req.getSession();
			String pid=(String) session.getAttribute("pid");
			String repName=(String) session.getAttribute("repName");
			String ScanRep=(String) session.getAttribute("ScanRep");
			
			System.out.println("\n"+pid+" "+ScanRep+" "+repName+"\n");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e){e.printStackTrace();}
			
			try
			{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");
				Statement st= con.createStatement();
				String qry="select * from Scans where PID='"+pid+"';";
				ResultSet rs= st.executeQuery(qry);
				
				if(rs.next())
				{
					System.out.println(rs.getString("Fname")+" "+rs.getString("Lname"));
					if(rs.getString("TestName")==null)
					{
						String qry2="update Scans set TestName='"+repName+"',TestReport='"+ScanRep+"', TestFile='"+imgName+"'  where PID='"+pid+"';  ";
						PreparedStatement ps= con.prepareStatement(qry2);
						int c=ps.executeUpdate();
						if(c==0)
						{
							res.sendRedirect("error.jsp");
						}else
						{
							System.out.println("Inserted\n");
						}
					}
					else
					{
						repName=rs.getString("TestName")+", "+repName;
						ScanRep=rs.getString("TestReport")+", "+ScanRep;
						imgName=rs.getString("TestFile")+", "+imgName;
						
						String qry2="update Scans set TestName='"+repName+"',TestReport='"+ScanRep+"', TestFile='"+imgName+"'  where PID='"+pid+"';  ";
						
						PreparedStatement ps= con.prepareStatement(qry2);
						int c=ps.executeUpdate();
						if(c==0)
						{
							res.sendRedirect("error.jsp");
						}else
						{
							System.out.println("Inserted\n");
						}
						
					}
					
					
					
				}
				else
				{
					System.out.println("not found");
					res.sendRedirect("error.jsp");
				}
				
			} 
			catch (SQLException e) {e.printStackTrace();}
			
			res.sendRedirect("SubmitRep.jsp");
			
			}//ME
		
	
}

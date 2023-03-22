package com.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin")
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String fname= req.getParameter("fname");
		String mname= req.getParameter("mname");
		String lname= req.getParameter("lname");
		String mobile= req.getParameter("mob");
		String address= req.getParameter("addr");
		String email= req.getParameter("email");
		String age= req.getParameter("age");
		String dob= req.getParameter("dob");
		String gender= req.getParameter("gender");
		String dept= req.getParameter("dept");
		String pos= req.getParameter("pos");
		String pswrd= req.getParameter("pass");
		String pid=age.trim()+dob.trim();
		ArrayList<String> al= new ArrayList<String>();
		al.add(pid);
		al.add(fname);
		al.add(mname);
		al.add(lname);
		al.add(mobile);
		al.add(address);
		al.add(email);
		al.add(age);
		al.add(dob);
		al.add(gender);
		al.add(dept);
		al.add(pos);
		al.add(pswrd);
		
		for(String st:al)
		{
			if(st.isEmpty())
			{
				res.sendRedirect("error.jsp");
				return;
			}
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root","Spark@3000");
			String query="INSERT INTO Staff values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement ps=con.prepareStatement(query);
			for(int i=0;i<al.size();i++)
			{
				ps.setString(i+1,al.get(i));
			}
			
			int c=ps.executeUpdate();
			if(c!=0)
			{
				System.out.println("Inserted");
				SendMail obj;
				obj=new SendMail(email,"Admin Credentials","The Admin has Added you on the hospital Staff with your UserName:"+pid+" and Password: "+pswrd+". Kindly changed it acordingly.");
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		
	}//ME

}

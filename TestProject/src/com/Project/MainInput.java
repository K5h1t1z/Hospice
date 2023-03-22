package com.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@WebServlet("/try")
public class MainInput extends HttpServlet {

	static String query = "INSERT INTO Patient(PID,Fname, Mname,Lname,Mnum,Addr,Symptoms,Age,DOB,Email) VALUES(?,?,?,?,?,?,?,?,?,?);";
	static String q2 = "INSERT INTO Report (PID,Fname,Lname,Report,Medicine,DrName) VALUES(?,?,?,?,?,?);";
	static String q3 = "INSERT INTO Scans (PID,Fname,Lname,MobNum) VALUES(?,?,?,?);";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String fname = req.getParameter("fname");
		String mname = req.getParameter("mname");
		String lname = req.getParameter("lname");
		String mnum = req.getParameter("mnum");
		String addr = req.getParameter("addr");
		String symp = req.getParameter("symp");
		String email= req.getParameter("email");
		if(email.isEmpty())
		{
			email="";
		}

		String age = req.getParameter("age");
		String dob = req.getParameter("dob");
		dob = dob.replaceAll("/", "");
		dob = dob.replaceAll("-", "");
		String pid = age + dob;

		System.out.println(fname + " " + mname + " " + lname + " " + mnum + " " + addr + " " + symp + " " + pid + " " + dob);

		HttpSession ses = req.getSession();
		String k = "not initiated";
		ses.setAttribute("doc", k);
		ses.setAttribute("repo", k);
		ses.setAttribute("meds", k);
		ses.setAttribute("scan", "");

		if (fname.isEmpty() || lname.isEmpty() || mnum.isEmpty() || addr.isEmpty() || age.isEmpty() || dob.isEmpty()) {
			System.out.println("Null Value");
			res.sendRedirect("error.jsp");
		} else {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");

				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, pid);
				ps.setString(2, fname);
				ps.setString(3, mname);
				ps.setString(4, lname);
				ps.setString(5, mnum);
				ps.setString(6, addr);
				ps.setString(7, symp);
				ps.setString(8, age);
				ps.setString(9, dob);
				ps.setString(10, email);

				int cnt = ps.executeUpdate();

				PreparedStatement ps2 = conn.prepareStatement(q2);
				ps2.setString(1, pid);
				ps2.setString(2, fname);
				ps2.setString(3, lname);
				ps2.setString(4, "");
				ps2.setString(5, "");
				ps2.setString(6, "");
				int cnt2 = ps2.executeUpdate();

				PreparedStatement ps3 = conn.prepareStatement(q3);
				ps3.setString(1, pid);
				ps3.setString(2, fname);
				ps3.setString(3, lname);
				ps3.setString(4, mnum);

				int cnt3 = ps3.executeUpdate();

				if (cnt == 0 && cnt2 == 0 && cnt3 == 0) {
					System.out.println("Not Inserted");
					res.sendRedirect("error.jsp");

				} else {
					System.out.println("Inserted");
					if(email.isEmpty()==false)
					{
						new SendMail(email,"From Hospital","The Patient"+fname+" "+lname+" has Admitted in Hospital, Please Take care!!!😊😊");
					}
					res.sendRedirect("index.html");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		
		
	}// ME

}

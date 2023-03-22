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
import javax.servlet.http.HttpSession;

@WebServlet("/format")
public class FormatBkend extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String age = req.getParameter("ageSearch");
		String dob = req.getParameter("dobSearch");
		String val1 = req.getParameter("pid");
		System.out.println(val1 + " " + age + " " + dob);

		String query1 = "select * from Patient where PID='" + val1 + "';";

		String query2 = "select * from Report where PID='" + val1 + "';";

		String query3 = "select * from Scans where PID='" + val1 + "'";

		HttpSession ses = req.getSession();
		ses.setAttribute("age", age);
		ses.setAttribute("dob", dob);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");

			Statement st1 = conn.createStatement();// Patient
			Statement st2 = conn.createStatement();// Report
			Statement st3 = conn.createStatement();// Scans

			ResultSet rs = st1.executeQuery(query1);// Patient
			ResultSet rs2 = st2.executeQuery(query2);// Report
			ResultSet rs3 = st3.executeQuery(query3);// Scans

			String repo;
			String meds;
			String doc;

			if (rs2.next()) {
				repo = rs2.getString("Report");
				meds = rs2.getString("Medicine");
				doc = rs2.getString("DrName");
				ses.setAttribute("doc", doc);
				ses.setAttribute("meds", meds);
				ses.setAttribute("repo", repo);
			} else {
				repo = "not Initiated";
				meds = "not Initialized";
				doc = "not Initialized";
			}
			String scan = "";
			if (rs3.next()) {
				scan = rs3.getString("Scans");
				System.out.println(scan);
				ses.setAttribute("scan", scan);
			} else {
				scan = "not initialized";
				ses.setAttribute("scan", scan);
			}
			if (rs.next()) {
				String pid = rs.getString("PID");
				String fname = rs.getString("Fname");
				String mname = rs.getString("Mname");
				String lname = rs.getString("Lname");
				String mnum = rs.getString("Mnum");
				String addr = rs.getString("Addr");

				repo = rs2.getString("Report");

				ses.setAttribute("pid", pid);
				ses.setAttribute("fname", fname);
				ses.setAttribute("mname", mname);
				ses.setAttribute("lname", lname);
				ses.setAttribute("mnum", mnum);
				ses.setAttribute("addr", addr);
				ses.setAttribute("age", age);

				// forward to jsp
				res.sendRedirect("format.jsp");
			} else {
				res.sendRedirect("error.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// ME
}

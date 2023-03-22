package com.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scan")
public class Scans extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String scan = req.getParameter("scans");
		HttpSession ses = req.getSession();
		String pid = (String) ses.getAttribute("pid");
		String fname = (String) ses.getAttribute("fname");
		String lname = (String) ses.getAttribute("lname");
		String mnum = (String) ses.getAttribute("mnum");

		System.out.println("The scans are " + scan + " " + pid + " " + fname);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");
			Statement st = con.createStatement();
			String query = "select * from Scans where PID='" + pid + "'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String val = rs.getString("Scans");

			if (val == null) {
				ses.setAttribute("scan", scan);
				System.out.println("no value found");
				String qry = "UPDATE Scans SET Scans='" + scan + "' where PID='" + pid + "' ";// query
				// to
				// update
				PreparedStatement ps = con.prepareStatement(qry);
				int c = ps.executeUpdate();

				if (c != 0) {
					System.out.println("Value Upadated!!");
					ses.setAttribute("scan", scan);
				}
			} else {
				System.out.println("Found Value");
				String data = rs.getString("Scans");
				scan = scan + ", " + data;
				String qry = "UPDATE Scans SET Scans='" + scan + "' where PID='" + pid + "' ";// query
				// to
				// update
				PreparedStatement ps = con.prepareStatement(qry);
				int c = ps.executeUpdate();

				if (c != 0) {
					System.out.println("Value Upadated!!");
					ses.setAttribute("scan", scan);
				}

			}
			res.sendRedirect("format.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// ME

}

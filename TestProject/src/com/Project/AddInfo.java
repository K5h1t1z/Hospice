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

@WebServlet("/add")
public class AddInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String drName = req.getParameter("doc");
		String Addrep = req.getParameter("addRep");
		String Addmeds = req.getParameter("addMeds");
		drName = "Dr. " + drName;

		System.out.println(drName + " " + Addrep + " " + Addmeds);

		HttpSession ses = req.getSession();
		ses.setAttribute("doc", drName);
		ses.setAttribute("repo", Addrep);
		ses.setAttribute("meds", Addmeds);
		String age = (String) ses.getAttribute("age");
		String dob = (String) ses.getAttribute("dob");
		String val = age + dob;
		String query = "Select Report,Medicine,DrName FROM Report where PID='" + val + "'; ";

		try {
			Class.forName("com.mysql.jdbc.Drivers");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			System.out.println("the valueis :" + rs.getString("Report"));
			int cnt;

			if (rs.getString("Report").isEmpty()) {

				// System.out.println("data nahi found");
				String query2 = "UPDATE Report SET Report='" + Addrep + "', Medicine='" + Addmeds + "',DrName='"
						+ drName + "' where PID='" + val + "'; ";
				PreparedStatement ps = conn.prepareStatement(query2);
				cnt = ps.executeUpdate();
			} else {
				String data1 = rs.getString("Report");
				data1 = data1 + "\n, " + Addrep;

				String data2 = rs.getString("Medicine");
				data2 = data2 + "\n, " + Addmeds;

				String data3 = rs.getString("DrName");
				data3 = data3 + "\n, " + drName;

				ses.setAttribute("doc", data3);
				ses.setAttribute("repo", data1);
				ses.setAttribute("meds", data2);
				String query2 = "UPDATE Report SET Report='" + data1 + "', Medicine='" + data2 + "',DrName='" + data3
						+ "' where PID='" + val + "'; ";

				PreparedStatement ps = conn.prepareStatement(query2);
				cnt = ps.executeUpdate();
			}

			if (cnt == 0) {
				System.out.println("data not inserted");
				res.sendRedirect("error.jsp");
			} else {
				System.out.println("data inserted");
				res.sendRedirect("format.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			res.sendRedirect("error.jsp");
		}

	}// ME

}//

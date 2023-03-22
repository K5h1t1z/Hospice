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

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/SubmitRep")
public class SubmitRep extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String pid =req.getParameter("pid");
		
		String repName=req.getParameter("repName");
		
		String ScanRep=req.getParameter("ScanRep");
		
		System.out.println(pid+" "+repName+" "+ScanRep);
		
		
		HttpSession ses= req.getSession();
		ses.setAttribute("pid", pid);
		ses.setAttribute("repName", repName);
		ses.setAttribute("ScanRep", ScanRep);
		
		resp.sendRedirect("SubmitRep.jsp");
	}//main
}

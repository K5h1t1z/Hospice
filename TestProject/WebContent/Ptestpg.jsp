<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FormatTemplate</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


</head>

<body>
	
	<!-- navbar-->
				
					<nav class="navbar navbar-white bg-danger mt-5 py-2">
					  <div class="container-fluid ">
					    <a class="navbar-brand" href="index.html">
					     <i class="fa fa-home w3-xxlarge"></i>
					     Hospice
					    </a>
					  </div>
					</nav>
					
				<!-- navbar end-->
	
	<div class=" container-fluid small mt-2 px-3 border">
		<!--start div-->
				<%@page import="java.io.IOException"%>
				<%@page import="java.sql.Connection"%>
				<%@page import="java.sql.DriverManager"%>
				<%@page import="java.sql.ResultSet"%>
				<%@page import="java.sql.SQLException"%>
				<%@page import="java.sql.Statement"%>

				<!-- database Connectivity -->
				<div class=container text-primary border-success>

					<%!ResultSet rs;
						Statement st;
						Connection conn;
					%>

					<%
						String qry = "SELECT * FROM Scans ORDER BY Fname,Lname";
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

						try {
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GMC", "root", "Spark@3000");
							st = conn.createStatement();
							rs = st.executeQuery(qry);

						} catch (SQLException e) {
							e.printStackTrace();
						}
					%>
				</div>
				<!-- database Connectivity end-->
				<!-- table -->
				<div class="	container">

					<table class="table table-hover fs-4">
						<thead class="py-4 my-3">
							<tr class="text-dark my-2 py-2"
								style="background-color: lightgrey">
								<th scope="col">Sr no.</th>
								<th scope="col">PID</th>
								<th scope="col">FirstName</th>
								<th scope="col">LastName</th>
								<th scope="col">Moblie Number</th>
								<th scope="col">Scans</th>
							</tr>
						</thead>

						<tbody class="fs-5 text-secondary">

							<%
								int cnt = 1;
								while (rs.next()) {
									out.print("<tr><td>" + cnt + "</td><td>" + rs.getString("PID") + "</td><td>" + rs.getString("Fname")
											+ "</td><td>" + rs.getString("Lname") + "</td><td>" + rs.getString("MobNum") + "</td> <td>"
											+ rs.getString("Scans") + "</td></tr>");
									cnt += 1;
								}
							%>
						</tbody>
					</table>

				</div>
				<!-- table end-->
	</div>
	<!-- lastdiv-->
</body>
</html>
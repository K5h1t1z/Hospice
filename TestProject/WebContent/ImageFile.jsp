
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
  <title>Project Example</title>

    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	 <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

	<div class="container"><!--start-->
	<%@ page import = "java.sql.*,java.util.*" %>
		</div>
		
		<!--Image Show-->
		<div class="container mt-3">
		<div class="row">
			<% 
			
			
			String[] fileName= (String[])session.getAttribute("fileName");
			String[] fileReport= (String[])session.getAttribute("fileReport");
			String[] files= (String[])session.getAttribute("files");
			System.out.print("thet elements are: \n");
			
			for(int i=0;i<fileName.length;i++)
			{
				if( i>0 && String.valueOf(fileName[i]).equals(String.valueOf(fileName[i-1])) )
				{
					continue;
				}
				System.out.print(fileName[i]);
				out.print("<div class=\"row mt-2 mb-2 fs-3 text-dark fw-bold\">"+fileName[i]+": </div>");
				out.print("<div class=\"row  mt-1 mb-4 fs-5 text-secondary border\">"+fileReport[i]+"</div>");
				%><div class="row mb-3 mt-2 "><%
				int it=i;
				while(it < fileName.length && fileName[it].equals(fileName[i]) )
				{
					out.print("<div class=\"col\">"+"<img src=\"Img/"+files[it]+"\" style=\"width:300px;height:200px\">"+"</div>");
					it++;
				}
				%></div><%  
				
			}
			
			%>
		
		</div>
		</div><!--Image Show End -->
	
	</div><!--end-->
	<div><hr class="border-dark fw-bold"></div>
	
</body>

</html>
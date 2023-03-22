<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Staff Login</title>
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
				
<div class =" container-fluid mt-2 px-3 border"><!--Starting  --> 
	<!--form-->
	<div class="container">
	<form action="Login" method="get" onsubmit="mySubmit()">
	
	<div class="row my-4" ><input class="form-control" type="text" name="sid" id="sid" placeholder="Enter ID"></div>
	<div class="row my-4" ><input class="form-control" type="password" name="spswrd"  id="spswrd" placeholder="Enter password"></div>
	<div class="row my-4" >
	<!-- <div class="col"></div> -->
	<button class="btn btn-outline-success" type="submit">Login</button>
	<!-- 	<div class="col"></div> -->
	</div>

	</form>
	</div>
	<!--form ending-->
</div><!--Ending  --> 

<script>
function mySubmit()
{
	alert("Data Submitted");
}
</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

	<div class =" container-fluid mt-2 px-3 border"><!--Starting  --> 
	
		<!-- navbar-->
					<nav class="navbar navbar-white bg-danger mt-5 py-2">
					  <div class="container-fluid ">
					    <a class="navbar-brand" href="#">
					     <i class="fa fa-home w3-xxlarge"></i>
					      Hospice
					    </a>
					  </div>
					</nav>
		<!-- navbar end-->
		
		<div class="mt-5 mx-3 mb-3 border"><!--form Start-->
		<form action="admin" method="get" onSubmit="mySubmit()">
		
		<div class="row my-2 py-2">
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter FirstName" name="fname" ></input></div>
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter MiddleName" name="mname" ></input></div>
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter LastName" name="lname" ></input></div>
		</div>
		
		<div class="row my-2 py-2">
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter MobileNumber" name="mob" ></input></div>
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter Address" name="addr" ></input></div>
		</div>
		
		<div class="row my-2 py-2">
		<div class="col mx-2"><input class="form-control" type="email" placeholder="Enter Email" name="email" ></input></div>
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter Age" name="age" ></input></div>
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter DateofBirth" name="dob" ></input></div>
		<div class="col mx-2">GENDER: <input type="radio" name="gender" value="M"><label for="M">Male</label></input>
  		 <input type="radio" name="gender" value="F"><label for="F">Female</label></input> </div>
		</div>
		
		<div class="row my-2 py-2">
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter Department" name="dept" ></input></div>
		<div class="col mx-2"><input class="form-control" type="text" placeholder="Enter Position" name="pos" ></input></div>
		<div class="col mx-2"><input class="form-control" type="password" placeholder="Enter DefaultPasssword" name="pass" ></input></div>
		</div>
		
		<div class="row my-2 py-2 mx-5"><button type="submit" class="btn btn-outline-success">Submit</button></div>
		</form>
		</div><!--form End-->
	
	</div><!--Ending  --> 
	<!-- Script-->
	<script>
		function mySubmit() {
			alert("The data will be submitted");
		}
	</script>

</body>

</html>
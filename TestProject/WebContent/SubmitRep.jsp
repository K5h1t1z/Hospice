<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Staff Login</title>
	  
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
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
		<form action="SubmitRep" method="get" onsubmit="mySubmit()" class="m-1">
		
			<div class="row my-4" >
			<div class="col"><input class="form-control border-success" type="text" name="pid" id="pid" placeholder="Enter PatientID"></div>
			
			<div class="col"><input class="form-control border-success" type="text" name="repName" id="repName" placeholder="Enter Report Name"></div>
			</div>
			
			<div class="row my-4" >
			
			<label for="ScanRep" class="fs-5 text-secondary container mb-2">Report:</label><br>
			<textarea class="form-control border-success" rows="9" id="ScanRep" name="ScanRep"></textarea>
			
			</div>

			<!-- Buttons -->
			<div class="row my-4" >
			<div class="col"><button class="btn btn-outline-success" type="submit">Submit</button></div> 
			<div class="col"></div>
			<div class="col"></div>
			</div>
			<!-- Buttons ending-->
	
		</form>
		
		<label for="ScanRep" class="fs-5 text-secondary">Upload Scans:</label><br>
		
		<form action="upl" method="post" enctype="multipart/form-data" onsubmit="mySubmit()">
			
			<div class="row mb-3 pb-2 mt-2"> 
			
				<div class="col"><input class="form-control btn btn-outline-success" type="file" name="imgf" ></input></div>
				<div class="col"><input type="submit" class="form-control btn btn-outline-success" value="Upload"></div>
			
			</div>
			
		</form>
		
		<div class="container row mx-1 my-3">
		<button class="btn btn-outline-secondary text-dark border-dark " type="button" onclick="myList()" >Patients Scans List to Submit</button>
		</div>
		
		
	</div>
	<!--form ending-->
</div><!--Ending  --> 

<script>
function mySubmit()
{
	alert("The Data will be submited");
}
 function myList()
 {
	 //Ptestpg.jsp
	 window.location.href = "Ptestpg.jsp";	 
 }

</script>
</body>

</html>
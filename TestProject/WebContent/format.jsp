<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>FormatTemplate</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	
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
	<%
		String pid = String.valueOf(session.getAttribute("pid"));
		String fname = String.valueOf(session.getAttribute("fname"));
		String mname = String.valueOf(session.getAttribute("mname"));
		String lname = String.valueOf(session.getAttribute("lname"));
		String mnum = String.valueOf(session.getAttribute("mnum"));
		String addr = String.valueOf(session.getAttribute("addr"));
		String age = String.valueOf(session.getAttribute("age"));
		String dob = String.valueOf(session.getAttribute("dob"));
		String rep = String.valueOf(session.getAttribute("repo"));
		String meds = String.valueOf(session.getAttribute("meds"));
		String doc = String.valueOf(session.getAttribute("doc"));
		String scan = String.valueOf(session.getAttribute("scan"));
	%>


	<div class=" container-fluid small mt-2 px-3 border">
		<!--start div-->

				<!--Table-->
				<div class="container-sm mt-3 border p-5">
					<table class="table  table-hover ">
						<tbody class=" small">

							<tr>
								<td><small><h4>PID</h4> </small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(pid);
											%>
										</h5></small></td>
							</tr>

							<tr>
								<td><small><h4>FirstName</h4></small></td>
								<td><small>
										<h5 class="text-secondary">
											<%
												out.print(fname);
											%>
										</h5>
								</small></td>
							</tr>

							<tr>
								<td><small><h4>MiddleName</h4></small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(mname);
											%>
										</h5></small></td>
							</tr>

							<tr>
								<td><small><h4>LastName</h4></small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(lname);
											%>
										</h5></small></td>
							</tr>

							<tr>
								<td><small><h4>Moblile Number</h4></small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(mnum);
											%>
										</h5></small></td>
							</tr>

							<tr>
								<td><small><h4>Address</h4></small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(addr);
											%>
										</h5 "></small></td>
							</tr>

							<tr>
								<td><small><h4>Age</h4> </small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(age);
											%>
										</h5> </small></td>
							</tr>

							<tr>
								<td><small><h4>Date of Birth</h4> </small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(dob);
											%>
										</h5></small></td>
							</tr>

							<tr>
								<td><small><h4>Dr Prescibed</h4> </small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(doc);
											%>
										</h5></small></td>
							</tr>

							<tr>
								<td><small><h4>Report</h4> </small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(rep);
											%>
										</h5></small></td>
							</tr>

							<tr>
								<td><small><h4>Medicines</h4> </small></td>
								<td><small><h5 class="text-secondary">
											<%
												out.print(meds);
											%>
										</h5></small></td>
							</tr>


						</tbody>
					</table>
				</div>
				<!--table end-->

				<div class="container my-5 border pt-3 my-2">
					<ul class="list-group list-group-flush">

						<li class="list-group-item mb-2 pb-3">
							<!--list item 1--> <!--dropdown-->
							<div class="dropdown">
								<button type="button"
									class="btn btn-outline-success dropdown-toggle"
									data-bs-toggle="dropdown">Add Report</button>
								<form
									class="container-fluid dropdown-menu m-3 p-3 border-success"
									action="add" method="get" onsubmit="myFunction()">

									<div class="row m-2 p-2">
										<input class="form-control border-success" type="text"
											name="doc" placeholder="Name of Dr."> </input>
									</div>

									<div class="row m-2 p-2">
										<div class="p-2 text-secondary">Report:</div>
										<textarea class="form-control border-success" type="text"
											rows="5" name="addRep" placeholder="Report"> </textarea>
									</div>

									<div class="row m-2 p-2">
										<div class="p-2 text-secondary">Medicine:</div>
										<textarea class="form-control border-success" type="text"
											rows="5" name="addMeds" placeholder="Medicines"> </textarea>
									</div>

									<div class="row">
										<div class="col mx-4 p-2">
											<button type="submit" class="btn btn-outline-success">
												Submit</button>
										</div>
										<div class="col"></div>
										<div class="col">
											<button type="reset"
												class="btn btn-outline-success float-end">Clear</button>
										</div>
									</div>

								</form>
							</div> <!--dropdown end-->
						</li>
						<!--list item end-->




						<li class="list-group-item mt-1 pt-2">
							<!--dropdown-->
							
							<div class="dropdown">

								<button type="button" class="btn btn-outline-success dropdown-toggle"data-bs-toggle="dropdown">Add Scans</button>
								<td><small><h5 class="text-secondary mx-2 my-2">
											<%
												out.print(scan);
											%>
										</h5></small></td>


								<form class="container-fluid dropdown-menu m-3 mb-5 p-3 border-success" action="scan" method="get" onsubmit="myFunction()">

									<div class="row">
										<div class="col my-2">
											<input class="form-control border-success text" type="text"
												name="scans" placeholder="Scans" autofocus></input>
										</div>
										<div class="col my-2">
											<button class="btn btn-success" type="submit">Submit</button>
										</div>
									</div>
									</form>
							</div>
					<!--dropdown end-->
					</li>
					<!--list item end-->
					
					<!--list item start-->
					<li class="list-group-item mt-1 pt-2">
					<div class="row mb-2 pb-2">
					
					<div class="col"></div>
					
					<!-- 2nd column  -->
					<div class="col">
					<form action="ImageFile" method="get">
					<button type="submit"  class="form-control btn btn-outline-success" >Scanned Report</button>
					</form>
					</div>
					
					<div class="col"></div>
					
					</div>
					
					</li><!--list item end-->

				</ul>
	</div>
	
	<hr class="text-dark solid">
	<div class="container mb-3 pb-3 text-danger"></div>
	

	</div>
	<!--end div-->

	<script>
		function myFunction() {
			alert("The data is submitted");
		}
	</script>

</body>
</html>
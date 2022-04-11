<!DOCTYPE html>
<html>
<head>
<title>Job hiring portal</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Job hiring portal</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#">Home</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<main class="container-fluid">	
		<h2>Project Features</h2>
		<hr/>
		<h5>Sprint 1 ( 4th APR to 8th APR )</h5>
		<table  class="table table-bordered">
			<thead  class="thead-dark">
				<tr>
					<th width="5%">Sno</th>
					<th width="25%">Description</th>
					<th width="25%">URL</th>
					<th width="5%">Method</th>
					<th width="10%">Status</th>
					<th width="5%">Sprint</th>
					<th width="5%">Estimation</th>					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>User Registration API</td>
					<td>/RegisterServlet</td>
					<td>GET</td>
					<td><span class="badge bg-success">COMPLETED</span></td>
					<td>1</td>			
					<td>10hrs </td>		
				</tr>
				<tr>
					<td>2</td>
					<td>User Login API</td>
					<td>/LoginServlet</td>
					<td>GET</td>
					<td><span class="badge bg-warning">In Progress</span></td>
					<td>1</td>			
					<td>10hrs </td>					
				</tr>
				
			</tbody>
		</table>
		
		<h5>Sprint 2 ( 11th APR to 15th APR )</h5>
		<table border="1" class="table table-bordered">
			<thead>
				<tr>
					<th width="5%">Sno</th>
					<th width="25%">Description</th>
					<th width="25%">URL</th>
					<th width="5%">Method</th>
					<th width="10%">Status</th>
					<th width="5%">Sprint</th>
					<th width="5%">Estimation</th>					
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td>3</td>
					<td>List Users</td>
					<td>/ListUserServlet</td>
					<td>GET</td>
					<td><span class="badge bg-danger">Pending</span></td>
					<td>1</td>			
					<td>10hrs </td>					
				</tr>
			</tbody>
		</table>
		
	</main>
</body>
</html>

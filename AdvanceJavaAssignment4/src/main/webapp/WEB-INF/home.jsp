<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Product Home Page</title>
</head>
<body>

	<div class="container mt-5">
		<h3 class="text-center mb-5">Welcome, You can search your product
			here</h3>
		<form action="home" method="post">
			<div class="mb-3 row">
				<label for="color" class="col-sm-2 col-form-label">Color : </label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="color" value=""
						name="color">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="size" class="col-sm-2 col-form-label">Size : </label>
				<div class="col-sm-6">
					<select name="size" class="form-select form-select-sm"
						aria-label=".form-select-lg example">
						<option selected></option>
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
						<option value="XXL">XXL</option>
						</select>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="gender" class="col-sm-2 col-form-label">Gender :
				</label>
				<div class="col-sm-6">
					<select name="gender" class="form-select form-select-sm"
						aria-label=".form-select-lg example">
						<option selected></option>
						<option value="F">Female</option>
						<option value="M">Male</option>
						<option value="U">Unisex</option>
						
					</select>

				</div>
			</div>
			<div class="mb-3 row">
				<label for="output" class="col-sm-2 col-form-label">Output
					Preference : </label>
				<div class="col-sm-6">
					<select name="output" class="form-select form-select-sm"
						aria-label=".form-select-lg example">
						<option selected></option>
						<option value="1">Sorted only by Price</option>
						<option value="2">Sorted only by Rating</option>
						<option value="3">Sorted by Price and rating</option>
					</select>
				</div>
			</div>


			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>

		</form>
	</div>


</body>
</html>
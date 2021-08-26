<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="fontawesome-pro-5.15.3-web\css/all.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row" style="height: 500px">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 bg-light">
				<h3 class="display-4 font-weight-bold text-uppercase">Thêm Một
					Sản Phẩm</h3>
				<form:form autocomplete="off" action="save-product"
					modelAttribute="product" method="POST">
					<div class="form-group">
						<label for="name">Product Name</label>
						<form:input type="text" name="productName" path="productName" class="form-control"
							id="name" placeholder="Input the name of the product!" />
					</div>
					<div class="form-group">
						<label for="address">Product Address</label>
						<form:input type="text" path="productAddress" class="form-control"
							id="address" placeholder="Input the address of the product!" />
					</div>
					<div class="form-group">
						<label for="price">Product Price</label>
						<form:input type="number" path="productPrice" class="form-control"
							id="price" placeholder="Input the price of the product!" />
					</div>
					<div class="form-group">
						<label for="image">Product Image</label>
						<form:input type="file" path="productImage"
							class="form-control-file" id="image" />
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
<body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<!-- Header -->
	<div class="container-fluid bg-dark py-3 text-white">
		<!-- Navigation Bar -->
		<div class="row">
			<!-- Logo -->
			<div class=" h3 col-sm-3 d-flex justify-content-center">
				<i class="fas fa-building mr-3 align-self-center"></i>
				<p class="m-0 align-self-center">Real Estate</p>
			</div>
			<!-- Navigation link -->
			<div class="col-sm-6">
				<nav class="nav justify-content-center">
					<a class="nav-link text-success"
						href="${pageContext.request.contextPath}">Home</a> <a
						class="nav-link text-success"
						href="${pageContext.request.contextPath}/product-form">Add
						Product</a>
				</nav>
			</div>
			<!-- Login & Sign Up -->
			<div class="col-sm-3 d-flex justify-content-center">
				<security:authorize access="!isAuthenticated()">
					<button type="button" class="btn btn-light mr-1 align-self-center"
						onclick="location.href='${pageContext.request.contextPath}/login'">LOGIN</button>
					<button type="button" class="btn btn-light ml-1 align-self-center">SIGN
						UP</button>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<button type="button" class="btn btn-light mr-1 align-self-center"
						onclick="location.href='${pageContext.request.contextPath}/logout'">LOGOUT
					</button>
				</security:authorize>
			</div>

		</div>
	</div>
	<hr>
	<!-- End Header -->

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

</body>

</html>
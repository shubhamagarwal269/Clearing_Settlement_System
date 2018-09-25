<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<title>Member Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="login/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/css/util.css">
	<link rel="stylesheet" type="text/css" href="login/css/main.css">
<!--===============================================================================================-->
</head>
<body>


			<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="#">Group 5</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		  </button>

		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
			  <li class="nav-item active">
				<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
			  </li>
			  
			  <li class="nav-item active">
				<a class="nav-link" href="signin.jsp">Sign In<span class="sr-only">(current)</span></a>
			  </li>
			</ul>
		  </div>
		</nav>
		

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form action="forgetpassmail"  method="post" class="login100-form validate-form p-l-55 p-r-55 p-t-178" >
					<span class="login100-form-title">
						Forget Member Password 
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter Member Email Id">
						<input class="input100" type="email" name="email" placeholder="Registered Email Id">
						<span class="focus-input100"></span>
					</div>

					
					<div class="text-center p-t-13 p-b-23">
						<span class="txt1">
							Temporary password will be sent to registered email-Id.
						</span>
					</div>
					
					<div class="container-login100-form-btn p-b-30">	
	                        <input type="submit" value="Proceed" class="login100-form-btn">
					</div>


<!-- 					<div class="flex-col-c p-t-120 p-b-40">
						<span class="txt1 p-b-9">
							Don’t have an account?
						</span>

						<a href="registration.html" class="txt3">
							Sign up now
						</a>
					</div> -->
				</form>
			</div>
		</div>
	</div>

	
<!--===============================================================================================-->
	<script src="login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/bootstrap/js/popper.js"></script>
	<script src="login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/daterangepicker/moment.min.js"></script>
	<script src="login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="login/js/main.js"></script>


</body>
</html>
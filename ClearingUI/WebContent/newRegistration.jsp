<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<title>New Member Sign Up</title>
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
			  <!-- 
			  <li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				  Dropdown
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
				  <a class="dropdown-item" href="#">Action</a>
				  <a class="dropdown-item" href="#">Another action</a>
				  <div class="dropdown-divider"></div>
				  <a class="dropdown-item" href="#">Something else here</a>
				</div>
			  </li> 
			  <li class="nav-item">
				<a class="nav-link disabled" href="#">Disabled</a>
			  </li>  -->
			  
			</ul>
			<!-- <form class="form-inline my-2 my-lg-0">
			  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form> -->
		  </div>
		</nav>
		

	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="signup" method="post">
					<span class="login100-form-title">
						<h2>New Clearing Member Registration</h2>
					</span>

					<div class="wrap-input100 validate-input m-b-20" data-validate="Please enter name">
						<input class="input100" type="text" name="membername" placeholder="Member Name">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-20" data-validate = "Please enter email-Id">
						<input class="input100" type="email" name="emailid" placeholder="Email Id">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-20" data-validate = "Please enter positive 9 digits Bank A/C number">
						<input class="input100" type="number" name="bankac" placeholder="Bank Account Number">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-20" data-validate = "Please enter positive 9 digits DEMAT A/C number">
						<input class="input100" type="number" name="dematac" placeholder="Demat Account Number">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-20" data-validate = "Minimum 6 characters, atleast one alphabet, number and special character">
						<input class="input100" type="password" id ="pass" name="pass" placeholder="Password">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-30" data-validate = "Please enter same password as above">
						<input class="input100" type="password" id="confirmpass" name="confirmpass" placeholder="Confirm Password">
						<span class="focus-input100"></span>
					</div>
<!-- 
					<div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							Forgot
						</span>

						<a href="#" class="txt2">
							Username / Password?
						</a>
					</div> -->

					<div class="container-login100-form-btn p-b-30">	
	                        <input type="submit" id="register" value="Register" class="login100-form-btn">
					</div>

<!-- 					<div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
							Don’t have an account?
						</span>

						<a href="#" class="txt3">
							Sign up now
						</a> -->
					</div>
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
	
	<!-- confirm password and password validation -->
	<script type="text/javascript">
	    $(function () {
	        $("#register").click(function () {
	            var password = $("#pass").val();
	            var confirmPassword = $("#confirmpass").val();
	            if (password != confirmPassword) {
	                alert("Passwords do not match.");
	                return false;
	            }
	            return true;
	        });
	    });
	</script>
	
</body>
</html>
<%@page import="java.util.concurrent.TimeUnit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<style>
	
		#snackbar {
		    visibility: visible;
		    min-width: 250px;
		    margin-left: -125px;
		    background-color: #333;
		    color: #fff;
		    text-align: center;
		    border-radius: 2px;
		    padding: 16px;
		    position: fixed;
		    z-index: 1;
		    left: 50%;
		    bottom: 30px;
		    font-size: 17px;
		}
				
	</style>
	
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
			<!-- <form class="form-inline my-2 my-lg-0">
			  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form> -->
		  </div>
		</nav>
		
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form action="signin" method="post" class="login100-form validate-form p-l-55 p-r-55 p-t-170">
					<span class="login100-form-title">
						Sign In
					</span>
					
					
					<div class="btn-group btn-group-toggle m-b-16 center-block" data-toggle="buttons">
					  <label class="btn btn-info active">
					    <input type="radio" name="options" id="option1" autocomplete="off" checked value="1"> &nbsp;&nbsp;&nbsp;&nbsp; Member &nbsp;&nbsp;&nbsp;&nbsp;
					  </label>
					  <label class="btn btn-info">
					    <input type="radio" name="options" id="option2" autocomplete="off" value="0"> &nbsp;&nbsp;&nbsp;&nbsp; Administrator &nbsp;&nbsp;&nbsp;&nbsp;
					  </label>
					  <label class="btn btn-info">
					    <input type="radio" name="options" id="option3" autocomplete="off" value="2"> &nbsp;&nbsp;&nbsp;&nbsp; Guest &nbsp;&nbsp;&nbsp;
					  </label>
					</div>					

					<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
						<input class="input100" type="email" name="username" placeholder="Enter Member Email-Id">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
					</div>

					<div class="text-right p-t-13 p-b-23">
						<a href="forgetPassword.jsp" class="txt2">
							Forgot Password ?
						</a>
					</div>
					
					<%
						try{
							boolean flag = (boolean)request.getAttribute("alert");
							String type = (String)request.getAttribute("type");
							
							if(type.equals("wrongCred")){
								out.println("<div id='snackbar'> You have entered wrong credentials, Please try again</div>");
							}
							else if(type.equals("memRegistered")){
								out.println("<div id='snackbar'>New Member registered, You can login using your credentials now</div>");
							}
							
							
							//TimeUnit.SECONDS.sleep(2);
						}
						catch(NullPointerException e){
							
						}
					%>
					

					<div class="container-login100-form-btn">
						
	                        <input type="submit" value="Sign In" class="login100-form-btn">
						
					</div>

					<div class="flex-col-c p-t-90 p-b-30">
						<span class="txt1 p-b-9">
							Don't have an account?
						</span>

						<a href="newRegistration.jsp" class="txt3">
							Sign up now
						</a>
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
	
	<script type="text/javascript">
	
	$('input[name="options"]').on('change', function() {
		   
	    if($(this).val() === '2'){
	        $('input[type="email"]').val("guest@hello.com");
	        $('input[type="password"]').val("guest@123");
	        }
	    else if($(this).val() === '1'){
	    	$('input[type="email"]').val("");
	        $('input[type="password"]').val("");
	        $('input[type="email"]').attr("placeholder","Enter Member Email-Id");
	        
	        }
	    else if($(this).val() === '0'){
	    	$('input[type="email"]').val("");
	        $('input[type="password"]').val("");
	        $('input[type="email"]').attr("placeholder","Enter Admin Email-Id");
	        
	        }
	});
	
	</script>
	
	
	
	<script>
		$(document).ready(function(){
			setTimeout(
					function(){
						document.getElementById("snackbar").style.visibility = "hidden";
					}, 
				3000);
			}
		);
	</script>

	


</body>
</html>
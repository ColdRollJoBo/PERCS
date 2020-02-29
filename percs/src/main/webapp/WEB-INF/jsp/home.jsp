<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/master.css">
<title>Insert title here</title>
</head>
<body>
	<div class="nav-bar">
      <div class="nav-container">
        <a href="/home" class="nav-items">Home</a>
        <a href="register" class="nav-items">Register</a>

      </div>

    </div>

	<div class="home-container">

		<div class="home-image-container">
			<img src="/img/site-art/home-image.jpg" alt="">
		</div>

		<div class="login-container">

			<h1 style="text-align: center; color: black">Login</h1>

			<form action="login" method="post" modelAttribute="user">
				<label style="color: white">User Name</label><br> 
				<input class="userinput" type="text" name="username" placeholder="Username"> <br> 
				<label style="color: white">Password</label><br> 
				<input class="userinput" type="password" name="password" placeholder="password"> <br> 
				<input type="submit" class="button" value="Login"> <br> 
				<label>Register</label>
				<a href="register">Register</a>
			</form>


		</div>

		<div class="main-info">
			<h1 style="text-align: center">P.E.R.C.S</h1>
			<p style="text-align: center; font-size: 2em;">Point Earning
				Reward Card System</p>

			<div class="main-paragraph-container">

				<p class="main-paragraph" style="padding: 10px">PERCS is a new
					way small businesses can transition into the digital age while not
					spending large amounts of capital to make a custom app. Our new
					digital punch-card system is also a great option for customers too!
					Never lose out on great savings because you forgot or lost your
					punch-card.</p>
			</div>
		</div>
		<div class="businesses">
			<h1>Participating Businesses</h1>
		</div>
		
		<div class="section1">
			<img src="/img/site-art/coming-soon-1.jpg" alt=""
				style="width: auto; height: 500px">
		</div>
		
		<div class="section2">
			<img src="/img/site-art/jtd-logo.png" alt=""
				style="width: auto; height: 500px">
		</div>
		
		<div class="section3">
			<img src="/img/site-art/coming-soon-2.jpg" alt=""
				style="width: auto; height: 500px">
		</div>
	</div>
</body>
</html>
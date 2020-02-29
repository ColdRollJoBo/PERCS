<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/master.css">
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
<a href="topdog">test</a>


	<div class="login-wrap">
		<div class="login-html">
			<form action="add" method="post">
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
					for="tab-1" class="tab">Sign In</label> <input id="tab-2"
					type="radio" name="tab" class="sign-up"><label for="tab-2"
					class="tab">Sign Up</label>
				<div class="login-form">
					<div class="sign-in-htm">
						<div class="group">
							<label for="user" class="label">Username</label> 
							<input id="user" type="text" class="input">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> 
							<input id="pass" type="password" class="input" data-type="password">
						</div>
						<div class="group">
							<input id="check" type="checkbox" class="check" checked>
							<label for="check"><span class="icon"></span> Keep me
								Signed in</label>
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign In">
						</div>
						<div class="hr"></div>
						<div class="foot-lnk">
						<!-- 	<a href="#forgot">Forgot Password?</a> -->
						</div>
					</div>
					<div class="sign-up-htm">
						<div class="group">
							<label for="user" class="label">Username</label> <input id="user"
								name="userName" type="text" class="input">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> <input id="pass"
								name="pass" type="password" class="input" data-type="password">
						</div>
						<div class="group">
							<label for="pass" class="label">Repeat Password</label> <input
								id="pass" type="password" class="input"
								data-type="password">
						</div>
						<div class="group">
							<label for="pass" class="label">Email Address</label> <input
								id="pass" name="email" type="email" class="input">
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign Up">
						</div>
						<div class="hr"></div>
						<div class="foot-lnk">
							<label for="tab-1">Already Member?</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<form action="single" method="post">
		<label for="find" class="label">Search</label> <input name="userId" type="text" class="input">
		<input name="userName" type="text" class="input">
		<div class="group">
			<input type="submit" class="button" value="Find">
		</div>
	</form>

	<form action="test" method="post">
		<label class="label">Find User Info</label> <input name="username" type="text" class="input">
		<input type="submit" class="button" value="Find User Info">

	</form>

	<!-- User Name : <input type="text" name="userName" /> Password : <input
			type="password" name="pass" /> Email : <input type="email"
			name="email" /> <input type="submit" /> -->

</body>
</html>
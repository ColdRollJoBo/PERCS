<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Joe's Top Dog Punch Card</title>
<link rel="stylesheet" href="/css/master.css">
</head>
<body>

<div class="nav-bar">
      <div class="nav-container">
        <a href="home" class="nav-item-home">Home</a>
        <!-- May want to make an account access link here -->
        Hello ${username}
      </div>
    </div>


    <div class="home.container">
      <div class="punchcard-container">
        <div class="main-info-section-1">
          <div><img src="/img/site-art/jtd-logo.png" style="width:50%" alt=""></div>
          <h1>Business Authorization</h1>
         
			<form class="" action="punch" method="post">
            	<label>Code</label>
            	<input type="password" name="punchPassword" value="">
            	<button type="submit" name="button">Punch!</button>
            	<button type="button" name="redeem" ${redeem} formaction="???">Redeem</button>
          </form>
        </div>
        
        <div class="main-info-section-2">
          <h1>Hello ${username} this is your current Joe's Top Dog punch card.</h1>
          <div><img src="${punchcard}" style="width:100%;" alt=""></div>

        </div>
    </div>
    </div>

</body>

<script>
function disableBtn() {
if( /* the punch is the last one use an EL tag here */) {
  document.getElementByName("myBtn").disabled = false;
}

</script>

</html>
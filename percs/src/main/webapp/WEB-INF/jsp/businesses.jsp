<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Punch Card</title>
<link rel="stylesheet" href="/css/master.css">
</head>
<body>
<div>
</div>
<%-- <a href="topdog"><img alt="" src="\img\site-art\jtd-logo.png"></a>
<img alt="" src="${punchcard}">
 --%>



    <div class="nav-bar">
      <div class="nav-container">
        <a href="home" class="nav-item-home">Home</a>
        <a href="register" class="nav-item-login">Welcome ${username}</a>
      </div>
    </div>

<h1>Hello ${username} please select a business to add or view your current punchcard.</h1>
    
    <div class="main-info">
      <div class="main-info-section-1">
        <div><img src="/img/site-art/coming-soon-1.jpg" style="width:50%" alt=""></div>
        <h1>New Business Spot Available</h1>
        <p>Head to our request page to set up your account</p>
      </div>
      <div class="main-info-section-2">
        <div><img src="/img/site-art/jtd-logo.png" style="width:50%" alt=""></div>
        <h1>Joe's Top Dog</h1>
        <a href="topdog"><img src="/img/site-art/percs-icon.png" style="width:30%" alt=""></a>

      </div>
      <div class="main-info-section-3">
        <div><img src="/img/site-art/coming-soon-2.jpg" style="width:50%" alt=""></div>
        <h1>New Business Spot Available</h1>
          <p>Head to our request page to set up your account</p>

      </div>

    </div>




</body>
</html>
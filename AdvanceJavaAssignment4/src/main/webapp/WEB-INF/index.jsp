<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
<%@include file="style.css" %>
</style>
<title>Login Page</title>

<SCRIPT type="text/javascript">
window.history.forward();
function noBack() { window.history.forward(); }
</SCRIPT>

</head>
<body>

<div class="container">
      <p class="box"><strong>Login</strong></p>
      
      <div class="form">
        <form action="login" method="post">
          <div class="name">
            <label for="username">Username</label><p class="star">*</p> <input
              type="text"
              name="name"
            />
          </div>

          <div class="pass">
            <label for="password">Password</label><p class="star">*</p> <input type="password" name="pass"/>
          </div>
         
          <div class="footer">
            <button id="login" type="submit">Login &DoubleRightArrow;</button>
          </div>
        </form>
      </div>
		<% if((session.getAttribute("usernameError"))!=null || (session.getAttribute("passwordError"))!=null){ 
		session.removeAttribute("username");
		session.invalidate();
		%>
		 <div class="error">
        <p class="errormsg">Username or password is empty!</p>
      </div>
      <%} %>
     
    </div>


</body>
</html>
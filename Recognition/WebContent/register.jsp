<%@page import="com.istudy.exception.RegisterFormValidationException"%>
<%@page import="com.istudy.auth.RegisterForm"%>
<%@page import="com.istudy.exception.UserNameAlreadyExistsException"%>
<%@page import="com.istudy.deprecated.User"%>
<%@page import="com.istudy.action.RegisterAction"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="/global.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/prefixfree.min.js"></script>
</head>
<%
RegisterAction regaction = new RegisterAction(recogFactory);
if("registerForm".equals(submittedFormName)){
	if(request.getParameter("Register") != null){
		try {
			RegisterForm newUserForm = new RegisterForm();
			newUserForm.setName(request.getParameter("username"));
			newUserForm.setPassword(request.getParameter("password"));
			regaction.addNewUser(newUserForm);
			%>	
			<div class="success">
				Registration Successful! You will be redirected to the login
				page soon.	
				<script>
				setTimeout(function () {
				    window.location.assign("login.jsp");
				}, 3000);
				</script>
			</div>
			<%
		} catch (RegisterFormValidationException e){
		%>
    			<div class="error">
    			<% if (e.getErrorMessages().size() > 0) {
    				for(String error: e.getErrorMessages()) { %>
    				<%= error %> <br>
    			<% 	}
    			}%>
    			</div>
		<%
		} catch (UserNameAlreadyExistsException e) {
		%>	<div class="error">
			<%= e.getMessage() %>
			</div>
			<%
		}
		} else if (request.getParameter("FBReg") != null) {
			
		} else {
			response.sendRedirect("/Recognition/login.jsp");
		}
	}
%>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Re<span>gister</span>
		</div>
	</div>
	<br>
	<form action="register.jsp" method="post" class="login">
	<input type="hidden" name="formIsFilled" value="true"> <br />
	<input type="hidden" name="formName" value="registerForm" value="true"/>
		<input type="text" placeholder="username" name="username"><br>
		<input type="password" placeholder="password" name="password"><br>
		<input type="submit" value="Register" name="Register" onclick="playSFX()">
		<input type="submit" value="Register w/ Facebook" name="FBReg" onclick="playSFX()">
		<input type="submit" value="Back to Login" name="Return" onclick="playSFX()">
	</form>
	<script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
</body>
<script type="text/javascript">
	
	 function logIn() {
		    FB.login(
		         function(response) {
		    if (response.status== 'connected') {
		     FB.api('/me', function(response) {
		         console.log(response);
		           console.log('Good to see you, ' + response.name + '.');
		        });
		 
		        FB.api("/me/picture?width=200&redirect=0&type=normal&height=200", function (response) {
		           if (response && !response.error) {
		             console.log('PIC ::', response);
		           }
		        });
		    }
		   }
		   ,{
		 scope: "email"
		     }
		  );
		 }
</script>
</html>
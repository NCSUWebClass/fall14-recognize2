<%@page import="com.istudy.db.RecogDBException"%>
<%@page import="com.istudy.deprecated.UserDoesntExistException"%>
<%@page import="com.istudy.deprecated.User"%>
<%@page import="com.istudy.action.LoginAction"%>
<%@include file="/global.jsp"%>
<head>
<title>Recogneyes</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/prefixfree.min.js"></script>
</head>
<%
LoginAction logAction = new LoginAction(recogFactory);
if("loginForm".equals(submittedFormName)){
		if(request.getParameter("Login") != null) {
			try {
				currentUser = logAction.login(request.getParameter("username"),request.getParameter("password"));
				if( currentUser != null) {
					currentUserOptions = logAction.getCurrentUserOptions(currentUser.getUID());
					session.setAttribute("currentUser", currentUser);
					session.setAttribute("currentUserOptions", currentUserOptions);
					response.sendRedirect("main.jsp?uID=" + currentUser.getUID());
					return;
				} else { %>
					<div class="error">
						<span>Invalid Login Information</span>
					</div>
					<%
				}
			} catch (RecogDBException e){
			%>
			<div class="header">
				<span><%=e.getMessage()%></span>
			</div>
			<%
			}
		} else if (request.getParameter("Register") != null){
			response.sendRedirect("/Recognition/register.jsp");
			return;
		} 
	}%>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Re<span>cogneyes</span><br>
			<font size=2>Take a closer look</font>
		</div>
	</div>
	<br>
	<form action="login.jsp" method="post" class="login">
	<input type="hidden" name="formIsFilled" value="true"> <br />
	<input type="hidden" name="formName" value="loginForm" value="true"/>
		<input type="text" placeholder="username" name="username"><br>
		<input type="password" placeholder="password" name="password"><br>
		<input type="submit" value="Login" name="Login" onclick="playSFX()">
		<input type="submit" value="Register" name="Register" onclick="playSFX()">
	</form>
	<script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
</body>
</html>
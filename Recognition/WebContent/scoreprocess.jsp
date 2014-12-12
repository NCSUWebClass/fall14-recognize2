<%@include file="/global.jsp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>

<%
	if("scoreForm".equalsIgnoreCase(submittedFormName)){
		int currentScore = Integer.parseInt(request.getParameter("playerScore"));
		currentUser.setCurrentScore(currentScore);
		currentUser.setLastDayPlayed(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		currentUser.updateHighestScore();
		recogFactory.getRecogUserDatabase().updateUser(currentUser);
	}
	response.sendRedirect("main.jsp?uID="+currentUser.getUID());
%>

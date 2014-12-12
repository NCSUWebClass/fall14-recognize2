<%@page import="com.istudy.exception.AlbumFinishedException"%>
<%@page import="com.istudy.util.RecognizeUtil"%>
<%@page import="com.istudy.action.PlayAction"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/global.jsp"%>
<html>
<head>
<title>Recognition</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/gamestyle.css" type="text/css" rel="stylesheet" />
</head>
<%
	String selectedAlbumTitle = request.getParameter("albumtitle");
	session.setAttribute("albumTitle", selectedAlbumTitle);

	if(currentUser == null){
		response.sendRedirect("login.jsp");
		return;
	}
	if(currentUserOptions == null){
		response.sendRedirect("login.jsp");
		return;
	}	
%>


<body>
	<h2 id="albumTitle"><%=selectedAlbumTitle%></h2>
	<br>
	<div>Current Image Points:</div>
	<div id="cpoints">100</div>
	<div>Player Score:</div>
	<div id="currentPlayerScore">0</div>
	<br>
	<button id="pause" class="button red medium" onclick="pause()">Pause</button>
	<button id="home" class="button red medium"
		onclick="home('<%=currentUser.getUID()%>')">Return to Home</button>
	<form action="scoreprocess.jsp" method="post" class="pscoreclass">
		<input type="hidden" name="formIsFilled" value="true"> <br />
		<input type="hidden" name="formName" value="scoreForm" value="true"/>
		<input id="pscore" type="number" name="playerScore" value="0" hidden="hidden"/>
		<input type="submit" class="button red medium" id="scoresubmit" value="Finished" />
	</form>
	
	<iframe src='gamesection.jsp' id="CurrentGameFrame" sandbox="allow-scripts allow-same-origin allow-forms allow-top-navigation" ></iframe>
	
	<% if (currentUserOptions.getMusicSetting() == true) { %>
		<script type="text/javascript">
		// BG Music: Ambience by Mads Nielsen
		// Liscense: http://creativecommons.org/licenses/by-nc-nd/3.0/
		var puzzleBGMusic = new Audio();
		puzzleBGMusic.src = 'sounds/Mads-Nielsen_Ambience2-320.mp3'
		puzzleBGMusic.play();
		
		</script>
	<% } %>
	<script>
	
	function home(userID){
		window.open("main.jsp?uID="+userID, "_parent", "toolbar=no, scrollbars=no, resizable=no, top=0, left=0, width=200, height=500");
	}
	
	function pause() {
		var gameframe = document.getElementById("CurrentGameFrame");
        var doc = gameframe.contentWindow;
		doc.pause();
	}
	</script>
</body>
</html>
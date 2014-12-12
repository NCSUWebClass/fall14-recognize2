<%@page import="com.istudy.action.HomeAction"%>
<%@page import="javax.print.attribute.ResolutionSyntax"%> 
<%@include file="/global.jsp"%>
<!-- =============================================== -->
<!-- =                                             = -->
<!-- =                Keyners	                   = -->
<!-- =                                             = -->
<!-- =          http://keyners.com/	               = -->
<!-- =============================================== -->


<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->
<head>

	<!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<title>Recognyze Home</title>
	<meta name="description" content="">
	<meta name="author" content=" Made by Keyners">
    <meta http-equiv="X-UA-Compatible" content="IE=9" />


	<!-- Mobile Specific Metas
  ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- PT Sans -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

	<!-- Crete Roung -->
	<link href='http://fonts.googleapis.com/css?family=Crete+Round&subset=latin,latin-ext' rel='stylesheet' type='text/css'>

	<!-- CSS
  ================================================== -->
  	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/skeleton.css">
	<link rel="stylesheet" href="css/layout.css">

	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"></script>
	<script type="text/javascript" src="js/validate.js"></script>
	<script type="text/javascript" src="js/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<link rel="stylesheet" type="text/css" href="js/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
	<script type="text/javascript">
		$(document).ready(function() {
				$("a[rel=example_group]").fancybox({
				'transitionIn'		: 'none',
				'transitionOut'		: 'none',
				'titlePosition' 	: 'over',
				'titleFormat'		: function(title, currentArray, currentIndex, currentOpts) {
					return '<span id="fancybox-title-over">Image ' + (currentIndex + 1) + ' / ' + currentArray.length + (title.length ? ' &nbsp; ' + title : '') + '</span>';
				}
			});
		});
	</script>
</head>
<%
String uID = request.getParameter("uID");
if(uID == null || uID.length() <= 0){
	response.sendRedirect("login.jsp");
	return;
}
if(currentUserOptions == null){
	response.sendRedirect("login.jsp");
	return;
}
%>
<body>
	
	<header>			
		<nav>
			<div class='container'>
				<div class='five columns logo'>
					<img src="css/bg/profileHolder.jpg" alt="Account Photo" class="headerAccountPhoto">
					<a href='#'>Welcome <%= currentUser.getUserName()%></a>
				</div>			
				<div class='eleven columns'>
					<ul class='mainMenu'>
						<% if (currentUserOptions.getSfxSetting() == true) { %>
						<li><a href='#' title='Home' onclick="selectSFX.play();goTo('home.jsp')">Home</a></li>
						<li><a href='#' title='About us' onclick="selectSFX.play()">Quick Game</a></li>
						<li><a href='#'  title='Albums' onclick="selectSFX.play();goTo('albums.jsp')">Albums</a></li>
						<li><a href='#' title='Friends' onclick="selectSFX.play()">Play With Friends</a></li>
						<li><a href='#' title='LB' onclick="selectSFX.play();goTo('leaderboard.jsp')">Leaderboard</a></li>
						<li><a href='#' title='Account' onclick="selectSFX.play();goTo('options.jsp')">Settings/Account</a></li>
						<li><a href='login.jsp' title='Logout'  onclick="selectSFX.play()">Logout</a></li>
						<% } else { %>
						<li><a href='#' title='Home' onclick="goTo('home.jsp')">Home</a></li>
						<li><a href='#' title='About us' onclick="">Quick Game</a></li>
						<li><a href='#'  title='Albums' onclick="goTo('albums.jsp')">Albums</a></li>
						<li><a href='#' title='Friends' onclick="">Play With Friends</a></li>
						<li><a href='#' title='LB' onclick="goTo('leaderboard.jsp')">Leaderboard</a></li>
						<li><a href='#' title='Account' onclick="goTo('options.jsp')">Settings/Account</a></li>
						<li><a href='login.jsp' title='Logout'  onclick="">Logout</a></li>
						<% } %>
					</ul>
				</div>
			</div>
		</nav>
		<div class='container'>
			<div class='slogan'>
				<div class='ten columns'>
					<h1><%= currentUser.getUserName() %></h1>					
					<h2>Highest Score: <%= currentUser.getHighestScore() %> </h2>
					<br>
					<br>
					<br>
					<br>
					<br>
					<h2>Last Time Played: <%= currentUser.getLastDayPlayed() %></h2>
				</div>
			</div>
		</div>	
	</header>
<iframe src='home.jsp' width="100%" height="500px" id="gameframe" sandbox="allow-scripts allow-same-origin allow-forms allow-top-navigation">
</iframe>
<script type="text/javascript">
		function goTo(webaddress){
			document.getElementById('gameframe').src = webaddress;
		}
</script>
<% if (currentUserOptions.getSfxSetting() ==true) { %>
	<script>
	var selectSFX = new Audio();
	selectSFX.src = 'sounds/select.mp3';
	</script>
<% } %>
<% if (currentUserOptions.getMusicSetting() == true) { %>
	<script>
	var bgMusic = new Audio();
	bgMusic.src = 'sounds/Pixelize.mp3';
	bgMusic.autoplay = true;
	bgMusic.play();
	</script>
<% } %>
</body>
</html>
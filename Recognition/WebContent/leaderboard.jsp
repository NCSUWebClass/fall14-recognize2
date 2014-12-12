	<%@page import="com.istudy.action.LeaderboardAction"%>
<%@page import="com.istudy.action.HomeAction"%>
	<%@page import="java.util.List" %>
	<%@include file="/global.jsp"%>
	
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/skeleton.css">
	<link rel="stylesheet" href="css/layout.css">
	
	<% 
		LeaderboardAction action = new LeaderboardAction(recogFactory);
		List<UserBean> users = action.getAllUsersLB();
	%>
	
	<h2 class="otherPage">Leaderboard</h2>
	<hr>
	<div class='clear'></div>

	<div class='container'>
		<div class="table-title">
			<h2>Leaderboard (All Players)</h2>
			</div>
			<% if (users.size() > 0) { %>
			<table class="table-fill">
				<thead>
				<tr>
					<th class="text-center">Rank</th><th class="text-center">Player</th><th class="text-center">Score</th>
				</tr>
				</thead>
				<tbody class="table-hover">
				<% int i = 1; 
				for(UserBean user : users){ %>
				<tr>
					<td class="text-center"><%= i++ %></td><td class="text-center"><%= user.getUserName() %></td><td class="text-center"><%= user.getHighestScore() %></td>
				</tr>
				<% } %>
				</tbody>
			</table>
			<% } else { %>
				<span>No one has played...</span>
			<% } %>
	</div>
	<footer>
		<div class='container'>
			
			<div class='eight columns'>
				<h5>Some stuff can go here</h5>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
			</div>

			<div class='four columns social'>
				<h5>Tell your friends about us!</h5>
				<a href='#'><img src='css/bg/facebook.png'></a>
				<a href='#'><img src='css/bg/twitter.png'></a>
			</div>

			<div class='four columns'>
				<h5>Having Issues?</h5>
				<p>Call:<br>
					Office Phone: (919) - 555 - 5555</p>
				<p>Or send in an email to:<br>
					Customer Support: <a href='mailto:contact@free.com'>office@recognition.ncsu.edu</a></p>
			</div>


		<a id='top' href='#'>&uarr;</a>	
		</div>
	</footer>
	<script type="text/javascript">
		var toper = $('a#top');


		$(window).scroll(function(){
            if ($(this).scrollTop() > 100) {
                toper.fadeIn( 200 );
            } else {
                toper.fadeOut( 200 );
            }
        });

         toper.click(function(){
        	$('html, body').animate({scrollTop:0}, 500);	        	
        	return false;
    	}); 
	</script>
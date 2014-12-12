	<%@page import="com.istudy.action.HomeAction"%>
	<%@page import="java.util.List" %>
	<%@include file="/global.jsp"%>
	
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="css/skeleton.css">
	<link rel="stylesheet" href="css/layout.css">
	
	<% 
		HomeAction action = new HomeAction(recogFactory);
		List<UserBean> users = action.getAllUsersLB();
	%>
	
	<h2 class="otherPage">Home</h2>
	<hr>
	
	<div class='clear'></div>

	<div class='container'>

		<div class='one-third column'>
			<div class="table-title">
			<h2>Leaderboard (Top Five)</h2>
			</div>
			<% if (users.size() > 0) { %>
			<table class="table-fill">
				<thead>
				<tr>
					<th class="text-left">Player</th><th class="text-left">Score</th>
				</tr>
				</thead>
				<tbody class="table-hover">
				<% for(int i = 0; i < 5; i++){ %>
				<tr>
					<td class="text-left"><%= users.get(i).getUserName() %></td><td class="text-center"><%= users.get(i).getHighestScore() %></td>
				</tr>
				<% } %>
				</tbody>
			</table>
			<% } else { %>
				<span>No one has played...</span>
			<% } %>
		</div>

		<div class='one-third column'>
			<img src="css/bg/profileHolder.jpg" alt="Account Photo" class="accountPhoto">
		</div>
		
		<div class='one-third column'>
			<h3>Chat</h3>
			<p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
		</div>
		
	</div>


	<div class='clear'></div>


	<div class='red'>

		<div class='container'>
			<h3>Instructions</h3>
			<p>Want the know how to play this game? Try out the tutorial below and you will be 
			well on your way! Have fun and enjoy Reconyze.</p>
			<a href='#' class='dalej'>Tutorial</a>
		</div>

	</div>
	<div class='clear'></div>
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


		</div>
	</footer>
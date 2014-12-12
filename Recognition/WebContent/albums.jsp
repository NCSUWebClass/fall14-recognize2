<%@page import="com.istudy.gameparts.Album"%>
<%@page import="com.istudy.gameparts.AlbumDatabase"%>
<%@page import="com.istudy.action.AlbumSelectAction"%>
<%@page import="javax.print.attribute.ResolutionSyntax"%>
<%@page import="java.util.LinkedList" %>
<%@include file="/global.jsp"%>
<link rel="stylesheet" type="text/css" href="css/base.css">
<%
AlbumSelectAction action = new AlbumSelectAction(database);
LinkedList<Album> albums = action.getAllAlbums();
%>
<script type=text/javascript>
function goToGame(albumTitle,uID){
	window.parent.location.href = "play1.jsp?albumtitle="+albumTitle+"&uID="+uID;
}
</script>
<h2 class="otherPage">Choose an Album</h2>
<hr>
	<ul class="albumselect">
		<% int i = 0; %>
		<li><a href="#"> <img src="albumcovers/aliencover.jpg"
				class="albumcover"/> <span class="title" onclick="goToGame('Aliens','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img
				src="albumcovers/animalpatternscover.jpg" 
				class="albumcover" /> <span class="title"  onclick="goToGame('Animal Patterns','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img src="albumcovers/artnartistscover.jpg"
				class="albumcover"/> <span class="title"  onclick="goToGame('Art & Artists','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img src="albumcovers/cartoonshowscover.jpg"
				class="albumcover" /> <span class="title" onclick="goToGame('Cartoon Shows Characters','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img
				src="albumcovers/celebyearbookcover.jpg" class="albumcover" />
				<span class="title" onclick="goToGame('Celebrity Yearbook Photos','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img src="albumcovers/cityskylinescover.jpg"
				class="albumcover"/> <span class="title" onclick="goToGame('City Skylines','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img src="albumcovers/dogscover.jpg"
				class="albumcover" /> <span class="title" onclick="goToGame('Dogs','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img
				src="albumcovers/famousmustachescover.jpg" class="albumcover" />
				<span class="title" onclick="goToGame('Famous Mustaches_','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img
				src="albumcovers/microscopiccover.jpg" class="albumcover" />
				<span class="title" onclick="goToGame('Microscopic','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img src="albumcovers/superheroescover.jpg"
				class="albumcover" /> <span class="title" onclick="goToGame('Superheros','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
		<li><a href="#"> <img src="albumcovers/usflagscover.png"
				class="albumcover" /> <span class="title" onclick="goToGame('USFlags','<%=currentUser.getUID()%>')"><span><%= albums.get(i++).getTitle() %></span></span>
		</a></li>
	</ul>
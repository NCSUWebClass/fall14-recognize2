<%@page import="com.istudy.exception.AlbumFinishedException"%>
<%@page import="com.istudy.util.RecognizeUtil"%>
<%@page import="com.istudy.action.PlayAction2"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/global.jsp"%>

<% 
String selectedAlbumTitle = (String) session.getAttribute("albumTitle");
PlayAction2 action = PlayAction2.getGameInstance(currentUser, database , selectedAlbumTitle);
String randGameTitle = null;
ArrayList<String> generateRandom = null;
try {
	randGameTitle = action.getSelectedAlbum().getRandomSubAlbum();
	generateRandom = action.randomChoiceSeq();
} catch (AlbumFinishedException e){
	%>
	<script>
		alert("Album Finished. Click Finish");
	</script>
	<%
	action.getSelectedAlbum().resetSubAlbums();
	action.reset();
}
%>
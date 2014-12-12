<%@page import="com.istudy.auth.OptionBean"%>
<%@page import="com.istudy.db.RecognitionDBFactory"%>
<%@page import="com.istudy.gameparts.AlbumDatabase"%>
<%@page import="com.istudy.gameparts.AlbumsLoader"%>
<%@page import="com.istudy.gameparts.Album"%>
<%@page import="com.istudy.action.LoginAction"%>
<%@page import="com.istudy.auth.UserBean"%>
<%@page import="com.istudy.deprecated.RecognizeUserManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	String submittedFormName = request.getParameter("formName");
	RecognitionDBFactory recogFactory = RecognitionDBFactory.getProductionInstance();
	//RecognizeUserManager userManager = RecognizeUserManager.getInstance();
	AlbumsLoader albumLoader = new AlbumsLoader();
	AlbumDatabase database = new AlbumDatabase(albumLoader);
	UserBean currentUser = (UserBean) session.getAttribute("currentUser");
	OptionBean currentUserOptions = (OptionBean) session.getAttribute("currentUserOptions");
%>
</head>
<body>
</body>
</html>
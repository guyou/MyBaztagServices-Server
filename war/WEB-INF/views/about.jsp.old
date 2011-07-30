<%@page import="org.aggelos.baztag.api.SimpleNabaztag"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My Baztag Services - A portal of applications dedicated to the Nabaztag</title>
<link rel="stylesheet" type="text/css" href="/resources/style.css" media="screen" />
</head>
<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
%>
<div id="header">
	<div id="logo">
		<h1><a href="/">My Baztag Services</a></h1>
		<% if(user == null) {
			%>
		<p>Qui êtes vous ? <a href="<%= userService.createLoginURL("/") %>">
		 connectez vous ! 
		 </a>
		 </p>
		<%
		}
		else {
		
		%>
		<p>Bonjour, <%= user.getNickname() %>, tu veux peut-être <a href="<%= userService.createLogoutURL("/") %>">te déconnecter ?</a></p>
		<%}%>
	</div>
	<!-- end #logo -->
	<div id="menu">
		<ul>
			<li ><a href="#">Accueil</a></li>
			<li class="active"><a href="/about">Qu'est-ce que c'est ?</a></li>
			<li><a href="#">Contact</a></li>
		</ul>
	</div>
	<!-- end #menu -->
</div>
<!-- end #header -->
<div id="page">
	
	<div id="content">
	<jsp:include page="/WEB-INF/views/inc/about.jsp" />
	</div>
	<!-- end #content -->
	<%if(user!=null) {
		%>
		<jsp:include page="/WEB-INF/views/inc/sidebar/connected.jsp" />
	<% }
	else {%>
		<jsp:include page="/WEB-INF/views/inc/sidebar/disconnected.jsp" />
	<% }%>
	
	
	<!-- end #sidebar -->
</div>
<!-- end #page -->
<div id="footer">
	<p>&copy; 2011, tous droits réservés Clément Arnoux. Design "Customize" par <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>

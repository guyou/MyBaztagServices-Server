<%@page import="org.aggelos.baztag.api.SimpleNabaztag"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>My Baztag Services - A portal of applications dedicated to the Nabaztag</title>
<link rel="stylesheet" type="text/css" href="resources/style.css" media="screen" />
</head>
<body>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
%>
<div id="header">
	<div id="logo">
		<h1><a href="#">My Baztag Services</a></h1>
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
			<li class="active"><a href="#">Accueil</a></li>
			<li><a href="#">Qu'est-ce que c'est ?</a></li>
			<li><a href="#">Nous contacter</a></li>
		</ul>
	</div>
	<!-- end #menu -->
</div>
<!-- end #header -->
<div id="page">
	<jsp:include page="test.jsp" />
	<div id="content">
		<div class="post">
			<h1 class="title">Welcome to our website </h1>
			<p class="byline"><small>Posted by FreeCssTemplates</small></p>
			<div class="entry">
				<p><strong>Customize </strong> is a free template from <a href="http://www.freecsstemplates.org/">Free CSS Templates</a> released under a <a href="http://creativecommons.org/licenses/by/2.5/">Creative Commons Attribution 2.5 License</a>. You're free to use this template for both commercial or personal use. I only ask that you link back to <a href="http://www.freecsstemplates.org/">my site</a> in some way. Enjoy :)</p>
			</div>
			<div class="meta">
				<p class="links"><a href="#" class="comments">Comments (32)</a> &nbsp;&bull;&nbsp;&nbsp; <a href="#" class="more">Read full post &raquo;</a></p>
			</div>
		</div>
		<div class="post">
			<h2 class="title">Lorem Ipsum Dolor Volutpat</h2>
			<p class="byline"><small>Posted by FreeCssTemplates</small></p>
			<div class="entry">
				<p>Curabitur tellus. Phasellus tellus turpis, iaculis in, faucibus lobortis, posuere in, lorem. Donec a ante. Donec neque purus, adipiscing id, eleifend a, cursus vel, odio. Vivamus varius justo sit amet leo. Morbi sed libero. Vestibulum blandit augue at mi. Praesent fermentum lectus eget diam. Nam cursus, orci sit amet porttitor iaculis, ipsum massa aliquet nulla, non elementum mi elit a mauris.</p>
				<p> Praesent fermentum lectus eget diam. Nam cursus, orci sit amet porttitor iaculis, ipsum massa aliquet nulla, non elementum mi elit a mauris.</p>
				<ul>
					<li><a href="#">Magna lacus bibendum mauris</a></li>
					<li><a href="#">Velit semper nisi molestie</a></li>
					<li><a href="#">Magna lacus bibendum mauris</a></li>
					<li><a href="#">Velit semper nisi molestie</a></li>
				</ul>
			</div>
			<div class="meta">
				<p class="links"><a href="#" class="comments">Comments (32)</a> &nbsp;&bull;&nbsp;&nbsp; <a href="#" class="more">Read full post &raquo;</a></p>
			</div>
		</div>
	</div>
	<!-- end #content -->
	<div id="sidebar">
		<div id="sidebar-bgtop"></div>
		<div id="sidebar-content">
			<ul>
				<li>
					<h2>Mes lapins</h2>
					<ul>
						<li><a href="#">Pas de lapin inscrit. En inscrire un ?</a></li>
					</ul>
				</li>
				<li>
					<h2>Mes fonctions</h2>
					<ul>
						<li><a href="#">Inscrire un lapin</a></li>
						<li><a href="#">Liste de mes lapins</a></li>
						<li><a href="#">Liste des applications</a></li>
						<li><a href="#">Editeur de chorégraphies</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="sidebar-bgbtm"></div>
	</div>
	<!-- end #sidebar -->
</div>
<!-- end #page -->
<div id="footer">
	<p>&copy; 2011, tous droits réservés Clément Arnoux. Design "Customize" par <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>.</p>
</div>
<!-- end #footer -->
</body>
</html>

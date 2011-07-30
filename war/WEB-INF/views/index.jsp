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
<div id="header">
	<div id="logo">
		<h1><a href="/">My Baztag Services</a></h1>

	</div>
	<!-- end #logo -->
	<div id="menu">
		<ul>
			<li class="active"><a href="#">Accueil</a></li>
			<li><a href="/about">Qu'est-ce que c'est ?</a></li>
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
</div>
<!-- end #page -->
<div id="footer">
	<p>&copy; 2011, tous droits réservés Clément Arnoux. Design "Customize" par <a href="http://www.freecsstemplates.org/">Free CSS Templates</a>, icone et favicon Nabaztag Icons par <a href="http://tpdkcasimir.deviantart.com/art/Nabaztag-Icons-35572391">TPDKCasimir</a> .</p>
</div>
<!-- end #footer -->
</body>
</html>

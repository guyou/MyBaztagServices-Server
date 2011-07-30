<%@page import="org.aggelos.baztag.model.PNabaztag"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@page import="org.aggelos.baztag.model.Ztamp"%><div id="sidebar">
		<div id="sidebar-bgtop"></div>
		<div id="sidebar-contentù">
			<ul>
				<li>
					<h2>Mes lapins</h2>
					<ul>
						<% 
							List<PNabaztag> tags = (List<PNabaztag>)session.getAttribute("nabaztagList");
							if(tags==null) {
								%>
									<li><a href="/nabaztag/add">Pas de lapin inscrit. En inscrire un ?</a></li>
								<%
							}
							else {
								for(PNabaztag tag:tags) {
									%>
									<li><a href="/nabaztag/info/<%= tag.getKeyAsString() %> "> <%= tag.getName() %></a></li>
									<%
								}
							}
						
						%>
					</ul>
				</li>
				<li>
					<h2>Mes ztamps et nanoztags</h2>
					<ul>
						<% 
							List<Ztamp> ztamps = (List<Ztamp>)session.getAttribute("ztampList");
							if(ztamps==null) {
								%>
									<li>Oh, y en a aucun</li>
								<%
							}
							else {
								for(Ztamp tag:ztamps) {
									%>
									<li><a href="/ztamp/info/<%= tag.getKeyAsString() %> "> <%
										if(tag.getName()!=null) {
											%>
											<%= tag.getName() %>
											<%
										}
										else {
											%>
											Oh ? mais qui c'est ?
											<%
										}
										%></a></li>
									<%
								}
							}
						
						%>
					</ul>
				</li>
				<li>
					<h2>Mes fonctions</h2>
					<ul>
						<li><a href="/nabaztag/add">Inscrire un lapin</a></li>
						<li><a href="#">Liste de mes objets</a></li>
						<li><a href="#">Liste des applications</a></li>
						<li><a href="#">Editeur de chorégraphies</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="sidebar-bgbtm"></div>
	</div>
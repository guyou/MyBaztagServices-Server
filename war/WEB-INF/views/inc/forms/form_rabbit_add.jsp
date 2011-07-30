<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="post">
<c:if test="${not empty errorMsg }">
<div class="meta"><c:out value="errormsg" />
				<p class="links"></p>
			</div>
			</c:if>
<h1 class="title">Ajouter un lapin</h1>
<p class="byline"><small>Les informations suivantes sont obligatoires</small></p>
<div class="entry">
	<form:form commandName="api" action="/nabaztag/add" method="post">
	<fieldset>
		<h2>Serial Number (MAC) </h2>
		<form:input path="serialNumber"/>
		<p class="byline"><small>Se trouve sous le lapin</small></p>
		
		<input type="submit" id="x" value="Ajouter" />
	</form:form>
	
	
</div>
</div>
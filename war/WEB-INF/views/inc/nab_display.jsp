<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="post">
<h1 class="title"><c:out value="${tag.name}" /></h1>
<div class="entry">
	<p>${tag.signature}</p>
	${tag.awake }
	<c:if test="${tag.awake}" >Ah, il est réveillé. <a href="/nabaztag/changeState">Lui dire de dormir ?</a></c:if>
	<c:if test="${not tag.awake}" >Ah, il dort ! <a href="/nabaztag/changeState">Le révéiller ?</a></c:if>
	
</div>
<div class="meta">
				<p class="links"><a href="/nabaztag/delete/${ptag.keyAsString }" class="comments">Supprimer ce nabaztag</a></p>
			</div>
</div>
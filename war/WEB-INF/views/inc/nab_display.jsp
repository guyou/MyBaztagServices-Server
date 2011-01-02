<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="post">
<h1 class="title"><c:out value="${tag.name}" /></h1>
<div class="entry">
	<p>${tag.signature}</p>
</div>
<div class="meta">
				<p class="links"><a href="/nabaztag/delete/${ptag.keyAsString }" class="comments">Supprimer ce nabaztag</a></p>
			</div>
</div>
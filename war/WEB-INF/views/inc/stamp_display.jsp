<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="post">
<h1 class="title">
<c:if test="${empty ztamp.name }">
	????????	
</c:if>
<c:if test="${not empty ztamp.name }">
	<c:out value="${ztamp.name}" />	
</c:if>
- <c:out value="${ztamp.serialNumber}" />
</h1>
<div class="entry">
<form:form  commandName="formZtamp" action="/ztamp/update"  method="post">
	<input type="hidden" name="key" value="${ztamp.keyAsString}" />
	Changer le nom : <input name="name"/><input type="submit" id="x" value="ok" />
	</form:form>

</div>
<div class="meta">
				<p class="links"><a href="/ztamp/delete/${ztamp.keyAsString }" class="comments">Supprimer ce Ztamp</a></p>
			</div>
</div>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="post">
<h1 class="title"><c:out value="${tagToDelete.name}" /></h1>
<div class="entry">
	<p>Etes vous absolument sur(e) de vouloir enlever ${tagToDelete.name} de votre compte (attention, pas de retour en arrière possible !!!)</p>
	<form action="/nabaztag/delete/${tagToDelete.keyAsString }" method="post">
	<input type="submit" value="Je suis absolument sur(e) de vouloir retirer ce lapin">
	</form>
</div>
</div>
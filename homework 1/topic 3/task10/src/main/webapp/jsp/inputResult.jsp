<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<h1>Name: <c:out value="${userInfo.name}"/></h1>
<h1>Phone: <c:out value="${userInfo.phone}"/></h1>
<h1>E-mail: <c:out value="${userInfo.email}"/></h1>
</form>
</html>
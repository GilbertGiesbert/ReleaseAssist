<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta
	http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1">

<link
	href="<c:url value="/css/main.css"/>"
	rel="stylesheet">
<script src="<c:url value="/js/main.js"/>"></script>

<title>Release Build</title>
</head>
<body>

	<div class="pageRow">
		<div class="pageColumnLeft"></div>
		<div class="pageColumnRight">
			<jsp:include page="homeButton.jsp" />
			<h1>Release Build</h1>
		</div>
	</div>

</body>
</html>
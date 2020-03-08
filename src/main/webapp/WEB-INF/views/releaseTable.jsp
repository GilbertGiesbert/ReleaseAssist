<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="message" var="messageBundle" />
<fmt:message key="pages.releaseTable.title" bundle="${messageBundle}" var="pageTitle"/>

<html>
	<jsp:include page="head.jsp" >
		<jsp:param name="pageTitle" value="${pageTitle}"/>
	</jsp:include>
	<body>	
		<div class="pageRow">
			<div class="pageColumnLeft"></div>
			<div class="pageColumnCenter">
				<jsp:include page="languageSwitch.jsp" />
				<jsp:include page="homeButton.jsp" />
				<h1>${pageTitle}</h1>
			</div>
		</div>
	</body>
</html>
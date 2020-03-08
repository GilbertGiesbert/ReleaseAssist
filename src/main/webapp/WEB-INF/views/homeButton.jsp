<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="message" var="messageBundle" />

<p>
	<a href="${pageContext.request.contextPath}">
		<img title="<fmt:message key="common.homeButton.title" bundle="${messageBundle}"/>"
					src="<c:url value="/images/home.png"/>" width="48px">
	</a>
</p>
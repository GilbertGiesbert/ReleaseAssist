<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="showHomeButton" value="${empty param.showHomeButton ? true : empty param.showHomeButton}" />

<div class="titleRow">
	<jsp:include page="languageSwitch.jsp" />
	<c:if test="${showHomeButton}">
		<jsp:include page="homeButton.jsp" />
	</c:if>
	<h1>${param.pageTitle}</h1>
</div>
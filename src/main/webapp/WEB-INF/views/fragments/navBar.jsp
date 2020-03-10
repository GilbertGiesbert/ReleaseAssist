<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<nav class="navbar navbar-light bg-light">

	<a class="navbar-brand" href="${pageContext.request.contextPath}">
		<img class="homeIcon" title="<spring:message code="common.homeIcon.title" />" src="<c:url value="/images/home.png"/>" >
	</a>
	<span>
		<a href="?lang=de">
			<img class="flagIcon" title="<spring:message code="common.flagIcon.title.de" />" src="<c:url value="/images/flag-germany-rect.png"/>">
		</a>
		&nbsp;
		<a href="?lang=en">
			<img class="flagIcon" title="<spring:message code="common.flagIcon.title.en" />" src="<c:url value="/images/flag-usa-rect.png"/>">
		</a>
	</span>
</nav>
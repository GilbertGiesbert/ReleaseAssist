<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="common.homeIcon.title" var="buttonTitle"/>
<c:url value="/images/home.png" var="buttonTitleUrl"/>


<a class="homeLink" href="${pageContext.request.contextPath}">
	<img class="homeIcon" title="${buttonTitle}" src="${buttonTitleUrl}">
</a>
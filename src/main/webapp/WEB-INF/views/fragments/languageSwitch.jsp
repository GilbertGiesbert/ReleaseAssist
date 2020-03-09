<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<p class="flagContainer">

	<spring:message code="common.languageSwitch.de" var="imgTitle"/>
	<c:url value="/images/flag-germany-rect.png" var="imgUrl"/>
	<a href="?lang=de">	
		<img class="flagIcon" title="${imgTitle}" src="${imgUrl}" >
	</a>
	&nbsp;
	<spring:message code="common.languageSwitch.en" var="imgTitle"/>
	<c:url value="/images/flag-usa-rect.png" var="imgUrl"/>
	<a href="?lang=en">
		<img class="flagIcon" title="${imgTitle}" src="${imgUrl}" >
	</a>
</p>
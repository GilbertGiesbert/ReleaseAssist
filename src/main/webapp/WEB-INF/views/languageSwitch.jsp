<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="message" var="messageBundle" />

<p class="flagContainer">
	<a href="?lang=de">
		<img class="flagIcon" title="<fmt:message key="common.languageSwitch.de" bundle="${messageBundle}"/>"
				src="<c:url value="/images/flag-germany-rect.png"/>" >
	</a>
	&nbsp;
	<a href="?lang=en">
		<img class="flagIcon" title="<fmt:message key="common.languageSwitch.en" bundle="${messageBundle}"/>"
				src="<c:url value="/images/flag-usa-rect.png"/>" >
	</a>
</p>
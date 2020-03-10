<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="ariaDescribedBy" value="" />
<c:if test="${not empty param.fieldHelpText}">
	<c:set var="ariaDescribedBy">
		aria-describedby="${param.fieldName}Help"
	</c:set>
</c:if>

<div class="form-group">
	<spring:bind path="${param.fieldName}">
		<label for="${param.fieldName}"><spring:message code="${param.fieldLabelKey}"/></label>
		<form:errors path="${param.fieldName}" />
		<c:set var="errorClass" value="${status.error ? 'is-invalid' : ''}" />
		<form:input path="${param.fieldName}" type="${param.fieldType}" class="form-control ${errorClass}" aria-describedby="${param.fieldName}Help"/>
		<c:if test="${not empty param.fieldHelpText}">
			<small id="${param.fieldName}Help" class="form-text text-muted">${param.fieldHelpText}</small>
		</c:if>
	</spring:bind>
</div>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="pages.releaseTable.title" var="pageTitle"/>

<html>
	<jsp:include page="fragments/head.jsp" >
		<jsp:param name="pageTitle" value="${pageTitle}"/>
	</jsp:include>
	<body>	
		<div class="pageRow">
			<div class="pageColumnLeft"></div>
			<div class="pageColumnCenter">
			
				<jsp:include page="fragments/titleRow.jsp" >
					<jsp:param name="pageTitle" value="${pageTitle}"/>
				</jsp:include>
				
				
				<spring:url value="/release-table" var="formUrl" />
				<form:form method="post" modelAttribute="form" action="${formUrl}">
	
					<spring:bind path="jiraUserName">
						<form:input path="jiraUserName" type="text" />
						<form:errors path="jiraUserName" />
					</spring:bind>
					
					<spring:bind path="jiraPassword">
						<form:input path="jiraPassword" type="text" />
						<form:errors path="jiraPassword" />
					</spring:bind>
					
					<button type="submit" >Submit</button>
	
				</form:form>
				
			</div>
		</div>
	</body>
</html>
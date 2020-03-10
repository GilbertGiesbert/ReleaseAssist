<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="pages.releaseBuild.title" var="pageTitle"/>

<html>
	<jsp:include page="fragments/head.jsp" >
		<jsp:param name="pageTitle" value="${pageTitle}"/>
	</jsp:include>
	<body>	
		<div class="pageRow">
			<div class="pageColumnLeft"></div>
			<div class="pageColumnCenter">
			
			
			<jsp:include page="fragments/navBar.jsp" />
				
				<jsp:include page="fragments/titleRow.jsp" >
					<jsp:param name="pageTitle" value="${pageTitle}"/>
				</jsp:include>
				
				<!-- show global errors -->
				<spring:hasBindErrors name="form">
					<div class="alert alert-danger">
						<form:errors path="form" />
					</div>
				</spring:hasBindErrors>
	
				<spring:url value="/release-build" var="formUrl" />
				<form:form method="post" modelAttribute="form" action="${formUrl}">
	
					<spring:bind path="gitLabUserName">
						<form:input path="gitLabUserName" type="text" />
						<form:errors path="gitLabUserName" />
					</spring:bind>
					
					<spring:bind path="gitLabPassword">
						<form:input path="gitLabPassword" type="text" />
						<form:errors path="gitLabPassword" />
					</spring:bind>
					
					<button type="submit" >Submit</button>
	
				</form:form>

			</div>
		</div>
	</body>
</html>
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
				
				<!-- show global errors -->
				<spring:hasBindErrors name="form">
					<div class="alert alert-danger">
						<form:errors path="form" />
					</div>
				</spring:hasBindErrors>
				
				<spring:url value="/release-table" var="formUrl" />
				<form:form method="post" modelAttribute="form" action="${formUrl}">
	
					<div class="form-group">
						<spring:bind path="jiraUserName">
							<label for="jiraUserName"><spring:message code="pages.releaseTable.form.jiraUserName"/></label>
							<form:errors path="jiraUserName" />
							<c:set var="errorClass" value="${status.error ? 'is-invalid' : ''}" />
							<form:input path="jiraUserName" type="text" class="form-control ${errorClass}"/>
						</spring:bind>
					</div>
					
					<div class="form-group">
						<spring:bind path="jiraPassword">
							<label for="jiraPassword"><spring:message code="pages.releaseTable.form.jiraPassword"/></label>
							<form:errors path="jiraPassword" />
							<c:set var="errorClass" value="${status.error ? 'is-invalid' : ''}" />
							<form:input path="jiraPassword" type="password" class="form-control ${errorClass}"/>
						</spring:bind>
					</div>
					
					<div class="form-group">
						<spring:bind path="lastReleaseBranchName">
							<label for="lastReleaseBranchName"><spring:message code="pages.releaseTable.form.lastReleaseBranchName"/></label>
							<form:errors path="lastReleaseBranchName" />
							<c:set var="errorClass" value="${status.error ? 'is-invalid' : ''}" />
							<form:input path="lastReleaseBranchName" type="text" class="form-control ${errorClass}" aria-describedby="lastReleaseBranchNameHelp"/>
							<small id="lastReleaseBranchNameHelp" class="form-text text-muted">Bli bla blubb.</small>
						</spring:bind>
					</div>
					
					<button type="submit" class="btn btn-primary float-right">Submit</button>
	
				</form:form>
				
			</div>
		</div>
	</body>
</html>
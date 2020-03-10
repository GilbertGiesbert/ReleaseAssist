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
		<div class="container">
			<div class="row">
			    <div class="col"></div>
			    <div class="col-8">
			    
				    <jsp:include page="fragments/navBar.jsp" />
  					<h1 class="subpageHeadline">${pageTitle}</h1>
					
					<!-- show global errors -->
					<spring:hasBindErrors name="releaseTableForm">
						<div class="alert alert-danger">
							<form:errors path="releaseTableForm" />
						</div>
					</spring:hasBindErrors>
					
					<spring:url value="/release-table" var="formUrl" />
					<form:form method="post" modelAttribute="releaseTableForm" action="${formUrl}">
		
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
								<spring:message code="common.example.abbreviated" var="example"/>
								<spring:eval var="applicationProperty" expression="@environment.getProperty('pages.releaseTable.form.lastReleaseBranchName.example')"/>
								<small id="lastReleaseBranchNameHelp" class="form-text text-muted">${example}: ${applicationProperty}</small>
							</spring:bind>
						</div>
						
						<button type="submit" class="btn btn-primary float-right">
							<spring:message code="pages.releaseTable.form.submit"/>
						</button>
		
					</form:form>
				
				</div>
				<div class="col"></div>
			</div>
		</div>
	</body>
</html>
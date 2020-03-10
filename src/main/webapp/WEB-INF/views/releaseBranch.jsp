<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="pages.releaseBranch.title" var="pageTitle"/>

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
					<spring:hasBindErrors name="releaseBranchForm">
						<div class="alert alert-danger">
							<form:errors path="releaseBranchForm" />
						</div>
					</spring:hasBindErrors>
		
					<spring:url value="/release-branch" var="formUrl" />
					<form:form method="post" modelAttribute="releaseBranchForm" action="${formUrl}">
					
						<div class="form-group">
							<spring:bind path="gitLabUserName">
								<label for="gitLabUserName"><spring:message code="pages.releaseBranch.form.gitLabUserName"/></label>
								<form:errors path="gitLabUserName" />
								<c:set var="errorClass" value="${status.error ? 'is-invalid' : ''}" />
								<form:input path="gitLabUserName" type="text" class="form-control ${errorClass}"/>
							</spring:bind>
						</div>
						
						<div class="form-group">
							<spring:bind path="gitLabPassword">
								<label for="gitLabPassword"><spring:message code="pages.releaseBranch.form.gitLabPassword"/></label>
								<form:errors path="gitLabPassword" />
								<c:set var="errorClass" value="${status.error ? 'is-invalid' : ''}" />
								<form:input path="gitLabPassword" type="password" class="form-control ${errorClass}"/>
							</spring:bind>
						</div>
						
						<button type="submit" class="btn btn-primary float-right">
							<spring:message code="pages.releaseBranch.form.submit"/>
						</button>
		
					</form:form>
				</div>
				<div class="col"></div>
			</div>
		</div>
	</body>
</html>
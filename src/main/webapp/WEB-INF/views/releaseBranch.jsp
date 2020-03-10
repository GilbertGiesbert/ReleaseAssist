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
					
						<jsp:include page="fragments/inputField.jsp" >
							<jsp:param name="fieldName" value="releaseBranchName"/>
							<jsp:param name="fieldLabelKey" value="pages.releaseBranch.form.releaseBranchName"/>
							<jsp:param name="fieldType" value="text"/>
						</jsp:include>
					
						<jsp:include page="fragments/inputField.jsp" >
							<jsp:param name="fieldName" value="gitLabUserName"/>
							<jsp:param name="fieldLabelKey" value="pages.releaseBranch.form.gitLabUserName"/>
							<jsp:param name="fieldType" value="text"/>
						</jsp:include>
						
						<jsp:include page="fragments/inputField.jsp" >
							<jsp:param name="fieldName" value="gitLabPassword"/>
							<jsp:param name="fieldLabelKey" value="pages.releaseBranch.form.gitLabPassword"/>
							<jsp:param name="fieldType" value="password"/>
						</jsp:include>
						
						<jsp:include page="fragments/inputField.jsp" >
							<jsp:param name="fieldName" value="revertList"/>
							<jsp:param name="fieldLabelKey" value="pages.releaseBranch.form.revertList"/>
							<jsp:param name="fieldType" value="text"/>
						</jsp:include>
						
						<jsp:include page="fragments/inputField.jsp" >
							<jsp:param name="fieldName" value="initDocumentationReleasePageUrl"/>
							<jsp:param name="fieldLabelKey" value="pages.releaseBranch.form.initDocumentationReleasePageUrl"/>
							<jsp:param name="fieldType" value="text"/>
						</jsp:include>
						
						<jsp:include page="fragments/inputField.jsp" >
							<jsp:param name="fieldName" value="initDocumentationUserName"/>
							<jsp:param name="fieldLabelKey" value="pages.releaseBranch.form.initDocumentationUserName"/>
							<jsp:param name="fieldType" value="text"/>
						</jsp:include>
						
						<jsp:include page="fragments/inputField.jsp" >
							<jsp:param name="fieldName" value="initDocumentationPassword"/>
							<jsp:param name="fieldLabelKey" value="pages.releaseBranch.form.initDocumentationPassword"/>
							<jsp:param name="fieldType" value="password"/>
						</jsp:include>

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
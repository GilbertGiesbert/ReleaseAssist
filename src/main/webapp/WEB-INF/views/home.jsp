<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="pages.home.title" var="pageTitle"/>

<html>
	
	<jsp:include page="fragments/head.jsp" >
		<jsp:param name="pageTitle" value="${pageTitle}"/>
	</jsp:include>

	<body>
	
		<div class="container">
			<div class="row">
			    <div class="col"></div>
			    <div class="col-9">
			    	
			    	<jsp:include page="fragments/navBar.jsp" />
					
					
					<h1 class="homepageHeadline">${pageTitle}</h1>
					<hr class="homepageHr">
					
					
	
					<div class="container">
						<div class="row justify-content-md-center">
							
							<div class="col-4">
								<a href="release-table" class="btn btn-primary btn-block" role="button">
									<spring:message code="pages.home.link.releaseTable" />
								</a>
							</div>
							<div class="col-2"></div>
							<div class="col-4">
								<a href="release-build" class="btn btn-primary btn-block" role="button">
									<spring:message code="pages.home.link.releaseBuild" />
								</a>	
							</div>
							
						</div>
					</div>
					
				</div>
				<div class="col"></div>
			</div>
		</div>
	
	</body>
</html>
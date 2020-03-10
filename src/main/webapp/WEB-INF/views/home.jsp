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
					
					  <div class="jumbotron">
					    <h1 class="display-4">${pageTitle}</h1>
					    <hr class="my-4">
					    <p class="lead">This web app is meant to support <a href="#">bloa blubb</a>.</p>
					  </div>
	
					<div class="container">
						<div class="row">
							<div class="col-1"></div>
							<div class="col-4">
								<ul class="list-group">
									<li class="list-group-item list-group-item-action">
										<a href="release-table">
											<spring:message code="pages.home.link.releaseTable" />
										</a>
									</li>
									<li class="list-group-item list-group-item-action">
										<a href="release-build">
											<spring:message code="pages.home.link.releaseBuild" />
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col"></div>
			</div>
		</div>
	
	</body>
</html>
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
	
		<div class="pageRow">
		    <div class="pageColumnLeft"></div>
		    <div class="pageColumnCenter">
		    	<jsp:include page="fragments/titleRow.jsp" >
					<jsp:param name="pageTitle" value="${pageTitle}"/>
					<jsp:param name="showHomeButton" value="${false}"/>
				</jsp:include>
		        <p>
		            <a href="release-table"><spring:message code="pages.home.link.releaseTable"/></a>
		        </p>
		        <p>
		            <a href="release-build"><spring:message code="pages.home.link.releaseBuild"/></a>
		        </p>
		    </div>
		    <div class="pageColumnRight"></div>
		</div>
	
	</body>
</html>
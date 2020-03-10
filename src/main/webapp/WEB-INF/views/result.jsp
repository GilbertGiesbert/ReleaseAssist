<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="pages.result.${resultType}.${resultSuccess ? 'success' : 'error'}Title" var="pageTitle"/>

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
					<h1 class="subpageHeadline">${pageTitle}</h1>
					
					<div class="alert alert-${resultSuccess ? 'success' : 'danger'}">
						<p>
							<spring:message code="pages.result.${resultType}.${resultSuccess ? 'success' : 'error'}Message" />
						</p>
					</div>
					
					<c:if test="${not empty resultContent }">
						<h2>
							<spring:message code="pages.result.resultContent.${resultSuccess ? 'success' : 'error'}"/>:
						</h2>
						<p>
							${resultContent}
						</p>
					</c:if>

				</div>
				<div class="col"></div>
			</div>
		</div>
	</body>
</html>
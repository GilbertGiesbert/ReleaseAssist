<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1" %>
<%@taglib
        prefix="c"
        uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<fmt:setBundle basename="message" var="messageBundle" />

<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="<c:url value="/webjars/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/js/main.js"/>"></script>
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
    <title>ReleaseAssist</title>

</head>
<body>


<div class="pageRow">
    <div class="pageColumnLeft"></div>
    <div class="pageColumnRight">
        <a href="<c:url value="/?lang=de"/>">Deutsch</a>
        <br>
        <a href="<c:url value="/?lang=en"/>">Englisch</a>
        <h1 id="myTitle"><fmt:message key="pages.home.title" bundle="${messageBundle}"/></h1>
        <p>
            <a href="release-table"><fmt:message key="pages.releaseTable.title" bundle="${messageBundle}"/></a>
        </p>
        <p>
            <a href="release-build"><fmt:message key="pages.releaseBuild.title" bundle="${messageBundle}"/></a>
        </p>
        check ${pageContext.request.locale}
    </div>
</div>



</body>
</html>
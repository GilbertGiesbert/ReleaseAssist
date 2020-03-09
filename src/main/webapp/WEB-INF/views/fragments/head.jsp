<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
        language="java"
        contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"
        trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="<c:url value="/webjars/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/js/main.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
    <title>${param.pageTitle}</title>
</head>
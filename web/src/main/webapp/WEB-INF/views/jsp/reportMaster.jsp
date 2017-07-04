<%@page session="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Spring MVC 4 + Ajax Hello World</title>
    <c:url var="home" value="/" scope="request"/>

    <spring:url value="/resources/core/css/reportMaster.css" var="coreCss"/>
    <spring:url value="/resources/core/img/" var="img"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>

    <spring:url value="/resources/core/js/bootstrap.min.js"
                var="bootstrapJs"/>
    <spring:url value="/resources/core/js/jquery-3.2.1.js"
                var="jqueryJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
</head>

<body>
<%@ include file="module/main/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-xs-6">
            <h3 class="text-center">Выбор должностей</h3>
            <div class="well" style="max-height: 600px;overflow: auto;">
                <ul class="list-group checked-list-box">
                    <c:forEach items="${positions}" var="position">
                        <li class="list-group-item">${position}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
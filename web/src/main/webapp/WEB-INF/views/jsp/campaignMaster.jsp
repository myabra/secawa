<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Управление обучающими кампаниями</title>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/core/js/jquery-3.2.1.js" var="jqueryJs"/>
    <spring:url value="/resources/core/js/bootstrap.js" var="bootstrapJs"/>
    <spring:url value="/resources/custom/js/campaignMaster.js" var="viewJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${viewJs}"></script>
</head>
<body>
<%@ include file="module/main/navbar.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-xs-10">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Дата создания</th>
                    <th>Автор</th>
                    <th>Кампания действующая</th>
                    <th>Материалы</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${campaigns}" var="campaign">
                    <tr data-id="${campaign.id}">
                        <td>${campaign.name}</td>
                        <td class="center"><fmt:formatDate value='${campaign.creationDate}' var='creationDate' type='date' pattern='dd-MM-yyyy'/>${creationDate}</td>
                        <td class="center">${campaign.createdBy}</td>
                        <td class="center">${(campaign.isActive == 'true') ? 'да' : 'нет'}</td>
                        <td class="center">${campaign.fileName}</td>
                        <td class="center"><span class="glyphicon glyphicon-pencil" aria-hidden="true"><a
                                href="#">Редактировать</a></span>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="clearfix"></div>

        <div class="col-xs-10">
            <form id="create-campaign">
                <div class="form-group">
                    <label for="new-campaign-name">Название</label>
                    <input type="text" class="form-control" id="new-campaign-name" placeholder="Название кампании">
                </div>
                <div class="form-group">
                    <label for="new-campaign-file">Материалы тестирования</label>
                    <input type="file" id="new-campaign-file">
                </div>
                <button type="submit" class="btn btn-default">Готово</button>
            </form>
        </div>
    </div>

</div>
</body>
</html>

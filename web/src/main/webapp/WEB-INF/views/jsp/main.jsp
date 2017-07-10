<%@page session="false" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>KraftLab Security Awareness Home</title>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/resources/core/js/jquery-3.2.1.js" var="jqueryJs"/>
    <spring:url value="/resources/core/js/bootstrap.js" var="bootstrapJs"/>
    <spring:url value="/resources/custom/js/main.js" var="viewJs"/>
    <script src="${jqueryJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${viewJs}"></script>
</head>

<body>
<!-- start: Header -->
<%@ include file="module/main/navbar.jsp" %>
<!-- start: Header -->

<div class="container">
    <div class="row">
        <div class="col-xs-5">
            <div>
                <h2>Вся Компания</h2>
            </div>
            <div class="box-content">
                <div class="progress">
                    <div class="bar progress-bar progress-warning" role="progressbar" aria-valuenow="40"
                         aria-valuemin="0" aria-valuemax="100" style="width:40%">
                        Общее 40%
                    </div>
                </div>
                <div class="progress">
                    <div class="bar progress-bar progress-success" role="progressbar" aria-valuenow="40"
                         aria-valuemin="0" aria-valuemax="100" style="width:100%">
                        Информировано ${overallReport.informedPercent}%
                    </div>
                </div>
                <div class="progress">
                    <div class="bar progress-bar progress-info" role="progressbar" aria-valuenow="40"
                         aria-valuemin="0" aria-valuemax="100" style="width:20%">
                        Тестирование ${overallReport.testedPercent}%
                    </div>
                </div>
                <div class="progress">
                    <div class="bar progress-bar progress-danger" role="progressbar" aria-valuenow="40"
                         aria-valuemin="0" aria-valuemax="100" style="width:10%">
                        Контроль ${overallReport.controlPercent}%
                    </div>
                </div>
                <div class="circleStatsItemBox green">
                    <div class="header"> Средний балл</div>
                    <div class="circleStat">
                        <span>${overallReport.averageScore}</span>
                    </div>
                    <div class="footer">
                        <span class="number">Протестировано сотрудников: ${overallReport.employeeCount}</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="clearfix"></div>

        <c:forEach items="${departmentReports}" var="report">
            <div class="col-xs-4">
                <div>
                    <h2>${report.departmentName}</h2>
                </div>
                <div class="box-content">
                    <div class="progress">
                        <div class="bar progress-bar progress-warning" role="progressbar" aria-valuenow="40"
                             aria-valuemin="0" aria-valuemax="100" style="width:40%">
                            Общее 40%
                        </div>
                    </div>
                    <div class="progress">
                        <div class="bar progress-bar progress-success" role="progressbar" aria-valuenow="40"
                             aria-valuemin="0" aria-valuemax="100" style="width:${report.informedPercent}%">
                            Информировано ${report.informedPercent}%
                        </div>
                    </div>
                    <div class="progress">
                        <div class="bar progress-bar progress-info" role="progressbar" aria-valuenow="40"
                             aria-valuemin="0" aria-valuemax="100" style="width:${report.testedPercent}%">
                            Тестирование ${report.testedPercent}%
                        </div>
                    </div>
                    <div class="progress">
                        <div class="bar progress-bar progress-danger" role="progressbar" aria-valuenow="40"
                             aria-valuemin="0" aria-valuemax="100" style="width:${report.controlPercent}%">
                            Контроль ${report.controlPercent}%
                        </div>
                    </div>
                    <div class="circleStatsItemBox green">
                        <div class="header"> Средний балл</div>
                        <div class="circleStat">
                            <span>${report.averageScore}</span>
                        </div>
                        <div class="footer">
                            <span class="number">Протестировано сотрудников: ${report.employeeCount}</span>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="row">
        <div class="col-xs-10">
            <div>
                <h2>Сотрудники</h2>
            </div>
            <div>
                <table class="table" id="employees">
                    <thead>
                    <tr>
                        <th>ФИО</th>
                        <th>Подразделение</th>
                        <th>Должность</th>
                        <th>Руководитель</th>
                        <th>Тест</th>
                        <th>Контроль</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employees}" var="employee">
                        <tr>
                            <td>${employee.displayName}</td>
                            <td class="center">${employee.department}</td>
                            <td class="center">${employee.position}</td>
                            <td class="center">${employee.manager}</td>
                            <td class="center">100</td>
                            <td class="center">10</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

    <div class="row">

        <div class="col-xs-8">
            <div>
                <div class="box-header">
                    <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>Подразделения
                    </h2>
                    <div class="box-icon">
                        <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                        <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                        <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                    </div>
                </div>
                <div class="box-content">
                    <table class="table" id="departments">
                        <thead>
                        <tr>
                            <th>Подразделение</th>
                            <th>Обучение</th>
                            <th>Тест</th>
                            <th>Контроль</th>
                            <th>Общее</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${departments}" var="department">
                            <tr>
                                <td>${department.name}</td>
                                <td class="center">100</td>
                                <td class="center">80</td>
                                <td class="center">10</td>
                                <td class="center">68</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href="#" data-page="1">1</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<%--<div class="span3 statbox purple" onTablet="span6" onDesktop="span3">
    <div class="boxchart">0,1,3,2,7,10</div>
    <div class="number">10<i class="icon-arrow-up"></i></div>
    <div class="title">Активные</div>
    <div class="footer">
        <a href="#"> Отчет</a>
    </div>
</div>
<div class="span3 statbox green" onTablet="span6" onDesktop="span3">
    <div class="boxchart">1,2,6,4,0,8,2,4,5,3,1,7,5</div>
    <div class="number">3<i class="icon-arrow-up"></i></div>
    <div class="title">Остановленные</div>
    <div class="footer">
        <a href="#"> Отчет</a>
    </div>
</div>
<div class="span3 statbox blue noMargin" onTablet="span6" onDesktop="span3">
    <div class="boxchart">5,6,7,2,0,-4,-2,4,8,2,3,3,2</div>
    <div class="number">5<i class="icon-arrow-up"></i></div>
    <div class="title">Завершенные</div>
    <div class="footer">
        <a href="#"> Отчет</a>
    </div>
</div>
<div class="span3 statbox yellow" onTablet="span6" onDesktop="span3">
    <div class="boxchart">7,2,2,2,1,-4,-2,4,8,,0,3,3,5</div>
    <div class="number">32<i class="icon-arrow-down"></i></div>
    <div class="title">Сотрудники</div>
    <div class="footer">
        <a href="#"> Отчет</a>
    </div>
</div>

</div>--%>

</body>
</html>


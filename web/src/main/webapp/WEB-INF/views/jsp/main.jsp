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
    <!-- end: Meta -->
    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <%@ include file="module/include/css.jsp" %>

</head>

<body>
<!-- start: Header -->
<%@ include file="module/main/navbar.jsp" %>
<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <%@ include file="module/main/leftmenu.jsp" %>
        <!-- end: Main Menu -->

        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span10">


            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="login">Вход</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="main">Рабочий стол</a></li>
            </ul>

            <div class="row-fluid sortable ui-sortable">

                <div class="span3 statbox purple" onTablet="span6" onDesktop="span3">
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

            </div>
            <div class="row-fluid sortable ui-sortable circleStats">
                <div class="box span3">
                    <div class="box-header">
                        <h2><i class="halflings-icon white white tasks"></i><span class="break"> Вся Компания</span>
                        </h2>
                        <div class="box-icon">
                            <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                            <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                            <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                        </div>
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
                                <%--<div style="width:120px;display:inline;&quot;">--%>
                                <input type="text" value="${overallReport.averageScore}" class="whiteCircle"
                                       readonly="readonly" style="width: 60px; position: absolute;
                                       margin-top: 42.8571px; margin-left: -90px; font-size: 30px; border: none;
                                       background: none; font-family: Arial; font-weight: bold;
                                       text-align: center; color: rgba(255, 255, 255, 0.901961); padding: 0px;
                                        -webkit-appearance: none;">
                                <%--</div>--%>
                            </div>
                            <div class="footer">
							<span class="count">
								<span class="number">120</span>
								<span class="unit"></span>
							</span>
                                <span class="sep"> / </span>
                                <span class="value">
								<span class="number">${overallReport.employeeCount}</span>
								<span class="unit"></span>
							</span>
                            </div>
                        </div>
                    </div>
                </div>
                <c:forEach items="${departmentReports}" var="report">
                    <div class="box span3">
                        <div class="box-header">
                            <h2><i class="halflings-icon white white tasks"></i><span
                                    class="break">${report.departmentName}</span>
                            </h2>
                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                            </div>
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
                                        <%--<div style="width:120px;display:inline;&quot;">--%>
                                    <input type="text" value="${report.averageScore}" class="whiteCircle"
                                           readonly="readonly" style="width: 60px; position: absolute;
                                       margin-top: 42.8571px; margin-left: -90px; font-size: 30px; border: none;
                                       background: none; font-family: Arial; font-weight: bold;
                                       text-align: center; color: rgba(255, 255, 255, 0.901961); padding: 0px;
                                        -webkit-appearance: none;">
                                        <%--</div>--%>
                                </div>
                                <div class="footer">
							<span class="count">
								<span class="number">120</span>
								<span class="unit"></span>
							</span>
                                    <span class="sep"> / </span>
                                    <span class="value">
								<span class="number">${report.employeeCount}</span>
								<span class="unit"></span>
							</span>
                                    </br>
                                    <span>Отчет</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="row-fluid sortable ui-sortable">
                <div class="box span8">
                    <div class="box-header">
                        <h2><i class="halflings-icon white align-justify"></i><span class="break"></span>Сотрудники</h2>
                        <div class="box-icon">
                            <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                            <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                            <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                        </div>
                    </div>
                    <div class="box-content">
                        <table class="table">
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
                            <tr>
                                <td>Безкровный А.А</td>
                                <td class="center">ОИБ</td>
                                <td class="center">Специалист</td>
                                <td class="center">Суслов О.А.</td>
                                <td class="center">100</td>
                                <td class="center">10</td>
                            </tr>
                            <tr>
                                <td>Безкровный А.А</td>
                                <td class="center">ОИБ</td>
                                <td class="center">Специалист</td>
                                <td class="center">Суслов О.А.</td>
                                <td class="center">100</td>
                                <td class="center">10</td>
                            </tr>
                            <tr>
                                <td>Безкровный А.А</td>
                                <td class="center">ОИБ</td>
                                <td class="center">Специалист</td>
                                <td class="center">Суслов О.А.</td>
                                <td class="center">100</td>
                                <td class="center">10</td>
                            </tr>
                            <tr>
                                <td>Безкровный А.А</td>
                                <td class="center">ОИБ</td>
                                <td class="center">Специалист</td>
                                <td class="center">Суслов О.А.</td>
                                <td class="center">100</td>
                                <td class="center">10</td>
                            </tr>
                            <tr>
                                <td>Безкровный А.А</td>
                                <td class="center">ОИБ</td>
                                <td class="center">Специалист</td>
                                <td class="center">Суслов О.А.</td>
                                <td class="center">100</td>
                                <td class="center">10</td>
                            </tr>
                            <tr>
                                <td>Безкровный А.А</td>
                                <td class="center">ОИБ</td>
                                <td class="center">Специалист</td>
                                <td class="center">Суслов О.А.</td>
                                <td class="center">100</td>
                                <td class="center">10</td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="pagination pagination-centered">
                            <ul>
                                <li><a href="#">Prev</a></li>
                                <li class="active">
                                    <a href="#">1</a>
                                </li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">Next</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="box span4">
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
                        <table class="table">
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
                            <tr>
                                <td>ОИБ</td>
                                <td class="center">100</td>
                                <td class="center">80</td>
                                <td class="center">10</td>
                                <td class="center">68</td>
                            </tr>
                            <tr>
                                <td>ОИБ</td>
                                <td class="center">100</td>
                                <td class="center">80</td>
                                <td class="center">10</td>
                                <td class="center">68</td>
                            </tr>
                            <tr>
                                <td>ОИБ</td>
                                <td class="center">100</td>
                                <td class="center">80</td>
                                <td class="center">10</td>
                                <td class="center">68</td>
                            </tr>
                            <tr>
                                <td>ОИБ</td>
                                <td class="center">100</td>
                                <td class="center">80</td>
                                <td class="center">10</td>
                                <td class="center">68</td>
                            </tr>
                            <tr>
                                <td>ОИБ</td>
                                <td class="center">100</td>
                                <td class="center">80</td>
                                <td class="center">10</td>
                                <td class="center">68</td>
                            </tr>
                            <tr>
                                <td>ОИБ</td>
                                <td class="center">100</td>
                                <td class="center">80</td>
                                <td class="center">10</td>
                                <td class="center">68</td>
                            </tr>
                            </tbody>
                        </table>
                        <div class="pagination pagination-centered">
                            <ul>
                                <li><a href="#">Prev</a></li>
                                <li class="active">
                                    <a href="#">1</a>
                                </li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">Next</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>
        </div><!--/.fluid-container-->

        <!-- end: Content -->
    </div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>

<div class="clearfix"></div>

<footer>

    <p><span style="text-align:left;float:left">&copy; 2017 <a
            href="http://kraftlab.ru/"> разработано KraftLab</a></span></p>

</footer>

<!-- start: JavaScript-->
<%@ include file="module/include/js.jsp" %>
<!-- end: JavaScript-->

</body>
</html>


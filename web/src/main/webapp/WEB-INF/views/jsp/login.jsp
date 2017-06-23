<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Secawa Login page</title>
    <!-- end: Meta -->
    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->
    <!-- start: CSS -->
    <%@ include file="module/include/css.jsp" %>
    <!-- end: CSS -->
    <style type="text/css">
        body { background: url(/resources/core/img/bg-login.jpg) !important; }
    </style>

</head>

<body>
<div class="container-fluid-full">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">
                <div class="icons">
                    <a href="index"><i class="halflings-icon home"></i></a>
                    <a href="#"><i class="halflings-icon cog"></i></a>
                </div>
                <h2>Авторизация пользователя</h2>
                <form class="form-horizontal" action="main">
                    <fieldset>

                        <div class="input-prepend" title="Username">
                            <span class="add-on"><i class="halflings-icon user"></i></span>
                            <input class="input-large span10" name="username" id="username" type="text" placeholder="Введите имя пользователя"/>
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend" title="Password">
                            <span class="add-on"><i class="halflings-icon lock"></i></span>
                            <input class="input-large span10" name="password" id="password" type="password" placeholder="Введите пароль"/>
                        </div>
                        <div class="clearfix"></div>

                        <label class="remember" for="remember"><input type="checkbox" id="remember" />Запомнить меня</label>

                        <div class="button-login">
                            <a class="btn btn-primary" href="main" role="button">Вход</a>
                        </div>
                        <div class="clearfix"></div>
                        </fieldset>
                </form>
                <hr>
                <%--<h3>Forgot Password?</h3>--%>
                <%--<p>--%>
                    <%--No problem, <a href="#">click here</a> to get a new password.--%>
                <%--</p>--%>
            </div><!--/span-->
        </div><!--/row-->


    </div><!--/.fluid-container-->

</div><!--/fluid-row-->
<%--<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">--%>
    <%--<div class="modal-content">--%>
        <%--<ul class="list-inline item-details">--%>
            <%--<li><a href="http://themifycloud.com">Admin templates</a></li>--%>
            <%--<li><a href="http://themescloud.org">Bootstrap themes</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
<%--</div>--%>
<!-- start: JavaScript-->
<%@ include file="module/include/js.jsp" %>
<!-- end: JavaScript-->

</body>
</html>
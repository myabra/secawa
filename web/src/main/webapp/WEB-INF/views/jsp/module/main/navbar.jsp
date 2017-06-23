<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="main"><span>Kraftlab Security Awareness Home</span></a>

            <!-- start: Header Menu -->
            <div class="nav-no-collapse header-nav">
                <ul class="nav pull-right">
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-bell"></i>
                            <span class="badge red">
								7 </span>
                        </a>
                        <ul class="dropdown-menu notifications">
                            <li class="dropdown-menu-title">
                                <span>11 новых уведомлений</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">Новый пользователь</span>
                                    <span class="time">1 мин</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">Новое сообщение</span>
                                    <span class="time">7 мин</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">Новое сообщение</span>
                                    <span class="time">8 мин</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">Новое сообщение</span>
                                    <span class="time">16 мин</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">Новый пользователь</span>
                                    <span class="time">36 мин</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon yellow"><i class="icon-shopping-cart"></i></span>
                                    <span class="message">2 письма отправлено </span>
                                    <span class="time">1 час</span>
                                </a>
                            </li>
                            <li class="warning">
                                <a href="#">
                                    <span class="icon red"><i class="icon-user"></i></span>
                                    <span class="message">Переход по ссылке</span>
                                    <span class="time">2 часа</span>
                                </a>
                            </li>
                            <li class="warning">
                                <a href="#">
                                    <span class="icon red"><i class="icon-shopping-cart"></i></span>
                                    <span class="message">Новое сообщение</span>
                                    <span class="time">6 часов</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">Новое сообщение</span>
                                    <span class="time">Вчера</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">Новый пользователь</span>
                                    <span class="time">Вчера</span>
                                </a>
                            </li>
                            <li class="dropdown-menu-sub-footer">
                                <a>Посмотреть все оповещения</a>
                            </li>
                        </ul>
                    </li>
                    <!-- start: Notifications Dropdown -->
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-calendar"></i>
                            <span class="badge red">
								5 </span>
                        </a>
                        <ul class="dropdown-menu tasks">
                            <li class="dropdown-menu-title">
                                <span>Выполняется 7 задач</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">Рассылка iOS Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim red">80</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">Обучение Android Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim green">47</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">Тестирование ARM Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim yellow">32</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">Обучение ARM Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim greenLight">63</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">Обучение ARM Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim orange">80</div>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-menu-sub-footer">Посмотреть все задачи</a>
                            </li>
                        </ul>
                    </li>
                    <!-- end: Notifications Dropdown -->
                    <!-- start: Message Dropdown -->
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-envelope"></i>
                            <span class="badge red">
								4 </span>
                        </a>
                        <ul class="dropdown-menu messages">
                            <li class="dropdown-menu-title">
                                <span>9 новых сообщений</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="/resources/core/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Олег Суслов
										     </span>
											<span class="time">
										    	6 мин
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="/resources/core/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Олег Суслов
										     </span>
											<span class="time">
										    	56 мин
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="/resources/core/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Олег Суслов
										     </span>
											<span class="time">
										    	3 часа
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="/resources/core/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Олег Суслов
										     </span>
											<span class="time">
										    	вчера
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="/resources/core/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Олег Суслов
										     </span>
											<span class="time">
										    	Июнь 25, 2012
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-menu-sub-footer">Посмотреть все сообщения</a>
                            </li>
                        </ul>
                    </li>

                    <!-- start: User Dropdown -->
                    <li class="dropdown">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="halflings-icon white user"></i> Ольга Сыса
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-title">
                                <span>Профиль</span>
                            </li>
                            <li><a href="#"><i class="halflings-icon user"></i> Настройки</a></li>
                            <li><a href="login.html"><i class="halflings-icon off"></i> Выйти</a></li>
                        </ul>
                    </li>
                    <!-- end: User Dropdown -->
                </ul>
            </div>
            <!-- end: Header Menu -->

        </div>
    </div>
</div>
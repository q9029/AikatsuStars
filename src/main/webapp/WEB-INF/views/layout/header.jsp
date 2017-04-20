<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="navbar navbar-inverse navbar-fixed-top" id="top" role="banner">
    <div class="header">
        <div class="navbar-header">
            <a href="/" class="navbar-brand">スタトレ</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav"></ul>
            <ul class="nav navbar-nav navbar-right">
                    <li><a class="dropdown-toggle" data-toggle="dropdown" href="#"></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">Signed in as <strong></strong></li>
                            <li class="divider"></li>
                            <li><a href="/<sec:authentication property='principal.username'/>">Your profile</a></li>
                                <li><a href="/accountsmanager">Accounts Management</a></li>
                            <li><a href="#">Help</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Settings</a></li>
                            <li><button type="button" id="logout" class="dropdown-link">Sign out</button></li>
                        </ul>
                    </li>
                    <li><a href="<c:url value='/login'/>">Login</a></li>
            </ul>
        </nav>
    </div>
</header>

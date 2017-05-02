<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value='/'/>">スタトレ</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <c:if var='isAnonymous' test='${empty session.getAttribute("twitter")}'>
                        <li><a class="navbar-link btn-clear">ログイン</a></li>
                    </c:if>
                    <c:if test='${!isAnonymous}'>
                        <li><a class="navbar-link btn-clear">マイリスト</a></li>
                        <li><a class="navbar-link btn-clear">カード検索</a></li>
                        <li><a class="navbar-link btn-clear">ログアウト</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>

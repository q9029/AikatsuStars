<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">
        <div class="container">
            <h1 class="h3">スタトレについて</h1>
            <p>当サイトはアイカツスターズのカード交換を目的としております。また、当サイトではユーザ認証にTwitterアカウントを使用いたします。</p>
            <p>
                <a class="btn btn-default btn-twitter" href="/signin" role="button">
                    <img class="img-twitter" alt="Sign in with Twitter" src="https://g.twimg.com/dev/sites/default/files/images_documentation/sign-in-with-twitter-gray.png"/>
                </a>
            </p>
        </div>
        <div class="container">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h2 class="panel-title h3">更新情報</h2>
                </div>
                <div class="panel-body">
                    <div class="ellipsis">2017-04-22 カード検索機能を追加しました。</div>
                    <div class="ellipsis">2017-04-22 マイリスト機能を追加しました。</div>
                    <div class="ellipsis">2017-03-20 星のツバサ1弾を追加しました。</div>
                    <div class="ellipsis">2017-03-01 サイトを開設しました。</div>
                </div>
            </div>
        </div>
    </c:param>
</c:import>

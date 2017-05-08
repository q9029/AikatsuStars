<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">当サイトについて</div>
                <div class="panel-body">
                    アイカツスターズのカード交換を目的としております。
                    また、今後の機能追加に向けてTwitterアカウントによる認証を利用しております。
                </div>
            </div>
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

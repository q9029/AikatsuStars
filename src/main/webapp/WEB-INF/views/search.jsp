<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">
        <div class="container">
            <form class="form-horizontal" method="post" action="/search">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="keyword">キーワード</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="keyword" placeholder="ドリーミングプリンセストップス">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="volume">弾</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="volume">
                            <option value="">すべて</option>
                            <c:forEach var="volume" items="${requestScope.volumeList}" >
                                <option value="<c:out value="${volume.id}"/>"><c:out value="${volume.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="type">タイプ</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="type">
                            <option value="">すべて</option>
                            <c:forEach var="volume" items="${requestScope.categoryList}" >
                                <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="category">カテゴリー</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="category">
                            <option value="">すべて</option>
                            <c:forEach var="volume" items="${requestScope.categoryList}" >
                                <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="brand">ブランド</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="brand">
                            <option value="">すべて</option>
                            <c:forEach var="volume" items="${requestScope.categoryList}" >
                                <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="rarity">レアリティ</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="rarity">
                            <option value="">すべて</option>
                            <c:forEach var="volume" items="${requestScope.categoryList}" >
                                <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">検索</button>
                    </div>
                </div>
            </form>
            <hr/>
            <div class="row-eq-height">
                <c:forEach var="card" items="${requestScope.cardlist}" >
                    <div class="col-sm-1 col-xs-3">
                        <div class="thumbnail">
                            <img src="https://q9029.github.io/aikatsustars/card<c:out value="${card.url}"/>"/>
                            <div class="caption"><c:out value="${card.no}"/></div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:param>
</c:import>

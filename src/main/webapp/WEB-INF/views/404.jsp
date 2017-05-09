<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">
        <div class="container">
            <h1 class="h3">404 Not Found.</h1>
            <h2 class="h4"><small>お探しのページが見つかりませんでした。</small></h2>
            <img class="img-responsive" alt="404 Not Found" src="<c:url value='/img/404.png'/>"/>
        </div>
    </c:param>
</c:import>

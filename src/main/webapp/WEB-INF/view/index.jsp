<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/view/layout/layout.jsp">
	<c:param name="content">
		<div class="container">
			<div class="alert alert-success" role="alert">
				<div>2017-04-22 02:57:28</div>
				<div>Queueさんから交換依頼が届いています。</div>
			</div>
		</div>
		<div class="container">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">更新情報</h3>
				</div>
				<div class="panel-body">
					<c:forEach var="notification" items="${requestScope.notificationList}" >
						<div class="ellipsis">
							<fmt:formatDate value="${notification.createdAt}" pattern="yyyy-MM-dd HH:mm" /> <c:out value="${notification.head}"/>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">アクティビティ</h3>
				</div>
				<div class="panel-body">
					<div class="ellipsis">2017-04-22 00:10:54 リスト「募集」を更新しました。</div>
					<div class="ellipsis">2017-04-22 00:05:03 リスト「提供」を更新しました。</div>
					<div class="ellipsis">2017-04-10 23:00:23 リスト「募集」を更新しました。</div>
					<div class="ellipsis">2017-04-10 22:55:46 リスト「提供」を更新しました。</div>
					<div class="ellipsis">2017-03-31 22:50:10 リスト「提供」を更新しました。</div>
				</div>
			</div>
		</div>
	</c:param>
</c:import>

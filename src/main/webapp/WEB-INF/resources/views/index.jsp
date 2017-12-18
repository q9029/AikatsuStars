<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/resources/layouts/main.jsp">
	<c:param name="content">
		<!--
		<div class="container">
			<div class="alert alert-success" role="alert">
				<div>2017-04-22 02:57:28</div>
				<div>XXXXXさんから交換依頼が届いています。</div>
			</div>
		</div>
		-->
		<div class="container">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">当サイトについて</h3>
				</div>
				<div class="panel-body">
					当サイトは。。。。
					また、ご利用頂く際にはTwitterアカウントによる認証が必要となります。
				</div>
			</div>
		</div>
		<div class="container">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">更新情報</h3>
				</div>
				<div class="panel-body">
					<c:if var="isEmptyNotification" test="${empty requestScope.notificationList}"/>
					<c:if test="${isEmptyNotification}">
						更新情報はありません。
					</c:if>
					<c:if test="${!isEmptyNotification}">
						<c:forEach var="notification" items="${requestScope.notificationList}" >
							<div class="ellipsis">
								<fmt:formatDate value="${notification.createdAt}" pattern="yyyy-MM-dd" /> <c:out value="${notification.head}"/>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">アクティビティ</h3>
				</div>
				<div class="panel-body">
					<div class="ellipsis">2017-04-22 リスト「募集」を更新しました。</div>
					<div class="ellipsis">2017-04-22 リスト「提供」を更新しました。</div>
					<div class="ellipsis">2017-04-10 リスト「募集」を更新しました。</div>
					<div class="ellipsis">2017-04-10 リスト「提供」を更新しました。</div>
					<div class="ellipsis">2017-03-31 リスト「提供」を更新しました。</div>
				</div>
			</div>
		</div>
	</c:param>
</c:import>

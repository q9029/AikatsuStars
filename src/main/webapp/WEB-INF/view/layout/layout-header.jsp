<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/'/>">スタトレ</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<c:if var='isAnonymous' test='${empty sessionScope.account}'>
						<li><a class="navbar-link" href="<c:url value='/signin'/>">ログイン</a></li>
					</c:if>
					<c:if test='${!isAnonymous}'>
						<li><a class="navbar-link">マイリスト</a></li>
						<li><a class="navbar-link" href="<c:url value='/cardlist'/>">カードリスト</a></li>
						<li><a class="navbar-link" href="<c:url value='/search'/>">募集検索</a></li>
						<li>
							<a class="navbar-link" href="/<c:out value='${sessionScope.account.name}'/>'">
								<c:out value='${sessionScope.account.name}'/>
							</a>
						</li>
						<li><a class="navbar-link" href="<c:url value='/signout'/>">ログアウト</a></li>
					</c:if>
					<li><a class="navbar-link" href="https://twitter.com/q9029">お問い合わせ</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>

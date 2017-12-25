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
				<a class="navbar-brand" href="/">スタトレ</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<c:if var='isAnonymous' test='${empty sessionScope.screen_name}'>
						<li><a class="navbar-link" href="/signin">ログイン</a></li>
					</c:if>
					<c:if test='${!isAnonymous}'>
						<li><a class="navbar-link">マイリスト</a></li>
						<li><a class="navbar-link" href="/cardlist">カードリスト</a></li>
						<li><a class="navbar-link" href="/search">募集検索</a></li>
						<li>
							<a class="navbar-link" href="/${sessionScope.screen_name}">
								<c:out value='${sessionScope.screen_name}'/>
							</a>
						</li>
						<li><a class="navbar-link" href="/signout">ログアウト</a></li>
					</c:if>
					<li><a class="navbar-link" href="https://twitter.com/intent/tweet?user_id=2434248589">お問い合わせ</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>

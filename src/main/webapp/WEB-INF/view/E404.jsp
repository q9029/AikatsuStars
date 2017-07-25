<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/view/layout/layout.jsp">
	<c:param name="content">
		<div class="container">
			<h1 class="h3">404 NOT FOUND</h1>
			<img class="img-responsive" alt="404 Not Found" src="<c:url value='/img/404.png'/>"/>
		</div>
	</c:param>
</c:import>

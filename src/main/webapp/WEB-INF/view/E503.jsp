<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
	<c:param name="content">
		<div class="container">
			<h1 class="h3">503 SERVICE UNAVAILABLE</h1>
			<img class="img-responsive" alt="503 SERVICE UNAVAILABLE" src="<c:url value='/img/503.png'/>"/>
		</div>
	</c:param>
</c:import>

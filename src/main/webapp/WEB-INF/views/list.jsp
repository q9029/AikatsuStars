<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
	<c:param name="content">
		<div class="container">
			<div class="row-eq-height">
				<c:forEach var="card" items="${requestScope.cardlist}" >
					<div class="col-sm-1 col-xs-3">
						<div class="thumbnail">
							<img src="https://q9029.github.io/starstrade/card<c:out value="${card.url}"/>"/>
							<div class="caption"><c:out value="${card.no}"/></div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:param>
</c:import>

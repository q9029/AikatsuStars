<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/view/layout/layout.jsp">
	<c:param name="content">
		<div class="container">
			<div class="row">
				<div class="col-xs-4">
					<div class="thumbnail">
						<img src="https://q9029.github.io/starstrade/card<c:out value="${card.img_url}"/>"/>
					</div>
				</div>
				<div class="col-xs-8">
					<ul>
						<li><c:out value="${card.no}"/></li>
						<li><c:out value="${card.name}"/></li>
						<li><c:out value="${card.brand}"/></li>
						<li><c:out value="${card.type}"/></li>
						<li><c:out value="${card.volume}"/></li>
						<li><c:out value="${card.rarerity}"/></li>
					</ul>
				</div>
			</div>
		</div>
	</c:param>
</c:import>

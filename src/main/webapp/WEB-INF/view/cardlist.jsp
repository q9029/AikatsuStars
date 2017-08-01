<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/view/layout/layout.jsp">
	<c:param name="content">
		<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="cardModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">SPR S2-1-1</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<img src="https://q9029.github.io/starstrade/card/391005/cp5-1-1-star_00.png"/>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div>
			</div>
		</div>
		<button type="button" class="btn" data-toggle="modal" data-target="#cardModalLabel">
			Launch demo modal
		</button>
		<div class="container">
			<form class="form-horizontal" method="get" action="<c:url value='/cardlist'/>">
				<button type="button" class="btn btn-info btn-sm btn-accordion" data-toggle="collapse" data-target="#additional-condition">＋条件を指定してカードを検索する</button>
				<div id="additional-condition" class="collapse">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="name">カード名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name" placeholder="ドリーミングプリンセストップス">
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
										<c:forEach var="type" items="${requestScope.typeList}" >
											<option value="<c:out value="${type.id}"/>"><c:out value="${type.name}"/></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="category">カテゴリー</label>
								<div class="col-sm-10">
									<select class="form-control" id="category">
										<option value="">すべて</option>
										<c:forEach var="category" items="${requestScope.categoryList}" >
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
										<c:forEach var="brand" items="${requestScope.brandList}" >
											<option value="<c:out value="${brand.id}"/>"><c:out value="${brand.name}"/></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="rarity">レアリティ</label>
								<div class="col-sm-10">
									<select class="form-control" id="rarity">
										<option value="">すべて</option>
										<c:forEach var="rare" items="${requestScope.rareList}" >
											<option value="<c:out value="${rare.id}"/>"><c:out value="${rare.name}"/></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group form-btn">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary btn-sm btn-search">検索</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<hr/>
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

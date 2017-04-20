<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:import url="/WEB-INF/views/layout/layout.jsp">
    <c:param name="content">
        <h1>Index</h1>
        <table class="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>登録日時</th>
              </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.registered}</td>
                </tr>
            </tbody>
        </table>
    </c:param>
</c:import>

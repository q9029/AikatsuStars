<%@page pageEncoding="UTF-8" contentType="text/html" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>スタトレ</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="icon" type="image/png" href="<c:url value='/img/favicon.png'/>"/>
    <link href="<c:url value='/css/webapp.css'/>" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.12.3.min.js"></script>
    <script src="//code.jquery.com/jquery-2.2.3.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
    <c:import url="/WEB-INF/views/layout/header.jsp"/>
    <div class="contents">
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">${param.content}</div>
            </div>
        </div>
        <div class="container-fluid">
            <footer>
                <hr>
                <div class="row-fluid">
                    <div class="span12">
                        <p>Copyright &copy; 2017 Queue All Rights Reserved.</p>
                    </div>
                </div>
            </footer>
        </div>
    </div>
</body>
</html>

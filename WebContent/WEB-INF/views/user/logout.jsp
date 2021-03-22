<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 모든 컨텍스트 경로를 포함한 설정 -->
<c:url var='root' value='/'></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
alert("로그아웃")

location.href='${root}main'
</script>
</body>
</html>
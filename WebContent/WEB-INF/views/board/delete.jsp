<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 모든 컨텍스트 경로를 포함한 설정 -->
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
alert("삭제")
location.href='${root}board/main?board_info_idx=${board_info_idx}'
</script>
</body>
</html>
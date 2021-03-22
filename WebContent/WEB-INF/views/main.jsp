<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 모든 컨텍스트 경로를 포함한 설정 -->
<c:url var='root' value='/'></c:url> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="/WEB-INF/views/include/top_menu.jsp"/>	


<!-- 게시판 미리보기 부분 -->
<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-lg-6" style="margin-top:20px">
			<div class="card shadow">
				<div class="card-body">
					<h4 class="card-title">자바게시판</h4>
					<table class="table table-hover" id='board_list'>
						<thead>
							<tr>
								<th class="text-center w-25">글번호</th>
								<th>제목</th>
								<th class="text-center w-25 d-none d-xl-table-cell">작성날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
						</tbody>
					</table>
					
					<a href="${root}board/main" class="btn btn-primary">더보기</a>
				</div>
			</div>
		</div>
		<div class="col-lg-6" style="margin-top:20px">
			<div class="card shadow">
				<div class="card-body">
					<h4 class="card-title">JSP게시판</h4>
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center w-25">글번호</th>
								<th>제목</th>
								<th class="text-center w-25 d-none d-xl-table-cell">작성날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
						</tbody>
					</table>
					
					<a href="${root}board/main" class="btn btn-primary">더보기</a>
				</div>
			</div>
		
		</div>
		<div class="col-lg-6" style="margin-top:20px">
			<div class="card shadow">
				<div class="card-body">
					<h4 class="card-title">Spring게시판</h4>
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center w-25">글번호</th>
								<th>제목</th>
								<th class="text-center w-25 d-none d-xl-table-cell">작성날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
						</tbody>
					</table>
					
					<a href="${root}board/main" class="btn btn-primary">더보기</a>
				</div>
			</div>
		</div>
		<div class="col-lg-6" style="margin-top:20px">
			<div class="card shadow">
				<div class="card-body">
					<h4 class="card-title">DataBase게시판</h4>
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center w-25">글번호</th>
								<th>제목</th>
								<th class="text-center w-25 d-none d-xl-table-cell">작성날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
							<tr>
								<td class="text-center">5</td>
								<th><a href='${root }board/read'>제목입니다</a></th>
								<td class="text-center d-none d-xl-table-cell">2019-12-15</td>
							</tr>
						</tbody>
					</table>
					
					<a href="${root}board/main" class="btn btn-primary">더보기</a>
				</div>
			</div>
		</div>
	</div>
</div>
	
<c:import url="/WEB-INF/views/include/buttom_info.jsp"/>	


</body>
</html>

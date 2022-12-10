<%@ page language="java" contentType="text/html; charset=UTF-8" import=" java.util.*,task.*" pageEncoding="UTF-8"
	isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Bootstrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
	integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
	crossorigin="anonymous"></script>
	<!-- Fontawesome -->
	<script src="https://kit.fontawesome.com/591ebcb214.js" crossorigin="anonymous"></script>
	<!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"
	integrity="sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css"
	integrity="sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<title>회원 리스트</title>
	<style>
		.cls1 {
			font-size: 40px;
			text-align: center;
		}

		.cls2 {
			font-size: 20px;
			text-align: center;
		}
	</style>
</head>

<body style="margin: 40px;">
	<h1 class="cls1">회원 정보</h1>
	<hr><br>
	
	<div class="container-fluid" id="modify">
		<table class="container-fluid" align="center">
			<tr align="center">
				<td width="7%">ID</td>
				<td width="7%">PW</td>
				<td width="7%">이름</td>
				<td width="7%">생년월일</td>
				<td width="7%">E-MAIL</td>
				<td width="7%">성별</td>
				<td width="7%">취미</td>
				<td width="7%">가입일</td>
			</tr>

			<c:choose>
				<c:when test="${ empty membersList}">
					<tr>
						<td colspan="8" style="text-align: center;">
							<b>등록된 회원이 없습니다.</b>
						</td>
					</tr>
				</c:when>
				<c:when test="${!empty membersList }">
					<c:forEach var="mem" items="${membersList }">
						<tr align="center">
							<td>${mem.uid }</td>
							<td>${mem.pwd }</td>
							<td>${mem.uname}</td>
							<td>${mem.birth }</td>
							<td>${mem.email }</td>
							<td>${mem.gender }</td>
							<td>${mem.hobby }</td>
							<td>${mem.joinDate}</td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
			<tr style="text-align: center;">
				<td colspan="8">
					<a href="${contextPath}/jw/task/member/memberForm.do">
						<input type="button" class="mt-4 btn btn-danger" value="회원 가입">
					</a>
				</td>
			</tr>
		</table>
	</div>
</body>

</html>
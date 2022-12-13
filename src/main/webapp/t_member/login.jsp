<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">

<head>
<c:choose>
  <c:when test='${msg=="wrongInfo"}'>
    <script>window.onload = function () { alert("로그인 실패"); }</script>
  </c:when>
</c:choose>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css"
    integrity="sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <title>로그인</title>
  <link href="/jw/t_member/calc.css" rel="stylesheet">
  <link href="/jw/t_member/table.css" rel="stylesheet">
  <link href="/jw/t_member/font.css" rel="stylesheet">
  <script>
    function loginM() {
      let formLog = document.formLog;
      let uid = formLog.uid.value;
      let pwd = formLog.pwd.value;
      if (uid.length <= 3 || uid == "") {
        console.log("ID를 입력하세요.");
      } else if (pwd.length <= 3 || pwd == "") {
        console.log("패스워드를 입력하세요.");
      } else {
        formLog.method = "post";
        formLog.action = "member/login.do"
        formLog.submit();
      }
    }
    function regM() {
        formLog.method = "post";
        formLog.action = "member/memberForm.do";
        formLog.submit();
    }
  </script>
</head>
<body>
  <div>
    <h1 class="mt-3 a" style="text-align: center; color: white; font-size: 50px;">
    	LOGIN
    </h1>
	<!-- 브라우저에서 접속 시에는 msg 값을 가져와서 표시하고,
	최초 접속 시에는 null이므로 아무것도 표시하지 않음 -->
	<%
	  String msgUid = request.getParameter("msgUid");
	  if (msgUid != null) {
	%>
	  <h3 class="mt-3 a" style="text-align: center; color: red;">	<%=msgUid%> </h3>
	<%
	  }
	%>
	<%
	  String msgPwd = request.getParameter("msgPwd");
	  if (msgPwd != null) {
	%>
	  <h3 class="mt-3 a" style="text-align: center; color: red;">	<%=msgPwd%> </h3>
	<%
	  }
	%>
  </div>
  
  <div class="container-fluid mt-4" style="max-width: 500px;">
    <form name="formLog" action="main.jsp">
      <table>
        <tr>
          <td class="l" style="text-align: center;">ID</td>
          <td class="r">
            <input type="text" name="uid">
          </td>
        </tr>
        <tr>
          <td class="l" style="text-align: center;">PW</td>
          <td class="r">
            <input type="password" name="pwd">
          </td>
        </tr>
      </table>
      <div class="container-fluid mt-4 b" align="center">
        <button class="btn btn-danger" onclick="loginM()">로그인</button>
        <button class="btn btn-secondary" type="reset">다시입력</button>
        <button class="btn btn-success" onclick="regM()">회원 가입</button>
      </div>
    </form>
  </div>
</body>
</html>
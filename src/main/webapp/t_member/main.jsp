<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- login.jsp로 전달할 오류 메세지를 선언 -->
<%!
  String msgUid = "You didn't enter ID. Please enter ID.";
%>
<%!
  String msgPwd = "You didn't enter Password. Please enter Password.";
%>
<!DOCTYPE html>
<html lang="ko">

<head>
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
  <title>HOME</title>
  <link href="/jw/t_member/calc.css" rel="stylesheet">
  <link href="/jw/t_member/table.css" rel="stylesheet">
  <link href="/jw/t_member/font.css" rel="stylesheet">
  <script type="text/javascript">
  	function listM() {
  		let listM = document.listM;
  		listM.method = "post",
  		listM.action = "/t_member/listMembers.jsp",
  		listM.submit();
  	}
  </script>
</head>
<body>
<!-- 로그인 시 입력한 ID를 가져오기 -->
<%
  String uid = request.getParameter("uid");
  String pwd = request.getParameter("pwd");
/* ID를 입력하지 않았을 경우 <jsp:param> 액션 태그를 이용해
오류 메세지를 login.jsp로 전달 */
  if (uid.length() < 4) {
%>
  <jsp:forward  page="login.jsp">
  	<jsp:param name="msgUid" value="<%= msgUid %>" />
  </jsp:forward>
<%
  }
/* 패스워드를 입력하지 않았을 경우 <jsp:param> 액션 태그를 이용해
오류 메세지를 login.jsp로 전달 */
  else if (pwd.length() < 4) {
%>
  <jsp:forward  page="login.jsp">
  	<jsp:param name="msgPwd" value="<%= msgPwd %>" />
  </jsp:forward>
<%
  }
%>
  <div>
    <h1 class="mt-3 a" style="text-align: center; color: white; font-size: 50px;">MAIN</h1>
    <h3 class="mt-3 a" style="text-align: center; color: white;">HELLO <%= uid %> !!!</h3>
  </div>

  <div class="container-fluid mt-4" style="max-width: 500px;">
    <form name="info">
      <table>
        <tr>
          <td class="l" style="text-align: center;">ID</td>
          <td class="r">
            <%= uid %>
          </td>
        </tr>
        <tr>
          <td class="l" style="text-align: center;">PW</td>
          <td class="r">
            <%= pwd %>
          </td>
        </tr>
      </table>
      <div class="container-fluid mt-4 b" align="center">
         <button class="btn btn-danger" onclick="logOut()">로그아웃</button>
         <button class="btn btn-success" name="listM" onclick="listM()">회원 목록</button>
         <button class="btn btn-secondary" type="reset">회원 탈퇴</button>
      </div>
    </form>
  </div>
</body>
</html>
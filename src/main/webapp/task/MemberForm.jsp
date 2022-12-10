<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css"
    integrity="sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
  <title>회원 가입</title>
  <script>
    var checkBoxes = document.querySelectorAll('input[type="checkbox"]');
    function vaildate() {
      let formReg = document.formReg;
      let uid = formReg.uid.value;
      let pwd = formReg.pwd.value;
      let pwd2 = formReg.pwd2.value;
      let uname = formReg.uname.value;
      let birth = formReg.birth.value;
      let email = formReg.email.value;
      let gender = formReg.gender.value;
      let checkboxes = document.querySelectorAll('input[name="hobby"]');
      let hobby = [];
      for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked == true) {
          hobby.push(checkboxes[i].value);
        }
      }
      console.log(uid, pwd, pwd2, uname, birth, email, gender, hobby);
      if (uid.length < 4 || uid == "") {
        alert("아이디 입력은 필수입니다. 4자 이상 입력하세요.");
      } else if (pwd.length < 4 || pwd == "") {
        alert("비밀번호 입력은 필수입니다. 4자 이상 입력하세요.");
      } else if (pwd2 == "") {
        alert("비밀번호 확인은 필수입니다.");
      } else if (pwd != pwd2) {
        alert("입력한 패스워드가 일치하지 않습니다.");
      } else if (uname.length == 0 || uname == "") {
        alert("이름 입력은 필수입니다.");
      } else if (birth.length == 0 || birth == "") {
        alert("생년월일 입력은 필수입니다.");
      } else if (email.length == 0 || email == "") {
        alert("이메일 입력은 필수입니다.");
      } else if (gender.length == 0 || gender == "") {
        alert("성별 선택은 필수입니다.");
      } else {
        formReg.method = "post";
    	formReg.action = "${contextPath}/task/member/addMember.do";
        formReg.submit();
      }
    }
    $(function () {
      $('#datepicker').datepicker({
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
        dateFormat: 'yy-mm-dd',
        showOtherMonths: true
      });
    })
  </script>
  <style>
    .ui-widget-header {
      border: 0px solid #dddddd;
      background: #fff;
    }

    .ui-datepicker-calendar>thead>tr>th {
      font-size: 14px !important;
    }

    .ui-datepicker .ui-datepicker-header {
      position: relative;
      padding: 10px 0;
    }

    .ui-state-default,
    .ui-widget-content .ui-state-default,
    .ui-widget-header .ui-state-default,
    .ui-button,
    html .ui-button.ui-state-disabled:hover,
    html .ui-button.ui-state-disabled:active {
      border: 0px solid #c5c5c5;
      background-color: transparent;
      font-weight: normal;
      color: #454545;
      text-align: center;
    }

    .ui-datepicker .ui-datepicker-title {
      margin: 0 0em;
      line-height: 16px;
      text-align: center;
      font-size: 14px;
      padding: 0px;
      font-weight: bold;
    }

    .ui-datepicker {
      display: none;
      background-color: #fff;
      border-radius: 4px;
      margin-top: 10px;
      margin-left: 0px;
      margin-right: 0px;
      padding: 20px;
      padding-bottom: 10px;
      width: 300px;
      box-shadow: 10px 10px 40px rgba(0, 0, 0, 0.1);
    }

    .ui-widget.ui-widget-content {
      border: 1px solid #eee;
    }

    #datepicker:focus>.ui-datepicker {
      display: block;
    }

    .ui-datepicker-prev,
    .ui-datepicker-next {
      cursor: pointer;
    }

    .ui-datepicker-next {
      float: right;
    }

    .ui-state-disabled {
      cursor: auto;
      color: hsla(0, 0%, 80%, 1);
    }

    .ui-datepicker-title {
      text-align: center;
      padding: 10px;
      font-weight: 100;
      font-size: 20px;
    }

    .ui-datepicker-calendar {
      width: 100%;
    }

    .ui-datepicker-calendar>thead>tr>th {
      padding: 5px;
      font-size: 20px;
      font-weight: 400;
    }

    .ui-datepicker-calendar>tbody>tr>td>a {
      color: #000;
      font-size: 12px !important;
      font-weight: bold !important;
      text-decoration: none;
    }

    .ui-datepicker-calendar>tbody>tr>.ui-state-disabled:hover {
      cursor: auto;
      background-color: #fff;
    }

    .ui-datepicker-calendar>tbody>tr>td {
      border-radius: 100%;
      width: 44px;
      height: 30px;
      cursor: pointer;
      padding: 5px;
      font-weight: 100;
      text-align: center;
      font-size: 12px;
    }

    .ui-datepicker-calendar>tbody>tr>td:hover {
      background-color: transparent;
      opacity: 0.6;
    }

    .ui-state-hover,
    .ui-widget-content .ui-state-hover,
    .ui-widget-header .ui-state-hover,
    .ui-state-focus,
    .ui-widget-content .ui-state-focus,
    .ui-widget-header .ui-state-focus,
    .ui-button:hover,
    .ui-button:focus {
      border: 0px solid #cccccc;
      background-color: transparent;
      font-weight: normal;
      color: #2b2b2b;
    }

    .ui-widget-header .ui-icon {
      background-image: url('https://github.com/NOSTALJIAN/JavaWeb/blob/master/src/main/webapp/ch07/btns.png?raw=true');
    }

    .ui-icon-circle-triangle-e {
      background-position: -20px 0px;
      background-size: 36px;
    }

    .ui-icon-circle-triangle-w {
      background-position: -0px -0px;
      background-size: 36px;
    }

    .ui-datepicker-calendar>tbody>tr>td:first-child a {
      color: red !important;
    }

    .ui-datepicker-calendar>tbody>tr>td:last-child a {
      color: #0099ff !important;
    }

    .ui-datepicker-calendar>thead>tr>th:first-child {
      color: red !important;
    }

    .ui-datepicker-calendar>thead>tr>th:last-child {
      color: #0099ff !important;
    }

    .ui-state-highlight,
    .ui-widget-content .ui-state-highlight,
    .ui-widget-header .ui-state-highlight {
      border: 0px;
      background: #f1f1f1;
      border-radius: 50%;
      padding-top: 10px;
      padding-bottom: 10px;
    }

    .inp {
      padding: 10px 10px;
      background-color: #f1f1f1;
      border-radius: 4px;
      border: 0px;
    }

    .inp:focus {
      outline: none;
      background-color: #eee;
    }

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
  <h1 class="cls1">회원 가입</h1>
  <hr><br>
  <div class="container-fluid" align="center">
    <form name="formReg">
      <table>
        <th style="text-align: center;" colspan="2">회원 가입</th>
        <tr>
          <td><br></td>
        </tr>
        <tr>
          <td style="text-align: center;">ID</td>
          <td>&nbsp; : <input type="text" name="uid" placeholder="가입할 사용자 ID"></td>
        </tr>
        <tr>
          <td style="text-align: center;">PW</td>
          <td>&nbsp; : <input type="password" name="pwd" placeholder="사용할 비밀번호"></td>
        </tr>
        <tr>
          <td></td>
          <td>&nbsp; &nbsp; <input type="password" name="pwd2" placeholder="비밀번호 확인"></td>
        </tr>
        <tr>
          <td style="text-align: center;">이름</td>
          <td>&nbsp; : <input type="text" name="uname" placeholder="사용자 이름"></td>
        </tr>
        <tr>
          <td style="text-align: center;">생년월일</td>
          <td>&nbsp; : <input type="text" name="birth" id="datepicker" placeholder="ex) 2022-12-09"></td>
        </tr>
        <tr>
          <td style="text-align: center;">E-MAIL</td>
          <td>&nbsp; : <input type="text" name="email" placeholder="ex) user@gmail.com"></td>
        </tr>
        <tr>
          <td style="text-align: center;">성별</td>
          <td>&nbsp; :
            <input type="radio" name="gender" value="male"> 남자
          </td>
        </tr>
        <tr>
          <td></td>
          <td>&nbsp; &nbsp;
            <input type="radio" name="gender" value="female" checked> 여자
          </td>
        </tr>
        <div class="hobby">
          <tr>
            <td style="text-align: center;">취미</td>
            <td>&nbsp; :
              <input type="checkbox" name="hobby" value="Listening to music" checked> 음악 감상
            </td>
          </tr>
          <tr>
            <td></td>
            <td>&nbsp; &nbsp;
              <input type="checkbox" name="hobby" value="Watching movies" checked>
              영화보기
            </td>
          </tr>
          <tr>
            <td></td>
            <td>&nbsp; &nbsp;
              <input type="checkbox" name="hobby" value="Exercise"> 운동하기
            </td>
          </tr>
          <tr>
            <td></td>
            <td>&nbsp; &nbsp;
              <input type="checkbox" name="hobby" value="Drawing"> 그림 그리기
            </td>
          </tr>
          <tr>
            <td></td>
            <td>&nbsp; &nbsp;
              <input type="checkbox" name="hobby" value="Take a picture"> 사진 촬영
            </td>
          </tr>
        </div>
        <tr>
          <td><br></td>
        </tr>
        <tr style="text-align: center;">
          <td colspan="2">
            <button class="btn btn-danger" onclick="vaildate()">가입하기</button>
            <button class="btn btn-secondary" type="reset">다시 입력</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</body>

</html>
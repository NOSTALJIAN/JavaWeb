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
          	function check() {
          		var _uid = $("#uid").val();		// MemberForm에서 입력한 ID
          		if (_uid == "") {
          			alert("ID를 입력하세요.");
          			return;
          		}
          		$.ajax({
          			async: true,		// 동기식 처리(true), 비동기식 처리(false)
          			type: "post",		// 데이터 전송 방법('post' or 'get')
          			url: "check.do?uid=" + _uid,	// 요청할 url
          			data: { uid: _uid },	// { 서버로 전송할 데이터 }
          			dataType: "text",		// 전송 받을 데이터 형식
          			success: function(result) {
          				console.log("사용 가능한가? " + result);
          				if (result == "usable") {
	          				$('#overlappedMsg').text("사용할 수 있는 ID입니다.");
	          				$('#overlappedMsg').css("color", "green");
	          				$('#overlappedMsg').css("font-size", "11px");
/* 	          				$('#btn_duplicate').prop("disabled", true); */
          				} else {
          					$('#overlappedMsg').text("사용할 수 없는 ID입니다.");
	          				$('#overlappedMsg').css("color", "red");
	          				$('#overlappedMsg').css("font-size", "11px");
          				}
          			},
          			error: function(request, status, error) {
          				$('#overlappedMsg').text(request.responseText);
          				$('#overlappedMsg').css("font-size", "11px");
          				$('#overlappedMsg').css("color", "red");
          				console.log("code: " + request.status);
          				console.log("message: " + request.responseText);
          				console.log("error: " + error);
          			}
          		});
          	}
          	function rON () {
          		var pwd = $("#pwd").val();
          		var pwd2 = $("#pwd2").val();
            	if (pwd != pwd2) {
					$('#rOn').text("패스워드가 일치하지 않습니다.");
	   				$('#rOn').css("color", "red");
	   				$('#rOn').css("font-size", "11px");
          			console.log("패스워드가 일치하지 않습니다.");
            	} else if (pwd == pwd2) {
					$('#rOn').text("패스워드가 일치합니다.");
	   				$('#rOn').css("color", "green");
	   				$('#rOn').css("font-size", "11px");
          			console.log("패스워드가 일치합니다.");
            	}
          	}
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
                formReg.action = "${contextPath}/t_member/member/addMember.do";
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
          <link href="/jw/t_member/calc.css" rel="stylesheet">
          <link href="/jw/t_member/table.css" rel="stylesheet">
          <link href="/jw/t_member/font.css" rel="stylesheet">
        </head>

        <body>
          <div>
            <h1 class="mt-3 a" style="text-align: center; color: white; font-size: 50px;">JOIN<br>MEMBER</h1>
          </div>
          <div class="container-fluid mt-4" style="width: 500px;">
            <form name="formReg">
              <table>
                <tr>
                  <td class="l" style="text-align: center;">ID</td>
                  <td class="r">
                  	<input type="text" id="uid" name="uid" placeholder="가입할 사용자 ID" class="mt-1">
                  	<input type="button" id="btn_duplicate" value="중복체크" onClick="check()"><br>
                  	<div id="overlappedMsg" class="mt-1"></div>
                  </td>
                </tr>
                <tr>
                  <td class="l" style="text-align: center;">PW</td>
                  <td class="r">
                  	<input type="password" id="pwd" name="pwd" placeholder="사용할 비밀번호">
                  </td>
                </tr>
                <tr>
                  <td class="l"></td>
                  <td class="r">
                  	<input type="password" id="pwd2" name="pwd2" placeholder="비밀번호 확인" class="mt-1" onkeyup="rON()">
                  	<div id="rOn" class="mt-1"></div>
                  </td>
                </tr>
                <tr>
                  <td class="l" style="text-align: center;">이름</td>
                  <td class="r"><input type="text" name="uname" placeholder="사용자 이름"></td>
                </tr>
                <tr>
                  <td class="l" style="text-align: center;">생년월일</td>
                  <td class="r"><input type="text" name="birth" id="datepicker" placeholder="ex) 2022-12-09"></td>
                </tr>
                <tr>
                  <td class="l" style="text-align: center;">E-MAIL</td>
                  <td class="r"><input type="text" name="email" placeholder="ex) user@gmail.com"></td>
                </tr>
                <tr>
                  <td class="l" style="text-align: center;">성별</td>
                  <td class="r" style="text-align: center;"><input type="radio" name="gender" value="male">&nbsp; 남자
                  </td>
                </tr>
                <tr>
                  <td class="l" style="text-align: center;"></td>
                  <td class="r" style="text-align: center;"><input type="radio" name="gender" value="female">&nbsp; 여자
                  </td>
                </tr>
                <div class="hobby">
                  <tr>
                    <td class="l" style="text-align: center;">취미</td>
                    <td class="r" style="text-align: center;">
                      <input type="checkbox" name="hobby" value="Listening to music"> 음악 감상
                    </td>
                  </tr>
                  <tr>
                    <td class="l"></td>
                    <td class="r" style="text-align: center;">
                      <input type="checkbox" name="hobby" value="Watching movies">
                      영화보기
                    </td>
                  </tr>
                  <tr>
                    <td class="l"></td>
                    <td class="r" style="text-align: center;">
                      <input type="checkbox" name="hobby" value="Exercise"> 운동하기
                    </td>
                  </tr>
                  <tr>
                    <td class="l"></td>
                    <td class="r" style="text-align: center;">
                      <input type="checkbox" name="hobby" value="Drawing"> 그림 그리기
                    </td>
                  </tr>
                  <tr>
                    <td class="l"></td>
                    <td class="r" style="text-align: center;">
                      <input type="checkbox" name="hobby" value="Take a picture"> 사진 촬영
                    </td>
                  </tr>
                </div>
              </table>
              <div class="container-fluid mt-4 b" align="center">
                <button class="btn btn-danger" onclick="vaildate()">가입하기</button>
                <button class="btn btn-secondary" type="reset">다시입력</button>
              </div>
            </form>
          </div>
        </body>

        </html>
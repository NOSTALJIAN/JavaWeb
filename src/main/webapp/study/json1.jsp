<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>json1</title>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
    $(function () {
      $("#checkJason").click(function () {
        var jsonStr = '{ "name": ["홍길동", "이순신", "임꺽정"] }';
        var jsonInfo = JSON.parse(jsonStr);
        var output = "회원 이름<br>";
        output += "========<br>";
        for (var i in jsonInfo.name) {
          output += jsonInfo.name[i] + "<br>";
        }
        $("#output").html(output);
      });
    })
  </script>
</head>

<body>
  <h1></h1>
</body>

</html>
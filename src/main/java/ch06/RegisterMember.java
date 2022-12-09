package ch06;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.lang.String;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch06/regMember")
public class RegisterMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		/* 
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.listMembers();
		
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print(""
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
				+ "    integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\"\n"
				+ "    integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\"\n"
				+ "    crossorigin=\"anonymous\"></script>\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js\"\n"
				+ "    integrity=\"sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V\"\n"
				+ "    crossorigin=\"anonymous\"></script>\n"
				+ "  <!-- Fontawesome -->\n"
				+ "  <script src=\"https://kit.fontawesome.com/591ebcb214.js\" crossorigin=\"anonymous\"></script>\n"
				+ "  <!-- jQuery -->\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\n"
				+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js\"\n"
				+ "    integrity=\"sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q==\"\n"
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n"
				+ "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css\"\n"
				+ "    integrity=\"sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw==\"\n"
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.print("	<title>HttpServletRequest</title>");
		out.print("</head>");
		out.print("<body style=\"margin: 40px;\">");
		out.print("	<h1>회원가입 정보</h1>");
		out.print(" <hr><br>");
		
		out.print(" <div class='container-fluid'>");
		out.print("  <table class='container-fluid' style='text-align: center; font-size: 14px'>");
		out.print("    <tr>");
		out.print("      <td>ID</td>");
		out.print("      <td>PW</td>");
		out.print("      <td>이름</td>");
		out.print("      <td>생년월일</td>");
		out.print("      <td>E-MAIL</td>");
		out.print("      <td>성별</td>");
		out.print("      <td>취미</td>");
		out.print("    </tr>");
		
		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);
			String uid = m.getUid();
			String pwd = m.getPwd();
			String uname = m.getUname();
			Date birth = m.getBirth();
			String email = m.getEmail();
			String gender = m.getGender();
			String hobby = m.getHobby();
			out.print(""
					+ "<tr><td>"
					+ uid
					+ "</td><td>"
					+ pwd
					+ "</td><td>"
					+ uname
					+ "</td><td>"
					+ birth
					+ "</td><td>"
					+ email
					+ "</td><td>"
					+ gender
					+ "</td><td>"
					+ hobby
					+ "</td></tr></table>");
			
			out.print(" </div>");
			out.print("	</body>");
			out.print("</html>");
		}
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			try {
				doHandle(request, response);
			} catch (ServletException | IOException | ParseException e) {
				e.printStackTrace();
			}
		/*
		request.setCharacterEncoding("utf-8");
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String uname = request.getParameter("uname");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		
		String data = "uid: " + uid + "\n";
		data += "pwd: " + pwd.equals(pwd2) + "\n";
		data += "name: " + uname + "\n";
		data += "birth: " + birth + "\n";
		data += "email: " + email + "\n";
		data += "gender: " + gender + "\n";
		data += "hobby: ";
		for (String hobby: hobbies)
			data += hobby + ", ";
		System.out.println(data);
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print(""
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
				+ "    integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\"\n"
				+ "    integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\"\n"
				+ "    crossorigin=\"anonymous\"></script>\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js\"\n"
				+ "    integrity=\"sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V\"\n"
				+ "    crossorigin=\"anonymous\"></script>\n"
				+ "  <!-- Fontawesome -->\n"
				+ "  <script src=\"https://kit.fontawesome.com/591ebcb214.js\" crossorigin=\"anonymous\"></script>\n"
				+ "  <!-- jQuery -->\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\n"
				+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js\"\n"
				+ "    integrity=\"sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q==\"\n"
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n"
				+ "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css\"\n"
				+ "    integrity=\"sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw==\"\n"
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.print("	<title>HttpServletRequest</title>");
		out.print("</head>");
		out.print("<body style=\"margin: 40px;\">");
		out.print("	<h1>회원가입 정보</h1>");
		out.print(" <hr>");
		
		String[] ulList = data.split("\n");
		out.print(" <ul>");
		for (String li: ulList)
			out.print("  <li>" + li + "</li>");
		out.print(" </ul>");
		
		out.print(" <br>");
		out.print(" <div class=\"container-fluid\" style=\"text-align: center;\">");
		out.print("  <button class=\"btn btn-danger\" onclick=\"location.href='/jw/ch06/registerMember.html'\">돌아가기"
				+ "  </button></a>");
		out.print(" </div>");
		
		out.print("	</body>");
		out.print("</html>");
		*/
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException, ParseException {
		/*
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		MemberDAO dao = new MemberDAO();
		String datepattern = "yyyyMMdd";
		SimpleDateFormat format = new SimpleDateFormat(datepattern);
		
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");

		if (command != null && command.equals("addMember")) {
			String id = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("uname");
			String birthStr = request.getParameter("birth");
			Date birth = format.parse(birthStr);
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String[] hobbies = request.getParameterValues("hobby");
			if (hobbies != null) {
				String hobby = String.join(",", hobbies);
			Member m = (Member) new Member();
			m.setUid(id);
			m.setPwd(pwd);
			m.setUname(name);
			m.setBirth((java.sql.Date) birth);
			m.setEmail(email);
			m.setGender(gender);
			m.setHobby(hobby);
			dao.addMember(m);
			}
			
		} else if (command != null && command.equals("delMember")) {
			String uid = request.getParameter("uid");
			dao.delMember(uid);
		}
			
		
		List<Member> list = dao.listMembers();

		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print(""
				+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
				+ "    integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\"\n"
				+ "    integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\"\n"
				+ "    crossorigin=\"anonymous\"></script>\n"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js\"\n"
				+ "    integrity=\"sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V\"\n"
				+ "    crossorigin=\"anonymous\"></script>\n"
				+ "  <!-- Fontawesome -->\n"
				+ "  <script src=\"https://kit.fontawesome.com/591ebcb214.js\" crossorigin=\"anonymous\"></script>\n"
				+ "  <!-- jQuery -->\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\n"
				+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js\"\n"
				+ "    integrity=\"sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q==\"\n"
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\n"
				+ "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css\"\n"
				+ "    integrity=\"sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw==\"\n"
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.print("	<title>HttpServletRequest</title>");
		out.print("</head>");
		out.print("<body style=\"margin: 40px;\">");
		out.print("	<h1>회원가입 정보</h1>");
		out.print(" <hr><br>");
		
		out.print(" <div class='container-fluid'>");
		out.print("  <table class='container-fluid' style='text-align: center; font-size: 14px'>");
		out.print("    <tr>");
		out.print("      <td>ID</td>");
		out.print("      <td>PW</td>");
		out.print("      <td>이름</td>");
		out.print("      <td>생년월일</td>");
		out.print("      <td>E-MAIL</td>");
		out.print("      <td>성별</td>");
		out.print("      <td>취미</td>");
		out.print("      <td></td>");
		out.print("    </tr>");
		
		
		for (int i = 0; i < list.size(); i++) {
			Member m = (Member) list.get(i);
			String _uid = m.getUid();
			String _pwd = m.getPwd();
			String _uname = m.getUname();
			Date _birth = m.getBirth();
			String _email = m.getEmail();
			String _gender = m.getGender();
			String _hobby = m.getHobby();
			out.print(""
					+ "<tr><td>"
					+ _uid
					+ "</td><td>"
					+ _pwd
					+ "</td><td>"
					+ _uname
					+ "</td><td>"
					+ _birth
					+ "</td><td>"
					+ _email
					+ "</td><td>"
					+ _gender
					+ "</td><td>"
					+ _hobby
					+ "</td><td>"
					+ "<a href='/jw/ch06/regMember?command=delMember&uid=" + _uid + "'>삭제</a>");
		}
		
			out.print(""
					+ "<tr><td></td></tr>"
					+ "</td></tr><tr><td style=\"text-align: end;\" colspan=\"8\">"
					+ "<button class='btn btn-danger' onclick=\"location.href='/jw/ch06/registerMember.html'\">새 회원 등록</button>"
					+ "</td></tr></table>"
					);
			
					
			out.print(" </div>");
			out.print("	</body>");
			out.print("</html>");
			*/
	}
}
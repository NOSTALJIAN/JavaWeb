package ch07;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch07/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("-------------------------------------------------");
		System.out.println("doGet() Method 호출");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("-------------------------------------------------");
		System.out.println("doPost() Method 호출");
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("-------------------------------------------------");
		System.out.println("doHandle() Method 호출");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		String comm = request.getParameter("comm");		// command(입력 값) 받아오기
		
		// 회원 가입 창에서 전송된 command가 addMember이면 전송된 값을 받아옴
		if (comm != null && comm.equals("add")) {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			String uname = request.getParameter("uname");
			// text 타입으로 받아온 birth를 Date 타입으로 변환
			String birthStr = request.getParameter("birth");
			Date birth = Date.valueOf(birthStr);
			String email = request.getParameter("email");
			// gender => "male" or "female"
			String gender = request.getParameter("gender");
			// hobby => ["Listening to music"] or ["Watching movies"] or ...
			// 			or ["Listening to music","Watching movies"] or ...
			//			or ["Listening to music","Watching movies", ... ,"Take a picture"]
			String[] hobbies = request.getParameterValues("hobby");
			String hobby = String.join(", ", hobbies);
			System.out.println(hobby);
			Member mem = new Member();
			mem.setUid(uid);
			mem.setPwd(pwd);
			mem.setUname(uname);
			mem.setBirth(birth);
			mem.setEmail(email);
			mem.setGender(gender);
			mem.setHobby(hobby);
			dao.addMember(mem);
		}
		
		// command 값이 delMember이면 ID를 SQL문으로 전달 후 삭제
		else if (comm != null && comm.equals("delMember")) {
			String uid = request.getParameter("uid");
			dao.delMember(uid);
		}
		
		List<Member> list = dao.listMembers();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("  <meta charset=\"UTF-8\">"
				+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "  <!-- Bootstrap -->"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\""
				+ "    integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\""
				+ "    integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\""
				+ "    crossorigin=\"anonymous\"></script>"
				+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js\""
				+ "    integrity=\"sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V\""
				+ "    crossorigin=\"anonymous\"></script>"
				+ "  <!-- Fontawesome -->"
				+ "  <script src=\"https://kit.fontawesome.com/591ebcb214.js\" crossorigin=\"anonymous\"></script>"
				+ "  <!-- jQuery -->"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>"
				+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js\""
				+ "    integrity=\"sha512-57oZ/vW8ANMjR/KQ6Be9v/+/h6bq9/l3f0Oc7vn6qMqyhvPd1cvKBRWWpzu0QoneImqr2SkmO4MSqU+RpHom3Q==\""
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>"
				+ "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.13.2/themes/base/jquery-ui.min.css\""
				+ "    integrity=\"sha512-ELV+xyi8IhEApPS/pSj66+Jiw+sOT1Mqkzlh8ExXihe4zfqbWkxPRi8wptXIO9g73FSlhmquFlUOuMSoXz5IRw==\""
				+ "    crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />");
		out.print("  <title>MemberVO</title>");
		out.print("</head>");
		
		out.print("<body style=\"margin: 40px;\">"
				+ "  <h1>회원 리스트</h1>"
				+ "  <hr><br>");
		
		out.print(" <div class=\"container-fluid\" id=\"modify\">");
		out.print("  <form  action=\"userModify\">");
		out.print("   <table class='container-fluid' style='text-align: center; font-size: 14px'>");
		out.print("     <tr>");
		out.print("       <td>ID</td>");
		out.print("       <td>PW</td>");
		out.print("       <td>이름</td>");
		out.print("       <td>생년월일</td>");
		out.print("       <td>E-MAIL</td>");
		out.print("       <td>성별</td>");
		out.print("       <td>취미</td>");
		out.print("       <td></td>");
		out.print("       <td></td>");
		out.print("     </tr>");
		
		for (int i = 0; i < list.size(); i++) {
			Member mem = (Member) list.get(i);
			String uid = mem.getUid();
			String pwd = mem.getPwd();
			String uname = mem.getUname();
			Date birth = mem.getBirth();
			String email = mem.getEmail();
			String gender = mem.getGender();
			String hobby = mem.getHobby();
			
			out.print("       <tr>"
					+ "         <td>"
					+            uid
					+ "         </td>"
					+ "         <td>"
					+            pwd
					+ "         </td>"
					+ "         <td>"
					+            uname
					+ "         </td>"
					+ "         <td>"
					+            birth
					+ "         </td>"
					+ "         <td>"
					+            email
					+ "         </td>"
					+ "         <td>"
					+            gender
					+ "         </td>"
					+ "         <td>"
					+            hobby
					+ "         </td>"
					+ "         <td>"
								 // 삭제를 클릭하면 command값과 회원 ID를 서블릿으로 전송
					+ " 		 <a href='/jw/ch07/member?comm=delMember&uid=" + uid + "'>삭제</a>"
					+ "         </td>"
					+ "         <td>"
							 	 // 수정을 클릭하면 command값과 회원 ID를 서블릿으로 전송
					+ "		     <a href='/jw/ch07/member?comm=delMember&uid=" + uid + "'>수정</a></td>");
		}
			
		out.print("       <tr>"
				+ "         <td></td>"
				+ "       </tr>"
				+ "       </td>"
				+ "       </tr>"
				+ "       <tr>"
				+ "         <td style=\"text-align: end;\" colspan=\"8\">"
						 	 // 클릭하면 다시 회원 가입 화면으로 돌아가는 버튼 생성
				+ "		     <button class='btn btn-danger mt-4' onclick=\"location.href='/jw/ch07/MemberForm.html'\">새 회원 등록</button>"
				+ "         </td>"
				+ "       </tr>"
				+ "     </table>");
		
		out.print("  </form>"
				+ " </div>"
				+ "</body>"

				+ "</html>");
	}
}
package ch09;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch09/setCookie")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie c1 = new Cookie("cookie-name", "cookie-value");
		c1.setMaxAge(24*60*60);		//	Cookie 유효 기간: 1일(최종 접속 시간 기준)
		String kMsg = URLEncoder.encode("한글 데이터", "utf-8");
		response.addCookie(c1);
		
		Cookie c2 = new Cookie("hangul-test", kMsg);
		c2.setMaxAge(-1);			//	브라우저가 닫히면 쿠키가 사라짐
		response.addCookie(c2);
		
		out.print("<h1>현재시간: " + new Date() + "</h1>");
		out.print("<h3> 현재시간을 Cookie로 저장했습니다.</h3>");
	}
}
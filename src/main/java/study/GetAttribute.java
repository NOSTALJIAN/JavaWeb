package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		HttpSession sess = request.getSession();
		
		//	각 서블릿 API에서 바인딩된 속성의 값을 가져옴
		String ctxMesg = (String)ctx.getAttribute("context");
		String sesMesg = (String)sess.getAttribute("session");
		String reqMest = (String)request.getAttribute("request");
		
		System.out.println("-------------------------------------------------");
		System.out.println("context값 : " + ctxMesg);
		System.out.println();
		System.out.println("session값 : " + sesMesg);
		System.out.println("같은 브라우저에서는 \"" + sesMesg  + "\"이 " + "\"session에 바인딩\"이라고 정상 출력되고,\n" + "다른 브라우저에서는 \"null\"로 출력됨");
		System.out.println();
		System.out.println("request값 : " + reqMest);
		out.print("context값 : " + ctxMesg + "<br><br>");
		out.print("session값 : " + sesMesg + "<br>");
		out.println("같은 브라우저에서는 \"" + sesMesg  + "\"이 " + "\"session에 바인딩\"이라고 정상 출력되고, " + "다른 브라우저에서는 \"null\"로 출력됨<br><br>");
		out.print("request값 : " + reqMest + "<br>");
		
		//	같은 브라우저에서는 "null"이 "session에 바인딩"이라고 정상 출력되고,
		//	다른 브라우저에서는 "null"로 출력됨
		
		//	request 객체는 /get으로 요청하여 생성된 request 객체와 다르므로 null이 출력됨
	}
}
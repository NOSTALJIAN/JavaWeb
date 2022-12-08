package ch06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch06/params")
public class Params extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//	Query String 처리 localhost:8080/jw/ch06/params?uid=jian&cnt=5
		System.out.println("Params.doGet() method");
		request.setCharacterEncoding("utf-8");
		
		String uid = request.getParameter("uid");
		String cnt_ = request.getParameter("cnt");
		int cnt = Integer.parseInt(cnt_);
		for (int i=0; i<cnt; i++)
			System.out.println("uid : " + uid);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("Params.doPost() method");
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		String data = "uid: " + uid + "\n";
		data += "pwd: " + pwd + "\n";
		System.out.println(data);
	}

}

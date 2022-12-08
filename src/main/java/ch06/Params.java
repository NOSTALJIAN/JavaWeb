package ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ch06/params")
public class Params extends HttpServlet {
	private static final int DEFAULT_COUNT = 5;
	private static final String [] FOOD_LIST = {"짜장면", "짬뽕", "짬짜면"};

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//	Query String 처리 localhost:8080/jw/ch06/params?uid=jian&cnt=5
		System.out.println("Params.doGet() method");
		request.setCharacterEncoding("utf-8");
		
		String uid = request.getParameter("uid");
		int cnt = DEFAULT_COUNT;
		try {
			String cnt_ = request.getParameter("cnt");
			cnt = Integer.parseInt(cnt_);
		} catch(Exception e) {}
		for (int i=1; i<=cnt; i++)
			System.out.println(i + " uid : " + uid);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("Params.doPost() method");
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String[] skills = request.getParameterValues("skill");
		String food = request.getParameter("food");
		
		String data = "uid: " + uid + "\n";
		data += "pwd: " + pwd + "\n";
		for (String skill: skills)
			data += "skill: " + skill + "\n";
		data += "food: " + FOOD_LIST[Integer.parseInt(food) - 1] + "\n";
		System.out.println(data);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html lang=\"ko\">");
		out.print("<head>");
		out.print("	<meta charset=\"UTF-8\">");
		out.print("	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		out.print("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.print("	<title>HttpServletRequest</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("	<h1>Params.doPost() method로 받은 Parameter</h1>");
		out.print(" <hr>");
		
		//	out.print(data);
		String[] ulList = data.split("\n");
		out.print(" <ul>");
		for (String li: ulList)
			out.print("  <li>" + li + "</li>");
		out.print(" </ul>");
		
		out.print("	</body>");
		out.print("</html>");
	}

}

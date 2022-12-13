package t_member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/t_member/member/*")	// 브라우저에서 요청 시 두 단계로 요청이 이루어짐
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO memberDAO;
	
	public MemberController() {
		super();
	}
	
	public void init() throws ServletException {
		// MemberDAO 생성
		memberDAO = new MemberDAO();
		System.out.println("MemberDAO 생성");
	}

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
		String nextPage = null;
		System.out.println("-------------------------------------------------");
		System.out.println("doHandle() Method 호출");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		// URL에서 요청명을 가져오기
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		// 최초 요청이거나 action 값이 /listMembers.do면 회원 목록을 출력
		if (action == null || action.equals("/listMembers.do")) {
		// 요청에 대한 회원 정보 조회
		List<MemberVO> membersList = memberDAO.listMembers();
		// 조회한 회원 정보를 request에 바인딩
		request.setAttribute("membersList", membersList);
		// listMember.jsp로 포워딩
		nextPage = "/t_member/listMembers.jsp";
		
		// 로그인
		} else if (action.equals("/login.do")) {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			MemberVO memberVO = new MemberVO();
			memberVO.setUid(uid);
			memberVO.setPwd(pwd);
			MemberDAO dao = new MemberDAO();
			boolean result = dao.loginMember(memberVO);
			if (result == true) {
				// 조회한 결과가 true이면 isLogOn 속성을 true로 세션에 저장
				session.setAttribute("isLogon", true);
				// 조회한 결과가 true이면 ID와 비밀번호를 세션에 저장
				session.setAttribute("login.uid", uid);
				session.setAttribute("login.pwd", pwd);
				nextPage = "/t_member/main.jsp";
			} else {
				request.setAttribute("msg", "wrongInfo");
				nextPage = "/t_member/login.jsp";
//				nextPage = "/jw/t_member/login.jsp";
			}
		
		// 회원 등록
		} else if (action.equals("/addMember.do")) {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			String uname = request.getParameter("uname");
			// text 타입으로 받아온 birth를 Date 타입으로 변환
			Date birth = Date.valueOf(request.getParameter("birth"));
			String email = request.getParameter("email");
			// gender => "male" or "female"
			String gender = request.getParameter("gender");
			// hobby => ["Listening to music"] or ["Watching movies"] or ...
			// 			or ["Listening to music","Watching movies"] or ...
			//			or ["Listening to music","Watching movies", ... ,"Take a picture"]
			String[] hobbies = request.getParameterValues("hobby");
			String hobby = String.join(", ", hobbies);
			MemberVO mem = new MemberVO(uid, pwd, uname, birth, email, gender, hobby);
			memberDAO.addMember(mem);
			// 회원 등록 후 다시 회원 목록 출력
			request.setAttribute("msg", "addMember");
			nextPage = "/t_member/member/listMembers.do";
			
		// ID 중복 여부 체크
		} else if (action.equals("/check.do")) {
			String uid = request.getParameter("uid");
			boolean overlappedID = memberDAO.overlappedID(uid);
			String abtID;
			if (overlappedID == true) {
				abtID = "not_usable";
				System.out.println("[MemberController] abtID? " + abtID);
			} else {
				abtID = "usable";
				System.out.println("[MemberController] abtID? " + abtID);
			}
			out.write(abtID);
			out.close();
			return;
			
		// 회원 가입창
		} else if (action.equals("/memberForm.do")) {
			// memberForm.jsp로 포워딩
			nextPage = "/t_member/MemberForm.jsp";
			
		// 회원 수정 요청 시 ID로 회원정보를 조회 후 수정창으로 포워딩
		} else if (action.equals("/modMemberForm.do")) {
			String uid = request.getParameter("uid");
			MemberVO memInfo = memberDAO.findMember(uid);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/t_member/modMemberForm.jsp";
		} else if (action.equals("/modMember.do")) {
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			String uname = request.getParameter("uname");
			Date birth = Date.valueOf(request.getParameter("birth"));
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String[] hobbies = request.getParameterValues("hobby");
			String hobby = String.join(", ", hobbies);
			System.out.println("uid: " + uid);
			System.out.println("pwd: " + pwd);
			System.out.println("uname: " + uname);
			System.out.println("birth: " + birth);
			System.out.println("email: " + email);
			System.out.println("gender: " + gender);
			System.out.println("hobby: " + hobby);
			MemberVO mem = new MemberVO(uid, pwd, uname, birth, email, gender, hobby);
			memberDAO.modMember(mem);
			
			request.setAttribute("msg", "modified");
			nextPage = "/t_member/member/listMembers.do";
			
		// 회원 정보 삭제
		} else if (action.equals("/delMember.do")) {
			String uid = request.getParameter("uid");
			memberDAO.delMember(uid);
			request.setAttribute("msg", "delMember");
			nextPage = "/t_member/member/listMembers.do";

		// 그 외 다른 action 값은 회원 목록을 출력
		} else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/listMembers.jsp";
			
		}
		// nextPage에 지정한 요청명으로 다시 서블릿에 요청
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
	
}
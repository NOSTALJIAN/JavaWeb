package ch07;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.lang.String;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	MemberDAO() {
		try {
			// JNDI 기본 경로 지정
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envCtx.lookup("jdbc/jian");		// context.xml name값
			System.out.println("-------------------------------------------------");
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> listMembers() {
		List<Member> list = new ArrayList<Member>();
		try {
			// connDB();
			con = dataFactory.getConnection();
			String sql = "SELECT * FROM member ";
			System.out.println("-------------------------------------------------");
			System.out.println("MemberList: \n" + sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member mem = new Member();
				mem.setUid(rs.getString("uid"));
				mem.setPwd(rs.getString("pwd"));
				mem.setUname(rs.getString("uname"));
				mem.setBirth(rs.getDate("birth"));
				mem.setEmail(rs.getString("email"));
				mem.setGender(rs.getString("gender"));
				mem.setHobby(rs.getString("hobby"));
				System.out.println("ID : " + mem.getUid());
				System.out.println("PWD : " + mem.getPwd());
				System.out.println("name : " + mem.getUname());
				System.out.println("birthDay : " + mem.getBirth());
				System.out.println("E-MAIL : " + mem.getEmail());
				System.out.println("gender : " + mem.getGender());
				System.out.println("hobby : " + mem.getHobby());
				list.add(mem);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 회원 정보 등록
	public void addMember(Member mem) {
		try {
			// DataSource 인용해서 DB 연결
			con = dataFactory.getConnection();
			
			// MySQL INSERT문 => 문자열
			String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?, ?);";
			System.out.println("-------------------------------------------------");
			System.out.println("prepareStatement: \n" + sql);
			// INSERT문의 '?'에 순서대로 회원 정보를 세팅
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getUid());
			pstmt.setString(2, mem.getPwd());
			pstmt.setString(3, mem.getUname());
			pstmt.setDate(4, mem.getBirth());
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getGender());
			pstmt.setString(7, mem.getHobby());
			System.out.println("ID : " + mem.getUid());
			System.out.println("PWD : " + mem.getPwd());
			System.out.println("name : " + mem.getUname());
			System.out.println("birthDay : " + mem.getBirth());
			System.out.println("E-MAIL : " + mem.getEmail());
			System.out.println("gender : " + mem.getGender());
			System.out.println("hobby : " + mem.getHobby());
			// 회원 정보를 테이블에 추가
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 회원 정보 삭제
	public void delMember(String uid) {
		try {
			con = dataFactory.getConnection();
			
			// DELETE문을 문자열로 만들기
			String sql = "DELETE FROM member " + "WHERE uid=?";
			System.out.println("-------------------------------------------------");
			System.out.println("DeleteMember: \n" + sql + "\nuid = " + uid);
			pstmt = con.prepareStatement(sql);
			// '?'에 ID 입력
			pstmt.setString(1, uid);
			// DELETE문 실행
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
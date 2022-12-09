package ch07;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.lang.String;

public class MemberDAO {
	private String host;
	private String user;
	private String password;
	private String database;
	private String port;
	
	// Constructor
	MemberDAO() {
		try {
			// properties 정보 가져오기
			InputStream is = new FileInputStream("/Users/NOSTALJIAN/Workspace/JavaWeb/src/main/java/ch06/mysql.properties");
			Properties props = new Properties();
			props.load(is);
			is.close();
			
			host = props.getProperty("host");
			user = props.getProperty("user");
			password = props.getProperty("password");
			database = props.getProperty("database");
			port = props.getProperty("port", "3306");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 연결하기
	public Connection myGetConnection() {
		Connection conn = null;
		try {
			// JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("-------------------------------------------------");
			System.out.println("MySQL 드라이버 로딩 성공");
			
			// 연결하기
			String connStr = "jdbc:mysql://" + host + ":" + port + "/" + database;
			conn = DriverManager.getConnection(
					connStr,
					user,
					password
					);
			System.out.println("Connection 생성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<Member> listMembers() {
		List<Member> list = new ArrayList<Member>();
		Connection conn = myGetConnection();
		try {
			String sql = "" +
					"SELECT uid, pwd, uname, birth, email, gender, hobby " + 
					"FROM member;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
				System.out.println("-------------------------------------------------");
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
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// Member 등록
	public void addMember(Member mem) {
		Connection conn = myGetConnection();

		
		String uid = mem.getUid();
		String pwd = mem.getPwd();
		String uname = mem.getUname();
		java.sql.Date birth = (java.sql.Date) mem.getBirth();
		String email = mem.getEmail();
		String gender = mem.getGender();
		String hobby = mem.getHobby();
		
		String sql = "INSERT INTO member "
				+ "(uid,pwd,uname,birth,email,gender,hobby) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, pwd);
			pstmt.setString(3, uname);
			pstmt.setDate(4, birth);
			pstmt.setString(5, email);
			pstmt.setString(6, gender);
			pstmt.setString(7, hobby);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Member 탈퇴
	public void delMember(String uid) {
		Connection conn = myGetConnection();			//	위에 만들어 둔 myGetConnection 메소드 실행
		String sql = "" +
				"DELETE FROM member " +
				"WHERE uid=?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			// Delete
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
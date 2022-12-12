package t_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private Connection con;
	
	BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envCtx = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envCtx.lookup("jdbc/jian");		// context.xml name값
			System.out.println("-------------------------------------------------");
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticles() {
		List<ArticleVO> articlesList = new ArrayList<>();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articlesList;
	}

}

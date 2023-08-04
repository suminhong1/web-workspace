package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.model.MemberDAO;
import servlet.model.MemberVO;

public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 폼 데이터 받아오기
		String name = request.getParameter("name"); // 검색할 이름 파라미터 받기
		// 2. DAO 리턴 받아서
		MemberDAO dao = new MemberDAO();
		MemberVO vo = null;
		try {
			vo = dao.findByNameMember(name); // 이름으로 회원 검색
			// 3. 멤버 정보 1개 바인딩
			request.setAttribute("vo", vo); // 검색 결과를 request에 저장
			// 4. 네비게이션 -> view.jsp
			if(vo!=null) {
				request.getRequestDispatcher("view.jsp").forward(request, response); // 검색 결과 페이지로 포워딩
			} else {
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// 오류 처리 로직 추가
		}
		
		
		

	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.model.MemberDAO;
import servlet.model.MemberVO;

public class ViewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. DAO 리턴 받기
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = null;
		try {
			list = dao.showAllMember();
		} catch (SQLException e1) {

		}
		// 2. 바인딩
		request.setAttribute("list", list); // 회원 정보를 request에 저장
		// 3. 네비게이션 --> viewMember.jsp
		request.getRequestDispatcher("viewMember.jsp").forward(request, response); // 회원 정보 페이지로 포워딩
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

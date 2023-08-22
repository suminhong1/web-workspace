package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;

public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		int age = request.getParameter("age") != null ? Integer.parseInt(request.getParameter("age")) : 0;
		
		System.out.println("폼값을 받아온다...");
		
		MemberVO vo = new MemberVO(name, age, addr);
		System.out.println("2. VO 생성");
		
		MemberDAO dao = new MemberDAO();
		try {
			dao.insertMember(vo);
		} catch (SQLException e) {
		}
		response.sendRedirect("view");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

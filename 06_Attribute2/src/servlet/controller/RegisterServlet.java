package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		/*
		 * 1. 양방향 한글처리 2. 폼값 받아서 3. ViewServlet (view)한테 결과(이름, 나이, 주소) 출력
		 */
		// a링크로 ViewServlet 결과 확인하러 가기
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String addr = request.getParameter("addr");

		PrintWriter out = response.getWriter();
		out.println("<a href='view?name=" + name + "&age=" + age + "&addr=" + addr + "'>view로 이동</a>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

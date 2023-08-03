package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("name");
		int age = Integer.parseInt((request.getParameter("age")));
		String addr = request.getParameter("addr");

		PrintWriter out = response.getWriter();
		out.println("<h2>회원님의 정보를 출력합니다..</h2>");
		out.println("<p>이름 : " + name + "</p>");
		out.println("<p>나이 : " + age + "</p>");
		out.println("<p>주소 : " + addr + "</p>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

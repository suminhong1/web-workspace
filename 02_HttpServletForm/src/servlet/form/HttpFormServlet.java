package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글처리...양방향
		 */
		request.setCharacterEncoding("utf-8");	
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userId"); 
		String pwd = request.getParameter("userPwd"); 
		String[] menuList = request.getParameterValues("menu");
		
		String gender = request.getParameter("gender");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Client Send Data...</h2>");
		out.println("<p>" + id + "</p>");
		out.println("<p>" + pwd + "</p>");
//		당신의 성별은 --> form.html 라디오 사용!
		out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");
		out.println("<p>당신의 성별은" + " " + (gender.charAt(0) == 'M' ? "남자" : "여자") + "입니다. </p>");
//		out.println("<p>" + gender + "</p>");
		
		out.println("</body></html>");
		out.close();
	}

}

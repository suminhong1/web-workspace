package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

/*
 * 회원가입하면.. 정보를 바탕으로
 * MemberVO를 생성..ArrayList에 추가
 * ArrayList를 통쨰로 ServletContext에 바인딩 --> 1번 init
 * 출력 결과는 viewMember.jsp 페이지에서
 */
public class EntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	List<MemberVO> list = Collections.synchronizedList(new ArrayList<MemberVO>());

	public void init(ServletConfig config) throws ServletException {
//		context = config.getServletContext();
//		context.setAttribute("list", list);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("list", list);
		
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		int age = request.getParameter("age")!=null ? Integer.parseInt(request.getParameter("age")) : 0;
		
		System.out.println("1. 폼값을 받아온다..");
		
		if(name!=null) {
			MemberVO vo = new MemberVO(name, age, addr);
			list.add(vo);
		}
		System.out.println("2. MemberVO 생성..");

		
		System.out.println("3. MemberVO를 List에 저장...");

		// 내비게이션
		RequestDispatcher rdp = request.getRequestDispatcher("viewMember.jsp");
		rdp.forward(request, response); // 이때 페이지로 이동

//		PrintWriter out = response.getWriter();
//		out.println("<a href='viewMember.jsp'>결과 확인하러 가기 </a>");
//		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}

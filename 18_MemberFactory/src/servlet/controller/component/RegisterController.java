package servlet.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "index.jsp";

		// 2. 객체 생성 - 폼 값 담기
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setAddress(address);

		try {
			// 3. DAO와 연결
//					MemberDAO dao = new MemberDAO();
			MemberDAO.getInstance().registerMember(vo);

			// 4. 데이터 바인딩 - session
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			return new ModelAndView(path);
		} catch (SQLException e) {

			
		}
		System.out.println("회원가입 실패!");
		return new ModelAndView(path);


	}

}
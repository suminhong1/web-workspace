package member.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "views/login_result.jsp";
		
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPassword(password);
		
		MemberVO vo = new MemberService().login(m);
		
		System.out.println("vo :: " + vo);
		
		HttpSession session = request.getSession();
		
		if(vo!=null) {
			session.setAttribute("vo", vo);
		}
		return new ModelAndView(path , true);
	}
}

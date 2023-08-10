package servlet.controller.component;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class AllshowController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "views/allShow.jsp";
		try {
			ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
			request.setAttribute("list", list);
		} catch (SQLException e) {
		}
		return new ModelAndView(path);
	}

}

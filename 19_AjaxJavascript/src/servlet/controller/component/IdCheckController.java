package servlet.controller.component;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
//		String success = "ID 사용 가능";
//		String fail = "ID 사용 불가";

		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		boolean flag = false;
		if(vo!=null) {
			flag = true;
		}
		
		// 비동기 방식
		PrintWriter out = response.getWriter();
		out.println(flag);
		
		
//		try {
//			Thread.sleep(400);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

//		if (vo != null) {
//			request.setAttribute("vo", vo);
//			out.print(success);
//		} else {
//			out.print(fail);
//		}
		return null;
	}
}
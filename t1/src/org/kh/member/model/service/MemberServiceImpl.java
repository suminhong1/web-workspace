package org.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.kh.common.SqlSessionTemplate;
import org.kh.member.model.dao.MemberDAO;
import org.kh.member.model.vo.MemberVO;

public class MemberServiceImpl {

	public int insertMember(MemberVO mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDAO().insertMember(session, mOne);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
}

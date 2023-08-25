package org.kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.vo.MemberVO;

public class MemberDAO {
	public int insertMember(SqlSession session, MemberVO mOne) {
		int result = session.insert("mybatis.insertMember", mOne);
		
		return result;
	}
}

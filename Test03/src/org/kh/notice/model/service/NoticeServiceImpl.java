package org.kh.notice.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.common.SqlSessionTemplate;
import org.kh.notice.model.dao.NoticeDAO;
import org.kh.notice.model.vo.NoticeVO;

public class NoticeServiceImpl{

public ArrayList<NoticeVO> noticeAllList() {
	
	SqlSession session = SqlSessionTemplate.getSqlSession();
	ArrayList<NoticeVO> nList = new NoticeDAO().noticeAllList(session);

	if(nList!=null) {
		session.commit();
	} else {
		session.rollback();
	}
	
	session.close();


return nList;

}

}

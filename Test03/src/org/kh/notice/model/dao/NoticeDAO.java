package org.kh.notice.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.kh.notice.model.vo.NoticeVO;

public class NoticeDAO {

	public ArrayList<NoticeVO> noticeAllList(SqlSession session) {

		ArrayList<NoticeVO> nlist = session.selectList("mybatis.select");

		return nlist;
	}

}

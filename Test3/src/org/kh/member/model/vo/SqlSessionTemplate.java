package org.kh.member.model.vo;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

public class SqlSessionTemplate {

	public static SqlSession getSqlSession() throws IOException {
		SqlSession session = null;
		// 해당 리소스 경로(xml파일) 작성
		String resource;
		return session; // 생성된 SqlSession 리턴
	}
}
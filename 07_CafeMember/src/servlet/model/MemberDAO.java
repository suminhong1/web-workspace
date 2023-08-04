package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class MemberDAO implements MemberDAOTemplate {

	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();
		try {
//			dao.insertMember(new MemberVO("마마마", 3, "바바바"));
//			for(MemberVO vo : dao.showAllMember()) {
//				System.out.println(vo);
//			}
			System.out.println(dao.findByNameMember("가가가"));
		} catch (SQLException e) {
		}

	}

	public MemberDAO() {

		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...!!!");
		} catch (ClassNotFoundException e) {
		}
	}

	@Override
	public Connection getConnection() throws SQLException {
		// 2. 데이터베이스와 연결
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connection..!!");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		// 5. close 닫기
		ps.close();
		conn.close();

	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void insertMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();

		// 3. Statement 객체 생성
		String query = ("INSERT INTO MEMBER(NAME, AGE, ADDR) VALUES(?, ?, ?)");
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setString(3, vo.getAddr());

		// 4. 쿼리문 실행
		System.out.println(ps.executeUpdate() + "명 가입!");

		closeAll(ps, conn);

	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		// 3. Statement 객체 생성
		String query = "SELECT * FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);
		// 4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();

		ArrayList<MemberVO> list = new ArrayList<>();
		while (rs.next()) {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String addr = rs.getString("addr");
			list.add(new MemberVO(name, age, addr));
		}

		closeAll(rs, ps, conn);
		return list;
	}

	@Override
	public MemberVO findByNameMember(String name) throws SQLException {
		Connection conn = getConnection();
		// 3. Statement 객체 생성
		String query = "SELECT * FROM MEMBER WHERE NAME=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		MemberVO vo = null;
		if (rs.next()) {
			vo = new MemberVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr"));
		}

		closeAll(rs, ps, conn);
		return vo;
	}
}

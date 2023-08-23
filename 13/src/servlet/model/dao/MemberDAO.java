package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;

public class MemberDAO implements MemberDAOTemplate {
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO()	{
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
		}
		
	}
	public static MemberDAO getInstance() {
		return dao;
	}

	@Override
	public Connection getConnection() throws SQLException {
	
		return null;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
	}

	@Override
	public void registerMember(MemberDTO dto) throws SQLException {
	Connection conn = getConnection();
	
	String query = "INSERT INTO member(id, password, name, address)";
	PreparedStatement ps = conn.prepareStatement(query);
	
	ps.S
	}

	@Override
	public MemberDTO login(String id, String password) throws SQLException {
		
		return null;
	}

	@Override
	public MemberDTO findByIdMember(String id) throws SQLException {
		
		return null;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		
		return null;
	}


}

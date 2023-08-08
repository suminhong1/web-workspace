package servlet.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.dao.MemberDAOTemplate;

/*
 * VO(Value Object), DTO(Data Transfer Object) : 데이터 전송 및 저장 객체
 * - getter/setter만 가지는 것을 DTO
 * - 실상 구별 없이 사용
 */

public class MemberDTO{
	
	private String id;
	private String password;
	private String name;
	private String address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

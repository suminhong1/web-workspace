package servlet.model;

public class UserVO {
	private String userid;
	private String userpwd;
	private String username;
	private int age;
	public UserVO() {
		super();
	}
	public UserVO(String userid, String userpwd, String username, int age) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.age = age;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", age=" + age + "]";
	}
}

package seasonfood;


import java.sql.Timestamp;

public class LogonDataBean {
	private String User_id;
	private String User_passwd;
	private String User_email;
	private String User_gender;
	private Timestamp User_join_date;
	
	public LogonDataBean() {
		
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String User_id) {
		
		this.User_id = User_id;
		System.out.println(User_id);
	}
	public String getUser_passwd() {
		return User_passwd;
		
	}
	public void setUser_passwd(String User_passwd) {
		this.User_passwd = User_passwd;
		System.out.println(User_id);
	}
	public String getUser_email() {
		return User_email;
	}
	public void setUser_email(String User_email) {
		this.User_email = User_email;
		System.out.println(User_email);
	}
	public String getUser_gender() {
		return User_gender;
	}
	public void setUser_gender(String User_gender) {
		this.User_gender = User_gender;
		System.out.println(User_gender);
	}
	public Timestamp getUser_join_date() {
		return User_join_date;
	}
	public void setUser_join_date(Timestamp User_join_date) {
		this.User_join_date = User_join_date;
		System.out.println(User_join_date);
	}

}
